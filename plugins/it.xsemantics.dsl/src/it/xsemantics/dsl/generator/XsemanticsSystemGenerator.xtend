package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.xtext.xbase.compiler.ImportManager

class XsemanticsSystemGenerator {
	
	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject XsemanticsRuleGenerator ruleGenerator
	
	@Inject XsemanticsErrorSpecificationGenerator errSpecGenerator
	
	def compile(XsemanticsSystem ts) {
		val importManager = new ImportManager(true, ts.createJvmType)
		compile(ts, importManager)
	}
	
	def compile(XsemanticsSystem ts, ImportManager importManager) '''
		«val applyMethods = compileApplyMethods(ts, importManager)»
		«val entryMethods = compileEntryPointMethods(ts, importManager)»
		«val checkMethods = compileCheckRules(ts, importManager)»
		«val superClass = importManager.serialize(createJvmTypeForTypeSystemBaseClass)»
		«val dispatchers = polymorphicDispatchers(ts, importManager)»
		«val dispatchersInit = polymorphicDispatchersInit(ts, importManager)»
		«val packageGen = ts.toPackage»
		«IF packageGen.length > 0»
		package «packageGen»;
		«ENDIF»
		«IF !importManager.imports.empty»

		«FOR i : importManager.imports»
		import «i»;
		«ENDFOR»
		«ENDIF»

		public class «ts.toJavaClassName» extends «superClass» {
			«ts.getRules.map([ it.ruleIssueDeclaration(importManager) ]).join("\n")»
		
			«dispatchers»
		
			public «ts.toJavaClassName»() {
				init();
			}
		
			public void init() {
				«dispatchersInit»
			}
		
			«entryMethods»
		
			«checkMethods»
		
			«applyMethods»
		}
	'''

	def compileEntryPointMethods(XsemanticsSystem ts, ImportManager importManager) {
		ts.getJudgmentDescriptions.map([ desc | desc.compileEntryPointMethod(importManager)]).join("\n")
	}
	
	def compileEntryPointMethod(JudgmentDescription judgmentDescription, ImportManager importManager) '''
		«val resultType = judgmentDescription.resultType(importManager)»
		«val resultForFailureMethod = "resultForFailure" + judgmentDescription.suffixStartingFrom2»
		«val inputParams = judgmentDescription.inputParameters(importManager)»
		«val inputArgs = judgmentDescription.inputArgs»
		public «resultType» «judgmentDescription.entryPointMethodName»(«inputParams») {
			return «judgmentDescription.entryPointMethodName»(new «importManager.environmentClass»(),
				null, «inputArgs»);
		}
		
		public «resultType» «judgmentDescription.entryPointMethodName»(«importManager.environmentDeclaration.javaFinalParam»,
				«inputParams») {
			return «judgmentDescription.entryPointMethodName»(«environmentName»,
				null, «inputArgs»);
		}
		
		public «resultType» «judgmentDescription.entryPointMethodName»(«importManager.additionalParamsDeclaration»,
				«inputParams») {
			try {
				return «judgmentDescription.entryPointInternalMethodName»(«additionalArgs», «inputArgs»);
			} catch («importManager.exceptionClass» e) {
				return «resultForFailureMethod»(e);
			}
		}
	'''

	def compileInternalMethod(JudgmentDescription judgmentDescription, ImportManager importManager) '''
		«val resultType = judgmentDescription.resultType(importManager)»
		«val inputParams = judgmentDescription.inputParameters(importManager)»
		«val inputArgs = judgmentDescription.inputArgs»
		protected «resultType» «judgmentDescription.entryPointInternalMethodName»(«importManager.additionalParamsDeclaration»,
				«inputParams») {
			try {
				checkParamsNotNull(«inputArgs»);
				return «judgmentDescription.polymorphicDispatcherField».invoke(«additionalArgs», «inputArgs»);
			} catch («importManager.exceptionClass» e) {
				sneakyThrowRuleFailedException(e);
				return null;
			}
		}
		'''

	def compileCheckRules(XsemanticsSystem ts, ImportManager importManager) {
		ts.getCheckrules.map([ 
			rule | ruleGenerator.compileCheckRule(rule, importManager)
		]).join("\n")
	}
	
	def compileApplyMethods(XsemanticsSystem ts, ImportManager importManager) {
		ts.getJudgmentDescriptions.map([
			desc | 
			desc.compilationForJudgmentDescription(importManager)
		]).join("\n") +
		"\n" +
		ts.getRules.map([ 
			rule |
			ruleGenerator.compileDispatcherImplMethod(rule, importManager).toString
			+
			ruleGenerator.compileApplyMethod(rule, importManager)
		]).join("\n")
	}
	
	def compilationForJudgmentDescription(JudgmentDescription desc, ImportManager importManager) {
		'''
		«desc.compileErrorSpecification(importManager)»
		«desc.compileInternalMethod(importManager)»'''
	}	

	def polymorphicDispatchers(XsemanticsSystem ts, ImportManager importManager) {
		ts.getJudgmentDescriptions.map([ desc | desc.polymorphicDispatcherFieldDecl(importManager)]).join("\n")
	}
	
	def polymorphicDispatcherFieldDecl(JudgmentDescription judgmentDescription, ImportManager importManager) '''
		protected «importManager.polymorphicDispatcherClass»<«judgmentDescription.resultType(importManager)»> «judgmentDescription.polymorphicDispatcherField»;
	''' 

	def polymorphicDispatchersInit(XsemanticsSystem ts, ImportManager importManager) {
		ts.getJudgmentDescriptions.map([ desc | desc.polymorphicDispatcherInit]).join("\n")
	}

	def polymorphicDispatcherInit(JudgmentDescription judgmentDescription) {
		val relationSymbols = judgmentDescription.relationSymbolsArgs
		val relationSymbolArgs = if (!relationSymbols.empty) ", " + relationSymbols else ""
		'''
		«judgmentDescription.polymorphicDispatcherField» = «judgmentDescription.polymorphicDispatcherBuildMethod»(
			"«judgmentDescription.polymorphicDispatcherImpl»", «
			»«judgmentDescription.polymorphicDispatcherNumOfArgs», «
			»"«judgmentDescription.judgmentSymbol»"«
			»«relationSymbolArgs»);'''
	}
	
	def compileErrorSpecification(JudgmentDescription judgmentDescription, ImportManager importManager) {
		val errorSpecification = judgmentDescription.error
		if (errorSpecification == null) {
			return ''''''	
		}
		val b = judgmentDescription.createAndConfigureAppendable(importManager)
		val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, b)
		val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, b)
		val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, b)
		
		'''
		protected void «judgmentDescription.throwExpectionMethod»«
				»(String _issue, «importManager.exceptionClass» _ex, «judgmentDescription.inputParameters(importManager)») 
				throws «importManager.ruleFailedExceptionClass» {
			«b»
			«throwRuleFailedExceptionMethod»(«error»,
					_issue, _ex,
					new «importManager.errorInformationClass»(«source», «feature»));
		}
		
		'''
	}

}
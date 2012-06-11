package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.TempXsemanticsGeneratorExtensions
import it.xsemantics.dsl.generator.UniqueNames
import it.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.validation.Check

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class TempJvmModelInferrer extends AbstractModelInferrer {

    /**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension JvmTypesBuilder
	
	@Inject extension TempXsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension TypeReferences
	
	@Inject XsemanticsXbaseCompiler xbaseCompiler
	
	@Inject XsemanticsErrorSpecificationGenerator errSpecGenerator

	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the closure you pass to the returned
	 *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
	 *            initializeLater(..)}.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
   	def dispatch void infer(XsemanticsSystem ts, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   		val inferredClass = ts.toClass( ts.toJavaFullyQualifiedName )
   		
   		acceptor.accept(
			inferredClass
		).initializeLater [
			documentation = ts.documentation
			
			superTypes += ts.newTypeRef(typeof(XsemanticsRuntimeSystem))

			val issues = <JvmField>newArrayList()
			ts.rules.forEach [
				issues += genIssueField
			]
			members += issues
			
			val polymorphicDispatchers = <JvmField>newArrayList()
			ts.judgmentDescriptions.forEach [
				polymorphicDispatchers += genPolymorphicDispatcherField
			]
			members += polymorphicDispatchers
			
			//val procedure = element.newTypeRef(typeof(Procedure1), it.newTypeRef())
			members += ts.genConstructor
			
			members += ts.genInit
			
			ts.judgmentDescriptions.forEach [
				j |
				members += j.genEntryPointMethods
			]
			
			ts.checkrules.forEach [
				r |
				members += r.compileCheckRuleMethod
				members += r.compileInternalMethod
			]
			
			ts.judgmentDescriptions.forEach [
				j |
				members += j.compileInternalMethod
				val throwExceptionMethod = j.compileThrowExceptionMethod
				if (throwExceptionMethod != null)
					members += throwExceptionMethod
			]
			
			ts.rules.forEach [
				rule |
				if (rule.judgmentDescription != null) {
					members += rule.compileImplMethod
					members += rule.compileApplyMethod
				}
			]
		]
		
		// generation of the Validator
		acceptor.accept(
			ts.toClass( ts.toValidatorJavaFullyQualifiedName )
		).initializeLater [
			documentation = ts.documentation
			
			superTypes += ts.newTypeRef(typeof(XsemanticsBasedDeclarativeValidator))
			
			members += ts.toField("xsemanticsSystem", inferredClass.createTypeRef) [
				annotations += ts.toAnnotation(typeof(Inject))
				visibility = JvmVisibility::PROTECTED
			]
			
			ts.checkrules.forEach [
				rule |
				members += rule.compileValidatorCheckRuleMethod
			]
		]
   	}
   	
   	def genIssueField(Rule rule) {
   		val issueField = rule.containingTypeSystem.toField(
				rule.ruleIssueString,
				rule.newTypeRef(typeof(String))
			) [
				visibility = JvmVisibility::PUBLIC
				^static = true
				final = true
			]
		issueField.setInitializer [
			it.append('''"«rule.toJavaFullyQualifiedName»"''')
		]
		issueField
   	}
   	
   	def genConstructor(XsemanticsSystem ts) {
   		ts.toConstructor() [
			body = [it.append("init();")]
		]
   	}
   	
	def genPolymorphicDispatcherField(JudgmentDescription e) {
		e.containingTypeSystem.toField(
			e.polymorphicDispatcherField.toString,
			e.polymorphicDispatcherType
		)
	}

	def polymorphicDispatcherType(JudgmentDescription e) {
		e.newTypeRef(typeof(PolymorphicDispatcher), e.resultType)
	}
	
	def genInit(XsemanticsSystem ts) {
   		ts.toMethod("init", null) [
   			body = [
   				it.append(
	   				ts.
	   				judgmentDescriptions.map([ 
	   					desc | desc.genPolymorphicDispatcherInit
	   				]).join("\n")
   				)
   			]
   		]
   	}
   	
   	def genPolymorphicDispatcherInit(JudgmentDescription judgmentDescription) {
   		val relationSymbols = judgmentDescription.relationSymbolsArgs
		val relationSymbolArgs = if (!relationSymbols.empty) ", " + relationSymbols else ""
		'''
		«judgmentDescription.polymorphicDispatcherField» = «judgmentDescription.polymorphicDispatcherBuildMethod»(
			"«judgmentDescription.polymorphicDispatcherImpl»", «
			»«judgmentDescription.polymorphicDispatcherNumOfArgs», «
			»"«judgmentDescription.judgmentSymbol»"«
			»«relationSymbolArgs»);'''
   	}
   	
   	def genEntryPointMethods(JudgmentDescription judgmentDescription) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.inputParameters
   			
   			body = [
   				it.append(
   				'''return «judgmentDescription.entryPointMethodName»(new ''')
   				it.append(judgmentDescription.environmentType.type)
   				it.append('''(), null, «judgmentDescription.inputArgs»);''')
   			]
   		]
   		
   		// entry point method with environment parameter
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = [
   				it.append(
   				'''return «judgmentDescription.entryPointMethodName»(«environmentName», null, «judgmentDescription.inputArgs»);''')
   			]
   		]
   		
   		// entry point method with environment parameter and rule application trace
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = [
   				it.append('''
				try {
					return «judgmentDescription.entryPointInternalMethodName»(«additionalArgs», «judgmentDescription.inputArgs»);
				} catch (''')
				judgmentDescription.exceptionType.serialize(judgmentDescription, it)
				it.append(" ")
				it.append('''
				«judgmentDescription.exceptionVarName») {
					return resultForFailure«judgmentDescription.suffixStartingFrom2»(«judgmentDescription.exceptionVarName»);
				}''')
   			]
   		]
   		
   		entryPointMethods
   	}
   	
   	def inputParameters(JudgmentDescription judgmentDescription) {
		val names = new UniqueNames()
		judgmentDescription.inputParams.map([
			it.toParameter(
				names.createName(it.inputParameterName),
				it.parameter.parameterType
			)
		])
	}
	
	def environmentParam(JudgmentDescription e) {
		e.toParameter(
			environmentName.toString,
			e.environmentType
		)
	}
	
	def ruleApplicationTraceParam(EObject e) {
		e.toParameter(
			ruleApplicationTraceName.toString,
			e.newTypeRef(typeof(RuleApplicationTrace))
		)
	}
	
	def compileThrowExceptionMethod(JudgmentDescription judgmentDescription) {
		val errorSpecification = judgmentDescription.error
		if (errorSpecification == null) {
			return null
		}
		
		judgmentDescription.toMethod(
			judgmentDescription.throwExceptionMethod.toString,
			null
		) 
		[
			visibility = JvmVisibility::PROTECTED

			exceptions += judgmentDescription.ruleFailedExceptionType
			
			parameters += judgmentDescription.toParameter("_issue", 
				judgmentDescription.newTypeRef(typeof(String))
			)
   			parameters += judgmentDescription.toParameter("_ex",
   				judgmentDescription.exceptionType
   			)
   			parameters += judgmentDescription.inputParameters
   			
   			body = [
   				val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, it)
				val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, it)
				val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, it)
   				
   				it.newLine
   				it.append('''
   					«throwRuleFailedExceptionMethod»(«error»,
   						_issue, _ex, new ''')
				judgmentDescription.errorInformationType.serialize(judgmentDescription, it)
				it.append('''(«source», «feature»));''')
   			]
		]
	}
	
	def compileInternalMethod(JudgmentDescription judgmentDescription) {
		judgmentDescription.toMethod(
			judgmentDescription.entryPointInternalMethodName.toString,
			judgmentDescription.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = [
   				it.append('''
					try {
						checkParamsNotNull(«judgmentDescription.inputArgs»);
						return «judgmentDescription.polymorphicDispatcherField».invoke(«additionalArgs», «judgmentDescription.inputArgs»);
					} catch (''')
				judgmentDescription.exceptionType.serialize(judgmentDescription, it)
				it.append(" ")
				it.append('''
					«judgmentDescription.exceptionVarName») {
						sneakyThrowRuleFailedException(«judgmentDescription.exceptionVarName»);
						return null;
					}'''
				)
   			]
		]
	}
	
	def ruleFailedExceptionType(EObject o) {
		o.newTypeRef(typeof(RuleFailedException))
	}
	
	def environmentType(EObject o) {
		o.newTypeRef(typeof(RuleEnvironment))
	}
	
	def compileImplMethod(Rule rule) {
		rule.toMethod(
			'''«rule.judgmentDescription.polymorphicDispatcherImpl»'''.toString,
			rule.judgmentDescription.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.paramForEnvironment
   			parameters += rule.judgmentDescription.ruleApplicationTraceParam
   			parameters += rule.inputParameters
   			
   			body = [
   				it.append('''try {''').increaseIndentation.newLine
				it.append(rule.ruleApplicationTraceType.type)
				it.append(''' «ruleApplicationSubtraceName» = «newTraceMethod(ruleApplicationTraceName())»;''').newLine
				rule.judgmentDescription.resultType(it)
				it.append(" ")
				it.append('''
					_result_ = «rule.applyRuleName»(«rule.additionalArgsForRule», «rule.inputParameterNames»);
					«addToTraceMethod(ruleApplicationTraceName(), rule.traceStringForRule)»;
					«addAsSubtraceMethod(ruleApplicationTraceName(), ruleApplicationSubtraceName)»;
					return _result_;''').decreaseIndentation.newLine
				it.append('''} catch (''')
				rule.exceptionType.serialize(rule, it)
				it.append(" ")
				it.append('''''')
				it.append('''e_«rule.applyRuleName») {''').increaseIndentation.newLine
   				rule.compileFinalThrow(it)
   				it.append(''';''').newLine
   				it.append('''return null;''').decreaseIndentation.newLine
   				it.append('''}''')
   			]
		]
	}
	
	def ruleApplicationTraceType(EObject o) {
		o.newTypeRef(typeof(RuleApplicationTrace))
	}
	
	def compileFinalThrow(Rule rule, ITreeAppendable b) {
		if (rule.conclusion.error != null) {
			val errorSpecification = rule.conclusion.error
			val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, b)
			val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, b)
			val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, b)
			b.newLine()
			
			b.append('''
   					«throwRuleFailedExceptionMethod»(«error»,
   						«rule.ruleIssueString», e_«rule.applyRuleName», new ''')
			rule.errorInformationType.serialize(rule, b)
			b.append('''(«source», «feature»));''')
		} else if (rule.judgmentDescription.error != null) {
			b.append('''
			«rule.judgmentDescription.throwExceptionMethod»(«rule.ruleIssueString»,
				e_«rule.applyRuleName», «rule.inputParameterNames»)''')
		} else {
			b.append('''
			«throwRuleFailedExceptionMethod»(«rule.errorForRule»,
				«rule.ruleIssueString»,
				e_«rule.applyRuleName»''')
			rule.errorInformationArgs(b)
			b.append(''')''')
		}
	}
	
	def errorInformationArgs(Rule rule, ITreeAppendable b) {
		val inputEObjects = rule.inputEObjectParams
		if (!inputEObjects.empty)
			b.append(", ")
		val iter = inputEObjects.iterator
		val errInfoType = rule.errorInformationType.type
		while (iter.hasNext) {
			b.append("new ")
			b.append(errInfoType)
			b.append('''(«iter.next.parameter.name»)''')
			if (iter.hasNext)
				b.append(", ")
		}
	}
	
	def compileApplyMethod(Rule rule) {
		rule.toMethod(
			'''applyRule«rule.toJavaClassName»'''.toString,
			rule.judgmentDescription.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.paramForEnvironment
   			parameters += rule.ruleApplicationTraceParam
   			parameters += rule.inputParameters
   			
   			body = [
   				rule.declareVariablesForOutputParams(it) 
   				rule.compileRuleBody(rule.judgmentDescription.resultType, it)
   			]
		]
	}

	def compileCheckRuleMethod(CheckRule rule) {
		rule.toMethod(
			'''«rule.methodName»''',
			rule.resultType
		) 
		[
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)
   			
   			body = [
   				it.append(
   				'''
				try {
					return «rule.methodName»Internal(null, «rule.element.parameter.name»);
				} catch ('''
   				)
   				rule.exceptionType.serialize(rule, it)
   				it.append(
   				'''
				 e) {
					return resultForFailure(e);
				}'''
   				)
   			]
		]
	}

	def compileValidatorCheckRuleMethod(CheckRule rule) {
		rule.toMethod(
			'''«rule.methodName»''',
			Void::TYPE.getTypeForName(rule)
		) 
		[
			annotations += rule.toAnnotation(typeof(Check))
			
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)
   			
   			body = [
   				it.append(
   				'''
				generateErrors(
					xsemanticsSystem.«rule.methodName»(«rule.element.parameter.name»),
						«rule.element.parameter.name»);'''
   				)
   			]
		]
	}

	def compileInternalMethod(CheckRule rule) {
		rule.toMethod(
			'''«rule.methodName»Internal''',
			rule.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.ruleApplicationTraceParam
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)
   			
   			body = [
   				rule.compilePremises(it)
   				if (!it.toString.empty)
					it.newLine
				it.append("return new ")
				rule.resultType(it)
				it.append("(true);")
   			]
		]
	}
	
	def paramForEnvironment(Rule rule) {
		rule.toParameter(rule.ruleEnvName, rule.newTypeRef(typeof(RuleEnvironment)))
	}
	
	def declareVariablesForOutputParams(Rule rule, ITreeAppendable appendable) {
		rule.outputParams.forEach([
			it.declareVariableForOutputParam(appendable).append("\n")
		])
	}
	
	def declareVariableForOutputParam(RuleParameter ruleParam, ITreeAppendable appendable) {
		val outputVarName = appendable.declareVariable(ruleParam.parameter, ruleParam.parameter.simpleName)
   		val childAppendable = appendable.trace(ruleParam.parameter, true)
		ruleParam.parameter.parameterType.serialize(ruleParam.parameter, childAppendable)
		childAppendable.append(" " + outputVarName + " = null; // output parameter")
	}
	
	def inputParameters(Rule rule) {
		rule.inputParams.map([
			it.toParameter(
				it.parameter.name,
				it.parameter.parameterType
			)
		])
	}
	
	def compileRuleBody(Rule rule, JvmTypeReference resultType, ITreeAppendable result) {
		compilePremises(rule, result)
		compileRuleConclusionElements(rule, result)
		compileReturnResult(rule, resultType, result)
	}
	
	def dispatch compilePremises(Rule rule, ITreeAppendable result) {
		
	}

	def dispatch compilePremises(RuleWithPremises rule, ITreeAppendable result) {
		xbaseCompiler.compile(rule.premises, result, false)
	}

	def dispatch compilePremises(CheckRule rule, ITreeAppendable result) {
		xbaseCompiler.compile(rule.premises, result, false)
	}
	
	def compileRuleConclusionElements(Rule rule, ITreeAppendable result) {
		rule.expressionsInConclusion.forEach([
			xbaseCompiler.compile(it.expression, result, true)
		])
	}
	
	def compileReturnResult(Rule rule, JvmTypeReference resultType, ITreeAppendable result) {
		val expressions = rule.outputConclusionElements
		
		if (!result.toString.empty)
			result.append("\n")
		result.append("return new ")
		resultType.serialize(rule, result)
		result.append("(")
		
		if (expressions.size() == 0)
			result.append("true")
		else {
			val iterator = expressions.iterator()
			while (iterator.hasNext) {
				val elem = iterator.next
				switch elem {
					RuleParameter: 
						result.append(result.getName(elem.parameter))
					ExpressionInConclusion: 
						xbaseCompiler.compileAsJavaExpression(elem.expression, result)
				}
				if (iterator.hasNext)
					result.append(", ")
			}
		}
		result.append(");")
	}
	
}


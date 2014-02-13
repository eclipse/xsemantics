package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.UniqueNames
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer
import org.eclipse.xtext.common.types.JvmField

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class XsemanticsJvmModelInferrer extends AbstractModelInferrer {

    /**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension JvmTypesBuilder
	
	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils
	
	@Inject extension TypeReferences
	
	@Inject extension XbaseTypeConformanceComputer

	@Inject XsemanticsTypeSystem typeSystem

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
   		if (ts.toJavaFullyQualifiedName == null)
   			return
   		
   		val inferredClass = ts.toClass( ts.toJavaFullyQualifiedName )
   		
   		acceptor.accept(
			inferredClass
		).initializeLater [
			documentation = ts.documentation
			
			if (ts.superSystem != null)
				superTypes += ts.superSystem.cloneWithProxies
			else
				superTypes += ts.newTypeRef(typeof(XsemanticsRuntimeSystem))
			
			val injectedFields = <JvmField>newArrayList()
			val polyDispFields = <JvmField>newArrayList()
			val issueFields = <JvmField>newArrayList()

			val getterSetters = <JvmOperation>newArrayList()
			val entryPoints = <JvmOperation>newArrayList()
			val checkMethods = <JvmOperation>newArrayList()
			val internalMethods = <JvmOperation>newArrayList()
			val implMethods = <JvmOperation>newArrayList()

			for (elem: ts.auxiliaryDescriptions) {
				issueFields += elem.genIssueField
				entryPoints += elem.genEntryPointMethods
				polyDispFields += elem.genPolymorphicDispatcherField
				internalMethods += elem.compileInternalMethod
				internalMethods += elem.compileThrowExceptionMethod
			}
			
			for (injected : ts.injections) {
				injectedFields += injected.toField(
					injected.name, 
					injected.type
				) [
					documentation = injected.documentation
					annotations += ts.toAnnotation(typeof(Inject))
					visibility = JvmVisibility::PRIVATE
				]
				
				getterSetters += injected.toGetter
					(injected.name, injected.type)
				getterSetters += injected.toSetter
					(injected.name, injected.type)
			}
			
			for (elem : ts.judgmentDescriptions) {
				polyDispFields += elem.genPolymorphicDispatcherField
				entryPoints += elem.genEntryPointMethods
				entryPoints += elem.genSucceededMethods
				internalMethods += elem.compileInternalMethod
				internalMethods += elem.compileThrowExceptionMethod
			}

			for (r : ts.checkrules) {
				checkMethods += r.compileCheckRuleMethods
				checkMethods += r.compileInternalMethod
			}

			for (aux : ts.auxiliaryFunctions) {
				if (aux.getOrSetAuxiliaryDescription != null) {
					implMethods += aux.compileImplMethod
					implMethods += aux.compileApplyAuxiliaryFunction
				}
			}
			
			for (rule : ts.rules) {
				issueFields += rule.genIssueField
				if (rule.orSetJudgmentDescription != null) {
					implMethods += rule.compileImplMethod
					implMethods += rule.compileApplyMethod
					for (e : rule.expressionsInConclusion) {
						implMethods += e.compileExpressionInConclusionMethod
					}
					if (rule.conclusion.error != null)
						implMethods += rule.compileErrorSpecificationMethod
				}
			}			
			// add fields to the inferred class
			members.addAll(issueFields)
			members.addAll(injectedFields)
			members.addAll(polyDispFields)
			
			//val procedure = element.newTypeRef(typeof(Procedure1), it.newTypeRef())
			members += ts.genConstructor
			
			members += ts.genInit
			
			members.addAll(getterSetters)
			members.addAll(entryPoints)
			members.addAll(checkMethods)
			members.addAll(internalMethods)
			members.addAll(implMethods)
		]
		
		// generation of the Validator
		acceptor.accept(
			ts.toClass( ts.toValidatorJavaFullyQualifiedName )
		).initializeLater [
			documentation = ts.documentation
			
			if (ts.superSystemDefinition != null)
				superTypes += ts.newTypeRef(ts.superSystemDefinition.toValidatorJavaFullyQualifiedName)
			else if (ts.validatorExtends != null)
				superTypes += ts.validatorExtends.cloneWithProxies
			else
				superTypes += ts.newTypeRef(typeof(AbstractDeclarativeValidator))

			if (ts.superSystem === null)
				members += ts.toField("errorGenerator", ts.newTypeRef(typeof(XsemanticsValidatorErrorGenerator))) [
					annotations += ts.toAnnotation(typeof(Inject))
					visibility = JvmVisibility::PROTECTED
				]
			// avoid generating a field that masks the one in the superclass
			// FindBugs MF_CLASS_MASKS_FIELD
						
			members += ts.toField("xsemanticsSystem", inferredClass.createTypeRef) [
				annotations += ts.toAnnotation(typeof(Inject))
				visibility = JvmVisibility::PROTECTED
			]
			
			members += ts.toGetter("xsemanticsSystem", inferredClass.createTypeRef) => [
				visibility = JvmVisibility::PROTECTED
				if (ts.superSystem != null)
   					annotations += ts.toAnnotation(typeof(Override))
			]
			
			for (rule : ts.checkrules) {
				members += rule.compileValidatorCheckRuleMethod
			}
		]
   	}

   	def genIssueField(Rule rule) {
   		val issueField = rule.toField(
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

   	def genIssueField(AuxiliaryDescription aux) {
   		val issueField = aux.toField(
				aux.ruleIssueString,
				aux.newTypeRef(typeof(String))
			) [
				visibility = JvmVisibility::PUBLIC
				^static = true
				final = true
			]
		issueField.setInitializer [
			it.append('''"«aux.toJavaFullyQualifiedName»"''')
		]
		issueField
   	}
   	
   	def genConstructor(XsemanticsSystem ts) {
   		ts.toConstructor() [
			body = [it.append("init();")]
		]
   	}
   	
	def genPolymorphicDispatcherField(JudgmentDescription e) {
		e.toField(
			e.polymorphicDispatcherField.toString,
			e.polymorphicDispatcherType
		)
	}

	def genPolymorphicDispatcherField(AuxiliaryDescription e) {
		e.toField(
			e.polymorphicDispatcherField.toString,
			e.polymorphicDispatcherType
		)
	}

	def polymorphicDispatcherType(JudgmentDescription e) {
		e.newTypeRef(typeof(PolymorphicDispatcher), e.resultType)
	}

	def polymorphicDispatcherType(AuxiliaryDescription e) {
		e.newTypeRef(typeof(PolymorphicDispatcher), e.resultType)
	}
	
	def genInit(XsemanticsSystem ts) {
   		ts.toMethod("init", Void::TYPE.getTypeForName(ts)) [
   			if (ts.superSystem != null)
   				annotations += ts.toAnnotation(typeof(Override))
   			
   			body = [
   				if (ts.superSystem != null)
   					it.append('''
   					super.init();
   					''')

   				it.append(
	   				(ts.judgmentDescriptions.map [ 
	   					desc | desc.genPolymorphicDispatcherInit
	   				] 
	   				+ 
	   				ts.auxiliaryDescriptions.map [ 
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
			»"«judgmentDescription.judgmentSymbol.escapeJavaStringChars»"«
			»«relationSymbolArgs»);'''
   	}

   	def genPolymorphicDispatcherInit(AuxiliaryDescription aux) {
   		'''
		«aux.polymorphicDispatcherField» = buildPolymorphicDispatcher(
			"«aux.polymorphicDispatcherImpl»", «
			»«aux.polymorphicDispatcherNumOfArgs»);'''
   	}
   	
   	def genEntryPointMethods(JudgmentDescription judgmentDescription) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		entryPointMethods += judgmentDescription.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))
   			
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''return «judgmentDescription.entryPointMethodName»(new «RuleEnvironment»(), null, «judgmentDescription.inputArgs»);'''
   		]
   		
   		// entry point method with environment parameter
   		entryPointMethods += judgmentDescription.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))

   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''return «judgmentDescription.entryPointMethodName»(«environmentName», null, «judgmentDescription.inputArgs»);'''
   		]
   		
   		// entry point method with environment parameter and rule application trace
   		entryPointMethods += judgmentDescription.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))
   			
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''
				try {
					return «judgmentDescription.entryPointInternalMethodName»(«additionalArgs», «judgmentDescription.inputArgs»);
				} catch («Exception» «judgmentDescription.exceptionVarName») {
					return resultForFailure«judgmentDescription.suffixStartingFrom2»(«judgmentDescription.exceptionVarName»);
				}'''
   		]
   		
   		entryPointMethods
   	}

   	def genSucceededMethods(JudgmentDescription judgmentDescription) {
   		val inferredMethods = <JvmOperation>newArrayList()

		if (!typeSystem.isPredicate(judgmentDescription))
			return inferredMethods

   		// main succeded method
   		inferredMethods += judgmentDescription.toMethod(
   			judgmentDescription.succeededMethodName.toString,
   			judgmentDescription.booleanType
   		) [
   			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))
   			
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''return «judgmentDescription.succeededMethodName»(new «RuleEnvironment»(), null, «judgmentDescription.inputArgs»);'''
   		]
   		
   		// entry point method with environment parameter
   		inferredMethods += judgmentDescription.toMethod(
   			judgmentDescription.succeededMethodName.toString,
   			judgmentDescription.booleanType
   		) [
   			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))

   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''return «judgmentDescription.succeededMethodName»(«environmentName», null, «judgmentDescription.inputArgs»);'''
   		]
   		
   		// entry point method with environment parameter and rule application trace
   		inferredMethods += judgmentDescription.toMethod(
   			judgmentDescription.succeededMethodName.toString,
   			judgmentDescription.booleanType
   		) [
			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))
   			
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''
				try {
					«judgmentDescription.entryPointInternalMethodName»(«additionalArgs», «judgmentDescription.inputArgs»);
					return true;
				} catch («Exception» «judgmentDescription.exceptionVarName») {
					return false;
				}'''
   		]
   		
   		inferredMethods
   	}

   	def genEntryPointMethods(AuxiliaryDescription aux) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		entryPointMethods += aux.toMethod(
   			aux.entryPointMethodName.toString,
   			aux.resultType
   		) [
   			exceptions += aux.ruleFailedExceptionType
   			
   			parameters += aux.inputParameters
   			
   			body = '''return «aux.entryPointMethodName»(null, «aux.inputArgs»);'''
   		]
   		
   		// entry point method with rule application trace
   		entryPointMethods += aux.toMethod(
   			aux.entryPointMethodName.toString,
   			aux.resultType
   		) [
   			exceptions += aux.ruleFailedExceptionType
   			
   			parameters += aux.ruleApplicationTraceParam
   			parameters += aux.inputParameters
   			
   			body = '''
				try {
					return «aux.entryPointInternalMethodName»(«ruleApplicationTraceName», «aux.inputArgs»);
				} catch («Exception» «aux.exceptionVarName») {
					throw extractRuleFailedException(«aux.exceptionVarName»);
				}'''
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

   	def inputParameters(AuxiliaryDescription aux) {
		aux.parameters.map([
			it.toParameter(
				it.name,
				it.parameterType
			)
		])
	}

   	def inputParameters(AuxiliaryFunction aux) {
		aux.parameters.map([
			it.toParameter(
				it.name,
				it.parameterType
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
		
		judgmentDescription.toMethod(
			judgmentDescription.throwExceptionMethod.toString,
			Void::TYPE.getTypeForName(judgmentDescription)
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))

			exceptions += judgmentDescription.ruleFailedExceptionType
			
			parameters += judgmentDescription.toParameter("_error", 
				judgmentDescription.newTypeRef(typeof(String))
			)
			parameters += judgmentDescription.toParameter("_issue", 
				judgmentDescription.newTypeRef(typeof(String))
			)
   			parameters += judgmentDescription.toParameter("_ex",
   				judgmentDescription.exceptionType
   			)
   			parameters += judgmentDescription.inputParameters
   			
   			parameters += judgmentDescription.toParameter("_errorInformations",
   				judgmentDescription.newTypeRef(typeof(ErrorInformation)).
   					addArrayTypeDimension
   			)
   			
   			if (errorSpecification != null) {
   				body = errorSpecification
   			} else {
   				body = '''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);'''
   			}
   			
//   			body = [
//   				if (errorSpecification != null) {
//	   				val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, it)
//					val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, it)
//					val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, it)
//	   				
//	   				it.newLine
//	   				it.append('''
//	   					«throwRuleFailedExceptionMethod»(«error»,
//	   						_issue, _ex, new ''')
//					judgmentDescription.errorInformationType.serialize(judgmentDescription, it)
//					it.append('''(«source», «feature»));''')
//				} else {
//					it.append('''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);''')
//				}
//   			]
		]
	}
	
	def compileThrowExceptionMethod(AuxiliaryDescription aux) {
		val errorSpecification = aux.error
		
		aux.toMethod(
			aux.throwExceptionMethod.toString,
			Void::TYPE.getTypeForName(aux)
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += aux.ruleFailedExceptionType
			
			parameters += aux.toParameter("_error", 
				aux.newTypeRef(typeof(String))
			)
			parameters += aux.toParameter("_issue", 
				aux.newTypeRef(typeof(String))
			)
   			parameters += aux.toParameter("_ex",
   				aux.exceptionType
   			)
   			parameters += aux.inputParameters
   			
   			parameters += aux.toParameter("_errorInformations",
   				aux.newTypeRef(typeof(ErrorInformation)).
   					addArrayTypeDimension
   			)
   			
   			if (errorSpecification != null) {
   				body = errorSpecification
   			} else {
   				body = '''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);'''
   			}
   			
//   			body = [
//   				if (errorSpecification != null) {
//	   				val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, it)
//					val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, it)
//					val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, it)
//	   				
//	   				it.newLine
//	   				it.append('''
//	   					«throwRuleFailedExceptionMethod»(«error»,
//	   						_issue, _ex, new ''')
//					aux.errorInformationType.serialize(aux, it)
//					it.append('''(«source», «feature»));''')
//				} else {
//					it.append('''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);''')
//				}
//   			]
		]
	}

	def compileInternalMethod(JudgmentDescription judgmentDescription) {
		judgmentDescription.toMethod(
			judgmentDescription.entryPointInternalMethodName.toString,
			judgmentDescription.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))
			
			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   			
   			body = '''
			try {
				checkParamsNotNull(«judgmentDescription.inputArgs»);
				return «judgmentDescription.polymorphicDispatcherField».invoke(«additionalArgs», «judgmentDescription.inputArgs»);
			} catch («Exception» «judgmentDescription.exceptionVarName») {
				sneakyThrowRuleFailedException(«judgmentDescription.exceptionVarName»);
				return null;
			}'''
		]
	}
	
	def compileInternalMethod(AuxiliaryDescription aux) {
		aux.toMethod(
			aux.entryPointInternalMethodName.toString,
			aux.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
   			parameters += aux.ruleApplicationTraceParam
   			for (p : aux.parameters) {
				parameters += p.toParameter(p.name, p.parameterType)
			}
			
			// check the original declared type (which can be null)
			val isBoolean = aux.newTypeRef(typeof(Boolean)).
				isConformant(aux.type)
   			
   			body = '''
				try {
					checkParamsNotNull(«aux.inputArgs»);
					return «aux.polymorphicDispatcherField».invoke(«ruleApplicationTraceName», «aux.inputArgs»);
				} catch («Exception» «aux.exceptionVarName») {
					«IF isBoolean»
						return false;
					«ELSE»
						sneakyThrowRuleFailedException(«aux.exceptionVarName»);
						return «IF aux.type === null»false«ELSE»null«ENDIF»;
					«ENDIF»
				}
				'''
				// don't return null if aux.type is null: the generated method will have
				// type Boolean and returning null is considered bad practice
				// see FindBugs NP_BOOLEAN_RETURN_NULL
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
			'''«rule.orSetJudgmentDescription.polymorphicDispatcherImpl»'''.toString,
			rule.orSetJudgmentDescription.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.paramForEnvironment
   			parameters += rule.orSetJudgmentDescription.ruleApplicationTraceParam
   			parameters += rule.inputParameters
   			
   			body = '''
				try {
					«RuleApplicationTrace» «ruleApplicationSubtraceName» = «newTraceMethod(ruleApplicationTraceName())»;
					«rule.orSetJudgmentDescription.resultType» _result_ = «rule.applyRuleName»(«rule.additionalArgsForRule», «rule.inputParameterNames»);
					«addToTraceMethod(ruleApplicationTraceName(), rule.traceStringForRule)»;
					«addAsSubtraceMethod(ruleApplicationTraceName(), ruleApplicationSubtraceName)»;
					return _result_;
				} catch («Exception» «rule.exceptionVarName») {
					«IF rule.conclusion.error != null»
					«rule.throwExceptionMethod»(«rule.exceptionVarName», «rule.inputParameterNames»);
					«ELSE»
					«rule.orSetJudgmentDescription.throwExceptionMethod»(«rule.errorForRule»,
						«rule.ruleIssueString»,
						e_«rule.applyRuleName», «rule.inputParameterNames»«rule.errorInformationArgs»);
					«ENDIF»
					return null;
				}
   				'''
		]
	}

	def compileImplMethod(AuxiliaryFunction aux) {
		val resultType = aux.resultType
		val isBoolean = aux.newTypeRef(typeof(Boolean)).
				isConformant(resultType)
		val auxiliaryDescription = aux.getOrSetAuxiliaryDescription
		
		aux.toMethod(
			'''«auxiliaryDescription.polymorphicDispatcherImpl»'''.toString,
			resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += aux.ruleFailedExceptionType
			
   			parameters += auxiliaryDescription.ruleApplicationTraceParam
   			parameters += aux.inputParameters
   			
   			body = '''
				try {
					«RuleApplicationTrace» «ruleApplicationSubtraceName» = «newTraceMethod(ruleApplicationTraceName())»;
					«aux.resultType.type» _result_ = «aux.applyAuxFunName»(«ruleApplicationSubtraceName», «aux.inputParameterNames»);
					«addToTraceMethod(ruleApplicationTraceName(), aux.traceStringForAuxiliaryFun)»;
					«addAsSubtraceMethod(ruleApplicationTraceName(), ruleApplicationSubtraceName)»;
					return _result_;
				} catch («Exception» e_«aux.applyAuxFunName») {
					«auxiliaryDescription.throwExceptionMethod»(«aux.errorForAuxiliaryFun»,
						«auxiliaryDescription.ruleIssueString»,
						e_«aux.applyAuxFunName», «aux.inputParameterNames»«aux.errorInformationArgs»);
					return «IF isBoolean»false«ELSE»null«ENDIF»;
				}
   				'''
   				// don't return null if resultType is boolean: the generated method will have
				// type Boolean and returning null is considered bad practice
				// see FindBugs NP_BOOLEAN_RETURN_NULL
		]
	}
	
	def StringConcatenationClient errorInformationArgs(Rule rule) {
		rule.inputEObjectParams.map[parameter.name].errorInformationArgs
	}

	def StringConcatenationClient errorInformationArgs(AuxiliaryFunction aux) {
		aux.inputEObjectParams.map[name].errorInformationArgs
	}

	def StringConcatenationClient errorInformationArgs(Iterable<String> names) {
		''', new «ErrorInformation»[] {«FOR name : names SEPARATOR ', '»new «ErrorInformation»(«name»)«ENDFOR»}'''
	}

	def compileApplyMethod(Rule rule) {
		rule.toMethod(
			rule.applyRuleName.toString,
			rule.orSetJudgmentDescription.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.paramForEnvironment
   			parameters += rule.ruleApplicationTraceParam
   			parameters += rule.inputParameters

			assignBody(rule)    			
		]
	}

	def dispatch assignBody(JvmExecutable logicalContainer, Rule rule) {
		logicalContainer.body = [
	   		rule.declareVariablesForOutputParams(it)
	   		rule.compileReturnResult(rule.orSetJudgmentDescription.resultType, it)
	   	]
	}

	def dispatch assignBody(JvmExecutable logicalContainer, RuleWithPremises rule) {
		logicalContainer.body = rule.premises
	}

	def compileExpressionInConclusionMethod(ExpressionInConclusion e) {
		e.toMethod(
			e.expressionInConclusionMethodName,
			e.expression.inferredType
		) 
		[
			visibility = JvmVisibility::PRIVATE
			
			val rule = e.containingRule

			exceptions += rule.ruleFailedExceptionType

			parameters += rule.paramForEnvironment
   			parameters += rule.inputParameters

			body = e.expression
		]
	}

	def compileErrorSpecificationMethod(Rule rule) {
		val errSpec = rule.conclusion.error
		
		errSpec.toMethod(
			rule.throwExceptionMethod.toString,
			Void::TYPE.getTypeForName(rule)
		) 
		[
			visibility = JvmVisibility::PRIVATE
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.toParameter(rule.exceptionVarName,
   				rule.exceptionType
   			)
			
   			parameters += rule.inputParameters

			body = errSpec
		]
	}

	def compileApplyAuxiliaryFunction(AuxiliaryFunction auxfun) {
		auxfun.toMethod(
			auxfun.applyAuxFunName.toString,
			auxfun.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED

			exceptions += auxfun.ruleFailedExceptionType
			
   			parameters += auxfun.ruleApplicationTraceParam
   			parameters += auxfun.inputParameters
   			
   			body = auxfun.body
		]
	}

	def compileCheckRuleMethods(CheckRule rule) {
		val checkMethods = <JvmOperation>newArrayList()
		
		checkMethods += rule.toMethod(
			'''«rule.methodName»''',
			rule.resultType
		) 
		[
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)
   			
   			body = '''return «rule.methodName»(null, «rule.element.parameter.name»);'''
		]
		
		checkMethods += rule.toMethod(
			'''«rule.methodName»''',
			rule.resultType
		) 
		[
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
			parameters += rule.ruleApplicationTraceParam
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)
   			
   			body = '''
				try {
					return «rule.methodName»Internal(«ruleApplicationTraceName.toString», «rule.element.parameter.name»);
				} catch («Exception» e) {
					return resultForFailure(e);
				}'''
		]
		
		checkMethods
	}

	def compileValidatorCheckRuleMethod(CheckRule rule) {
		rule.toMethod(
			'''«rule.methodName»''',
			Void::TYPE.getTypeForName(rule)
		) 
		[
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))

			annotations += rule.toAnnotation(typeof(Check))
			
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)
   			
   			body = 
   				'''
				errorGenerator.generateErrors(this,
					getXsemanticsSystem().«rule.methodName»(«rule.element.parameter.name»),
						«rule.element.parameter.name»);'''
		]
	}

	def compileInternalMethod(CheckRule rule) {
		rule.toMethod(
			'''«rule.methodName»Internal''',
			rule.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
			exceptions += rule.ruleFailedExceptionType
			
			parameters += rule.ruleApplicationTraceParam
   			parameters += rule.element.parameter.
   				toParameter(rule.element.parameter.name,
   					rule.element.parameter.parameterType
   				)

   			body = rule.premises
		]
	}
	
	def paramForEnvironment(Rule rule) {
		rule.toParameter(rule.ruleEnvName, rule.newTypeRef(typeof(RuleEnvironment)))
	}
	
	def inputParameters(Rule rule) {
		rule.inputParams.map [
			it.toParameter(
				it.parameter.name,
				it.parameter.parameterType
			)
		]
	}
	
}


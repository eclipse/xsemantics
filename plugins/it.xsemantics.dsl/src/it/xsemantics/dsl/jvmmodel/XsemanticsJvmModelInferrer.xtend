package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.UniqueNames
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.Cachable
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Named
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.XsemanticsProvider
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.XExpression
import it.xsemantics.dsl.xsemantics.Overrider

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
	
	@Inject extension XsemanticsTypeSystem typeSystem

	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            accept(..) method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the lambda you pass to accept as the last argument.
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
   		
   		acceptor.accept(inferredClass) [
			documentation = ts.documentation
			
			if (ts.superSystem != null)
				superTypes += ts.superSystem.cloneWithProxies
			else
				superTypes += XsemanticsRuntimeSystem.typeRef

			for (elem: ts.auxiliaryDescriptions) {
				members += elem.genIssueField
			}
			
			for (elem : ts.rules) {
				members += elem.genIssueField
			}
			
			for (injectedField : ts.injections) {
				members += injectedField.toField(
					injectedField.name, 
					injectedField.type
				) [
					documentation = injectedField.documentation
					addInjectAnnotation
					if (injectedField.extension) {
						addExtensionAnnotation
					}
					visibility = JvmVisibility::PRIVATE
				]
			}
			
			for (elem : ts.auxiliaryDescriptions) {
				members += elem.genPolymorphicDispatcherField
			}
			
			for (elem : ts.judgmentDescriptions) {
				members += elem.genPolymorphicDispatcherField
			}
			
			//val procedure = element.newTypeRef(typeof(Procedure1), it.newTypeRef())
			members += ts.genConstructor
			
			members += ts.genInit
			
			for (injectedField : ts.injections) {
				members += injectedField.toGetter
					(injectedField.name, injectedField.type)
				members += injectedField.toSetter
					(injectedField.name, injectedField.type)
			}
			
			for (elem : ts.auxiliaryDescriptions) {
				members += elem.genEntryPointMethods
			}

			for (elem : ts.judgmentDescriptions) {
				members += elem.genEntryPointMethods
				members += elem.genSucceededMethods
			}
			
			for (r : ts.checkrules) {
				members += r.compileCheckRuleMethods
				members += r.compileInternalMethod
			}

			for (elem : ts.auxiliaryDescriptions) {
				members += elem.compileInternalMethod
				members += elem.compileThrowExceptionMethod
				val cacheConditionMethod = elem.compileCacheConditionMethod
				if (cacheConditionMethod !== null)
					members += cacheConditionMethod
			}
			
			for (elem : ts.judgmentDescriptions) {
				members += elem.compileInternalMethod
				members += elem.compileThrowExceptionMethod
				val cacheConditionMethod = elem.compileCacheConditionMethod
				if (cacheConditionMethod !== null)
					members += cacheConditionMethod
			}
			
			for (aux : ts.auxiliaryFunctions) {
				if (aux.getAuxiliaryDescription != null) {
					members += aux.compileImplMethod
					members += aux.compileApplyAuxiliaryFunction
				}
			}
			
			for (rule : ts.rules) {
				if (rule.getJudgmentDescription != null) {
					members += rule.compileImplMethod
					members += rule.compileApplyMethod
					for (e : rule.expressionsInConclusion) {
						members += e.compileExpressionInConclusionMethod
					}
					if (rule.conclusion.error != null)
						members += rule.compileErrorSpecificationMethod
				}
			}
		]
		
		// generation of the Validator
		acceptor.accept(ts.toClass(ts.toValidatorJavaFullyQualifiedName)) [
			documentation = ts.documentation
			
			if (ts.superSystemDefinition != null)
				superTypes += ts.superSystemDefinition.toValidatorJavaFullyQualifiedName.typeRef
			else if (ts.validatorExtends != null)
				superTypes += ts.validatorExtends.cloneWithProxies
			else
				superTypes += AbstractDeclarativeValidator.typeRef

			if (ts.superSystem === null)
				members += ts.toField("errorGenerator", XsemanticsValidatorErrorGenerator.typeRef) [
					addInjectAnnotation
					visibility = JvmVisibility::PROTECTED
				]
			// avoid generating a field that masks the one in the superclass
			// FindBugs MF_CLASS_MASKS_FIELD
						
			members += ts.toField("xsemanticsSystem", inferredClass.createTypeRef) [
				addInjectAnnotation
				visibility = JvmVisibility::PROTECTED
			]
			
			members += ts.toGetter("xsemanticsSystem", inferredClass.createTypeRef) => [
				visibility = JvmVisibility::PROTECTED
				if (ts.superSystem != null)
   					addOverrideAnnotation
			]
			
			for (rule : ts.checkrules) {
				members += rule.compileValidatorCheckRuleMethod
			}
		]
   	}

   	def genIssueField(Named e) {
   		val issueField = e.toField(
				e.ruleIssueString,
				String.typeRef
			) [
				visibility = JvmVisibility::PUBLIC
				^static = true
				final = true
			]
		issueField.setInitializer [
			it.append('''"«e.toJavaFullyQualifiedName»"''')
		]
		issueField
   	}
   	
   	def genConstructor(XsemanticsSystem ts) {
   		ts.toConstructor() [
			body = [append("init();")]
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
		PolymorphicDispatcher.typeRef(e.resultType)
	}

	def polymorphicDispatcherType(AuxiliaryDescription e) {
		PolymorphicDispatcher.typeRef(e.resultType)
	}
	
	def genInit(XsemanticsSystem ts) {
   		ts.toMethod("init", Void::TYPE.getTypeForName(ts)) [
   			if (ts.superSystem != null)
   				addOverrideAnnotation
   			
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
   		val methodName = judgmentDescription.entryPointMethodName
   		val resultType = judgmentDescription.resultType
   		
   		judgmentDescription.toEntryMethodsTriple(methodName.toString, resultType)
		[
			val inputArgs = judgmentDescription.inputArgs
			
			val entryPointInternalInvocation =
			'''
				try {
					return «judgmentDescription.entryPointInternalMethodName»(«additionalArgs», «inputArgs»);
				} catch («Exception.simpleName» «judgmentDescription.exceptionVarName») {
					return resultForFailure«judgmentDescription.suffixStartingFrom2»(«judgmentDescription.exceptionVarName»);
				}'''
		
   			if (judgmentDescription.cacheEntryPointMethods) {
   				body = '''
				«bodyForCache(judgmentDescription, '''«environmentName», «inputArgs»''', entryPointInternalInvocation)»
				«wrapInGetFromCache(methodName, resultType, inputArgs, entryPointInternalInvocation)»'''
			} else {
				body = [ append(entryPointInternalInvocation) ]
			}
		]
   	}

	/**
	 * @param judgmentDescription
	 * @param name method name
	 * @param resultType method return type
	 * @param beforeInputParams can add parameters before the input parameters
	 * @param mainBodyCreator handles the creation of the body of the third method,
	 * 	which implements the real logic; the first two methods are only delegates with
	 * 	default arguments.
	 */
   	def toEntryMethodsTriple(JudgmentDescription judgmentDescription, String name, 
   			JvmTypeReference resultType, (JvmOperation) => void mainBodyCreator
   	) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		val inputArgs = judgmentDescription.inputArgs
   		// main entry point method
   		entryPointMethods += judgmentDescription.toEntryMethodCommon(name, resultType,
   			[], // no parameters before input params
   			[
   				body = '''return «name»(new «RuleEnvironment»(), null, «inputArgs»);'''
   			]	
   		)
   		
   		// entry point method with environment parameter
   		entryPointMethods += judgmentDescription.toEntryMethodCommon(name, resultType,
   			[
   				parameters += judgmentDescription.environmentParam
   			],
   			[
   				body = '''return «name»(«environmentName», null, «inputArgs»);'''
   			]
   		)
   		
   		// entry point method with environment parameter and rule application trace
		entryPointMethods += judgmentDescription.toEntryMethodCommon(name, resultType,
   			[
   				parameters += judgmentDescription.environmentParam
   				parameters += judgmentDescription.ruleApplicationTraceParam
   			],
   			mainBodyCreator
   		)
  		
   		entryPointMethods
   	}

	/**
	 * @param judgmentDescription
	 * @param name method name
	 * @param resultType method return type
	 * @param beforeInputParams can add parameters before the input parameters
	 * @param bodyCreator handles the creation of the body of the method
	 */
	def protected toEntryMethodCommon(JudgmentDescription judgmentDescription,
		String name,
		JvmTypeReference resultType,
		(JvmOperation) => void beforeInputParams,
		(JvmOperation) => void bodyCreator
	) {
		
		judgmentDescription.toMethod(name, resultType) [
   			addOverrideAnnotation(judgmentDescription)
   		
   			beforeInputParams.apply(it)	
   			parameters += judgmentDescription.inputParameters
   			
   			bodyCreator.apply(it)
   		]
	}

	def private bodyForCache(Cachable c, CharSequence args, CharSequence entryPointInternalInvocation) {
		val hasCacheCondition = c.cacheCondition !== null
		'''
		«IF hasCacheCondition»
if (!«c.cacheConditionMethod»(«args»))
	«entryPointInternalInvocation»
		«ENDIF»
		'''
	} 

	def private StringConcatenationClient wrapInGetFromCache(CharSequence methodName, JvmTypeReference resultType, 
			String inputArgs, CharSequence providerBody) {
		val envArg = environmentName
		wrapInGetFromCacheCommon(methodName, resultType, envArg, envArg, inputArgs, providerBody)
	}

	def private StringConcatenationClient wrapInGetFromCache2(CharSequence methodName, JvmTypeReference resultType, 
			String inputArgs, CharSequence providerBody) {
		wrapInGetFromCacheCommon(methodName, resultType, 
			'''(«RuleEnvironment.simpleName»)null''', "null", inputArgs, providerBody
		)
	}

	def private StringConcatenationClient wrapInGetFromCacheCommon(CharSequence methodName, JvmTypeReference resultType, 
		CharSequence getFromCacheEnvArg, CharSequence providerEnvArg, String inputArgs, CharSequence providerBody) {
		'''
		return getFromCache("«methodName»", «getFromCacheEnvArg», «ruleApplicationTraceName»,
			new «XsemanticsProvider»<«resultType»>(«providerEnvArg», «ruleApplicationTraceName») {
				public «resultType» doGet() {
					«providerBody»
				}
			}, «inputArgs»);'''
	}

   	def genSucceededMethods(JudgmentDescription judgmentDescription) {
		if (!typeSystem.isPredicate(judgmentDescription))
			return <JvmOperation>newArrayList()

   		judgmentDescription.toEntryMethodsTriple(judgmentDescription.succeededMethodName.toString, Boolean.typeRef)
		[
			body = '''
				try {
					«judgmentDescription.entryPointInternalMethodName»(«additionalArgs», «judgmentDescription.inputArgs»);
					return true;
				} catch («Exception» «judgmentDescription.exceptionVarName») {
					return false;
				}'''
   		]
   	}

   	def genEntryPointMethods(AuxiliaryDescription aux) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		entryPointMethods += aux.toMethod(
   			aux.entryPointMethodName.toString,
   			aux.resultType
   		) [
   			exceptions += ruleFailedExceptionType
   			
   			addOverrideAnnotation(aux)
   			
   			parameters += aux.inputParameters
   			
   			body = '''return «aux.entryPointMethodName»(null, «aux.inputArgs»);'''
   		]
   		
   		// entry point method with rule application trace
   		entryPointMethods += aux.toMethod(
   			aux.entryPointMethodName.toString,
   			aux.resultType
   		) [
   			exceptions += ruleFailedExceptionType
   			
   			addOverrideAnnotation(aux)

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
			environmentType
		)
	}
	
	def ruleApplicationTraceParam(EObject e) {
		e.toParameter(
			ruleApplicationTraceName.toString,
			RuleApplicationTrace.typeRef
		)
	}
	
	def compileThrowExceptionMethod(JudgmentDescription judgmentDescription) {
		val errorSpecification = judgmentDescription.error
		
		judgmentDescription.toMethod(
			judgmentDescription.throwExceptionMethod.toString,
			Void::TYPE.getTypeForName(judgmentDescription)
		) 
		[
			addProtectedAndOverride(judgmentDescription)

			exceptions += ruleFailedExceptionType
			
			parameters += judgmentDescription.toParameter("_error", 
				String.typeRef
			)
			parameters += judgmentDescription.toParameter("_issue", 
				String.typeRef
			)
   			parameters += judgmentDescription.toParameter("_ex",
   				judgmentDescription.exceptionType
   			)
   			parameters += judgmentDescription.inputParameters
   			
   			parameters += judgmentDescription.toParameter("_errorInformations",
   				ErrorInformation.typeRef.addArrayTypeDimension
   			)
   			
   			compileErrorSpecification(errorSpecification)
		]
	}

	def compileErrorSpecification(JvmOperation it, XExpression errorSpecification) {
		if (errorSpecification != null) {
			body = errorSpecification
		} else {
			body = '''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);'''
		}
	}

	def compileCacheConditionMethod(Cachable cachable) {
		val condition = cachable.cacheCondition
		
		if (condition === null)
			return null
		
		cachable.toMethod(
			cachable.cacheConditionMethod.toString,
			Boolean.getTypeForName(cachable)
		)
		[
			visibility = JvmVisibility::PROTECTED
			
			if (cachable instanceof JudgmentDescription) {
				parameters += cachable.toParameter("environment", 
					RuleEnvironment.typeRef
				)
				
				parameters += cachable.inputParameters
			} else if (cachable instanceof AuxiliaryDescription) {
				parameters += cachable.inputParameters
			}
			
			body = condition
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
			
			exceptions += ruleFailedExceptionType
			
			parameters += aux.toParameter("_error", String.typeRef)
			parameters += aux.toParameter("_issue", String.typeRef)
   			parameters += aux.toParameter("_ex", aux.exceptionType)
   			parameters += aux.inputParameters
   			
   			parameters += aux.toParameter("_errorInformations",
   				ErrorInformation.typeRef.addArrayTypeDimension
   			)
   			
   			compileErrorSpecification(errorSpecification)
		]
	}

	def compileInternalMethod(JudgmentDescription judgmentDescription) {
		val methodName = judgmentDescription.entryPointInternalMethodName.toString
		val resultType = judgmentDescription.resultType
		judgmentDescription.toMethod(
			methodName,
			resultType
		) 
		[
			addProtectedAndOverride(judgmentDescription)
			
			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   			
   			val inputArgs = judgmentDescription.inputArgs
   			val exceptionName = judgmentDescription.exceptionVarName
   			
   			val usePolymorphicDispatch = polymorphicInvokeTryCacth(
   				judgmentDescription.polymorphicDispatcherField,
   				additionalArgs, inputArgs, exceptionName,
   				'''
				sneakyThrowRuleFailedException(«exceptionName»);
				return null;'''
   			)
   			
   			if (judgmentDescription.cachedClause !== null) {
   				body = '''
				«bodyForCache(judgmentDescription, '''«environmentName», «inputArgs»''', usePolymorphicDispatch)»
				«wrapInGetFromCache(methodName, resultType, inputArgs, usePolymorphicDispatch)»'''
   			} else {
	   			body = [append(usePolymorphicDispatch)]
			}
		]
	}
	
	def compileInternalMethod(AuxiliaryDescription aux) {
		val methodName = aux.entryPointInternalMethodName.toString
		val resultType = aux.resultType
		aux.toMethod(
			methodName,
			resultType
		) 
		[
			addProtectedAndOverride(aux)
			
   			parameters += aux.ruleApplicationTraceParam
   			for (p : aux.parameters) {
				parameters += p.toParameter(p.name, p.parameterType)
			}
			
			// check the original declared type (which can be null)
			val isBoolean = aux.type.isBoolean
			
			val exceptionName = aux.exceptionVarName
			val inputArgs = aux.inputArgs
			
			val invokePolymorphicDispatcher = polymorphicInvokeTryCacth(
				aux.polymorphicDispatcherField,
				ruleApplicationTraceName, inputArgs,
				exceptionName,
				'''
				«IF isBoolean»
					return false;
				«ELSE»
					sneakyThrowRuleFailedException(«exceptionName»);
					return «IF aux.type === null»false«ELSE»null«ENDIF»;
				«ENDIF»
				'''
			)
   			
   			if (aux.cachedClause !== null) {
   				body = '''
   				«bodyForCache(aux, inputArgs, invokePolymorphicDispatcher)»
   				«wrapInGetFromCache2(methodName, resultType, inputArgs, invokePolymorphicDispatcher)»'''
   			} else {
	   			body = [append(invokePolymorphicDispatcher)]
			}
			// don't return null if aux.type is null: the generated method will have
			// type Boolean and returning null is considered bad practice
			// see FindBugs NP_BOOLEAN_RETURN_NULL
		]
	}

	def private polymorphicInvokeTryCacth(CharSequence polymorphicDispatcherField, 
			CharSequence additionalArgs, CharSequence inputArgs, CharSequence exceptionName, CharSequence catchBlock
	) {
		'''
		try {
			checkParamsNotNull(«inputArgs»);
			return «polymorphicDispatcherField».invoke(«additionalArgs», «inputArgs»);
		} catch («Exception.simpleName» «exceptionName») {
			«catchBlock»
		}'''
	}

	def ruleFailedExceptionType() {
		RuleFailedException.typeRef
	}
	
	def environmentType() {
		RuleEnvironment.typeRef
	}
	
	def compileImplMethod(Rule rule) {
		val judgment = rule.getJudgmentDescription
		val resultType = judgment.resultType
		rule.toMethod(
			'''«judgment.polymorphicDispatcherImpl»'''.toString,
			judgment.resultType
		) 
		[
			setupMethodForRule(rule)
			
			val exceptionVarName = rule.exceptionVarName
			val inputArgs = rule.inputParameterNames
			val applyRuleName = rule.applyRuleName
   			
   			body = bodyForImplMethod(resultType, applyRuleName,
				rule.additionalArgsForRule, inputArgs, rule.traceStringForRule, exceptionVarName,
				'''
				«IF rule.conclusion.error != null»
					«rule.throwExceptionMethod»(«exceptionVarName», «inputArgs»);
				«ELSE»
				«judgment.throwExceptionMethod»(«rule.errorForRule»,
						«rule.ruleIssueString»,
						e_«applyRuleName», «inputArgs»«rule.errorInformationArgs»);
				«ENDIF»
					return null;
   				'''
   			)
		]
	}

	def private void setupMethodForRule(JvmOperation it, Rule rule) {
		addProtectedAndOverride(rule)
			
		exceptions += ruleFailedExceptionType
		
		parameters += rule.paramForEnvironment
		parameters += rule.ruleApplicationTraceParam
		parameters += rule.inputParameters
	}

	def compileImplMethod(AuxiliaryFunction aux) {
		val resultType = aux.resultType
		val isBoolean = resultType.isBoolean
		val auxiliaryDescription = aux.getAuxiliaryDescription
		
		aux.toMethod(
			'''«auxiliaryDescription.polymorphicDispatcherImpl»'''.toString,
			resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += ruleFailedExceptionType
			
   			parameters += auxiliaryDescription.ruleApplicationTraceParam
   			parameters += aux.inputParameters
   			
   			val inputArgs = aux.inputParameterNames
   			val applyName = aux.applyAuxFunName
   			val exceptionVarName = aux.exceptionVarName
   			
   			body = bodyForImplMethod(resultType, applyName,
				ruleApplicationSubtraceName, inputArgs, aux.traceStringForAuxiliaryFun, exceptionVarName,
   				'''
					«auxiliaryDescription.throwExceptionMethod»(«aux.errorForAuxiliaryFun»,
							«auxiliaryDescription.ruleIssueString»,
							«exceptionVarName», «inputArgs»«aux.errorInformationArgs»);
						return «IF isBoolean»false«ELSE»null«ENDIF»;
   				'''
   			)
   				// don't return null if resultType is boolean: the generated method will have
				// type Boolean and returning null is considered bad practice
				// see FindBugs NP_BOOLEAN_RETURN_NULL
		]
	}

	def private StringConcatenationClient bodyForImplMethod(JvmTypeReference resultType, CharSequence applyRuleName,
			CharSequence additionalArgs, CharSequence inputArgs, CharSequence traceString, CharSequence exceptionVarName,
			StringConcatenationClient catchBlock
	) {
		'''
		try {
			final «RuleApplicationTrace» «ruleApplicationSubtraceName» = «newTraceMethod(ruleApplicationTraceName())»;
			final «resultType» «resultVariableForTrace» = «applyRuleName»(«additionalArgs», «inputArgs»);
			«addToTraceMethod(ruleApplicationTraceName, traceString)»;
			«addAsSubtraceMethod(ruleApplicationTraceName, ruleApplicationSubtraceName)»;
			return «resultVariableForTrace»;
		} catch («Exception» «exceptionVarName») {
			«catchBlock»
		}
		'''
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
			rule.getJudgmentDescription.resultType
		) 
		[
			setupMethodForRule(rule)

			assignBody(rule)    			
		]
	}

	def dispatch assignBody(JvmExecutable logicalContainer, Rule rule) {
		logicalContainer.body = [
	   		rule.declareVariablesForOutputParams(it)
	   		rule.compileReturnResult(rule.getJudgmentDescription.resultType, it)
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

			exceptions += ruleFailedExceptionType

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
			
			exceptions += ruleFailedExceptionType
			
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

			exceptions += ruleFailedExceptionType
			
   			parameters += auxfun.ruleApplicationTraceParam
   			parameters += auxfun.inputParameters
   			
   			body = auxfun.body
		]
	}

	def compileCheckRuleMethods(CheckRule rule) {
		val checkMethods = <JvmOperation>newArrayList()
		val methodName = rule.methodName
		val resultType = rule.resultType
		
		checkMethods += rule.toMethod(
			'''«methodName»''',
			resultType
		) 
		[
			setupMethodForCheckRule(rule)
   			
   			body = '''return «methodName»(null, «rule.element.parameter.name»);'''
		]
		
		checkMethods += rule.toMethod(
			'''«methodName»''',
			resultType
		) 
		[
			parameters += rule.ruleApplicationTraceParam
			setupMethodForCheckRule(rule)
   			
   			body = '''
				try {
					return «methodName»Internal(«ruleApplicationTraceName.toString», «rule.element.parameter.name»);
				} catch («Exception» e) {
					return resultForFailure(e);
				}'''
		]
		
		checkMethods
	}

	def compileValidatorCheckRuleMethod(CheckRule rule) {
		val methodName = rule.methodName
		
		rule.toMethod(
			'''«methodName»''',
			Void::TYPE.getTypeForName(rule)
		) 
		[
			setupMethodForCheckRule(rule)			

			annotations += Check.annotationRef
   			
   			body = 
   				'''
				errorGenerator.generateErrors(this,
					getXsemanticsSystem().«methodName»(«rule.element.parameter.name»),
						«rule.element.parameter.name»);'''
		]
	}

	def compileInternalMethod(CheckRule rule) {
		val methodName = rule.methodName
		
		rule.toMethod(
			'''«methodName»Internal''',
			rule.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			exceptions += ruleFailedExceptionType
			
			parameters += rule.ruleApplicationTraceParam
			setupMethodForCheckRule(rule)

   			body = rule.premises
		]
	}

	def private setupMethodForCheckRule(JvmOperation it, CheckRule rule) {
		addOverrideAnnotation(rule)
		
		parameters += rule.element.parameter.
			toParameter(rule.element.parameter.name,
				rule.element.parameter.parameterType
			)
	}
	
	def paramForEnvironment(Rule rule) {
		rule.toParameter(rule.ruleEnvName, RuleEnvironment.typeRef)
	}
	
	def inputParameters(Rule rule) {
		rule.inputParams.map [
			it.toParameter(
				it.parameter.name,
				it.parameter.parameterType
			)
		]
	}

	def isBoolean(JvmTypeReference typeRef) {
		typeRef != null
		&&
		{
		val identifier = typeRef.getType().getIdentifier()
		
		"boolean".equals(identifier)
		||
		"java.lang.Boolean".equals(identifier)
		}
	}

	def private addProtectedAndOverride(JvmOperation it, Overrider overrider) {
		visibility = JvmVisibility::PROTECTED
		addOverrideAnnotation(overrider)
	}

	def private addOverrideAnnotation(JvmAnnotationTarget it, Overrider overrider) {
		if (overrider.override)
			addOverrideAnnotation
	}

	def private addOverrideAnnotation(JvmAnnotationTarget it) {
		annotations += Override.annotationRef
	}

	def private addInjectAnnotation(JvmAnnotationTarget it) {
		annotations += Inject.annotationRef
	}

	def private addExtensionAnnotation(JvmAnnotationTarget it) {
		annotations += Extension.annotationRef
	}

}


package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.UniqueNames
import it.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer
import org.eclipse.xtext.xbase.XbaseFactory

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
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension TypeReferences
	
	@Inject extension XbaseTypeConformanceComputer

	@Inject XbaseCompiler xbaseCompiler
	
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

			ts.auxiliaryDescriptions.forEach [
				elem |
				members += elem.genIssueField
			]
			
			ts.rules.forEach [
				elem |
				members += elem.genIssueField
			]
			
			ts.injections.forEach [
				injectedField |
				members += injectedField.toField(
					injectedField.name, 
					injectedField.type
				) [
					documentation = injectedField.documentation
					annotations += ts.toAnnotation(typeof(Inject))
					visibility = JvmVisibility::PRIVATE
				]
			]
			
			ts.auxiliaryDescriptions.forEach [
				elem |
				members += elem.genPolymorphicDispatcherField
			]
			
			ts.judgmentDescriptions.forEach [
				elem |
				members += elem.genPolymorphicDispatcherField
			]
			
			//val procedure = element.newTypeRef(typeof(Procedure1), it.newTypeRef())
			members += ts.genConstructor
			
			members += ts.genInit
			
			ts.injections.forEach [
				injectedField |
				members += injectedField.toGetter
					(injectedField.name, injectedField.type)
				members += injectedField.toSetter
					(injectedField.name, injectedField.type)
			]
			
			ts.auxiliaryDescriptions.forEach [
				elem |
				members += elem.genEntryPointMethods
			]

			ts.judgmentDescriptions.forEach [
				elem |
				members += elem.genEntryPointMethods
			]
			
			ts.checkrules.forEach [
				r |
				members += r.compileCheckRuleMethods
				members += r.compileInternalMethod
			]

			ts.auxiliaryDescriptions.forEach [
				elem |
				members += elem.compileInternalMethod
				members += elem.compileThrowExceptionMethod
			]
			
			ts.judgmentDescriptions.forEach [
				elem |
				members += elem.compileInternalMethod
				members += elem.compileThrowExceptionMethod
			]
			
			ts.auxiliaryFunctions.forEach [
				aux |
				if (aux.auxiliaryDescription != null) {
					members += aux.compileImplMethod
					members += aux.compileApplyAuxiliaryFunction
				}
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
			
			if (ts.superSystemDefinition != null)
				superTypes += ts.newTypeRef(ts.superSystemDefinition.toValidatorJavaFullyQualifiedName)
			else if (ts.validatorExtends != null)
				superTypes += ts.validatorExtends.cloneWithProxies
			else
				superTypes += ts.newTypeRef(typeof(AbstractDeclarativeValidator))

			members += ts.toField("errorGenerator", ts.newTypeRef(typeof(XsemanticsValidatorErrorGenerator))) [
				annotations += ts.toAnnotation(typeof(Inject))
				visibility = JvmVisibility::PROTECTED
			]
						
			members += ts.toField("xsemanticsSystem", inferredClass.createTypeRef) [
				annotations += ts.toAnnotation(typeof(Inject))
				visibility = JvmVisibility::PROTECTED
			]
			
			members += ts.toGetter("xsemanticsSystem", inferredClass.createTypeRef) => [
				visibility = JvmVisibility::PROTECTED
				if (ts.superSystem != null)
   					annotations += ts.toAnnotation(typeof(Override))
			]
			
			ts.checkrules.forEach [
				rule |
				members += rule.compileValidatorCheckRuleMethod
			]
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
   		ts.toMethod("init", null) [
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
			»"«judgmentDescription.judgmentSymbol»"«
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
   			
   			body = [
   				it.append(
   				'''return «judgmentDescription.entryPointMethodName»(new ''')
   				it.append(judgmentDescription.environmentType.type)
   				it.append('''(), null, «judgmentDescription.inputArgs»);''')
   			]
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
   			
   			body = [
   				it.append(
   				'''return «judgmentDescription.entryPointMethodName»(«environmentName», null, «judgmentDescription.inputArgs»);''')
   			]
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

   	def genEntryPointMethods(AuxiliaryDescription aux) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		entryPointMethods += aux.toMethod(
   			aux.entryPointMethodName.toString,
   			aux.resultType
   		) [
   			exceptions += aux.ruleFailedExceptionType
   			
   			parameters += aux.inputParameters
   			
   			body = [
   				it.append(
   				'''return «aux.entryPointMethodName»(null, «aux.inputArgs»);''')
   			]
   		]
   		
   		// entry point method with rule application trace
   		entryPointMethods += aux.toMethod(
   			aux.entryPointMethodName.toString,
   			aux.resultType
   		) [
   			exceptions += aux.ruleFailedExceptionType
   			
   			parameters += aux.ruleApplicationTraceParam
   			parameters += aux.inputParameters
   			
   			body = [
   				it.append('''
				try {
					return «aux.entryPointInternalMethodName»(«ruleApplicationTraceName», «aux.inputArgs»);
				} catch (''')
				aux.exceptionType.serialize(aux, it)
				it.append(" ")
				it.append('''
				«aux.exceptionVarName») {
					throw extractRuleFailedException(«aux.exceptionVarName»);
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
			null
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
   			
   			body = [
   				if (errorSpecification != null) {
	   				val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, it)
					val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, it)
					val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, it)
	   				
	   				it.newLine
	   				it.append('''
	   					«throwRuleFailedExceptionMethod»(«error»,
	   						_issue, _ex, new ''')
					judgmentDescription.errorInformationType.serialize(judgmentDescription, it)
					it.append('''(«source», «feature»));''')
				} else {
					it.append('''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);''')
				}
   			]
		]
	}
	
	def compileThrowExceptionMethod(AuxiliaryDescription aux) {
		val errorSpecification = aux.error
		
		aux.toMethod(
			aux.throwExceptionMethod.toString,
			null
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
   			
   			body = [
   				if (errorSpecification != null) {
	   				val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, it)
					val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, it)
					val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, it)
	   				
	   				it.newLine
	   				it.append('''
	   					«throwRuleFailedExceptionMethod»(«error»,
	   						_issue, _ex, new ''')
					aux.errorInformationType.serialize(aux, it)
					it.append('''(«source», «feature»));''')
				} else {
					it.append('''«throwRuleFailedExceptionMethod»(_error, _issue, _ex, _errorInformations);''')
				}
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
			
			if (judgmentDescription.^override)
				annotations += judgmentDescription.toAnnotation(typeof(Override))
			
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
   			
   			body = [
   				it.append('''
					try {
						checkParamsNotNull(«aux.inputArgs»);
						return «aux.polymorphicDispatcherField».invoke(«ruleApplicationTraceName», «aux.inputArgs»);
					} catch (''')
				aux.exceptionType.serialize(aux, it)
				it.append(" ")
				if (isBoolean)
					it.append('''
						«aux.exceptionVarName») {
							return false;
						}'''
					)
				else
					it.append('''
						«aux.exceptionVarName») {
							sneakyThrowRuleFailedException(«aux.exceptionVarName»);
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
			
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
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

	def compileImplMethod(AuxiliaryFunction aux) {
		aux.toMethod(
			'''«aux.auxiliaryDescription.polymorphicDispatcherImpl»'''.toString,
			aux.resultType
		) 
		[
			visibility = JvmVisibility::PROTECTED
			
			exceptions += aux.ruleFailedExceptionType
			
   			parameters += aux.auxiliaryDescription.ruleApplicationTraceParam
   			parameters += aux.inputParameters
   			
   			body = [
   				it.append('''try {''').increaseIndentation.newLine
				it.append(aux.ruleApplicationTraceType.type)
				it.append(''' «ruleApplicationSubtraceName» = «newTraceMethod(ruleApplicationTraceName())»;''').newLine
				it.append(aux.resultType.type)
				it.append(" ")
				it.append('''
					_result_ = «aux.applyAuxFunName»(«ruleApplicationSubtraceName», «aux.inputParameterNames»);
					«addToTraceMethod(ruleApplicationTraceName(), aux.traceStringForAuxiliaryFun)»;
					«addAsSubtraceMethod(ruleApplicationTraceName(), ruleApplicationSubtraceName)»;
					return _result_;''').decreaseIndentation.newLine
				it.append('''} catch (''')
				aux.exceptionType.serialize(aux, it)
				it.append(" ")
				it.append('''''')
				it.append('''e_«aux.applyAuxFunName») {''').increaseIndentation.newLine
   				aux.compileFinalThrow(it)
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
			b.append('''(«source», «feature»))''')
		} else {
			b.append('''
			«rule.judgmentDescription.throwExceptionMethod»(«rule.errorForRule»,
				«rule.ruleIssueString»,
				e_«rule.applyRuleName», «rule.inputParameterNames»''')
			rule.errorInformationArgs(b)
			b.append(''')''')
		}
	}

	def compileFinalThrow(AuxiliaryFunction aux, ITreeAppendable b) {
		b.append('''
		«aux.auxiliaryDescription.throwExceptionMethod»(«aux.errorForAuxiliaryFun»,
			«aux.auxiliaryDescription.ruleIssueString»,
			e_«aux.applyAuxFunName», «aux.inputParameterNames»''')
		aux.errorInformationArgs(b)
		b.append(''')''')
	}

	def errorInformationArgs(Rule rule, ITreeAppendable b) {
		val inputEObjects = rule.inputEObjectParams
		b.append(", ")
		b.append('''new ''')
		rule.newTypeRef(typeof(ErrorInformation)).serialize(rule, b)
		b.append('''[] {''')

		val iter = inputEObjects.iterator
		val errInfoType = rule.errorInformationType.type
		while (iter.hasNext) {
			b.append("new ")
			b.append(errInfoType)
			b.append('''(«iter.next.parameter.name»)''')
			if (iter.hasNext)
				b.append(", ")
		}

		b.append('''}''')
	}

	def errorInformationArgs(AuxiliaryFunction aux, ITreeAppendable b) {
		val inputEObjects = aux.inputEObjectParams
		b.append(", ")
		b.append('''new ''')
		aux.newTypeRef(typeof(ErrorInformation)).serialize(aux, b)
		b.append('''[] {''')

		val iter = inputEObjects.iterator
		val errInfoType = aux.errorInformationType.type
		while (iter.hasNext) {
			b.append("new ")
			b.append(errInfoType)
			b.append('''(«iter.next.name»)''')
			if (iter.hasNext)
				b.append(", ")
		}

		b.append('''}''')
	}

	def compileApplyMethod(Rule rule) {
		rule.toMethod(
			rule.applyRuleName.toString,
			rule.judgmentDescription.resultType
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
//   			body = [
//   				rule.declareVariablesForOutputParams(it) 
//   				rule.compileRuleBody(rule.judgmentDescription.resultType, it)
//   			]
		]
	}
	
	def dispatch assignBody(JvmExecutable logicalContainer, Rule rule) {
//		logicalContainer.body = [
//			// TODO this is duplicate also in xbase compiler
//	   		rule.declareVariablesForOutputParams(it)
//	   	]
		logicalContainer.body = XbaseFactory.eINSTANCE.createXBlockExpression => [
			rule.eResource.contents += it
		]
	}

	def dispatch assignBody(JvmExecutable logicalContainer, RuleWithPremises rule) {
		logicalContainer.body = rule.premises
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
   			
   			body = [
   				it.append(
   				'''return «rule.methodName»(null, «rule.element.parameter.name»);'''
   				)
   			]
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
   			
   			body = [
   				it.append(
   				'''
				try {
					return «rule.methodName»Internal(«ruleApplicationTraceName.toString», «rule.element.parameter.name»);
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
   			
   			body = [
   				it.append(
   				'''
				errorGenerator.generateErrors(this,
					getXsemanticsSystem().«rule.methodName»(«rule.element.parameter.name»),
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
			
			if (rule.^override)
				annotations += rule.toAnnotation(typeof(Override))
			
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
		rule.inputParams.map [
			it.toParameter(
				it.parameter.name,
				it.parameter.parameterType
			)
		]
	}

	def inputArgs(Rule rule) {
		rule.inputParams.map[
			it.parameter.name
		].join(", ")
	}	
	


	def void compilePremises(CheckRule rule, ITreeAppendable result) {
		xbaseCompiler.toJavaStatement(rule.premises, result, false)
	}
	


}


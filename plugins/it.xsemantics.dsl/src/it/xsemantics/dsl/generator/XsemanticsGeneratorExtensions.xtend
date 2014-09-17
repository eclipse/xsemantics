package it.xsemantics.dsl.generator

import com.google.inject.Inject
import com.google.inject.Provider
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.Cachable
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Named
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.UniqueByName
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.Result3
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

import static extension org.eclipse.xtext.util.Strings.*
import it.xsemantics.dsl.xsemantics.Description

class XsemanticsGeneratorExtensions {
	
	@Inject extension IQualifiedNameProvider
	
	@Inject extension XsemanticsUtils
	
	@Inject extension XsemanticsTypeSystem typeSystem
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension TypeReferences
	
	@Inject
	protected IJvmModelAssociations associations
	
	protected static val RESULT_GET_METHODS = newArrayList(
		"getFirst()", "getSecond()", "getThird()"
	)
	
	def static getResultGetMethods() {
		return RESULT_GET_METHODS;
	}
	
	def toJavaFullyQualifiedName(XsemanticsSystem ts) {
		ts.fullyQualifiedName
	}
	
	def toJavaFullyQualifiedName(Named e) {
		val fQN = e.containingSystem.toJavaFullyQualifiedName
		if (fQN != null && fQN.segmentCount > 1)
			fQN.skipLast(1) + "." + e.toJavaClassName
		else
			e.toJavaClassName
	}

	def toJavaClassName(Named e) {
		e.name.toFirstUpper
	}
	
	def toValidatorPackage(XsemanticsSystem ts) {
		val typeSystemPackage = ts.fullyQualifiedName
		if (typeSystemPackage != null && typeSystemPackage.segmentCount > 1)
			typeSystemPackage.skipLast(1) + "." + "validation"
		else
			""
	}

	def toValidatorJavaClassName(XsemanticsSystem ts) {
		ts.fullyQualifiedName?.lastSegment + "Validator"
	}
	
	def toValidatorJavaFullyQualifiedName(XsemanticsSystem ts) {
		val validatorPackage = ts.toValidatorPackage
		if (validatorPackage.length > 0)
			validatorPackage + "." + ts.toValidatorJavaClassName
		else
			ts.toValidatorJavaClassName
	}
	
	def ruleIssueString(Named e) {
		e.name.toUpperCase
	}

	def polymorphicDispatcherField(UniqueByName e) {
		'''«e.name»Dispatcher'''
	}
	
	def relationSymbolsArgs(JudgmentDescription judgmentDescription) {
		judgmentDescription.relationSymbols.map(['''"«it.escapeJavaStringChars»"''']).join(", ")
	}

	def polymorphicDispatcherImpl(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»Impl'''
	}
	
	def polymorphicDispatcherBuildMethod(JudgmentDescription judgmentDescription) {
		'''buildPolymorphicDispatcher«judgmentDescription.polymorphicDispatcherBuildMethodSuffix»'''
	}

	def polymorphicDispatcherBuildMethodSuffix(JudgmentDescription judgmentDescription) {
		if (judgmentDescription.outputJudgmentParameters.size() == 0)
			1
		else
			judgmentDescription.outputJudgmentParameters.size()
	}

	def polymorphicDispatcherImpl(AuxiliaryDescription aux) {
		'''«aux.name»Impl'''
	}


	def polymorphicDispatcherNumOfArgs(JudgmentDescription judgmentDescription) {
		// add 2 for the environment to be passed and the RuleApplicationTrace
		'''«judgmentDescription.inputParams.size + 2»'''
	}

	def polymorphicDispatcherNumOfArgs(AuxiliaryDescription aux) {
		// add 1 for the RuleApplicationTrace
		'''«aux.parameters.size + 1»'''
	}

	def entryPointMethodName(Description desc) {
		'''«desc.name»'''
	}

	def succeededMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»Succeeded'''
	}

	def inputArgs(JudgmentDescription judgmentDescription) {
		val names = new UniqueNames()
		judgmentDescription.inputParams.map([ 
			'''«names.createName(it.inputParameterName)»'''
		]).join(", ")
	}

	def inputArgs(AuxiliaryDescription aux) {
		aux.parameters.map[name].join(", ")
	}

	def inputParameterName(InputParameter param) {
		param.parameter.name
	}

	def environmentName() '''_environment_'''

	def entryPointInternalMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.entryPointMethodName»Internal'''
	}

	def entryPointInternalMethodName(AuxiliaryDescription aux) {
		'''«aux.entryPointMethodName»Internal'''
	}

	def additionalArgs() {
		'''«environmentName», «ruleApplicationTraceName»'''
	}

	def ruleApplicationTraceName() '''_trace_'''

	def ruleApplicationSubtraceName() '''_subtrace_'''

	def exceptionVarName(Description desc) {
		'''_e_«desc.name»'''
	}

	def String exceptionVarName(Rule rule) {
		'''e_«rule.applyRuleName»'''
	}

	def String exceptionVarName(AuxiliaryFunction aux) {
		'''e_«aux.applyAuxFunName»'''
	}

	def suffixStartingFrom2(JudgmentDescription judgmentDescription) {
		val numOfOutputParams = judgmentDescription.outputJudgmentParameters.size();
		if (numOfOutputParams > 1)
			"" + numOfOutputParams
		else
			""
	}

	def throwExceptionMethod(UniqueByName e) {
		'''«e.name.toFirstLower»ThrowException'''
	}

	def cacheConditionMethod(Cachable c) {
		'''«c.name.toFirstLower»CacheCondition'''
	}

	def throwRuleFailedExceptionMethod() {
		'''throwRuleFailedException'''
	}

	def newTraceMethod(CharSequence trace) '''newTrace(«trace»)'''

	def applyRuleName(Rule rule) {
		'''applyRule«rule.toJavaClassName»'''
	}

	def applyAuxFunName(AuxiliaryFunction aux) {
		'''applyAuxFun«aux.toJavaClassName»'''
	}

	def additionalArgsForRule(Rule rule) {
		'''«rule.ruleEnvName», «ruleApplicationSubtraceName»'''
	}

	def additionalArgsForRuleInvocation(RuleInvocation ruleInvocation) {
		'''«ruleApplicationTraceName»'''
	}

	def ruleEnvName(Rule rule) {
		rule.conclusion.environment.name
	}

	def StringConcatenationClient addToTraceMethod(CharSequence trace, CharSequence toAdd) '''
		addToTrace(«trace», new «Provider»<Object>() {
				public Object get() {
					return «toAdd»;
				}
			})'''
	
	def addAsSubtraceMethod(CharSequence trace, CharSequence subtrace) '''
		addAsSubtrace(«trace», «subtrace»)'''

	def traceStringForRule(Rule rule) {
		val getMethods = getResultGetMethods.iterator
		rule.stringForRule(
			[wrapInStringRepr('''«resultVariableForTrace».«getMethods.next»''')],
			[wrapInStringRepr(it.ruleConclusionInputParamForError)])
	}

	def stringForRule(Rule rule,
			(RuleConclusionElement)=>CharSequence forOutput,
			(RuleConclusionElement)=>CharSequence forInput) {
		val buffer = new StringBuffer(
		'''«rule.name.ruleNameInvocation» + «wrapInStringReprForEnv(rule.ruleEnvName)» + " «rule.conclusion.judgmentSymbol» "'''
		)
		val judgmentParameters = rule.getJudgmentDescription.getJudgmentParameters.iterator
		val relationSymbols = rule.conclusion.relationSymbols.iterator
		for (e : rule.conclusion.conclusionElements) {
			buffer.append(" + ")
			if (judgmentParameters.next.outputParameter) {
				buffer.append(forOutput.apply(e))
			} else {
				buffer.append(forInput.apply(e))
			}
			if (relationSymbols.hasNext)
				buffer.append(''' + " «relationSymbols.next.escapeJavaStringChars» "''')
			
		}
		buffer.toString
	}

	def traceStringForAuxiliaryFun(AuxiliaryFunction aux) {
		aux.errorForAuxiliaryFun + ''' + " = " + ''' +
			resultVariableForTrace.wrapInStringRepr
	}

	def ruleNameInvocation(String ruleName) '''ruleName("«ruleName»")'''

	def auxFunNameInvocation(String ruleName) '''auxFunName("«ruleName»")'''

	def wrapInStringReprForEnv(CharSequence s) {
		'''«stringRepresentationForEnv»(«s»)'''
	}

	def stringRepresentationForEnv() '''stringRepForEnv'''

	def stringRepresentation() '''stringRep'''

	def wrapInStringRepr(CharSequence s) {
		'''«stringRepresentation»(«s»)'''
	}

	def resultVariableForTrace() '''_result_'''

	def environmentAccessMethod() {
		"environmentAccess"
	}

	def sneakyThrowRuleFailedException() {
		"sneakyThrowRuleFailedException"
	}

	def ruleConclusionInputParamForError(RuleConclusionElement element) {
		// this is called only for input params
		(element as RuleParameter).parameter.name
	}

	def inputParameterNames(Rule rule) {
		rule.inputParams.map[parameter.name].join(", ")
	}

	def inputParameterNames(AuxiliaryFunction aux) {
		aux.parameters.map[name].join(", ")
	}

	def errorForRule(Rule rule) {
		rule.stringForRule(
			['''"«it.ruleConclusionOutputParamForError»"'''],
			[wrapInStringRepr(it.ruleConclusionInputParamForError)]
		)
	}

	def errorForAuxiliaryFun(AuxiliaryFunction aux) {
		aux.getAuxiliaryDescription.name.auxFunNameInvocation + 
		''' + "(" + «aux.parameters.map[name.wrapInStringRepr].join(''' + ", " + ''')»+ ")"'''
	}

	def ruleConclusionOutputParamForError(RuleConclusionElement element) {
		switch element {
			RuleParameter: element.parameter.parameterType.simpleName
			ExpressionInConclusion: element.type.simpleName
		}
	}

	def javaString(String s) {
		Strings::convertToJavaString(s)
	}
	
	def resultType(JudgmentDescription judgmentDescription, IAppendable b) {
		judgmentDescription.resultType.serialize(judgmentDescription, b)
	}
	
	def resultType(JudgmentDescription e) {
		val resultTypeArguments = e.resultJvmTypeReferences()
		var JvmTypeReference resultT
		if (resultTypeArguments.size == 1)
			resultT = getTypeForName(Result, e, 
				resultTypeArguments.get(0)
			)
		else if (resultTypeArguments.size == 2)
			resultT = getTypeForName(Result2, e,
				resultTypeArguments.get(0),
				resultTypeArguments.get(1)
			)
		else if (resultTypeArguments.size == 3)
			resultT = getTypeForName(Result3, e,
				resultTypeArguments.get(0),
				resultTypeArguments.get(1),
				resultTypeArguments.get(2)
			)
		else // safe default
			resultT = getTypeForName(typeof(Result), e)
	}

	def resultType(AuxiliaryDescription e) {
		typeSystem.getType(e)
	}

	def resultType(AuxiliaryFunction e) {
		typeSystem.getType(e.getAuxiliaryDescription)
	}

	def ArrayList<JvmTypeReference> resultJvmTypeReferences(JudgmentDescription e) {
		val outputParams = e.outputJudgmentParameters
		if (outputParams.size == 0) {
			newArrayList(getTypeForName(Boolean, e))
		} else {
			newArrayList(outputParams.
				filter[it.jvmTypeReference != null && it.jvmTypeReference.type != null].
				map[it.jvmTypeReference])
		}
	}
	
	def resultType(CheckRule checkRule, IAppendable b) {
		checkRule.resultType.serialize(checkRule, b)
	}

	def resultType(CheckRule checkRule) {
		getTypeForName(Result, checkRule,
			getTypeForName(Boolean, checkRule))
	}

	def errorInformationType(EObject o) {
		getTypeForName(ErrorInformation, o)
	}

	def exceptionType(EObject o) {
		getTypeForName(Exception, o)
	}

	def emptyEnvironmentInvocation() {
		"emptyEnvironment()"
	}
	
	def environmentEntryInvocation() {
		"environmentEntry"
	}
	
	def environmentCompositionInvocation() {
		"environmentComposition"
	}

	def methodName(CheckRule rule) {
		rule.name.toFirstLower
	}

	def associatedAuxiliaryDescription(JvmIdentifiableElement e) {
		val associated = associations.getPrimarySourceElement(e)
		if (associated instanceof AuxiliaryDescription)
			associated
		else
			null
	}

	def declareVariablesForOutputParams(Rule rule, ITreeAppendable appendable) {
		for (p : rule.outputParams) {
 			appendable.append("\n")
			p.declareVariableForOutputParam(appendable)
		}
	}
	
	def declareVariableForOutputParam(RuleParameter ruleParam, ITreeAppendable appendable) {
		val outputVarName = appendable.declareVariable(ruleParam.parameter, ruleParam.parameter.simpleName)
   		val childAppendable = appendable.trace(ruleParam.parameter, true)
		ruleParam.parameter.parameterType.serialize(ruleParam.parameter, childAppendable)
		childAppendable.append(" " + outputVarName + " = null; // output parameter")
	}

	def expressionInConclusionMethodName(ExpressionInConclusion e) {
		val containingRule = e.containingRule
		"_" +
		containingRule.applyRuleName +
		"_" +
		containingRule.conclusion.conclusionElements.indexOf(e)
	}

	def compileReturnResult(Rule rule, JvmTypeReference resultType, ITreeAppendable result) {
		val expressions = rule.outputConclusionElements
		
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
					ExpressionInConclusion: {
						val inputParams = rule.inputParameterNames 
						result.append(
						elem.expressionInConclusionMethodName +
						"(" + 
						rule.ruleEnvName +
						// if (!inputParams.empty) // in a valid program there's at least one
							", " + inputParams + ")"
						)
					}
				}
				if (iterator.hasNext)
					result.append(", ")
			}
		}
		result.append(");")
	}

	def escapeJavaStringChars(String s) {
		s.convertToJavaString
	}

	def inputEObjectParams(Rule rule) {
		rule.inputParams.filter [
			it.parameter.parameterType.isEObject(rule)
		]
	}

	def inputEObjectParams(AuxiliaryFunction aux) {
		aux.parameters.filter[parameterType.isEObject(aux)]
	}
}
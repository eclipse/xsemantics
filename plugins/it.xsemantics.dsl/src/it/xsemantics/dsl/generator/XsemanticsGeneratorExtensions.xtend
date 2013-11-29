package it.xsemantics.dsl.generator

import com.google.common.collect.Lists
import com.google.inject.Inject
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.Result3
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static extension org.eclipse.xtext.util.Strings.*

class XsemanticsGeneratorExtensions {
	
	@Inject extension IQualifiedNameProvider
	
	@Inject extension XsemanticsUtils
	
	@Inject extension XsemanticsTypeSystem typeSystem
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension JvmTypesBuilder
	
	@Inject
	protected IJvmModelAssociations associations
	
	def toJavaFullyQualifiedName(XsemanticsSystem ts) {
		val packageString = ts.toPackage?.toString
		if (packageString != null && packageString.length > 0)
			packageString + "." + ts.toJavaClassName
		else
			ts.toJavaClassName
	}
	
	def toPackage(XsemanticsSystem ts) {
		ts.fullyQualifiedName?.skipLast(1)?.toString
	}
	
	def toJavaClassName(XsemanticsSystem ts) {
		ts.fullyQualifiedName?.lastSegment
	}
	
	def toJavaFullyQualifiedName(Rule rule) {
		rule.toPackage + "." + rule.toJavaClassName
	}
	
	def toPackage(Rule rule) {
		val typeSystemPackage = rule.containingSystem.toPackage
		if (typeSystemPackage.length > 0)
			typeSystemPackage + "." + "rules"
		else
			"rules"
	}
	
	def toJavaClassName(Rule rule) {
		rule.name.toFirstUpper
	}

	def toJavaClassName(AuxiliaryFunction aux) {
		aux.name.toFirstUpper
	}

	def toJavaFullyQualifiedName(AuxiliaryDescription desc) {
		desc.toPackage + "." + desc.toJavaClassName
	}
	
	def toPackage(AuxiliaryDescription desc) {
		val typeSystemPackage = desc.containingSystem.toPackage
		if (typeSystemPackage.length > 0)
			typeSystemPackage + "." + "auxiliary"
		else
			"auxiliary"
	}
	
	def toJavaClassName(AuxiliaryDescription desc) {
		desc.name.toFirstUpper
	}
	
	def toValidatorPackage(XsemanticsSystem ts) {
		val typeSystemPackage = ts.toPackage
		if (typeSystemPackage != null && typeSystemPackage.length > 0)
			typeSystemPackage + "." + "validation"
		else
			"validation"
	}

	def toValidatorJavaClassName(XsemanticsSystem ts) {
		ts.fullyQualifiedName?.lastSegment + "Validator"
	}
	
	def toValidatorJavaFullyQualifiedName(XsemanticsSystem ts) {
		ts.toValidatorPackage + "." + ts.toValidatorJavaClassName
	}
	
	def ruleIssueString(Rule rule) {
		rule.name.toUpperCase
	}

	def ruleIssueString(AuxiliaryDescription aux) {
		aux.name.toUpperCase
	}
	
	def polymorphicDispatcherField(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»Dispatcher'''
	}

	def polymorphicDispatcherField(AuxiliaryDescription aux) {
		'''«aux.name»Dispatcher'''
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

	def entryPointMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»'''
	}

	def succeededMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»Succeeded'''
	}

	def entryPointMethodName(AuxiliaryDescription aux) {
		'''«aux.name»'''
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

	def exceptionVarName(JudgmentDescription j) {
		'''_e_«j.name»'''
	}

	def exceptionVarName(AuxiliaryDescription aux) {
		'''_e_«aux.name»'''
	}

	def String exceptionVarName(Rule rule) {
		'''e_«rule.applyRuleName»'''
	}

	def suffixStartingFrom2(JudgmentDescription judgmentDescription) {
		val numOfOutputParams = judgmentDescription.outputJudgmentParameters.size();
		if (numOfOutputParams > 1)
			"" + numOfOutputParams
		else
			""
	}

	def throwExceptionMethod(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name.toFirstLower»ThrowException'''
	}

	def throwExceptionMethod(AuxiliaryDescription aux) {
		'''«aux.name.toFirstLower»ThrowException'''
	}

	def throwExceptionMethod(Rule rule) {
		'''«rule.name.toFirstLower»ThrowException'''
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

	def addToTraceMethod(CharSequence trace, CharSequence toAdd) '''
		addToTrace(«trace», «toAdd»)'''
	
	def addAsSubtraceMethod(CharSequence trace, CharSequence subtrace) '''
		addAsSubtrace(«trace», «subtrace»)'''

	def traceStringForRule(Rule rule) {
		val getMethods = XsemanticsGeneratorConstants::getResultGetMethods.iterator
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
		val judgmentParameters = rule.judgmentDescription.getJudgmentParameters.iterator
		val relationSymbols = rule.conclusion.relationSymbols.iterator
		rule.conclusion.conclusionElements.forEach() [
			buffer.append(" + ")
			if (judgmentParameters.next.outputParameter) {
				buffer.append(forOutput.apply(it))
			} else {
				buffer.append(forInput.apply(it))
			}
			if (relationSymbols.hasNext)
				buffer.append(''' + " «relationSymbols.next.escapeJavaStringChars» "''')
			
		]
		buffer.toString
	}

	def traceStringForAuxiliaryFun(AuxiliaryFunction aux) {
		aux.errorForAuxiliaryFun + ''' + " = " + ''' +
			"_result_".wrapInStringRepr
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
		switch element {
			RuleParameter: element.parameter.name
			ExpressionInConclusion: element.type.simpleName
		}
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
		aux.auxiliaryDescription.name.auxFunNameInvocation + 
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
			resultT = e.newTypeRef(typeof(Result), resultTypeArguments.get(0)) 
		else if (resultTypeArguments.size == 2)
			resultT = e.newTypeRef(typeof(Result2),
				resultTypeArguments.get(0), resultTypeArguments.get(1)
			)
		else if (resultTypeArguments.size == 3)
			resultT = e.newTypeRef(typeof(Result3),
				resultTypeArguments.get(0),
				resultTypeArguments.get(1),
				resultTypeArguments.get(2)
			)
		else // safe default
			resultT = e.newTypeRef(typeof(Result)) 
	}

	def resultType(AuxiliaryDescription e) {
		typeSystem.getType(e)
	}

	def resultType(AuxiliaryFunction e) {
		typeSystem.getType(e.auxiliaryDescription)
	}

	def booleanType(EObject e) {
		e.newTypeRef(typeof(Boolean))
	}

	def resultJvmTypeReferences(JudgmentDescription e) {
		val outputParams = e.outputJudgmentParameters
		if (outputParams.size == 0) {
			<JvmTypeReference>newArrayList(e.newTypeRef(typeof(Boolean)))
		} else {
			Lists::newArrayList(outputParams.
				filter[it.jvmTypeReference != null && it.jvmTypeReference.type != null].
				map [ it.jvmTypeReference ])
		}
	}
	
	def resultType(CheckRule checkRule, IAppendable b) {
		checkRule.resultType.serialize(checkRule, b)
	}

	def resultType(CheckRule checkRule) {
		checkRule.newTypeRef(typeof(Result),
			checkRule.newTypeRef(typeof(Boolean)))
	}
	

	def errorInformationType(EObject o) {
		o.newTypeRef(typeof(ErrorInformation))
	}

	def exceptionType(EObject o) {
		o.newTypeRef(typeof(Exception))
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
			associated as AuxiliaryDescription
		else
			null
	}

	def declareVariablesForOutputParams(Rule rule, ITreeAppendable appendable) {
		rule.outputParams.forEach([
			appendable.append("\n")
			it.declareVariableForOutputParam(appendable)
		])
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
					ExpressionInConclusion: {
						val inputParams = rule.inputParameterNames 
						result.append(
						elem.expressionInConclusionMethodName +
						"(" + 
						rule.ruleEnvName +
						if (!inputParams.empty)
							", " + inputParams
						+ ")"
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
}
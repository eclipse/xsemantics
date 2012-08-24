package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import org.eclipse.xtext.xbase.compiler.IAppendable
import it.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.emf.ecore.EObject
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.dsl.xsemantics.CheckRule

class XsemanticsGeneratorExtensions {
	
	@Inject extension IQualifiedNameProvider
	
	@Inject extension XsemanticsUtils
	
	@Inject extension XsemanticsTypeSystem
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension JvmTypesBuilder
	
	def toJavaFullyQualifiedName(XsemanticsSystem ts) {
		val packageString = ts.toPackage?.toString
		if (packageString?.length > 0)
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
		val typeSystemPackage = rule.containingTypeSystem.toPackage
		if (typeSystemPackage.length > 0)
			typeSystemPackage + "." + "rules"
		else
			"rules"
	}
	
	def toJavaClassName(Rule rule) {
		rule.name.toFirstUpper
	}
	
	def toValidatorPackage(XsemanticsSystem ts) {
		val typeSystemPackage = ts.toPackage
		if (typeSystemPackage?.length > 0)
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
	
	def polymorphicDispatcherField(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»Dispatcher'''
	}
	
	def relationSymbolsArgs(JudgmentDescription judgmentDescription) {
		judgmentDescription.relationSymbols.map(['''"«it»"''']).join(", ")
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

	def polymorphicDispatcherNumOfArgs(JudgmentDescription judgmentDescription) {
		// add 2 for the environment to be passed and the RuleApplicationTrace
		'''«judgmentDescription.inputParams.size + 2»'''
	}

	def entryPointMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»'''
	}

	def inputArgs(JudgmentDescription judgmentDescription) {
		val names = new UniqueNames()
		judgmentDescription.inputParams.map([ 
			'''«names.createName(it.inputParameterName)»'''
		]).join(", ")
	}

	def inputParameterName(InputParameter param) {
		param.parameter.name
	}

	def environmentName() '''_environment_'''

	def entryPointInternalMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.entryPointMethodName»Internal'''
	}

	def additionalArgs() {
		'''«environmentName», «ruleApplicationTraceName»'''
	}

	def ruleApplicationTraceName() '''_trace_'''

	def ruleApplicationSubtraceName() '''_subtrace_'''

	def exceptionVarName(JudgmentDescription j) {
		'''_e_«j.name»'''
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

	def throwRuleFailedExceptionMethod() {
		'''throwRuleFailedException'''
	}

	def newTraceMethod(CharSequence trace) '''newTrace(«trace»)'''

	def applyRuleName(Rule rule) {
		'''applyRule«rule.name»'''
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
		val getMethods = it::xsemantics::dsl::generator::XsemanticsGeneratorConstants::getResultGetMethods.iterator
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
				buffer.append(''' + " «relationSymbols.next» "''')
			
		]
		buffer.toString
	}

	def ruleNameInvocation(String ruleName) '''ruleName("«ruleName»")'''

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
		rule.inputParams.map([ it.parameter.name ]).join(", ")
	}

	def errorForRule(Rule rule) {
		rule.stringForRule(
			['''"«it.ruleConclusionOutputParamForError»"'''],
			[wrapInStringRepr(it.ruleConclusionInputParamForError)]
		)
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
		else
			resultT = e.newTypeRef(typeof(Result2),
				resultTypeArguments.get(0), resultTypeArguments.get(1)
			)
	}
	
	def resultJvmTypeReferences(JudgmentDescription e) {
		val outputParams = e.outputJudgmentParameters
		if (outputParams.size == 0) {
			<JvmTypeReference>newArrayList(e.newTypeRef(typeof(Boolean)))
		} else {
			outputParams.map [ it.jvmTypeReference ]
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
}
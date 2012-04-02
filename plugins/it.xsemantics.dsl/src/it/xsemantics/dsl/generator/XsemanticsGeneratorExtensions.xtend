package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import it.xsemantics.dsl.typing.XsemanticsTypingSystem
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.OutputParameter
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable

class XsemanticsGeneratorExtensions {
	
	@Inject extension IQualifiedNameProvider
	
	@Inject extension XsemanticsUtils
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension XsemanticsTypingSystem
	
	@Inject extension TypeReferences
	
	def toPackage(XsemanticsSystem ts) {
		ts.fullyQualifiedName.skipLast(1).toString
	}
	
	def toJavaClassFile(XsemanticsSystem ts) {
		ts.toJavaFullyQualifiedName.replace(".", "/") + ".java"
	}
	
	def toJavaClassName(XsemanticsSystem ts) {
		ts.fullyQualifiedName.lastSegment
	}
	
	def toJavaFullyQualifiedName(XsemanticsSystem ts) {
		val packageString = ts.toPackage.toString
		if (packageString.length > 0)
			packageString + "." + ts.toJavaClassName
		else
			ts.toJavaClassName
	}
	
	def toPackage(Rule rule) {
		val typeSystemPackage = rule.containingTypeSystem.toPackage
		if (typeSystemPackage.length > 0)
			typeSystemPackage + "." + "rules"
		else
			"rules"
	}
	
	def toJavaClassFile(Rule rule) {
		rule.toJavaFullyQualifiedName.replace(".", "/") + ".java"
	}
	
	def toJavaClassName(Rule rule) {
		rule.name.toFirstUpper
	}
	
	def toJavaFullyQualifiedName(Rule rule) {
		rule.toPackage + "." + rule.toJavaClassName
	}
	
	def toValidatorPackage(XsemanticsSystem ts) {
		val typeSystemPackage = ts.toPackage
		if (typeSystemPackage.length > 0)
			typeSystemPackage + "." + "validation"
		else
			"validation"
	}
	
	def toValidatorJavaClassFile(XsemanticsSystem ts) {
		ts.toValidatorJavaFullyQualifiedName.replace(".", "/") + ".java"
	}
	
	def toValidatorJavaClassName(XsemanticsSystem ts) {
		ts.fullyQualifiedName.lastSegment + "Validator"
	}
	
	def toValidatorJavaFullyQualifiedName(XsemanticsSystem ts) {
		ts.toValidatorPackage + "." + ts.toValidatorJavaClassName
	}
	
	def createJvmType(XsemanticsSystem ts) {
		createJvmType(ts.toJavaClassName, ts.toPackage)
	}
	
	def createValidatorJvmType(XsemanticsSystem ts) {
		createJvmType(ts.toValidatorJavaClassName, ts.toValidatorPackage)
	}
	
	def createJvmType(Rule rule) {
		createJvmType(rule.toJavaClassName, rule.toPackage)
	}
	
	def createJvmTypeForTypeSystemBaseClass() {
		createJvmType(typeof(XsemanticsRuntimeSystem))
	}
	
	def createJvmType(String simpleName, String packageName) {
	    val declaredType = TypesFactory::eINSTANCE.createJvmGenericType
	    declaredType.setSimpleName(simpleName)
	    declaredType.setPackageName(packageName)
	    declaredType
	}
	
	def createJvmType(Class clazz) {
		val fullName = clazz.name
		createJvmType(clazz.simpleName, fullName.substring(0, fullName.lastIndexOf(".")))	    
	}
	
	def environmentClass(ImportManager importManager) {
		importManager.serialize(createJvmType(typeof(RuleEnvironment)))
	}
	
	def stringClass(ImportManager importManager) {
		importManager.serialize(createJvmType(typeof(String)))
	}
	
	def errorInformationClass(ImportManager importManager) {
		importManager.serialize(errorInformationClass)
	}
	
	def errorInformationClass() {
		createJvmType(typeof(ErrorInformation))
	}
	
	def injectAnnotation(ImportManager importManager) {
		"@" + importManager.serialize(createJvmType(typeof(Inject)))
	}
	
	def checkAnnotation(ImportManager importManager) {
		"@" + importManager.serialize(createJvmType(typeof(Check)))
	}
	
	def ruleApplicationTraceClass(ImportManager importManager) {
		importManager.serialize(createJvmType(typeof(RuleApplicationTrace)))
	}
	
	def booleanClass() {
		createJvmType(typeof(Boolean))
	}
	
	def ruleFailedExceptionClass(ImportManager importManager) {
		importManager.serialize(ruleFailedExceptionClass)
	}
	
	def ruleFailedExceptionClass() {
		createJvmType(typeof(RuleFailedException))
	}
	
	def exceptionClass(ImportManager importManager) {
		importManager.serialize(exceptionClass)
	}
	
	def exceptionClass() {
		createJvmType(typeof(Exception))
	}
	
	def polymorphicDispatcherClass(ImportManager importManager) {
		importManager.serialize(createJvmType(typeof(PolymorphicDispatcher)))
	}
	
	def ruleResultTypeParameters(Rule rule, ImportManager importManager) {
		rule.outputJudgmentParameters.resultTypeParameters(new StringBuilderBasedAppendable(importManager))
	}
	
	def resultTypeParameters(List<OutputParameter> outputParams, IAppendable appendable) {
		if (outputParams.empty)
			appendable.append(booleanClass)
		else {
			val iterator = outputParams.iterator
			while (iterator.hasNext) {
				iterator.next.judgmentParameterCompile(appendable)
				if (iterator.hasNext)
					appendable.append(", ")
			}
		}
		appendable
	}
	
	def inputParameters(Rule rule, ImportManager importManager) {
		rule.inputParams.map([ 
			javaFinalParam('''«it.ruleParameterTypeCompile(importManager)» «it.parameter.name»''')
		]).join(", ")
	}
	
	def methodName(CheckRule rule) {
		rule.name.toFirstLower
	}
	
	def inputParameter(CheckRule rule, ImportManager importManager) {
		javaFinalParam('''«rule.element.ruleParameterTypeCompile(importManager)» «rule.inputParameterName»''')
	}
	
	def inputParameterName(CheckRule rule) {
		'''«rule.element.parameter.name»'''
	}
	
	def errorInformationArgs(Rule rule, ImportManager importManager) {
		val result = rule.inputEObjectParams.map [
			'''new «importManager.errorInformationClass»(«it.parameter.name»)'''
		].join(", ")
		if (!result.empty)
			", " + result
		else
			result
	}
	
	def inputParameterNames(Rule rule) {
		rule.inputParams.map([ it.parameter.name ]).join(", ")
	}
	
	def inputParameters(JudgmentDescription judgmentDescription, ImportManager importManager) {
		val names = new UniqueNames()
		judgmentDescription.inputParams.map([ 
			javaFinalParam('''«it.judgmentParameterCompile(importManager)» «names.createName(it.inputParameterName)»''')
		]).join(", ")
	}
	
	def javaFinalParam(CharSequence decl) {
		'''final «decl»'''
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
	
	def ruleConclusionElementType(RuleConclusionElement element, ImportManager importManager) {
		element.type.typeCompile(element, importManager)
	}
	
	def outputTypeParameters(JudgmentDescription judgmentDescription, ImportManager importManager) {
		outputTypeParameters(judgmentDescription, new StringBuilderBasedAppendable(importManager))
	}
	
	def outputTypeParameters(JudgmentDescription judgmentDescription, IAppendable appendable) {
		judgmentDescription.outputJudgmentParameters.resultTypeParameters(appendable)
	}
	
	def judgmentParameterCompile(InputParameter inputParameter, ImportManager importManager) {
		inputParameter.parameter.parameterType.typeCompile(inputParameter, importManager)
	}
	
	def judgmentParameterCompile(InputParameter inputParameter, IAppendable appendable) {
		inputParameter.parameter.parameterType.typeCompile(inputParameter, appendable)
	}
	
	def judgmentParameterCompile(OutputParameter outputParameter, IAppendable appendable) {
		outputParameter.jvmTypeReference.typeCompile(outputParameter, appendable)
	}
	
	def ruleParameterTypeCompile(RuleParameter ruleParameter, ImportManager importManager) {
		ruleParameter.parameter.parameterType.typeCompile(ruleParameter, importManager)
	}
	
	def ruleParameterTypeCompile(RuleParameter ruleParameter, IAppendable appendable) {
		ruleParameter.parameter.parameterType.typeCompile(ruleParameter, appendable)
	}
	
	def typeCompile(JvmTypeReference typeRef, EObject context, ImportManager importManager) {
		val elemType = new StringBuilderBasedAppendable(importManager)
		typeRef.typeCompile(context, elemType)
		elemType
	}
	
	def typeCompile(JvmTypeReference typeRef, EObject context, IAppendable appendable) {
		typeRef.serialize(context, appendable)
	}
	
	def resultType(Rule rule, ImportManager importManager) {
		rule.judgmentDescription.resultType(importManager)
	}
	
	def resultType(CheckRule rule, ImportManager importManager) {
		'''«importManager.serialize(resultClass)»<«importManager.serialize(booleanClass)»>'''
	}
	
	def declareVariable(RuleParameter ruleParam, IAppendable appendable) {
		ruleParam.ruleParameterTypeCompile(appendable)
		appendable.append(" ")
		appendable.append(ruleParam.parameter.name)
		appendable.append(" = null;")
	}
	
	def resultType(JudgmentDescription judgmentDescription, ImportManager importManager) {
		resultType(judgmentDescription,
			new StringBuilderBasedAppendable(importManager)
		).toString
	}
	
	def resultType(JudgmentDescription judgmentDescription, IAppendable appendable) {
		appendable.append(judgmentDescription.resultClass).append("<")
		judgmentDescription.outputTypeParameters(appendable)
		appendable.append(">")
	}
	
	def resultClass(JudgmentDescription judgmentDescription, ImportManager importManager) {
		importManager.serialize(judgmentDescription.resultClass)
	}
	
	def resultClass(JudgmentDescription judgmentDescription) {
		val numOfOutputParams = judgmentDescription.outputJudgmentParameters.size();
		if (numOfOutputParams > 1)
			result2Class
		else
			resultClass
	}
	
	def resultClass() {
		createJvmType(typeof(Result))
	}
	
	def result2Class() {
		createJvmType(typeof(Result2))
	}
	
	def suffixStartingFrom2(JudgmentDescription judgmentDescription) {
		val numOfOutputParams = judgmentDescription.outputJudgmentParameters.size();
		if (numOfOutputParams > 1)
			"" + numOfOutputParams
		else
			""
	}
	
	def polymorphicDispatcherField(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»Dispatcher'''
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
	
	def relationSymbolsArgs(JudgmentDescription judgmentDescription) {
		judgmentDescription.relationSymbols.map(['''"«it»"''']).join(", ")
	}
	
	def throwExpectionMethod(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name.toFirstLower»ThrowException'''
	}
	
	def throwRuleFailedExceptionMethod() {
		'''throwRuleFailedException'''
	}
	
	def applyRuleName(Rule rule) {
		'''applyRule«rule.name»'''
	}
	
	def entryPointMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.name»'''
	}
	
	def entryPointInternalMethodName(JudgmentDescription judgmentDescription) {
		'''«judgmentDescription.entryPointMethodName»Internal'''
	}
	
	def ruleEnvName(Rule rule) {
		rule.conclusion.environment.name
	}
	
	def additionalParamsDeclaration(Rule rule, ImportManager importManager) {
		'''«importManager.environmentDeclaration(rule.ruleEnvName).javaFinalParam», «importManager.ruleApplicationTraceDeclaration.javaFinalParam»'''
	}
	
	def additionalParamsDeclaration(ImportManager importManager) {
		'''«importManager.environmentDeclaration.javaFinalParam», «importManager.ruleApplicationTraceDeclaration.javaFinalParam»'''
	}
	
	def additionalArgs() {
		'''«environmentName», «ruleApplicationTraceName»'''
	}
	
	def additionalArgsForRule(Rule rule) {
		'''«rule.ruleEnvName», «ruleApplicationSubtraceName»'''
	}
	
	def additionalArgsForRuleInvocation(RuleInvocation ruleInvocation) {
		'''«ruleApplicationTraceName»'''
	}
	
	def environmentDeclaration(ImportManager importManager, CharSequence envName) {
		'''«importManager.environmentClass» «envName»'''
	}
	
	def environmentDeclaration(ImportManager importManager) {
		importManager.environmentDeclaration(environmentName())
	}
	
	def environmentName() '''_environment_'''
	
	def emptyEnvironmentInvocation() {
		"emptyEnvironment()"
	}
	
	def environmentEntryInvocation() {
		"environmentEntry"
	}
	
	def environmentCompositionInvocation() {
		"environmentComposition"
	}
	
	def stringRepInvocation() {
		"stringRep"
	}
	
	def ruleApplicationTraceDeclaration(ImportManager importManager) {
		'''«importManager.ruleApplicationTraceClass» «ruleApplicationTraceName»'''
	}
	
	def ruleApplicationSubtraceDeclaration(ImportManager importManager) {
		'''«importManager.ruleApplicationTraceClass» «ruleApplicationSubtraceName»'''
	}
	
	def ruleApplicationTraceName() '''_trace_'''
	
	def ruleApplicationSubtraceName() '''_subtrace_'''
	
	def javaString(String s) {
		Strings::convertToJavaString(s)
	}
	
	def stringRepresentation() '''stringRep'''
	
	def stringRepresentationForEnv() '''stringRepForEnv'''
	
	def ruleNameInvocation(String ruleName) '''ruleName("«ruleName»")'''
	
	def resultVariableForTrace() '''_result_'''
	
	def environmentAccessMethod() {
		"environmentAccess"
	}
	
	def sneakyThrowRuleFailedException() {
		"sneakyThrowRuleFailedException"
	}
	
	def errorForRule(Rule rule) {
		rule.stringForRule(
			['''"«it.ruleConclusionOutputParamForError»"'''],
			[wrapInStringRepr(it.ruleConclusionInputParamForError)]
		)
	}
	
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
	
	def ruleConclusionOutputParamForError(RuleConclusionElement element) {
		switch element {
			RuleParameter: element.parameter.parameterType.simpleName
			ExpressionInConclusion: element.type.simpleName
		}
	}
	
	def ruleConclusionInputParamForError(RuleConclusionElement element) {
		switch element {
			RuleParameter: element.parameter.name
			ExpressionInConclusion: element.type.simpleName
		}
	}
	
	def wrapInStringRepr(CharSequence s) {
		'''«stringRepresentation»(«s»)'''
	}
	
	def wrapInStringReprForEnv(CharSequence s) {
		'''«stringRepresentationForEnv»(«s»)'''
	}
	
	def newTraceMethod(CharSequence trace) '''newTrace(«trace»)'''
		
	def addToTraceMethod(CharSequence trace, CharSequence toAdd) '''
		addToTrace(«trace», «toAdd»)'''
	
	def addAsSubtraceMethod(CharSequence trace, CharSequence subtrace) '''
		addAsSubtrace(«trace», «subtrace»)'''
	
	def ruleIssueString(Rule rule) {
		rule.name.toUpperCase
	}
	
	def ruleIssueDeclaration(Rule rule, ImportManager importManager) {
		'''public final static «importManager.stringClass» «rule.ruleIssueString» = "«rule.toJavaFullyQualifiedName»";'''
	}
	
	def referenceForBaseRuntimeSystem(EObject context) {
		typeof(XsemanticsRuntimeSystem).getTypeForName(context)
	}
	
	def createAndConfigureAppendable(JudgmentDescription jDesc, ImportManager importManager) {
		val appendable = jDesc.createConfiguredAppendable(importManager)
		jDesc.configureAppendable(appendable)
		appendable
	}
	
	def configureAppendable(JudgmentDescription jDesc, IAppendable appendable) {
		jDesc.inputParams.forEach([
			appendable.declareVariable(it.parameter, it.parameter.simpleName)
		])
	}
	
	def createConfiguredAppendable(EObject context, ImportManager importManager) {
		val appendable = new FakeTreeAppendable(importManager)
		appendable.declareVariable(context.referenceForBaseRuntimeSystem.type, "this")
		appendable
	}
	
	def exceptionVarName(JudgmentDescription j) {
		'''_e_«j.name»'''
	}
}
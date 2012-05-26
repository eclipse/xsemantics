package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.UniqueNames
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion

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
	
	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils
	
	@Inject XsemanticsXbaseCompiler xbaseCompiler

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
   		acceptor.accept(
			ts.toClass( ts.toJavaFullyQualifiedName )
		).initializeLater [
			documentation = ts.documentation
			
			superTypes += ts.newTypeRef(typeof(XsemanticsRuntimeSystem))
			

			val issues = <JvmField>newArrayList()
			ts.rules.forEach [
				issues += genIssueField()
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
			
//			ts.rules.forEach [
//				rule |
//				members += rule.compileApplyMethod
//			]
			
//			members += element.toConstructor() [
//				parameters += element.toParameter("initializer", procedure)
//				body = [it.append("initializer.apply(this);")]
//			]
			//members += element.addToStringMethod(it)
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
   		]
   		
   		// entry point method with environment parameter
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.inputParameters
   		]
   		
   		// entry point method with environment parameter and rule application trace
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
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
			e.newTypeRef(typeof(RuleEnvironment))
		)
	}
	
	def ruleApplicationTraceParam(JudgmentDescription e) {
		e.toParameter(
			ruleApplicationTraceName.toString,
			e.newTypeRef(typeof(RuleApplicationTrace))
		)
	}
	
	def compileApplyMethod(Rule rule) {
		rule.toMethod(
			'''applyRule«rule.toJavaClassName»'''.toString,
			rule.judgmentDescription.resultType
		) 
		[
			parameters += rule.judgmentDescription.environmentParam
   			parameters += rule.judgmentDescription.ruleApplicationTraceParam
   			parameters += rule.inputParameters
   			
   			body = [
   				rule.declareVariablesForOutputParams(it) 
   				rule.compileRuleBody(rule.judgmentDescription.resultType, it)
   			]
		]
	}
	
	def declareVariablesForOutputParams(Rule rule, ITreeAppendable appendable) {
		rule.outputParams.forEach([
			it.declareVariable(appendable).append("\n")
		])
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
	
	def compilePremises(Rule rule, ITreeAppendable result) {
		switch rule {
			RuleWithPremises: xbaseCompiler.compile(rule.premises, result, false)
		}
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
		result.append('''return new «resultType»('''.toString)
		
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


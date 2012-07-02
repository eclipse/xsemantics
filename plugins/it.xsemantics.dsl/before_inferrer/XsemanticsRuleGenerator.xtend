package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class XsemanticsRuleGenerator {
	
	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils
	
	@Inject extension XsemanticsXbaseCompiler xbaseCompiler
	
	@Inject XsemanticsErrorSpecificationGenerator errSpecGenerator

	def compileDispatcherImplMethod(Rule rule, ImportManager importManager) {
		val resultType = rule.resultType(importManager)
		'''
		protected «resultType» «rule.judgmentDescription.polymorphicDispatcherImpl»«
				»(«rule.additionalParamsDeclaration(importManager)»,
				«rule.inputParameters(importManager)») 
				throws «importManager.ruleFailedExceptionClass» {
			try {
				«importManager.ruleApplicationSubtraceDeclaration» = «newTraceMethod(ruleApplicationTraceName())»;
				«resultType» _result_ = «rule.applyRuleName»(«rule.additionalArgsForRule», «rule.inputParameterNames»);
				«addToTraceMethod(ruleApplicationTraceName(), rule.traceStringForRule)»;
				«addAsSubtraceMethod(ruleApplicationTraceName(), ruleApplicationSubtraceName)»;
				return _result_;
			} catch («importManager.exceptionClass» e_«rule.applyRuleName») {
				«compileFinalThrow(rule, importManager)»;
				return null;
			}
		}
		'''
	}
	
	def compileApplyMethod(Rule rule, ImportManager importManager) {
		val resultType = rule.resultType(importManager)
		val appendable = createAndConfigureAppendable(rule, importManager)
		declareVariablesForOutputParams(rule, appendable)
		compileRuleBody(rule, resultType, appendable)
		'''
		
		protected «resultType» applyRule«rule.toJavaClassName»(«rule.additionalParamsDeclaration(importManager)»,
				«rule.inputParameters(importManager)») 
				throws «importManager.ruleFailedExceptionClass» {
			«appendable»
		}
		'''
	}
	
	def compileFinalThrow(Rule rule, ImportManager importManager) {
		if (rule.conclusion.error != null) {
			val errorSpecification = rule.conclusion.error
			val b = rule.createAndConfigureAppendable(importManager)
			val error = errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, b)
			val source = errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, b)
			val feature = errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, b)
		
			'''
			«b»
			«throwRuleFailedExceptionMethod»(«error»,
				«rule.ruleIssueString», e_«rule.applyRuleName»,
				new «importManager.errorInformationClass»(«source», «feature»))'''
		} else if (rule.judgmentDescription.error != null) {
			'''
			«rule.judgmentDescription.throwExceptionMethod»(«rule.ruleIssueString»,
				e_«rule.applyRuleName», «rule.inputParameterNames»)'''
		} else {
			'''
			«throwRuleFailedExceptionMethod»(«rule.errorForRule»,
				«rule.ruleIssueString»,
				e_«rule.applyRuleName»«rule.errorInformationArgs(importManager)»)'''
		}
	}

	def compileCheckRule(CheckRule rule, ImportManager importManager) {
		val resultType = rule.resultType(importManager)
		val appendable = createAndConfigureAppendable(rule, importManager)
		val inputParam = rule.inputParameter(importManager)
		compilePremises(rule, appendable)
		'''
		public «resultType» «rule.methodName»(«inputParam») {
			try {
				return «rule.methodName»Internal(null, «rule.inputParameterName»);
			} catch («importManager.exceptionClass» e) {
				return resultForFailure(e);
			}
		}
		
		public «resultType» «rule.methodName»Internal(«importManager.ruleApplicationTraceDeclaration.javaFinalParam», «inputParam») 
				throws «importManager.ruleFailedExceptionClass» {
			«appendable»
			return new «resultType»(true);
		}
		'''
	}
	
	def createAndConfigureAppendable(Rule rule, ImportManager importManager) {
		val appendable = rule.createConfiguredAppendable(importManager)
		rule.ruleParams.forEach([
			appendable.declareVariable(it.parameter, it.parameter.simpleName)
		])
		appendable
	}
	
	def createAndConfigureAppendable(CheckRule rule, ImportManager importManager) {
		val appendable = rule.createConfiguredAppendable(importManager)
		appendable.declareVariable(rule.element.parameter, rule.element.parameter.simpleName)
		appendable
	}
	
	def declareVariablesForOutputParams(Rule rule, ITreeAppendable appendable) {
		rule.outputParams.forEach([
			it.declareVariable(appendable).append("\n")
		])
	}
	
	def compileRuleBody(Rule rule, String resultType, ITreeAppendable result) {
		compilePremises(rule, result)
		compileRuleConclusionElements(rule, result)
		compileReturnResult(rule, resultType, result)
	}
	
	def compilePremises(Rule rule, ITreeAppendable result) {
		switch rule {
			RuleWithPremises: xbaseCompiler.compile(rule.premises, result, false)
		}
	}
	
	def compilePremises(CheckRule rule, ITreeAppendable result) {
		xbaseCompiler.compile(rule.premises, result, false)
	}
	
	def compileRuleConclusionElements(Rule rule, ITreeAppendable result) {
		rule.expressionsInConclusion.forEach([
			xbaseCompiler.compile(it.expression, result, true)
		])
	}
	
	def compileReturnResult(Rule rule, String resultType, ITreeAppendable result) {
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
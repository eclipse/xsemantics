package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import java.util.Set
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class CustomXbaseCompiler extends XbaseCompiler {
	@Inject extension XsemanticsUtils
	@Inject extension XsemanticsGeneratorExtensions
	
	override compile(XExpression obj, ITreeAppendable appendable, JvmTypeReference expectedReturnType, Set<JvmTypeReference> declaredExceptions) {
		if (obj.eContainer instanceof RuleWithPremises) {
			val rule = obj.eContainer as RuleWithPremises
			
			rule.declareVariablesForOutputParams(appendable) 
   			rule.compileRuleBody(rule.judgmentDescription.resultType, appendable)
			
			return appendable
		}
		
		return super.compile(obj, appendable, expectedReturnType, declaredExceptions)
	}
	
	def compileRuleBody(Rule rule, JvmTypeReference resultType, ITreeAppendable result) {
		compilePremises(rule, result)
		compileRuleConclusionElements(rule, result)
		compileReturnResult(rule, resultType, result)
	}
	
	def dispatch compilePremises(Rule rule, ITreeAppendable result) {
		return
	}

	def dispatch compilePremises(RuleWithPremises rule, ITreeAppendable result) {
		toJavaStatement(rule.premises, result, false)
	}

	def dispatch compilePremises(CheckRule rule, ITreeAppendable result) {
		toJavaStatement(rule.premises, result, false)
	}
	
	def compileRuleConclusionElements(Rule rule, ITreeAppendable result) {
		rule.expressionsInConclusion.forEach([
			toJavaStatement(it.expression, result, true)
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
						toJavaExpression(elem.expression, result)
				}
				if (iterator.hasNext)
					result.append(", ")
			}
		}
		result.append(");")
	}
}
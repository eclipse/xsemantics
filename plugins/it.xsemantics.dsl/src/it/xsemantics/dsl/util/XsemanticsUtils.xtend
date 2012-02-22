package it.xsemantics.dsl.util

import com.google.common.collect.Lists
import com.google.inject.Inject
import it.xsemantics.dsl.typing.XsemanticsSubtyping
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.JudgmentParameter
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.OutputParameter
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XVariableDeclaration

import static extension org.eclipse.xtext.EcoreUtil2.*

class XsemanticsUtils {
	
	@Inject extension XsemanticsSubtyping
	
	def getJvmTypes(XsemanticsSystem ts) {
		ts.getAllContentsOfType(typeof(JvmTypeReference))
	}
	
	def getRules(XsemanticsSystem ts) {
		EcoreUtil2::getAllContentsOfType(ts, typeof(Rule))
	}
	
	def getJvmParameters(Rule rule) {
		EcoreUtil2::getAllContentsOfType(rule.conclusion, typeof(JvmFormalParameter))
	}
	
	def getVariableDeclarations(RuleInvocation ruleInvocation) {
		ruleInvocation.expressions.
			map([ it.expression ]).typeSelect(typeof(XVariableDeclaration))
	}
	
	def getJvmParameters(JudgmentDescription jd) {
		EcoreUtil2::getAllContentsOfType(jd, typeof(JvmFormalParameter))
	}
	
	def getRuleInvocations(EObject element) {
		EcoreUtil2::getAllContentsOfType(element, typeof(RuleInvocation))
	}
	
	def getOrs(EObject element) {
		element.getAllContentsOfType(typeof(OrExpression))
	}

	def containingTypeSystem(EObject element) {
		return EcoreUtil2::getContainerOfType(element, typeof(XsemanticsSystem))
	}
	
	def containingRule(EObject element) {
		return EcoreUtil2::getContainerOfType(element, typeof(Rule))
	}
	
	def List<JudgmentDescription> getJudgmentDescriptions(XsemanticsSystem ts, String judgmentSymbol, Iterable<String> relationSymbols) {
		Lists::newArrayList(filterJudgmentDescriptions(ts, judgmentSymbol, relationSymbols))
	}
	
	def filterJudgmentDescriptions(XsemanticsSystem ts, String judgmentSymbol, Iterable<String> relationSymbols) {
		ts.getJudgmentDescriptions.filter
			[ it.judgmentSymbol.equals(judgmentSymbol) && 
				it.relationSymbols.elementsEqual(relationSymbols) ]
	}
	
	def judgmentDescription(Rule rule) {
		rule.judgmentDescription(rule.conclusion.judgmentSymbol, 
			rule.conclusion.relationSymbols)
	}
	
	def judgmentDescription(RuleInvocation ruleInvocation) {
		ruleInvocation.
			judgmentDescription(ruleInvocation.judgmentSymbol, 
				ruleInvocation.relationSymbols)
	}
	
	def judgmentDescription(EObject object, String judgmentSymbol, Iterable<String> relationSymbols) {
		val descriptions = object.
			containingTypeSystem.getJudgmentDescriptions(judgmentSymbol, relationSymbols)
		if (descriptions.size > 0)
			descriptions.get(0)
	}
	
	def List<Rule> rulesForJudgmentDescription(JudgmentDescription judgmentDescription) {
		Lists::newArrayList(judgmentDescription.containingTypeSystem.
			filterRulesByJudgmentDescription
				(judgmentDescription.judgmentSymbol, judgmentDescription.relationSymbols))
	}
	
	def filterRulesByJudgmentDescription(XsemanticsSystem ts, String judgmentSymbol, Iterable<String> relationSymbols) {
		ts.getRules.filter
			[ it.conclusion.judgmentSymbol.equals(judgmentSymbol) &&
				it.conclusion.relationSymbols.elementsEqual(relationSymbols)	]
	}
	
	def List<Rule> getRulesOfTheSameKind(Rule rule) {
		Lists::newArrayList(rule.containingTypeSystem.filterRulesByJudgmentDescription
			(rule.conclusion.judgmentSymbol, rule.conclusion.relationSymbols))
	}
	
	def isOutputParameter(JudgmentParameter j) {
		j instanceof OutputParameter
	}
	
	def List<OutputParameter> outputJudgmentParameters(JudgmentDescription judgmentDescription) {
		judgmentDescription.getJudgmentParameters.typeSelect(typeof(OutputParameter))
	}
	
	def List<OutputParameter> outputJudgmentParameters(Rule rule) {
		rule.judgmentDescription.outputJudgmentParameters
	}
	
	def List<RuleConclusionElement> outputConclusionElements(Rule rule) {
		val judgmentParameters = rule.judgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must be output
		Lists::newArrayList(
			rule.conclusion.conclusionElements.filter(
				[ judgmentParameters.next.outputParameter ]
			)
		)
	}
	
	def List<OutputParameter> outputParams(RuleInvocation ruleInvocation) {
		ruleInvocation.judgmentDescription.outputJudgmentParameters
	}
	
	def List<InputParameter> inputParams(JudgmentDescription judgmentDescription) {
		judgmentDescription.getJudgmentParameters.typeSelect(typeof(InputParameter))
	}
	
	def List<RuleParameter> inputParams(Rule rule) {
		val judgmentParameters = rule.judgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must not be output
		Lists::newArrayList(
			rule.conclusion.conclusionElements.filter(
				[ !judgmentParameters.next.outputParameter ]
			)
		).typeSelect(typeof(RuleParameter))
	}
	
	def List<RuleParameter> inputEObjectParams(Rule rule) {
		Lists::newArrayList(rule.inputParams.filter [
			it.parameter.parameterType.isEObject(rule)
		])
	}
	
	def isInputParam(RuleParameter ruleParameter) {
		ruleParameter.containingRule.inputParams.contains(ruleParameter)
	}
	
	def isInputParam(JvmFormalParameter jvmFormalParameter) {
		val ruleParameter = jvmFormalParameter.getContainerOfType(typeof(RuleParameter))
		if (ruleParameter != null)
			ruleParameter.inputParam
		else
			false
	}
	
	def List<RuleParameter> outputParams(Rule rule) {
		val judgmentParameters = rule.judgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must be output
		Lists::newArrayList(
			rule.conclusion.conclusionElements.filter(
				[ judgmentParameters.next.outputParameter ]
			)
		).typeSelect(typeof(RuleParameter))
	}
	
	def boolean hasOutputParams(Rule rule) {
		!rule.outputParams.empty
	}
	
	def boolean hasOutputParams(RuleInvocation ruleInvocation) {
		!ruleInvocation.outputParams.empty
	}
	
	def <T> void iterateIfThenElse(Iterable<T> iterable, (T)=>boolean predicate,
		(T)=>void ifTrue, (T)=>void ifFalse) {
		iterable.forEach() [
			if (predicate.apply(it)) {
				ifTrue.apply(it)
			} else {
				ifFalse.apply(it)
			}
		]		
	}
	
	def List<RuleParameter> ruleParams(Rule rule) {
		rule.conclusion.conclusionElements.typeSelect(typeof(RuleParameter))
	}
	
	def List<ExpressionInConclusion> expressionsInConclusion(Rule rule) {
		rule.conclusion.getAllContentsOfType(typeof(ExpressionInConclusion))
	}
	
	def List<RuleInvocationExpression> outputArgsExpressions(RuleInvocation ruleInvocation) {
		val judgmentParameters = ruleInvocation.judgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must be output
		Lists::newArrayList(
			ruleInvocation.expressions.filter(
				[ judgmentParameters.next.outputParameter ]
			)
		)
	}
	
	def validOutputArgExpression(RuleInvocationExpression ruleInvocationExpression) {
		val xexp = ruleInvocationExpression.expression
		switch (xexp) {
			XFeatureCall : {
				val feature = xexp.feature
				if (feature instanceof JvmFormalParameter)
					return !(feature as JvmFormalParameter).inputParam
				return true;
			}
			XVariableDeclaration : {
				return xexp.writeable && xexp.right == null
			}
		}		
		return false;
	}
	
	def validInputArgExpression(RuleInvocationExpression ruleInvocationExpression) {
		return !(ruleInvocationExpression.expression instanceof XVariableDeclaration);
	}
	
	def List<RuleInvocationExpression> inputArgsExpressions(RuleInvocation ruleInvocation) {
		val judgmentParameters = ruleInvocation.judgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must not be output
		Lists::newArrayList(
			ruleInvocation.expressions.filter(
				[ !judgmentParameters.next.outputParameter ]
			)
		)
	}
	
}
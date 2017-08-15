/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.dsl.util

import com.google.common.collect.Lists
import com.google.common.collect.Sets
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xsemantics.dsl.xsemantics.AuxiliaryDescription
import org.eclipse.xsemantics.dsl.xsemantics.AuxiliaryFunction
import org.eclipse.xsemantics.dsl.xsemantics.Cachable
import org.eclipse.xsemantics.dsl.xsemantics.EntryPointsOption
import org.eclipse.xsemantics.dsl.xsemantics.ExpressionInConclusion
import org.eclipse.xsemantics.dsl.xsemantics.InputParameter
import org.eclipse.xsemantics.dsl.xsemantics.JudgmentDescription
import org.eclipse.xsemantics.dsl.xsemantics.JudgmentParameter
import org.eclipse.xsemantics.dsl.xsemantics.OrExpression
import org.eclipse.xsemantics.dsl.xsemantics.OutputParameter
import org.eclipse.xsemantics.dsl.xsemantics.ReferToJudgment
import org.eclipse.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xsemantics.dsl.xsemantics.RuleConclusionElement
import org.eclipse.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.xsemantics.dsl.xsemantics.RuleParameter
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsFile
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsSystem
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

import static extension org.eclipse.xtext.EcoreUtil2.*

@Singleton
class XsemanticsUtils {
	
	@Inject
    IJvmModelAssociations associations;
    
    @Inject
    XsemanticsDslCache cache
	
	def containingSystem(EObject element) {
		//return EcoreUtil2::getContainerOfType(element, typeof(XsemanticsSystem))
		// this might be more efficient
		return (element.eResource.contents.head as XsemanticsFile).xsemanticsSystem
	}
	
	def containingRule(EObject element) {
		return EcoreUtil2::getContainerOfType(element, typeof(Rule))
	}

	def containingOrExpression(EObject element) {
		return EcoreUtil2::getContainerOfType(element, typeof(OrExpression))
	}

	def getJudgmentDescription(ReferToJudgment e) {
		// compute corresponding judgment only on the first invokation
		if (!e.isSet_judgment) {
			e._judgment = e.judgmentDescription(e.judgmentSymbol, 
					e.relationSymbols)
		}
		return e._judgment
	}
	
	def private judgmentDescription(EObject object, String judgmentSymbol, Iterable<String> relationSymbols) {
//		val descriptions = Lists::newArrayList(
//			object.
//			containingSystem.
//				allJudgments
//					(judgmentSymbol, relationSymbols))
//		if (descriptions.size > 0)
//			descriptions.get(0)
		object.containingSystem.allJudgmentsRepresentations.get(
			judgmentSymbol -> relationSymbols
		)
	}
	
	def getAuxiliaryDescription(AuxiliaryFunction fun) {
		// compute corresponding auxiliary description only on the first invokation
		if (!fun.isSet_auxiliaryDescription) {
			fun._auxiliaryDescription = fun.containingSystem.
				auxiliaryDescriptionsByName.get(fun.name)	
		}
		fun._auxiliaryDescription
	}
	
	def rulesForJudgmentDescription(JudgmentDescription judgmentDescription) {
		judgmentDescription.containingSystem.
			filterRulesByJudgmentDescription
				(judgmentDescription.judgmentSymbol, judgmentDescription.relationSymbols)
	}

	def List<AuxiliaryFunction> functionsForAuxiliaryDescrition(AuxiliaryDescription aux) {
		Lists::newArrayList(aux.containingSystem.auxiliaryFunctions.
			filter[name == aux.name])
	}
	
	def filterRulesByJudgmentDescription(XsemanticsSystem ts, String judgmentSymbol, Iterable<String> relationSymbols) {
		ts.getRules.filterRulesByJudgmentDescription(judgmentSymbol,
			relationSymbols)
	}

	def filterRulesByJudgmentDescription(Iterable<Rule> rules, String judgmentSymbol, Iterable<String> relationSymbols) {
		rules.filter
			[ it.conclusion.judgmentSymbol.equals(judgmentSymbol) &&
				it.conclusion.relationSymbols.elementsEqual(relationSymbols)	]
	}
	
	def isOutputParameter(JudgmentParameter j) {
		j instanceof OutputParameter
	}
	
	def List<OutputParameter> outputJudgmentParameters(JudgmentDescription judgmentDescription) {
		judgmentDescription.getJudgmentParameters.typeSelect(typeof(OutputParameter))
	}
	
	def List<RuleConclusionElement> outputConclusionElements(Rule rule) {
		val judgmentParameters = rule.getJudgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must be output
		Lists::newArrayList(
			rule.conclusion.conclusionElements.filter(
				[ judgmentParameters.next.outputParameter ]
			)
		)
	}
	
	def List<OutputParameter> outputParams(RuleInvocation ruleInvocation) {
		ruleInvocation.getJudgmentDescription.outputJudgmentParameters
	}
	
	def inputParams(JudgmentDescription judgmentDescription) {
		judgmentDescription.getJudgmentParameters.typeSelect(typeof(InputParameter))
	}
	
	def inputParams(Rule rule) {
		// compute it only on the first invokation
		if (!rule.set_inputParams) {
			val judgmentParameters = rule.getJudgmentDescription.getJudgmentParameters.iterator
			// the corresponding judgmentParameter must not be output
			rule._inputParams += rule.conclusion.conclusionElements.
				filter[ !judgmentParameters.next.outputParameter ].
				filter(RuleParameter).toList
		}
		rule._inputParams
	}
	
	def isInputParam(RuleParameter ruleParameter) {
		ruleParameter.containingRule.inputParams.contains(ruleParameter)
	}

	def isOutputParam(RuleParameter ruleParameter) {
		ruleParameter.containingRule.outputParams.contains(ruleParameter)
	}
	
	def isInputParam(JvmFormalParameter jvmFormalParameter) {
		val ruleParameter = jvmFormalParameter.getContainerOfType(typeof(RuleParameter))
		if (ruleParameter !== null) {
			ruleParameter.inputParam
		} else {
			// it is surely an input parameter
			true
		}
	}
	
	def outputParams(Rule rule) {
		// compute it only on the first invokation
		if (!rule.set_outputParams) {
			val judgmentDescription = rule.getJudgmentDescription
			if (judgmentDescription === null || judgmentDescription.judgmentParameters.empty)
				return Lists::newArrayList
			val judgmentParameters = judgmentDescription.judgmentParameters.iterator
			// the corresponding judgmentParameter must be output
			rule._outputParams += rule.conclusion.conclusionElements.
				filter[judgmentParameters.next.outputParameter].
				filter(RuleParameter).toList
		}
		rule._outputParams
	}
	
	def boolean hasOutputParams(RuleInvocation ruleInvocation) {
		!ruleInvocation.outputParams.empty
	}
	
	def expressionsInConclusion(Rule rule) {
		rule.conclusion.getAllContentsOfType(typeof(ExpressionInConclusion))
	}
	
	def outputArgsExpressions(RuleInvocation ruleInvocation) {
		val judgmentParameters = ruleInvocation.getJudgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must be output
		Lists::newArrayList(
			ruleInvocation.expressions.filter
				[ judgmentParameters.next.outputParameter ]
		)
	}
	
	def validOutputArgExpression(XExpression xexp) {
		if (xexp instanceof XFeatureCall) {
			val feature = xexp.feature
			if (feature instanceof JvmFormalParameter)
				return !feature.inputParam
			return true;
		} else if (xexp instanceof XVariableDeclaration) {
			return xexp.writeable && xexp.right === null
		}
		return false;
	}
	
	def validInputArgExpression(XExpression ruleInvocationExpression) {
		return !(ruleInvocationExpression instanceof XVariableDeclaration);
	}
	
	def inputArgsExpressions(RuleInvocation ruleInvocation) {
		val judgmentParameters = ruleInvocation.getJudgmentDescription.getJudgmentParameters.iterator
		// the corresponding judgmentParameter must not be output
		Lists::newArrayList(
			ruleInvocation.expressions.filter(
				[ !judgmentParameters.next.outputParameter ]
			)
		)
	}

	def allJudgments(XsemanticsSystem system) {
		cache.get("allJudgments" -> system) [|
			system.judgmentDescriptions
				+ system.allSuperSystemDefinitions.
					map[judgmentDescriptions].flatten
		]
	}
	
	def allRules(XsemanticsSystem system) {
		cache.get("allRules" -> system) [|
			system.rules
				+ system.allSuperSystemDefinitions.
					map[rules].flatten
		]
	}

	// since it will be used for checking its size, better to return a List
	def allRulesByJudgmentDescription(XsemanticsSystem ts, String judgmentSymbol, Iterable<String> relationSymbols) {
		cache.get2("allRulesByJudgmentDescription" -> (ts -> (judgmentSymbol -> relationSymbols))) [|
			ts.allRules.filterRulesByJudgmentDescription(judgmentSymbol,
				relationSymbols).toList
		]
	}

	def allCheckRules(XsemanticsSystem system) {
		cache.get("allCheckRules" -> system) [|
			system.checkrules 
				+ system.allSuperSystemDefinitions.
					map[checkrules].flatten
		]
	}

	def allAuxiliaryDescriptions(XsemanticsSystem system) {
		cache.get("allAuxiliaryDescriptions" -> system) [|
			system.auxiliaryDescriptions
				+ system.allSuperSystemDefinitions.
					map[auxiliaryDescriptions].flatten
		]
	}

	def allSuperSystemDefinitions(XsemanticsSystem system) {
		cache.get("allSuperSystemDefinitions" -> system) [|
			system.
				allSuperSystemDefinitionsInternal(Sets::newHashSet)
		]
	}

	def protected List<XsemanticsSystem> allSuperSystemDefinitionsInternal(XsemanticsSystem system, Set<XsemanticsSystem> visited) {
		if (visited.contains(system))
			return Lists::<XsemanticsSystem>newArrayList()
		
		visited.add(system)
		Lists::<XsemanticsSystem>newArrayList() => [
			val superS = system.superSystemDefinition
			if (superS !== null) {
				it += superS
				it += superS.allSuperSystemDefinitionsInternal(visited)
			}
		]
	}

	def superSystemDefinition(XsemanticsSystem system) {
		system.superSystem?.originalSystemDefinition
	}

	def originalSystemDefinition(JvmTypeReference typeReference) {
		// it is the JvmType which is associated to an XsemanticsSystem
		associations.getSourceElements(typeReference.type).
			filter(typeof(XsemanticsSystem)).head
	}

	def allJudgmentsRepresentations(XsemanticsSystem system) {
		cache.get("allJudgmentsRepresentations" -> (system)) [|
			system.allJudgments.toMap[judgmentSymbol -> relationSymbols]
		]
	}

	def auxiliaryDescriptionsByName(XsemanticsSystem system) {
		cache.get("auxiliaryDescriptionsByName" -> (system)) [|
			system.auxiliaryDescriptions.toMap[name]
		]
	}

	def cacheEntryPointMethods(Cachable c) {
		c.cachedClause?.entryPointsOption == EntryPointsOption.DEFAULT
	}

	def cacheCondition(Cachable c) {
		c.cachedClause?.condition
	}

}
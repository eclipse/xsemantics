package it.xsemantics.dsl.typing

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.OutputParameter
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression
import it.xsemantics.dsl.xsemantics.RuleParameter
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer
import org.eclipse.xtext.xbase.XAssignment

class XsemanticsTypingSystem {
	
	@Inject
	protected ITypeProvider typeProvider
	
	@Inject
	private XbaseTypeConformanceComputer conformanceComputer
	
	@Inject
	private TypeReferences typeReferences
	
	def JvmTypeReference getType(EObject element) {
		switch element {
			ExpressionInConclusion: typeProvider.getType(element.expression)
			RuleParameter: element.parameter.parameterType
			RuleInvocationExpression: typeProvider.getType(element.expression)
			InputParameter: element.parameter.parameterType
			OutputParameter: element.jvmTypeReference
			XExpression: typeProvider.getType(element)
			default: null
		}
	}
	
	def TupleType getTupleType(Rule rule) {
		val type = new TupleType();
		for (RuleConclusionElement ruleConclusionElement : rule.getConclusion()
				.getConclusionElements()) {
			type.add(getType(ruleConclusionElement));
		}
		return type;
	}
	
	def isBooleanPremise(XExpression expression) {
		// don't consider boolean variable declaration and assignments as expressions
		if (expression instanceof XVariableDeclaration ||
			expression instanceof XAssignment) {
			return false;
		} else {
			val booleanType = typeReferences.getTypeForName(Boolean::TYPE, expression);
			val operationType = typeProvider.getType(expression);
			return conformanceComputer.isConformant(booleanType, operationType)
		}
	}
}
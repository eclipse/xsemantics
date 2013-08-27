package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class CustomXbaseCompiler extends XbaseCompiler {
	@Inject extension XsemanticsUtils
	@Inject extension XsemanticsGeneratorExtensions
	
	override compile(XExpression obj, ITreeAppendable appendable, JvmTypeReference expectedReturnType, Set<JvmTypeReference> declaredExceptions) {
		val rule = obj.eContainer
		switch (rule) {
			RuleWithPremises: {
				rule.declareVariablesForOutputParams(appendable) 
   				rule.compileRuleBody(rule.judgmentDescription.resultType, appendable)
			
				return appendable
			}
			CheckRule: {
				rule.compilePremises(appendable)
   				if (!appendable.toString.empty)
					appendable.newLine
				appendable.append("return new ")
				rule.resultType(appendable)
				appendable.append("(true);")
			}			
		}
		
		return super.compile(obj, appendable, expectedReturnType, declaredExceptions)
	}
	
	def void compileRuleBody(Rule rule, JvmTypeReference resultType, ITreeAppendable result) {
		compilePremises(rule, result)

		rule.compileReturnResult(resultType, result)
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
	
	def String compileErrorOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getError(),
				b,
				getTypeReferences().getTypeForName(typeof(String),
						errorSpecification), "error");
	}

	def String compileSourceOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getSource(),
				b,
				getTypeReferences().getTypeForName(typeof(EObject),
						errorSpecification), "source");
	}

	def String compileFeatureOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getFeature(),
				b,
				getTypeReferences().getTypeForName(typeof(EStructuralFeature),
						errorSpecification), "feature");
	}

	def protected String compileAndAssignToLocalVariable(
			XExpression expression, ITreeAppendable b,
			JvmTypeReference expectedType, String proposedVariable) {
		if (expression == null)
			return "null";

		toJavaStatement(expression, b, true);
		val syntheticObject = new Object();
		val varName = b.declareSyntheticVariable(syntheticObject,
				proposedVariable);
		b.append("\n");
		serialize(expectedType, expression, b);
		b.append(" ").append(varName).append(" = ");
		toJavaExpression(expression, b);
		b.append(";");
		return b.getName(syntheticObject);
	}
}
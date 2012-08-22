package it.xsemantics.dsl.typing

import it.xsemantics.dsl.xsemantics.Fail
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider
import com.google.inject.Singleton
import it.xsemantics.dsl.xsemantics.EnvironmentAccess

/**
 * Custom version of XbaseTypeProvider for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
class XsemanticsTypeProvider extends XbaseTypeProvider {
	
	def dispatch type(RuleInvocation exp, 
			JvmTypeReference rawExpectation, boolean rawType) {
		typeReferences.createAnyTypeReference(exp)
	}
	
	def dispatch type(OrExpression exp, 
			JvmTypeReference rawExpectation, boolean rawType) {
		typeReferences.createAnyTypeReference(exp)
	}

	def dispatch type(Fail exp, 
			JvmTypeReference rawExpectation, boolean rawType) {
		typeReferences.createAnyTypeReference(exp)
	}

	def dispatch type(EnvironmentAccess exp, 
			JvmTypeReference rawExpectation, boolean rawType) {
		exp.getType
	}
}
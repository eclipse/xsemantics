package it.xsemantics.dsl.generator

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.IAppendable

class XsemanticsXbaseCompiler {
	@Inject protected it.xsemantics.dsl.generator.XsemanticsXExpressionCompiler xbaseCompiler
	
	def compile(XExpression xExpression, IAppendable result, boolean isReferenced) {
		xbaseCompiler.toJavaStatement(xExpression, result, isReferenced)
		result
	}
	
	def compileAsJavaExpression(XExpression obj, IAppendable appendable) {
		xbaseCompiler.toJavaExpression(obj, appendable)
	}
}
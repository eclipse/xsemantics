package it.xsemantics.dsl.generator

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class XsemanticsXbaseCompiler {
	@Inject protected it.xsemantics.dsl.generator.XsemanticsXExpressionCompiler xbaseCompiler
	
	def compile(XExpression xExpression, ITreeAppendable result, boolean isReferenced) {
		xbaseCompiler.toJavaStatement(xExpression, result, isReferenced)
		result
	}
	
	def compileAsJavaExpression(XExpression obj, ITreeAppendable appendable) {
		xbaseCompiler.toJavaExpression(obj, appendable)
	}
}
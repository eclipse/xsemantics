package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xtext.xbase.compiler.IAppendable

class XsemanticsErrorSpecificationGenerator {
	
	@Inject XsemanticsXExpressionCompiler xbaseCompiler
	
	def compileErrorOfErrorSpecification(ErrorSpecification errorSpecification, IAppendable appendable) {
		xbaseCompiler.compileErrorOfErrorSpecification(errorSpecification, appendable)
	}
	
	def compileSourceOfErrorSpecification(ErrorSpecification errorSpecification, IAppendable appendable) {
		xbaseCompiler.compileSourceOfErrorSpecification(errorSpecification, appendable)
	}
	
	def compileFeatureOfErrorSpecification(ErrorSpecification errorSpecification, IAppendable appendable) {
		xbaseCompiler.compileFeatureOfErrorSpecification(errorSpecification, appendable)
	}
}
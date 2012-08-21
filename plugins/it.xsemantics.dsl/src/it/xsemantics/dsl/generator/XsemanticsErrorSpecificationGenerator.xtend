package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class XsemanticsErrorSpecificationGenerator {
	
	@Inject XsemanticsXbaseCompiler xbaseCompiler
	
	def compileErrorOfErrorSpecification(ErrorSpecification errorSpecification, ITreeAppendable appendable) {
		xbaseCompiler.compileErrorOfErrorSpecification(errorSpecification, appendable)
	}
	
	def compileSourceOfErrorSpecification(ErrorSpecification errorSpecification, ITreeAppendable appendable) {
		xbaseCompiler.compileSourceOfErrorSpecification(errorSpecification, appendable)
	}
	
	def compileFeatureOfErrorSpecification(ErrorSpecification errorSpecification, ITreeAppendable appendable) {
		xbaseCompiler.compileFeatureOfErrorSpecification(errorSpecification, appendable)
	}
}
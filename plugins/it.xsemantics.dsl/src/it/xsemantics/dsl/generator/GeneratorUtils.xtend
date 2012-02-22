package it.xsemantics.dsl.generator

import java.util.List
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.diagnostics.Severity
import com.google.common.collect.Lists

class GeneratorUtils {
	
	def static onlyErrors(List<Issue> issues) {
		Lists::newArrayList(
			issues.filter( [ severity == Severity::ERROR ] )
		)
	}
	
	def static hasErrors(List<Issue> issues) {
		!(onlyErrors(issues).empty)
	}
}
package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.generator.XsemanticsRuleGenerator
import it.xsemantics.dsl.generator.XsemanticsSystemGenerator
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratorBaseTest extends XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsRuleGenerator ruleGenerator
	
	@Inject
	protected XsemanticsSystemGenerator tsGenerator
	
	def createAppendable(Rule rule) {
		ruleGenerator.createAndConfigureAppendable(rule, createImportManager)
	}
	
	def createAppendable(CheckRule rule) {
		ruleGenerator.createAndConfigureAppendable(rule, createImportManager)
	}
	
	def createAppendable() {
		new FakeTreeAppendable(createImportManager)
	}
	
	def createImportManager() {
		new ImportManager(true)
	}
}

package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.generator.XsemanticsRuleGenerator
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.junit.BeforeClass
import org.junit.runner.RunWith
import it.xsemantics.dsl.generator.XsemanticsSystemGenerator
import it.xsemantics.dsl.xsemantics.CheckRule

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratorBaseTest extends XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsRuleGenerator ruleGenerator
	
	@Inject
	protected XsemanticsSystemGenerator tsGenerator
	
	@BeforeClass
	def static void setNewLine() {
		System::setProperty("line.separator", "\n")
	}
	
	def createAppendable(Rule rule) {
		ruleGenerator.createAndConfigureAppendable(rule, createImportManager)
	}
	
	def createAppendable(CheckRule rule) {
		ruleGenerator.createAndConfigureAppendable(rule, createImportManager)
	}
	
	def createAppendable() {
		new StringBuilderBasedAppendable(createImportManager)
	}
	
	def createImportManager() {
		new ImportManager(true)
	}
}
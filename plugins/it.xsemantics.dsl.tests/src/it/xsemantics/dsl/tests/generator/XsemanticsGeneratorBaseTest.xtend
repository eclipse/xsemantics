package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratorBaseTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsUtils
	
	@Inject JvmModelGenerator jvmModelGenerator
	
	@Inject JvmModelAssociator associator
	
	@Inject GeneratorConfigProvider generatorConfigProvider
	
	def ITreeAppendable createAppendable(Rule rule) {
		createAndConfigureAppendable(rule, createImportManager)
	}
	
	def ITreeAppendable createAppendable(CheckRule rule) {
		createJvmModelGeneratorConfiguredAppendable(rule)
	}
	
	def createAndConfigureAppendable(Rule rule, ImportManager importManager) {
		val appendable = createAppendable
		rule.configureAppendable(appendable)
		appendable
	}
	
	def configureAppendable(Rule rule, ITreeAppendable appendable) {
		rule.ruleParams.forEach([
			appendable.declareVariable(it.parameter, it.parameter.simpleName)
		])
	}
	
	def createJvmModelGeneratorConfiguredAppendable(Rule rule) {
		val appendable = rule.createJvmModelGeneratorAppendable
		rule.configureAppendable(appendable)
		appendable
	}
	
	def createJvmModelGeneratorConfiguredAppendable(CheckRule rule) {
		val appendable = rule.createJvmModelGeneratorAppendable
		appendable.declareVariable(rule.element.parameter, rule.element.parameter.simpleName)
		appendable
	}

	def createJvmModelGeneratorAppendable(EObject context) {
		// the inferrer created a Java class for the generated system
		// so we retrieve this JvmGenericType from the associator
		val container = associator.getNearestLogicalContainer(context)
		// the created appendable contains the correct bindings for 'this'
		jvmModelGenerator.createAppendable
			(container, createImportManager, generatorConfig)
	}
	
	def createAppendable() {
		new FakeTreeAppendable(createImportManager)
	}
	
	def createImportManager() {
		new ImportManager(true)
	}
	
	def generatorConfig() {
		generatorConfigProvider.get(null)
	}
}

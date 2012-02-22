package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.runtime.StringRepresentationPostProcessor
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.base.Strings
import junit.framework.Assert

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class StringRepresentationPostProcessorTests extends XsemanticsBaseTest {
	
	@Inject extension StringRepresentationPostProcessor processor
	
	@Test
	def void testStopAtNewLineAbsent() {
		assertEqualsStrings("no new line", "no new line".stopAtNewLine)
	}
	
	@Test
	def void testStopAtNewLine() {
		assertEqualsStrings("no new line", 
		'''
		no new line
		some new
		lines
		'''.toString.stopAtNewLine)
	}
	
	@Test
	def void testLimitTo() {
		assertEqualsStrings("1234...", "123456".limitChars(4))
	}
	
	@Test
	def void testLimitToWithSmaller() {
		assertEqualsStrings("12", "12".limitChars(4))
	}
	
	@Test
	def void testLimitSameLength() {
		assertEqualsStrings("12", "12".limitChars(2))
	}
	
	@Test
	def void testProcessNull() {
		assertEqualsStrings("", process(null))
	}
	
	@Test
	def void testProcessLongString() {
		Assert::assertEquals(StringRepresentationPostProcessor::MAX_CHARS +
			StringRepresentationPostProcessor::OMISSIS.length,
			Strings::repeat("a", StringRepresentationPostProcessor::MAX_CHARS + 30)
				.process.length
		)
	}
	
	@Test
	def void testProcess() {
		assertEqualsStrings("no new line", 
		'''
		no new line
		some new
		lines
		'''.toString.process)
	}
}
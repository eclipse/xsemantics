package it.xsemantics.example.fj.tests

import com.google.inject.Inject
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.util.FjValueUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjSemanticsTests extends FjBaseTests {

	@Inject extension FjValueUtils

	@Test
	def void testLiteralsAreValues() {
		'''10'''.assertValue
		'''true'''.assertValue
		'''"foo"'''.assertValue
	}

	@Test
	def void testNewWithNoArgsIsValue() {
		'''
		class A {
			
		}
		
		new A()
		'''.assertValue
	}

	@Test
	def void testNewWithEvaluatedArgsIsValue() {
		'''
		class A {
			B b;
		}
		
		class B {
			int i;
		}
		
		new A(new B(1))
		'''.assertValue
	}

	@Test
	def void testMethodCallIsNotValue() {
		'''
		class A {
			String m() { return 'foo'; }
		}
		
		new A().m()
		'''.assertNotValue
	}

	def private assertValue(CharSequence prog) {
		Assert::assertTrue(prog.parseAndAssertNoError.main.isValue)
	}

	def private assertNotValue(CharSequence prog) {
		Assert::assertFalse(prog.parseAndAssertNoError.main.isValue)
	}
	

}
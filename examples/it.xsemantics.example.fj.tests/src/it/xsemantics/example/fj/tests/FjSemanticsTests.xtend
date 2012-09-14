package it.xsemantics.example.fj.tests

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.Expression
import it.xsemantics.example.fj.typing.FjTypeSystem
import it.xsemantics.example.fj.util.FjValueUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjInjectorProviderCustom))
class FjSemanticsTests extends FjBaseTests {

	@Inject extension FjValueUtils
	
	@Inject FjTypeSystem fjSystem

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

	@Test
	def void testReduceNew() {
		'''
		class A {
			
		}
		
		new A()
		'''.assertReduceOneStep("new A()")
	}

	@Test
	def void testReduceFieldSelection() {
		'''
		class A {
			int i;
		}
		
		new A(10).i
		'''.assertReduceOneStep("10")
	}

	@Test
	def void testCongruenceReduceFieldSelection() {
		'''
		class A {
			int i;
			String s;
		}
		
		new A(new A(10, 'a').i, 'b').i
		'''.assertReduceOneStep("new A(10, 'b').i")
	}

	@Test
	def void testReduceAllNew() {
		'''
		class A {
			int i;
			boolean b;
			String s;
		}
		
		new A(new A(10, true, 'a').i, false, 'b').b
		'''.
assertReduceAll(
'''
RSelection: [] |- new A(new A(10, true, 'a').i, false, 'b').b ~> new A(10, false, 'b').b
 RNew: [] |- new A(new A(10, true, 'a').i, false, 'b') ~> new A(10, false, 'b')
  RSelection: [] |- new A(10, true, 'a').i ~> 10
RSelection: [] |- new A(10, false, 'b').b ~> false'''
)
	}

	def private assertValue(CharSequence prog) {
		Assert::assertTrue(prog.parseAndAssertNoError.main.isValue)
	}

	def private assertNotValue(CharSequence prog) {
		Assert::assertFalse(prog.parseAndAssertNoError.main.isValue)
	}

	def private assertReduceOneStep(CharSequence prog, CharSequence expected) {
		prog.parseAndAssertNoError.main.copy.assertReduceOneStep(expected)	
	}
	
	def private assertReduceAll(CharSequence prog, CharSequence expectedTrace) {
		var exp = prog.parseAndAssertNoError.main.copy
		var result = exp.assertReduce
		while (!result.value.value) {
			exp = result.value
			result = exp.assertReduce
		}
		Assert::assertEquals(
			expectedTrace.toString,
			traceUtils.traceAsString(trace)
		)
	}

	def private assertReduceOneStep(Expression exp, CharSequence expected) {
		val result = assertReduce(exp)
		Assert::assertEquals(expected.toString, stringRep.string(result.value))
		result.value
	}
	
	def private assertReduce(Expression exp) {
		val result = fjSystem.reduce(null, trace, exp)
		if (result.failed) {
			println(traceUtils.failureTraceAsString(result.ruleFailedException))
			Assert::fail
		}
		result
	}
}
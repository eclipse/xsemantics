package it.xsemantics.example.fj.tests

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.Expression
import it.xsemantics.example.fj.typing.FjTypeSystem
import it.xsemantics.example.fj.util.FjSemanticsUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import it.xsemantics.example.fj.fj.Selection

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjInjectorProviderCustom))
class FjSemanticsTests extends FjBaseTests {

	@Inject extension FjSemanticsUtils
	
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
	def void testReplaceThis() {
		'''
		class B { }
		
		class A {
			B o;
			A m(A a, int i) { return this.m(this, 10); }
		}
		
		new A(new B())
		'''.assertThisReplacement("new A(new B()).m(new A(new B()), 10)")
	}

	@Test
	def void testReplaceParams() {
		'''
		class B { }
		
		class A {
			B o;
			A m(A a, B b, int i, String s) { return a.m(a, b, i, s); }
		}
		
		new A(new B()).m(new A(new B()), new A(new B()).o, 10, 'foo')
		'''.assertParamsReplacement(
		"new A(new B()).m(new A(new B()), new A(new B()).o, 10, 'foo')")
	}

	@Test
	def void testReduceNew() {
		'''
		class A {
			
		}
		
		new A()
		'''.assertReduceOneStep("new A()", null)
	}

	@Test
	def void testReduceFieldSelection() {
		'''
		class A {
			int i;
		}
		
		new A(10).i
		'''.assertReduceOneStep("10", null)
	}

	@Test
	def void testReduceMethodSelection() {
		'''
		class B { String s; }
		
		class A {
			B o;
			B m(B b, String s) { 
				return this.getB(s);
			}
			B getB(String s) { return this.o; }
		}
		
		new A(new B('foo')).m(new B('bar'), 'aaa')
		'''.assertReduceOneStep(
"new A(new B('foo')).getB('aaa')", null)
	}

	@Test
	def void testCongruenceReduceFieldSelection() {
		'''
		class A {
			int i;
			String s;
		}
		
		new A(new A(10, 'a').i, 'b').i
		'''.assertReduceOneStep(
"new A(10, 'b').i",
'''
RSelection: [] |- new A(new A(10, 'a').i, 'b').i ~> new A(10, 'b').i
 RNew: [] |- new A(new A(10, 'a').i, 'b') ~> new A(10, 'b')
  RSelection: [] |- new A(10, 'a').i ~> 10'''
		)
	}

	@Test
	def void testCongruenceReduceMethodSelection() {
		'''
		class A {
			int i;
			String s;
			int m(int arg) { return arg; }
		}
		
		new A(10, 'b').m(new A(20, 'c').i)
		'''.assertReduceOneStep(
"new A(10, 'b').m(20)",
'''
RSelection: [] |- new A(10, 'b').m(new A(20, 'c').i) ~> new A(10, 'b').m(20)
 RSelection: [] |- new A(20, 'c').i ~> 20''')
	}

	@Test
	def void testReduceAllFieldSelection() {
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

	@Test
	def void testReduceAllMethodSelection() {
		'''
		class B { 
			String s;
			String getS() { return this.s; }
		}
		
		class A {
			B o;
			B m(B b, String s) { 
				return this.getB(s);
			}
			B getB(String s) { 
				return this.o;
			}
		}
		
		new A(new B('foo')).m(new B('bar'), 'aaa').getS()
		'''.assertReduceAll(
'''
RSelection: [] |- new A(new B('foo')).m(new B('bar'), 'aaa').getS() ~> new A(new B('foo')).getB('aaa').getS()
 RSelection: [] |- new A(new B('foo')).m(new B('bar'), 'aaa') ~> new A(new B('foo')).getB('aaa')
RSelection: [] |- new A(new B('foo')).getB('aaa').getS() ~> new A(new B('foo')).o.getS()
 RSelection: [] |- new A(new B('foo')).getB('aaa') ~> new A(new B('foo')).o
RSelection: [] |- new A().o.getS() ~> new B('foo').getS()
 RSelection: [] |- new A(new B('foo')).o ~> new B('foo')
RSelection: [] |- new B('foo').getS() ~> new B('foo').s
RSelection: [] |- new B('foo').s ~> 'foo' ''')
	}

	def private assertValue(CharSequence prog) {
		Assert::assertTrue(prog.parseAndAssertNoError.main.isValue)
	}

	def private assertNotValue(CharSequence prog) {
		Assert::assertFalse(prog.parseAndAssertNoError.main.isValue)
	}

	def private assertThisReplacement(CharSequence prog, CharSequence expected) {
		val p = prog.parseAndAssertNoError
		val mBodyExp = p.methodByName("m").body.expression.copy
		mBodyExp.replaceThis(p.main)
		Assert::assertEquals(expected.toString, stringRep.string(mBodyExp))
	}

	def private assertParamsReplacement(CharSequence prog, CharSequence expected) {
		val p = prog.parseAndAssertNoError
		val m = p.methodByName("m")
		val mBodyExp = m.body.expression.copy
		mBodyExp.replaceParams(m.params, (p.main as Selection).args)
		Assert::assertEquals(expected.toString, stringRep.string(mBodyExp))
	}

	def private assertReduceAll(CharSequence prog, CharSequence expectedTrace) {
		var exp = prog.parseAndAssertNoError.main.copy
		var result = exp.assertReduce
		while (!result.value.value) {
			exp = result.value
			result = exp.assertReduce
		}
		Assert::assertEquals(
			expectedTrace.toString.trim,
			traceUtils.traceAsString(trace)
		)
	}

	def private assertReduceOneStep(CharSequence prog, CharSequence expected, CharSequence expectedTrace) {
		prog.parseAndAssertNoError.main.copy.assertReduceOneStep(expected, expectedTrace)	
	}
	
	def private assertReduceOneStep(Expression exp, CharSequence expected, CharSequence expectedTrace) {
		val result = assertReduce(exp)
		if (expected != null)
			Assert::assertEquals(expected.toString, stringRep.string(result.value))
		if (expectedTrace != null)
			Assert::assertEquals(
				expectedTrace.toString,
				traceUtils.traceAsString(trace)
			)
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
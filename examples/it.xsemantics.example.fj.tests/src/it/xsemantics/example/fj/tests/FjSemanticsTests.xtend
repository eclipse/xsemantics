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
import it.xsemantics.example.fj.fj.Selection
import it.xsemantics.example.fj.util.FjTypeUtils
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.Result

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

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
	def void testReplaceThisAndParams() {
		'''
		class B { }
		
		class A {
			B o;
			A m(A a, B b, int i, String s) { return this.m(a, b, i, s); }
		}
		
		new A(new B()).m(new A(new B()), new A(new B()).o, 10, 'foo')
		'''.assertThisAndParamsReplacement(
		"new A(new B()).m(new A(new B()), new A(new B()).o, 10, 'foo')")
	}

	@Test
	def void testWellTypedAfterSubstitutionParam() {
		'''
		class Base { }
		class B extends Base { }
		class C extends B {}
		
		class A {
			B o;
			Base m(B b, int i) { 
				return b;
			}
		}
		
		new A(new B()).m(new C(), 10)
		'''.assertSubstitutionLemma(
'''
WELLTYPED METHOD BODY
TParamRef: [this <- A] |- b : B
WELLTYPED AFTER SUBSTITUTION
TNew: [] |- new C() : C
 SubtypeSequence: [] |- new C() ~> [] << []
SUBTYPE AFTER SUBSTITUTION
ClassSubtyping: [] |- C <: B''')
	}

	@Test
	def void testWellTypedAfterSubstitutionThis() {
		'''
		class A {
			
		}
		
		class B extends A {
			A m() { 
				return this;
			}
		}
		
		class C extends B {
			
		}
		
		new C().m()
		'''.assertSubstitutionLemma(
'''
WELLTYPED METHOD BODY
TThis: [this <- B] |- this : B
WELLTYPED AFTER SUBSTITUTION
TNew: [] |- new C() : C
 SubtypeSequence: [] |- new C() ~> [] << []
SUBTYPE AFTER SUBSTITUTION
ClassSubtyping: [] |- C <: B''')
	}

	@Test
	def void testWellTypedAfterSubstitutionFieldSelection() {
		'''
		class A {
			int i;
		}
		
		class B extends A {
			int m() { 
				return this.i;
			}
		}
		
		class C extends B {
			
		}
		
		new C(10).m()
		'''.assertSubstitutionLemma(
'''
WELLTYPED METHOD BODY
TSelection: [this <- B] |- this.i : int
 TThis: [this <- B] |- this : B
WELLTYPED AFTER SUBSTITUTION
TSelection: [] |- new C(10).i : int
 TNew: [] |- new C(10) : C
  SubtypeSequence: [] |- new C(10) ~> [10] << [int i;]
   ExpressionAssignableToType: [] |- 10 <| int
    TIntConstant: [] |- 10 : int
    BasicSubtyping: [] |- int <: int
SUBTYPE AFTER SUBSTITUTION
BasicSubtyping: [] |- int <: int''')
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
	def void testReduceCast() {
		'''
		class A {
			int i;
		}
		
		class B extends A { }
		
		(A) new B(10)
		'''.assertReduceOneStep("new B(10)", null)
	}

	@Test
	def void testReduceCastWrong() {
		'''
		class A {
			int i;
		}
		
		class B extends A { }
		
		(B) new A(10)
		'''.assertReduceWrong(
'''failed: RCast: [] |- (B) new A(10) ~> Expression
 failed: new A(10) is not assignable for B
  failed: A is not a subtype of B
   failed: getAll(left.classref, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class)) .contains(right.classref)'''
)
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
	def void testCongruenceReduceCast() {
		'''
		class A {
			int i;
			B createB() { return new B(100); }
		}
		
		class B extends A { 
			
		}
		
		(A) (new A(10).createB())
		'''.assertReduceOneStep("(A) new B(100)", null)
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

	@Test
	def void testReduceAllCast() {
		'''
		class A {
			int i;
			B createB() { return new B(100); }
		}
		
		class B extends A { 
			
		}
		
		(A) (new A(10).createB())
		'''.assertReduceAll(
'''
RCast: [] |- (A) new A(10).createB() ~> (A) new B(100)
 RSelection: [] |- new A(10).createB() ~> new B(100)
RCast: [] |- (A) new B(100) ~> new B(100)
 ExpressionAssignableToType: [] |- new B(100) <| A
  TNew: [] |- new B(100) : B
   SubtypeSequence: [] |- new B(100) ~> [100] << [int i;]
    ExpressionAssignableToType: [] |- 100 <| int
     TIntConstant: [] |- 100 : int
     BasicSubtyping: [] |- int <: int
  ClassSubtyping: [] |- B <: A''')
	}

	@Test
	def void testSubjectReductionCast() {
		'''
		class A {
			int i;
		}
		
		class B extends A { }
		
		(A) new B(10)
		'''.assertSubjectReduction(
'''
WELLTYPED MAIN
TCast: [] |- (A) new B(10) : A
 TNew: [] |- new B(10) : B
  SubtypeSequence: [] |- new B(10) ~> [10] << [int i;]
   ExpressionAssignableToType: [] |- 10 <| int
    TIntConstant: [] |- 10 : int
    BasicSubtyping: [] |- int <: int
 ClassSubtyping: [] |- B <: A
REDUCTION
RCast: [] |- (A) new B(10) ~> new B(10)
 ExpressionAssignableToType: [] |- new B(10) <| A
  TNew: [] |- new B(10) : B
   SubtypeSequence: [] |- new B(10) ~> [10] << [int i;]
    ExpressionAssignableToType: [] |- 10 <| int
     TIntConstant: [] |- 10 : int
     BasicSubtyping: [] |- int <: int
  ClassSubtyping: [] |- B <: A
WELLTYPED AFTER REDUCTION
TNew: [] |- new B(10) : B
 SubtypeSequence: [] |- new B(10) ~> [10] << [int i;]
  ExpressionAssignableToType: [] |- 10 <| int
   TIntConstant: [] |- 10 : int
   BasicSubtyping: [] |- int <: int
SUBTYPE AFTER REDUCTION
ClassSubtyping: [] |- B <: A'''			
		)
	}

	@Test
	def void testSubjectReductionMethodSelection() {
		'''
		class A {
			A m() { return this; }
		}
		
		class B extends A{
			
		}
		
		new B().m()
		'''.assertSubjectReduction(
'''WELLTYPED MAIN
TSelection: [] |- new B().m() : A
 TNew: [] |- new B() : B
  SubtypeSequence: [] |- new B() ~> [] << []
 SubtypeSequence: [] |- new B().m() ~> [] << []
REDUCTION
RSelection: [] |- new B().m() ~> new B()
WELLTYPED AFTER REDUCTION
TNew: [] |- new B() : B
 SubtypeSequence: [] |- new B() ~> [] << []
SUBTYPE AFTER REDUCTION
ClassSubtyping: [] |- B <: A'''
)
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

	def private assertThisAndParamsReplacement(CharSequence prog, CharSequence expected) {
		val p = prog.parseAndAssertNoError
		val m = p.methodByName("m")
		val mBodyExp = m.body.expression.copy
		mBodyExp.replaceThisAndParams(
			(p.main as Selection).receiver, 
			m.params, (p.main as Selection).args
		)
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

	def private assertReduceWrong(CharSequence prog, CharSequence expectedTrace) {
		val exp = prog.parseAndAssertNoError.main.copy
		val result = fjSystem.reduce(null, trace, exp)
		if (result.failed) {
			Assert::assertEquals(
				expectedTrace.toString,
				traceUtils.failureTraceAsString
					(result.ruleFailedException)
			)
		} else {
			Assert::fail("unexpected success: " + stringRep.string(result.value))
		}
	}

	def private assertSubstitutionLemma(CharSequence prog, CharSequence expectedTrace) {
		val p = prog.parseAndAssertNoError
		val m = p.methodByName("m")
		
		trace.addToTrace("WELLTYPED METHOD BODY")
		
		val typeForThis = FjTypeUtils::createClassType(
			m.getContainerOfType(typeof(it.xsemantics.example.fj.fj.Class))
		)
		val methodBodyType = fjSystem.type(
			new RuleEnvironment(fjSystem.environmentEntry("this", typeForThis)),
			trace, m.body.expression
		)
		methodBodyType.assertResult
		
		val mBody = m.body.copy
		
		mBody.expression.replaceThisAndParams(
			(p.main as Selection).receiver, 
			m.params, (p.main as Selection).args
		)
		
		trace.addToTrace("WELLTYPED AFTER SUBSTITUTION")
		
		val substType = fjSystem.type(null, trace, mBody.expression)
		substType.assertResult
		
		trace.addToTrace("SUBTYPE AFTER SUBSTITUTION")
		val isSubtype = fjSystem.subtype
			(null, trace, substType.value, methodBodyType.value)
		isSubtype.assertResult
		
		Assert::assertEquals(expectedTrace.toString, 
			traceUtils.traceAsString(trace)
		)
	}

	def private assertSubjectReduction(CharSequence prog, CharSequence expectedTrace) {
		val p = prog.parseAndAssertNoError
		val m = p.main
		
		trace.addToTrace("WELLTYPED MAIN")
		
		val mainType = fjSystem.type(null, trace, m)
		mainType.assertResult
		
		trace.addToTrace("REDUCTION")
		
		val reduced = m.assertReduce
		
		trace.addToTrace("WELLTYPED AFTER REDUCTION")
		
		val reducedType = fjSystem.type(null, trace, reduced.value)
		reducedType.assertResult
		
		trace.addToTrace("SUBTYPE AFTER REDUCTION")
		val isSubtype = fjSystem.subtype
			(null, trace, reducedType.value, mainType.value)
		isSubtype.assertResult
		
		Assert::assertEquals(expectedTrace.toString, 
			traceUtils.traceAsString(trace)
		)
	}

	def private <T> assertResult(Result<T> result) {
		if (result.failed) {
			println(traceUtils.failureTraceAsString(result.ruleFailedException))
			Assert::fail
		}
	}
}
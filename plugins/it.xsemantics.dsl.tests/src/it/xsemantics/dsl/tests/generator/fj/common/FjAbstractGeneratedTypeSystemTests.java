package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.util.FjTypeUtils;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.StringRepresentation;
import it.xsemantics.runtime.util.TraceUtils;

import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;

public abstract class FjAbstractGeneratedTypeSystemTests extends
		FjAbstractTests {

	protected IFjTypeSystem fjTypeSystem;

	protected FjExpectedTraces expectedTraces;

	protected RuleApplicationTrace trace;

	protected StringRepresentation stringRep;

	protected TraceUtils traceUtils;

	static {
		System.setProperty("line.separator", "\n");
	}

	public class FjClassForTests {
		public Class A;

		public Class B;

		public Class C;

		protected Program program;

		public RuleApplicationTrace trace = new RuleApplicationTrace();

		public FjClassForTests(CharSequence programString) throws Exception {
			program = getProgram(programString);
			A = fjClassForName("A");
			B = fjClassForName("B");
			C = fjClassForName("C");
		}

		public Class fjClassForName(String className) {
			return fjTestsUtils.fjClassForName(program, className);
		}
	}

	public class FjFieldsForTests {
		public Field basicField1;

		public Field basicField2;

		Field basicField3;

		public Field classField1;

		public Field classField2;

		Field classField3;

		Program program;

		public RuleApplicationTrace trace = new RuleApplicationTrace();

		public FjFieldsForTests(CharSequence programString) throws Exception {
			program = getProgram(programString);
			basicField1 = fjTestsUtils.fjFieldForName(program, "_string");
			basicField2 = fjTestsUtils.fjFieldForName(program, "_int");
			basicField3 = fjTestsUtils.fjFieldForName(program, "_string2");
			classField1 = fjTestsUtils.fjFieldForName(program, "a");
			classField2 = fjTestsUtils.fjFieldForName(program, "b");
			classField3 = fjTestsUtils.fjFieldForName(program, "a2");
		}
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(fjCustomStandaloneSetupClass());
		fjTypeSystem = get(IFjTypeSystem.class);
		expectedTraces = get(FjExpectedTraces.class);
		trace = new RuleApplicationTrace();
		stringRep = get(FjTestsStringRepresentation.class);
		traceUtils = get(TraceUtils.class);
	}

	protected abstract java.lang.Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass();

	@Test
	public void testNullArguments() throws Exception {
		assertSubtypes(null, null, false, trace,
				"passed null object to system", "");
	}

	@Test
	public void testSubclasses() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertSubclasses(classes.B, classes.A, true, classes.trace,
				expectedTraces.okSubclasses(), "");
	}

	@Test
	public void testSubclassesObject() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchyWithObject());
		assertSubclasses(classes.C, classes.fjClassForName("Object"), true,
				classes.trace,
				"Subclassing: [] |- class C extends B { } <| class Object { }",
				"");
	}

	@Test
	public void testSubclassesFailed() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertSubclasses(classes.A, classes.B, false, classes.trace,
				expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
	}

	@Test
	public void testSubtypesBasic() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.basicField1.getType(),
				fields.basicField3.getType(), true, fields.trace,
				"BasicSubtyping: [] |- String <: String", "");
	}

	@Test
	public void testSubtypesBasicFailed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.basicField1.getType(),
				fields.basicField2.getType(), false, fields.trace,
				expectedTraces.failSubtypesBasic(), "String -- int");
	}

	@Test
	public void testSubtypesClasses() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.classField2.getType(),
				fields.classField1.getType(), true, fields.trace,
				expectedTraces.okSubtypesClasses().toString().trim(), "");
	}

	@Test
	public void testSubtypesClassesFailed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.classField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				expectedTraces.failSubtypesClasses(),
				"A -- B -- class A { } -- class B extends A { }");
	}

	@Test
	public void testEqualsBasicType() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.basicField1.getType(),
				fields.basicField3.getType(), true, fields.trace,
				"BasicEquals: [] |- String ~~ String", "");
	}

	@Test
	public void testEqualsClassType() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.classField1.getType(),
				fields.classField3.getType(), true, fields.trace,
				"ClassEquals: [] |- A ~~ A", "");
	}

	@Test
	public void testNotEqualsBasicType() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.basicField1.getType(),
				fields.basicField2.getType(), false, fields.trace,
				expectedTraces.failEqualsBasicType(), "String -- int");
	}

	@Test
	public void testNotEqualsClassType() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.classField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				expectedTraces.failEqualsClassType(), "A -- B");
	}

	@Test
	public void testNotEqualsTypeMixed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.basicField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				"cannot find a rule for |- String ~~ B", "");
	}

	@Test
	public void testStringConstant() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram("'foo'")), "String",
				trace, "TStringConstant: [] |- 'foo' : String", "");
	}

	@Test
	public void testIntConstant() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram("10")), "int", trace,
				"TIntConstant: [] |- 10 : int", "");
	}

	@Test
	public void testBoolConstant() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram("true")), "boolean",
				trace, "TBoolConstant: [] |- true : boolean", "");
	}

	@Test
	public void testNew() throws Exception {
		assertType(
				fjTestsUtils.mainExpression(getProgram(testFiles.testForNew())),
				"B", trace, expectedTraces.newType(), "");
	}

	@Test
	public void testVariable() throws Exception {
		assertType(fjTestsUtils.variableExpression(getProgram(testFiles
				.testForVariable())), "String", trace,
				expectedTraces.variableType(), "");
	}

	@Test
	public void testCast() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram(testFiles
				.testForCast())), "B", trace, expectedTraces.castType(), "");
	}

	@Test
	public void testThisWithEmptyEnvironment() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram(testFiles
				.testForThis())), null, trace, expectedTraces
				.failThisDueToNullEnvironment().toString().trim(), "this");
	}

	@Test
	public void testThisWithWrongMapping() throws Exception {
		RuleEnvironment environment = new RuleEnvironment();
		environment.add("this", "foo");
		assertType(
				environment,
				fjTestsUtils.mainExpression(getProgram(testFiles.testForThis())),
				null, trace, expectedTraces.failThisDueToNotClassType()
						.toString().trim(), "this");
	}

	@Test
	public void testThisOk() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		RuleEnvironment environment = new RuleEnvironment();
		environment.add("this", fields.classField1.getType());
		assertType(
				environment,
				fjTestsUtils.mainExpression(getProgram(testFiles.testForThis())),
				"A", trace, "TThis: [this <- A] |- this : A", "");
	}

	@Test
	public void testMethodCall() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram(testFiles
				.testForMethodCall())), "String", trace,
				expectedTraces.methodCallType(), "");
	}

	@Test
	public void testFieldSelection() throws Exception {
		assertType(fjTestsUtils.mainExpression(getProgram(testFiles
				.testForFieldSelection())), "int", trace,
				expectedTraces.fieldSelectionType(), "");
	}

	@Test
	public void testSuperclasses() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertSuperclasses(classes, classes.A, "[]");
		assertSuperclasses(classes, classes.B, "[class A { }]");
		assertSuperclasses(classes, classes.C,
				"[class B extends A { }, class A { }]");
	}

	@Test
	public void testSuperclassesWithCyclicHierarchy() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testCyclicClassHierarchy());
		assertSuperclasses(
				classes,
				classes.A,
				"[class C extends B { }, class B extends A { }, class A extends C { }, class C extends B { }]");
		assertSuperclasses(
				classes,
				classes.B,
				"[class A extends C { }, class C extends B { }, class B extends A { }, class A extends C { }]");
		assertSuperclasses(
				classes,
				classes.C,
				"[class B extends A { }, class A extends C { }, class C extends B { }, class B extends A { }]");
	}

	@Test
	public void testIsNotClassType() throws Exception {
		assertClassType(fjTestsUtils.mainExpression(getProgram("'foo'")), null,
				trace, expectedTraces.failClassType(), "'foo'");
	}

	@Test
	public void testIsClassType() throws Exception {
		assertClassType(
				fjTestsUtils.mainExpression(getProgram("class A {} new A()")),
				"A", trace, expectedTraces.classType(), "");
	}

	@Test
	public void testCheckMethodOk() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.fjMethodForName(
						getProgram(testFiles.testForMethodCall()), "m"), true,
				trace, expectedTraces.methodCheckOk(), "");
	}

	@Test
	public void testCheckMethodOkWithThis() throws Exception {
		assertCheck(null, fjTestsUtils.fjMethodForName(
				getProgram(testFiles.testForMethodBodyUsingThis()), "m"), true,
				trace, expectedTraces.methodCheckOkWithThis(), "");
	}

	@Test
	public void testCheckMethodBodyNotSubtype() throws Exception {
		assertCheck(null, fjTestsUtils.fjMethodForName(
				getProgram(testFiles.testForMethodBodyNotSubtype()), "m"),
				false, trace, expectedTraces.methodCheckBodyNotSubtype(),
				"int m(String param) { return new A(param... -- String -- int");
	}

	@Test
	public void testCheckMethodCallOk() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testMethodCallOk())), true, trace,
				expectedTraces.methodCallCheckOk(), "");
	}

	@Test
	public void testFieldsInHierarchy() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchyForFields());
		assertFields(classes, classes.A, "[int i;]");
		assertFields(classes, classes.B, "[int i;, String s;]");
		assertFields(classes, classes.C, "[int i;, String s;, A c;]");
	}

	@Test
	public void testFieldsInHierarchyWithoutFields() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertFields(classes, classes.A, "[]");
		assertFields(classes, classes.B, "[]");
		assertFields(classes, classes.C, "[]");
	}

	@Test
	public void testMethodsInHierarchy() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchyForMethods());
		assertMethods(classes, classes.A, "[String i() { return 'A.i'; }]");
		assertMethods(
				classes,
				classes.B,
				"[String j() { return 'B.j'; }, String k() { return 'B.k'; }, String i() { return 'A.i'; }]");
		assertMethods(
				classes,
				classes.C,
				"[String i() { return 'C.i'; }, String j() { return 'C.j'; }, String k() { return 'B.k'; }]");
	}

	@Test
	public void testCheckNewOk() throws Exception {
		assertCheck(null,
				fjTestsUtils.mainExpression(getProgram(testFiles.testNewOk())),
				true, trace, expectedTraces.newCheckOk(), "");
	}

	@Test
	public void testCheckNewWrongSubtypeSimpler() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testNewWrongArgSubtypeSimpler())), false, trace,
				expectedTraces.newCheckWrongSubtypeSimpler(),
				"new A('foo') -- int");
	}

	@Test
	public void testCheckNewWrongSubtype() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.mainExpression(getProgram(testFiles
						.testNewWrongArgSubtype())),
				false,
				trace,
				expectedTraces.newCheckWrongSubtype(),
				"new C(10, 'foo', new C(20, 'bar', new D(... -- new C(20, 'bar', new D()) -- D -- A -- class D {} -- class A { int i; }");
	}

	@Test
	public void testCheckNewWrongArgNum() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testNewWrongArgNum())), false, trace,
				expectedTraces.newCheckWrongArgNum(),
				"new C(10, 'foo', new B(20, 'bar', 1)) -- new B(20, 'bar', 1)");
	}

	@Test
	public void testCheckNewWrongSubtypeBasic() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testNewWrongArgSubtypeBasic())), false, trace,
				expectedTraces.newCheckWrongSubtypeBasic(),
				"new C(10, 10, new B(20, 'bar')) -- String");
		// note that the type int of the constant 10 is not present in the error
		// information
		// since it does not have a corresponding NodeModel
	}

	@Test
	public void testCastOk1() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testCastOk1())), true, trace, expectedTraces.castOk1(), "");
	}

	@Test
	public void testCastOk2() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testCastOk2())), true, trace, expectedTraces.castOk2(), "");
	}

	@Test
	public void testCastWrong() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.mainExpression(getProgram(testFiles
						.testCastWrong())),
				false,
				trace,
				expectedTraces.castWrong(),
				"(D) new C() -- C -- D -- class C extends B { } -- class D {} -- class B extends A { } -- class A { }");
		// note that class D {} duplicates are removed:
		// "(D) new C() -- C -- D -- class C extends B { } -- class D {} -- class B extends A { } -- class D {} -- class A { } -- class D {}");
	}

	@Test
	public void testCheckClassWrongSubclassDeclaresSameFieldOfSuperClass()
			throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testSubclassDeclaresSameFieldOfSuperClass());
		assertCheck(null, classes.B, false, trace,
				expectedTraces.subclassDeclaresSameFieldOfSuperClass(),
				"class B extends A { String s; int i; }");
	}

	@Test
	public void testCheckClassOkWRTFields() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testSubclassOkWRTFields());
		assertCheck(null, classes.B, true, trace,
				expectedTraces.subclassOkWRTFields(), "");
	}

	@Test
	public void testCheckSubclassNotOvverrideMethod() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testSubclassNotOverrideMethod());
		assertCheck(null, classes.C, false, trace,
				expectedTraces.subclassNotOvverrideMethod(),
				"class C extends A { boolean m(String s) ... -- boolean -- int");
	}

	@Test
	public void testCheckSubclassOvverrideMethod() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testSubclassNotOverrideMethod());
		assertCheck(null, classes.B, true, trace,
				expectedTraces.subclassOverrideMethod(), "");
	}

	@Test
	public void testNoRuleFound() throws Exception {
		assertCheck(null, FjTypeUtils.createStringType(), false, trace,
				"cannot find a rule for |- String", "");
	}

	protected void assertSuperclasses(FjClassForTests classes, Class class1,
			String expectedListRepresentation) {
		assertEquals(expectedListRepresentation,
				stringRep.string(fjTypeSystem.superclasses(class1).getValue()));
	}

	protected void assertFields(FjClassForTests classes, Class class1,
			String expectedListRepresentation) {
		assertEquals(expectedListRepresentation,
				stringRep.string(fjTypeSystem.fields(class1).getValue()));
	}

	protected void assertMethods(FjClassForTests classes, Class class1,
			String expectedListRepresentation) {
		assertEquals(expectedListRepresentation,
				stringRep.string(fjTypeSystem.methods(class1).getValue()));
	}

	protected void assertSubclasses(Class subClass, Class superClass,
			boolean expectSuccess, RuleApplicationTrace trace,
			CharSequence expectedTrace, CharSequence expectedErrorInformations) {
		if (expectSuccess)
			assertResultTrue(
					fjTypeSystem.subclass(null, trace, subClass, superClass),
					trace, expectedTrace);
		else
			assertResultFalse(fjTypeSystem.subclass(subClass, superClass),
					expectedTrace, expectedErrorInformations);
	}

	protected void assertSubtypes(Type subType, Type superType,
			boolean expectSuccess, RuleApplicationTrace trace,
			CharSequence expectedTrace, CharSequence expectedErrorInformations) {
		if (expectSuccess)
			assertResultTrue(
					fjTypeSystem.subtype(null, trace, subType, superType),
					trace, expectedTrace);
		else
			assertResultFalse(fjTypeSystem.subtype(subType, superType),
					expectedTrace, expectedErrorInformations);
	}

	protected void assertEqualsType(Type subType, Type superType,
			boolean expectSuccess, RuleApplicationTrace trace,
			CharSequence expectedTrace, CharSequence expectedErrorInformations) {
		if (expectSuccess)
			assertResultTrue(
					fjTypeSystem.equalstype(null, trace, subType, superType),
					trace, expectedTrace);
		else
			assertResultFalse(fjTypeSystem.equalstype(subType, superType),
					expectedTrace, expectedErrorInformations);
	}

	protected void assertType(Expression expression, String expectedType,
			RuleApplicationTrace trace, CharSequence expectedTrace,
			CharSequence expectedErrorInformations) {
		assertType(null, expression, expectedType, trace, expectedTrace,
				expectedErrorInformations);
	}

	protected void assertType(RuleEnvironment environment,
			Expression expression, String expectedType,
			RuleApplicationTrace trace, CharSequence expectedTrace,
			CharSequence expectedErrorInformations) {
		assertType(fjTypeSystem.type(environment, trace, expression),
				expectedType, trace, expectedTrace, expectedErrorInformations);
	}

	protected void assertClassType(Expression expression, String expectedType,
			RuleApplicationTrace trace, CharSequence expectedTrace,
			CharSequence expectedErrorInformations) {
		assertClassType(null, expression, expectedType, trace, expectedTrace,
				expectedErrorInformations);
	}

	protected void assertClassType(RuleEnvironment environment,
			Expression expression, String expectedType,
			RuleApplicationTrace trace, CharSequence expectedTrace,
			CharSequence expectedErrorInformations) {
		assertType(fjTypeSystem.classtype(environment, trace, expression),
				expectedType, trace, expectedTrace, expectedErrorInformations);
	}

	protected void assertType(Result<? extends Type> result, String expectedType,
			RuleApplicationTrace trace, CharSequence expectedTrace,
			CharSequence expectedErrorInformations) {
		if (expectedType != null) {
			assertFalse(result.failed());
			assertEquals(expectedType, stringRep.string(result.getValue()));
			expectedTraces.assertTrace(trace, expectedTrace);
		} else {
			assertResultFalse(result, expectedTrace, expectedErrorInformations);
		}
	}

	protected void assertCheck(RuleEnvironment environment, EObject eObject,
			boolean expectSuccess, RuleApplicationTrace trace,
			CharSequence expectedTrace, CharSequence expectedErrorInformations) {
		Result<Boolean> result = fjTypeSystem
				.check(environment, trace, eObject);
		assertCheck(result, expectSuccess, trace, expectedTrace,
				expectedErrorInformations);
	}

	protected void assertCheck(Result<?> result, boolean expectSuccess,
			RuleApplicationTrace trace, CharSequence expectedTrace,
			CharSequence expectedErrorInformations) {
		if (expectSuccess) {
			if (result.failed()) {
				fail("FAILED WITH:\n"
						+ traceUtils.failureTraceAsString(result
								.getRuleFailedException()));
			}
			expectedTraces.assertTrace(trace, expectedTrace);
		} else {
			assertResultFalse(result, expectedTrace, expectedErrorInformations);
		}
	}

	protected void assertResultTrue(Result<Boolean> result) {
		assertTrue(result.getValue());
	}

	protected void assertResultTrue(Result<Boolean> result,
			RuleApplicationTrace trace, CharSequence expectedTrace) {
		assertResultTrue(result);
		expectedTraces.assertTrace(trace, expectedTrace);
	}

	protected void assertResultFalse(Result<?> result,
			CharSequence expectedMessage, CharSequence expectedErrorInformations) {
		assertTrue(result.getRuleFailedException() != null);
		expectedTraces.assertFailureTrace(result.getRuleFailedException(),
				expectedMessage);
		expectedTraces.assertErrorInformation(result.getRuleFailedException(),
				expectedErrorInformations);
	}

}

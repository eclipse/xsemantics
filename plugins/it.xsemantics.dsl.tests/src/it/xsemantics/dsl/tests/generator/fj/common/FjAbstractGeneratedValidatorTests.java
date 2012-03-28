package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics.DiagnosticPredicate;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.junit.Test;

public abstract class FjAbstractGeneratedValidatorTests extends FjAbstractTests {

	protected ValidatorTester<XsemanticsBasedDeclarativeValidator> tester;

	protected FjInputFilesForTyping testFiles = new FjInputFilesForTyping();

	protected FjTestsUtils utils = new FjTestsUtils();

	protected FjExpectedTraces expectedTraces;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(fjCustomStandaloneSetupClass());
		tester = new ValidatorTester<XsemanticsBasedDeclarativeValidator>(
				get(XsemanticsBasedDeclarativeValidator.class), getInjector());
		expectedTraces = get(FjExpectedTraces.class);
	}

	protected abstract java.lang.Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass();

	@Test
	public void testMethodCall() throws Exception {
		assertOk(getProgram(testFiles.testForMethodCall()));
	}

	@Test
	public void testCheckNewWrongSubtypeSimpler() throws Exception {
		assertAll(testFiles.testNewWrongArgSubtypeSimpler(),
				expectedTraces.validateCheckNewWrongSubtypeSimpler());
	}
	
	@Test
	public void testCheckNewWrongArgNum() throws Exception {
		assertAll(testFiles.testNewWrongArgNum(),
				expectedTraces.validateCheckNewWrongArgNum());
	}

	@Test
	public void testCyclicClassHierarchy() throws Exception {
		assertAll(testFiles.testCyclicClassHierarchy(),
				expectedTraces.validateCyclicClassHierarchy());
	}
	
	@Test
	public void testSubclassDeclaresSameFieldOfSuperClass() throws Exception {
		assertAll(testFiles.testSubclassDeclaresSameFieldOfSuperClass(),
				expectedTraces.validateSubclassDeclaresSameFieldOfSuperClass());
	}

	protected void assertOk(EObject element) {
		assertOk(tester.validate(element));
	}

	protected void assertOk(AssertableDiagnostics validate) {
		if (listOfDiagnostics(validate).size() != 0) {
			System.err.println(utils.diagnosticsToString(validate));
			fail("There are expected to be no diagnostics.: "
					+ utils.diagnosticsToString(validate));
		}
	}

	protected void assertAll(CharSequence programToValidate,
			CharSequence expectedErrors) throws Exception {
		assertAll(expectedErrors.toString(),
				tester.validate(getProgram(programToValidate)));
	}

	protected void assertAll(CharSequence expectedErrors,
			AssertableDiagnostics validate) {
		assertEquals(utils.removeObjectIdentifiers(expectedErrors.toString())
				.trim(), utils.removeObjectIdentifiers(utils
				.diagnosticsToString(validate)));
	}

	protected void assertAll(AssertableDiagnostics validate,
			DiagnosticPredicate... predicates) {
		System.err.println(utils.diagnosticsToString(validate));
		validate.assertAll(predicates);
	}

	protected List<Diagnostic> listOfDiagnostics(AssertableDiagnostics validate) {
		return validate.getDiagnostic().getChildren();
	}
}

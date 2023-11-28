/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.dsl.tests;

import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.ACCESS_TO_OUTPUT_PARAM_WITHIN_CLOSURE;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.ASSIGNMENT_TO_INPUT_PARAM;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.DUPLICATE_JUDGMENT_DESCRIPTION_SYMBOLS;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.DUPLICATE_RULE_WITH_SAME_ARGUMENTS;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NOT_PARAMETER;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NOT_SUBTYPE;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NOT_VALIDATOR;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NOT_VALID_INPUT_ARG;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NOT_VALID_OUTPUT_ARG;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NOT_VALID_SUPER_SYSTEM;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NO_INPUT_PARAM;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.NO_JUDGMENT_DESCRIPTION;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.RETURN_NOT_ALLOWED;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.THROW_NOT_ALLOWED;
import static org.eclipse.xsemantics.dsl.validation.XsemanticsValidator.TOO_MANY_OUTPUT_PARAMS;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.dsl.tests.input.FjTypeSystemFiles;
import org.eclipse.xsemantics.dsl.tests.input.XsemanticsTestFiles;
import org.eclipse.xsemantics.dsl.validation.XsemanticsValidator;
import org.eclipse.xsemantics.dsl.validation.testutils.ValidatorTester;
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsFile;
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsPackage;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.AssertableDiagnostics;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XsemanticsValidatorTests {

	private static final String IN_SYSTEM_ORG_ECLIPSE_XSEMANTICS_TEST_TYPE_SYSTEM = ", in system: org.eclipse.xsemantics.test.TypeSystem";

	@Inject
	private ParseHelper<XsemanticsFile> parser;

	@Inject
	private XsemanticsValidator validator;

	@Inject
	private ValidatorTester<XsemanticsValidator> tester;

	@Inject
	private ValidationTestHelper validationTestHelper;

	private XsemanticsTestFiles testFiles = new XsemanticsTestFiles();

	private FjTypeSystemFiles fjTSFiles = new FjTypeSystemFiles();

	@Before
	public void setUp() {
		validator.setEnableWarnings(false);
	}

	@Test
	public void testDuplicateJudgmentDescriptionSymbols() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testJudgmentDescriptionsWithDuplicateSymbols());
		String messageFragment = "Duplicate judgment symbols '|- :'";
		validate.assertAll(AssertableDiagnostics.error(
				DUPLICATE_JUDGMENT_DESCRIPTION_SYMBOLS,
				messageFragment), AssertableDiagnostics.error(
				DUPLICATE_JUDGMENT_DESCRIPTION_SYMBOLS,
				messageFragment));
	}

	protected void assertContains(AssertableDiagnostics validate, String string) {
		final String diagnosticsToString = diagnosticsToString(validate);
		if (!diagnosticsToString.contains(string)) {
			fail("diagnostics: " + diagnosticsToString
					+ "\n does not contain: " + string);
		}
	}

	@Test
	public void testRulesWithExpressionInConclusionWrong() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testRuleWithExpressionInConclusion2());
		validate.assertAll(AssertableDiagnostics.error(
				NOT_PARAMETER,
				"Must be a parameter, not an expression"));
	}

	@Test
	public void testRulesWithSameEnvironmentNames() throws Exception {
		assertOk(loadModelAndValidate(testFiles
				.testRulesWithSameEnvironmentNames()));
	}

	@Test
	public void testNoRuleForJudgmentDescription() throws Exception {
		validator.setEnableWarnings(true);
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testJudgmentDescriptions());
		validate.assertAll(AssertableDiagnostics
				.warningMsg("No rule defined for the judgment description"));
	}

	@Test
	public void testNoJudgmentDescriptionForRule() throws Exception {
		assertNoJudgmentDescription(testFiles
				.testRuleWithoutJudgmentDescription());
	}

	@Test
	public void testNoJudgmentDescriptionForRuleInvocation() throws Exception {
		assertNoJudgmentDescription(testFiles
				.testRuleInvocationWithoutJudgmentDescription());
	}

	protected void assertNoJudgmentDescription(CharSequence programString)
			throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(programString);
		String messageFragment = "No Judgment description for: ||- :";
		validate.assertAll(AssertableDiagnostics.error(
				NO_JUDGMENT_DESCRIPTION, messageFragment));
	}

	@Test
	public void testRuleConclusionNotSubtype() throws Exception {
		EObject model = getModel(testFiles.testRuleWithConclusionNotSubtype()
				.toString());
		validationTestHelper
				.assertError(
						model,
						XsemanticsPackage.Literals.RULE_CONCLUSION_ELEMENT,
						NOT_SUBTYPE,
						"Rule conclusion type EObject "
								+ "is not subtype of JudgmentDescription declared type "
								+ "EClass");
	}

	@Test
	public void testRuleInvocationNotSubtype() throws Exception {
		EObject model = getModel(testFiles
				.testRuleInvokingAnotherRuleNotValid().toString());
		validationTestHelper
				.assertError(
						model,
						XbasePackage.eINSTANCE.getXBinaryOperation(),
						NOT_SUBTYPE,
						"Rule invocation type boolean "
								+ "is not subtype of JudgmentDescription declared type "
								+ "EObject");
	}

	@Test
	public void testRuleConclusionNotSubtypeBoth() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testRuleWithConclusionNotSubtypeBoth());
		validate.assertAll(
				AssertableDiagnostics
						.error(NOT_SUBTYPE,
								"Rule conclusion type EObject "
										+ "is not subtype of JudgmentDescription declared type "
										+ "EClass"),
				AssertableDiagnostics
						.error(NOT_SUBTYPE,
								"Rule conclusion type String "
										+ "is not subtype of JudgmentDescription declared type "
										+ "EObject"));
	}

	@Test
	public void testFjExpressionTypingRules() throws Exception {
		assertOk(loadModelAndValidate(fjTSFiles.fjExpressionTypeRules()));
	}

	@Test
	public void testRulesOfTheSameKindWithSameInputArgumentTypes()
			throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testRulesOfTheSameKindWithSameInputArgumentTypes());
		validate.assertAll(AssertableDiagnostics.error(
				DUPLICATE_RULE_WITH_SAME_ARGUMENTS,
				"Duplicate rule of the same kind with parameters: String"
						+ IN_SYSTEM_ORG_ECLIPSE_XSEMANTICS_TEST_TYPE_SYSTEM),
				AssertableDiagnostics.error(
						DUPLICATE_RULE_WITH_SAME_ARGUMENTS,
						"Duplicate rule of the same kind with parameters: String"
								+ IN_SYSTEM_ORG_ECLIPSE_XSEMANTICS_TEST_TYPE_SYSTEM));
	}

	@Test
	public void testErrorSpecifications() throws Exception {
		assertOk(loadModelAndValidate(testFiles
				.testRuleWithErrorSpecifications()));
	}

	@Test
	public void testRuleInvocationWithWrongOutputArg() throws Exception {
		EObject model = getModel(testFiles
				.testRuleInvocationWithWrongOutputArg().toString());
		validationTestHelper.assertError(model,
				XbasePackage.eINSTANCE.getXMemberFeatureCall(),
				NOT_VALID_OUTPUT_ARG,
				"Not a valid argument for output parameter");
	}

	@Test
	public void testRuleInvocationWithWrongOutputArg2() throws Exception {
		EObject model = getModel(testFiles
				.testRuleInvocationWithWrongOutputArg2().toString());
		validationTestHelper.assertError(model,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				NOT_VALID_OUTPUT_ARG,
				"Not a valid argument for output parameter");
	}

	@Test
	public void testWrongVariableDeclarationAsOutputArgument() throws Exception {
		EObject model = getModel(testFiles
				.testWrongVariableDeclarationAsOutputArgument().toString());
		validationTestHelper.assertError(model,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				NOT_VALID_OUTPUT_ARG,
				"Not a valid argument for output parameter");
	}

	@Test
	public void testMoreThan3OutputParams() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testJudgmentDescriptionsWith4OutputParams());
		validate.assertAll(AssertableDiagnostics.error(
				TOO_MANY_OUTPUT_PARAMS,
				"No more than 3 output parameters are handled at the moment"));
	}

	@Test
	public void testNoInputParam() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testJudgmentDescriptionsWithNoInputParam());
		validate.assertAll(AssertableDiagnostics.error(
				NO_INPUT_PARAM,
				"No input parameter; at least one is needed"));
	}

	@Test
	public void testAssignmentToOutputParam() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testRuleWithAssignmentToOutputParam());
		assertOk(validate);
	}

	@Test
	public void testAssignmentToInputParam() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testRuleWithAssignmentToInputParam());
		validate.assertAll(AssertableDiagnostics.error(
				ASSIGNMENT_TO_INPUT_PARAM,
				"Assignment to input parameter"));
	}

	@Test
	public void testRuleInvocationWithInputParamPassedAsOutput()
			throws Exception {
		EObject model = getModel(testFiles
				.testRuleInvocationWithInputParamPassedAsOutput().toString());
		validationTestHelper.assertError(model,
				XbasePackage.eINSTANCE.getXFeatureCall(),
				NOT_VALID_OUTPUT_ARG,
				"Not a valid argument for output parameter");
	}

	@Test
	public void testWrongVariableDeclarationAsInputArgument() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testWrongVariableDeclarationAsInputArgument());
		validate.assertAll(AssertableDiagnostics.error(
				NOT_VALID_INPUT_ARG,
				"Not a valid argument for input parameter"));
	}

	@Test
	public void testRuleInvocationWithOutputArgInsideClosure() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testRuleInvocationWithOutputArgInsideClosure());
		validate.assertAll(AssertableDiagnostics
				.error(ACCESS_TO_OUTPUT_PARAM_WITHIN_CLOSURE,
						"Cannot refer to an output parameter eC from within a closure"));
	}

	@Test
	public void testAccessToOutputParamInsideClosure() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testAccessToOutputParamInsideClosure());
		validate.assertAll(AssertableDiagnostics
				.error(ACCESS_TO_OUTPUT_PARAM_WITHIN_CLOSURE,
						"Cannot refer to an output parameter eC from within a closure"));
	}

	@Test
	public void testWrongReturnInPremises() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testWrongReturnInPremises());
		validate.assertAll(
				AssertableDiagnostics.error(RETURN_NOT_ALLOWED,
						"Return statements are not allowed here"));
		// in 2.4 the next error is not issued
//				AssertableDiagnostics
//						.error(org.eclipse.xtext.xbase.validation.INCOMPATIBLE_TYPES,
//								"Incompatible types"));
	}

	@Test
	public void testWrongThrowInPremises() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testWrongThrowInPremises());
		validate.assertAll(AssertableDiagnostics.error(
				THROW_NOT_ALLOWED,
				"Throw statements are not allowed here"));
		// AssertableDiagnostics
		// .error(org.eclipse.xtext.xbase.validation.UNHANDLED_EXCEPTION,
		// "Unhandled exception"));
	}

	@Test
	public void testRuleWithBooleanExpressionsWithNoSideEffectInsideClosure()
			throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testForClosureWithExpressionWithNoSideEffect());
		assertOk(validate);
	}

	@Test
	public void testNoSideEffectButNoError() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testNoSideEffectButNoError());
		assertOk(validate);
	}

	@Test
	public void testErrorNoSideEffect() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testErrorNoSideEffect());
		assertOk(validate);
//		validate.assertAll(AssertableDiagnostics
//				.error(org.eclipse.xtext.xbase.validation.INVALID_INNER_EXPRESSION,
//						"This expression is not allowed in this context"));
	}

	@Test
	public void testValidatorExtendsNotAbstractDeclarativeValidator()
			throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testSystemWithValidatorExtendsNotAbstractDeclarativeValidator());
		validate.assertAll(AssertableDiagnostics
				.error(NOT_VALIDATOR,
						"Not an AbstractDeclarativeValidator: EClass"));
	}

	@Test
	public void testSystemExtendsInvalidBaseSystem() throws Exception {
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testSystemExtendsInvalidBaseSystem());
		validate.assertAll(AssertableDiagnostics
				.error(NOT_VALID_SUPER_SYSTEM,
						"Not an Xsemantics system: TestInvalidBaseSystem"));
	}

	@Test
	public void testNoAuxFunForAuxiliaryDescription() throws Exception {
		validator.setEnableWarnings(true);
		AssertableDiagnostics validate = loadModelAndValidate(testFiles
				.testAuxiliaryDescriptionsWithoutAuxFun());
		validate.assertAll(
				AssertableDiagnostics
						.warningMsg("No function defined for the auxiliary description"),
				AssertableDiagnostics
						.warningMsg("No function defined for the auxiliary description"),
				AssertableDiagnostics
						.warningMsg("No function defined for the auxiliary description"));
	}

	private AssertableDiagnostics loadModelAndValidate(
			CharSequence testFileContents) throws Exception {
		return tester.validate(getModel(testFileContents));
	}

	private XsemanticsFile getModel(CharSequence testFileContents) throws Exception {
		return parser.parse(testFileContents);
	}

	protected void assertDuplicateErrors(AssertableDiagnostics validate,
			String elementClassName, String duplicateName,
			String... msgFragments) {
		//System.out.println(diagnosticsToString(validate));
		String messageFragment = "Duplicate " + elementClassName + " '"
				+ duplicateName + "'";
		validate.assertAll(AssertableDiagnostics.errorMsg(messageFragment),
				AssertableDiagnostics.errorMsg(messageFragment));
		for (String msgFragment : msgFragments) {
			validate.assertAny(AssertableDiagnostics.errorMsg(msgFragment));
		}
	}

	protected void assertOk(AssertableDiagnostics validate) {
		if (listOfDiagnostics(validate).size() != 0) {
			for (Diagnostic diag : listOfDiagnostics(validate)) {
				System.err.println(diag.toString());
			}
			fail("There are expected to be no diagnostics.: "
					+ diagnosticsToString(validate));
		}
	}

	protected String diagnosticsToString(AssertableDiagnostics validate) {
		return listOfDiagnostics(validate).toString();
	}

	protected List<Diagnostic> listOfDiagnostics(AssertableDiagnostics validate) {
		return validate.getDiagnostic().getChildren();
	}
}

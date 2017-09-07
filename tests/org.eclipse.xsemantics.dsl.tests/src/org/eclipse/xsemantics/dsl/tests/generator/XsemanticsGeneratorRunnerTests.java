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

package org.eclipse.xsemantics.dsl.tests.generator;

import org.eclipse.xsemantics.dsl.generator.XsemanticsOutputConfigurationProvider;
import org.eclipse.xsemantics.dsl.tests.XsemanticsAbstractTests;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

public class XsemanticsGeneratorRunnerTests extends XsemanticsAbstractTests {
	protected static final String VALIDATION_SUBDIR = "validation/";

	GeneratorForTests generator;
	
	XtextResourceSet resourceSet;

//	static {
//		System.setProperty("line.separator", "\n");
//	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		generator = get(GeneratorForTests.class);
		generator.setOutputPath(null);
		resourceSet = get(XtextResourceSet.class);
	}

	protected void setGeneratorOutputPath(String outputPath) {
		generator.setOutputPath(outputPath);
	}

	@Test
	public void testGeneratorIsNotNull() {
		assertTrue(generator != null);
	}

//	@Test
//	public void testCleanOutputFolder() {
//		setGeneratorOutputPath(RESULT_DIR + "ecore_test/");
//		cleanOutputFolderAndAssertEmpty();
//	}

	@Test
	public void testGeneratorOnSimpleRule() throws Exception {
		runGenerationAndAssertJavaFiles(
				TESTS_INPUT_FILES + "ecore_test.xsemantics", "ecore_test/",
				"org/eclipse/xsemantics/test/ecore/", "TypeSystem");
	}

	@Test
	public void testGeneratorOnRuleInvocation() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "ecore_ruleinvocation_test.xsemantics",
				"ecore_ruleinvocation_test/",
				"org/eclipse/xsemantics/test/ruleinvocation/ecore/", "TypeSystem");
	}

	@Test
	public void testGeneratorOnParticularTest() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "ecore_particular_test.xsemantics", "ecore_particular_test/",
				"org/eclipse/xsemantics/test/particular/ecore/", "TypeSystem");
	}

	@Test
	public void testGeneratorOrExpressions() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "ecore_or_test.xsemantics", "ecore_or_test/",
				"org/eclipse/xsemantics/test/orexpressions/ecore/", "TypeSystem");
	}

	@Test
	public void testGeneratorExpressions() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "ecore_expressions_test.xsemantics", "ecore_expressions_test/",
				"org/eclipse/xsemantics/test/expressions/ecore/", "TypeSystem");
	}

	@Test
	public void testGeneratorOnEcoreWithValidator() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "ecore_validation_test.xsemantics", "ecore_validation_test/",
				"org/eclipse/xsemantics/test/validation/ecore/", "TypeSystem");
	}

	@Test
	public void testGeneratorOnFjFirst() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_first_test.xsemantics", "fj_first_test/",
				"org/eclipse/xsemantics/test/fj/first/", "FjFirstTypeSystem");
	}

	@Test
	public void testGeneratorOnFjAlt() throws Exception {
		// make sure to load fj_first_test.xsemantics ...
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_first_test.xsemantics", "fj_first_test/",
				"org/eclipse/xsemantics/test/fj/first/", "FjFirstTypeSystem");
		// since fj_alt_test.xsemantics extends fj_first_test.xsemantics
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_alt_test.xsemantics", "fj_alt_test/",
				"org/eclipse/xsemantics/test/fj/alt/", "FjAltTypeSystem");
	}

	@Test
	public void testGeneratorOnFjLambdaTest() throws Exception {
		// make sure to load fj_first_test.xsemantics ...
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_first_test.xsemantics", "fj_first_test/",
				"org/eclipse/xsemantics/test/fj/first/", "FjFirstTypeSystem");
		// since fj_lambda_test.xsemantics extends fj_first_test.xsemantics
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_lambda_test.xsemantics", "fj_lambda_test/",
				"org/eclipse/xsemantics/test/fj/lambda/", "FjTestsForLambdas");
	}

	@Test
	public void testGeneratorOnFjFirstCachedTests() throws Exception {
		// make sure to load fj_first_test.xsemantics ...
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_first_test.xsemantics", "fj_first_test/",
				"org/eclipse/xsemantics/test/fj/first/", "FjFirstTypeSystem");
		// since fj_cached_test.xsemantics extends fj_first_test.xsemantics
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_cached_test.xsemantics", "fj_cached_test/",
				"org/eclipse/xsemantics/test/fj/caching/", "FjFirstCachedTypeSystem");
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "fj_cached_options_test.xsemantics", "fj_cached_options_test/",
				"org/eclipse/xsemantics/test/fj/caching/", "FjFirstCachedOptionsTypeSystem");
	}

	@Test
	public void testErrorSpecifications() throws Exception {
		runGenerationAndAssertJavaFiles(TESTS_INPUT_FILES
				+ "ecore_errspecification_test.xsemantics",
				"ecore_errspecification_test/",
				"org/eclipse/xsemantics/test/errspecification/ecore/", "TypeSystem");
	}

	@Test
	public void testOnANonValidInputFile() throws Exception {
		runGeneratorOnInputFileAndExpectErrors(TESTS_INPUT_FILES_WITH_ERRORS
				+ "ecore_test_errors.xsemantics", RESULT_DIR + "foo/", true);
	}

	/**
	 * This is used to generate the Java files in the source folder xsemantics-gen
	 * that then will be used for testing the type system
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRunGenerationInXsemanticsGen() throws Exception {
		setGeneratorOutputPath(XsemanticsOutputConfigurationProvider.XSEMANTICS_GEN);
		cleanOutputFolderAndAssertEmpty();
		runGenerator(TESTS_INPUT_FILES + "fj_first_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "fj_alt_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "fj_lambda_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "fj_cached_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "fj_cached_options_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_expressions_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_particular_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_ruleinvocation_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_or_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_validation_test.xsemantics");
		runGenerator(TESTS_INPUT_FILES + "ecore_errspecification_test.xsemantics");
	}

	protected void runGenerationAndAssertJavaFiles(String inputFile,
			String outputFolder, String outputPath, String typeSystemJavaFile)
			throws Exception {
		String resultDirOutputFolder = RESULT_DIR + outputFolder;
		runGeneratorOnInputFile(inputFile, resultDirOutputFolder);
		assertDirectoryContainsJavaClassFiles("./" + resultDirOutputFolder
				+ outputPath, typeSystemJavaFile);
		final String completeOutputPath = outputFolder + outputPath;
		compare(EXPECTATION_DIR + completeOutputPath + typeSystemJavaFile
				+ ".java", resultDirOutputFolder + outputPath
				+ typeSystemJavaFile + ".java");
		final String validatorJavaFile = typeSystemJavaFile + "Validator"
				+ ".java";
		compare(EXPECTATION_DIR + completeOutputPath + VALIDATION_SUBDIR
				+ validatorJavaFile, resultDirOutputFolder + outputPath
				+ VALIDATION_SUBDIR + validatorJavaFile);
	}

	protected void cleanOutputFolderAndAssertEmpty() {
		generator.cleanOutputFolder();
		assertDirectoryContainsNumOfFiles(0, generator.getOutputPath());
	}

	protected void runGeneratorOnInputFile(String inputFile, String outputFolder) {
		runGeneratorOnInputFileAndExpectErrors(inputFile, outputFolder, false);
	}

	protected void runGeneratorOnInputFileAndExpectErrors(String inputFile,
			String outputFolder, boolean expectErrors) {
		assertTrue("did you forget to specify the output folder?",
				outputFolder != null && outputFolder.length() > 0);
		setGeneratorOutputPath(outputFolder);
		if (!expectErrors)
			cleanOutputFolderAndAssertEmpty();
		runGenerator(inputFile, expectErrors);
	}

	protected void runGenerator(String inputFile) {
		runGenerator(inputFile, false);
	}

	protected void runGenerator(String inputFile, boolean expectErrors) {
		List<Issue> issues = generator.runGenerator(inputFile, resourceSet);
		if (expectErrors)
			assertTrue("no errors found", !issues.isEmpty());
		else {
			assertFalse("errors: " + issues, GeneratorUtils.hasErrors(issues));
		}
	}

	protected void assertDirectoryContainsJavaClassFiles(String dir,
			String... classFileNames) {
		File[] files = assertDirectoryContainsNumOfFiles(classFileNames.length,
				dir);
		for (String classFileName : classFileNames) {
			boolean found = false;
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().equals(classFileName + ".java")) {
					found = true;
					break;
				}
			}
			assertTrue("file for class " + classFileName + " not found in "
					+ dir, found);
		}
	}

	protected File[] assertDirectoryContainsNumOfFiles(int expectedNumOfFiles,
			String dir) {
		File[] listFiles = getListOfFiles(dir);
		assertEquals(expectedNumOfFiles, listFiles.length);
		return listFiles;
	}

	protected File[] getListOfFiles(String dir) {
		File dirFile = new File(dir);
		// This filter only returns files
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isFile() && 
						!file.getName().endsWith(".java._trace");
			}
		};
		File[] listFiles = dirFile.listFiles(fileFilter);
		return listFiles;
	}

	protected void compare(String expected, String result) throws Exception {
		String expectedContents = readFileAsString(expected);
		String actualContents = readFileAsString(result);
		assertEquals(expectedContents, actualContents);
	}

	protected static String readFileAsString(String file) throws IOException {
		return readFileAsString(new File(file));
	}

	protected static String readFileAsString(File file) throws IOException {
		byte[] buffer = new byte[(int) file.length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(file));
			f.read(buffer);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ignored) {
				}
		}
		return new String(buffer).replaceAll("\\r", "");
	}
}

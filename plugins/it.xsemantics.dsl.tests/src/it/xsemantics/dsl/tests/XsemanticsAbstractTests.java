/**
 * 
 */
package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.XsemanticsStandaloneSetup;
import it.xsemantics.dsl.tests.input.FjTypeSystemFiles;
import it.xsemantics.dsl.tests.input.XsemanticsTestFiles;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author bettini
 * 
 */
public class XsemanticsAbstractTests extends AbstractXtextTests {

	protected static final String TESTS_INPUT_FILES = "./tests_input_files/";

	protected static final String EXPECTATION_DIR = "expectations/";

	protected static final String RESULT_DIR = "test-gen/";

	protected XsemanticsTestFiles testFiles = new XsemanticsTestFiles();

	protected FjTypeSystemFiles fjTSFiles = new FjTypeSystemFiles();

	protected EmfFactoryUtils emfUtils = new EmfFactoryUtils();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XsemanticsStandaloneSetup.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// serializer tests do not work due to java.lang.ClassCastException: org.eclipse.xtext.impl.RuleCallImpl cannot be cast to org.eclipse.xtext.Alternatives
		return false;
	}

}

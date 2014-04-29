/**
 * 
 */
package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom.XsemanticsStandaloneSetupForTests;
import it.xsemantics.dsl.tests.input.FjTypeSystemFiles;
import it.xsemantics.dsl.tests.input.XsemanticsTestFiles;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Assert;
import org.junit.Before;

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
	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(XsemanticsStandaloneSetupForTests.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// serializer tests do not work due to java.lang.ClassCastException: org.eclipse.xtext.impl.RuleCallImpl cannot be cast to org.eclipse.xtext.Alternatives
		return false;
	}

	protected void assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
				("" + expected).replaceAll("\r", ""), 
				("" + actual).replaceAll("\r", "")
			);
	}
}

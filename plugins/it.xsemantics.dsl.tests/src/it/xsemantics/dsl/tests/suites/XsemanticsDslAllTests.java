package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.QualifiedNameTest;
import it.xsemantics.dsl.tests.XsemanticsNodeModelUtilsTest;
import it.xsemantics.dsl.tests.XsemanticsParserTest;
import it.xsemantics.dsl.tests.XsemanticsProposalsForDatatypeRulesTest;
import it.xsemantics.dsl.tests.XsemanticsScopingTest;
import it.xsemantics.dsl.tests.XsemanticsTypeProviderTest;
import it.xsemantics.dsl.tests.XsemanticsTypeSystemTest;
import it.xsemantics.dsl.tests.XsemanticsUtilsTest;
import it.xsemantics.dsl.tests.XsemanticsValidatorTest;
import it.xsemantics.dsl.tests.XsemanticsValidatorTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsParserTest.class,
	XsemanticsScopingTest.class,
	XsemanticsProposalsForDatatypeRulesTest.class,
	XsemanticsValidatorTests.class,
	XsemanticsValidatorTest.class,
	QualifiedNameTest.class,
	XsemanticsUtilsTest.class,
	XsemanticsNodeModelUtilsTest.class,
	XsemanticsTypeProviderTest.class,
	XsemanticsTypeSystemTest.class
})
public class XsemanticsDslAllTests {

}

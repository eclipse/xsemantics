package it.xsemantics.dsl.tests.ui;

import it.xsemantics.dsl.tests.ui.contentassist.XsemanticsProposalProviderTest;
import it.xsemantics.dsl.tests.ui.editor.XsemanticsEditorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsProposalProviderTest.class,
	XsemanticsEditorTest.class
})
public class XsemanticsAllUiTests {

}

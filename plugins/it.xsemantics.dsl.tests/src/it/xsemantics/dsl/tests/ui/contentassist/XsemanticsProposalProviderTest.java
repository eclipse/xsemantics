/**
 * 
 */
package it.xsemantics.dsl.tests.ui.contentassist;

import it.xsemantics.dsl.XsemanticsStandaloneSetup;
import it.xsemantics.dsl.XsemanticsUiInjectorProvider;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author bettini
 * 
 */
@SuppressWarnings("restriction")
public class XsemanticsProposalProviderTest extends
		AbstractContentAssistProcessorTest {

	XsemanticsTestFilesForContentAssist testInputs = new XsemanticsTestFilesForContentAssist();

	@BeforeClass
	public static void useStaticInjector() {
		useStaticInjector = false;
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(XsemanticsStandaloneSetup.class);
	}

	@Test
	public void testProposalsForJudgmentSymbol() throws Exception {
		newBuilder(getSetup()).append(testInputs.inputForJudgmentSymbols())
				.assertText("|-", "|=", "|>", "||-", "||=", "||>", "||~", "|~");
	}

	@Test
	public void testProposalsForRelationSymbol() throws Exception {
		newBuilder(getSetup()).append(testInputs.inputForRelationSymbols())
				.assertText(":", "<:", ":>", "<<", ">>", "<|", "|>", "<-",
						"-->", "<~", "~>", "~~", "<!", "!>", "<<!", "!>>",
						"<~!", "!~>", "error");
	}

	protected ISetup doGetSetup() {
		return new ISetup() {
			public Injector createInjectorAndDoEMFRegistration() {
				return new XsemanticsUiInjectorProvider().getInjector();
			}
		};
	}

}
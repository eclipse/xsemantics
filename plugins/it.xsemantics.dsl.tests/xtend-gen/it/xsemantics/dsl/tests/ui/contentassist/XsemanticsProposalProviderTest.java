package it.xsemantics.dsl.tests.ui.contentassist;

import it.xsemantics.dsl.XsemanticsUiInjectorProvider;
import it.xsemantics.dsl.tests.ui.contentassist.XsemanticsTestFilesForContentAssist;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsUiInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsProposalProviderTest extends AbstractContentAssistTest {
  private XsemanticsTestFilesForContentAssist testInputs = new Function0<XsemanticsTestFilesForContentAssist>() {
    public XsemanticsTestFilesForContentAssist apply() {
      XsemanticsTestFilesForContentAssist _xsemanticsTestFilesForContentAssist = new XsemanticsTestFilesForContentAssist();
      return _xsemanticsTestFilesForContentAssist;
    }
  }.apply();
  
  @Test
  public void testProposalsForJudgmentSymbol() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForJudgmentSymbols = this.testInputs.inputForJudgmentSymbols();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForJudgmentSymbols);
      _append.assertText("|-", "|=", "|>", "||-", "||=", "||>", "||~", "|~");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProposalsForRelationSymbol() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForRelationSymbols = this.testInputs.inputForRelationSymbols();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForRelationSymbols);
      _append.assertText(":", "<:", ":>", "<<", ">>", "<|", "|>", "<-", 
        "-->", "<~", "~>", "~~", "<!", "!>", "<<!", "!>>", 
        "<~!", "!~>", "error", "override");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

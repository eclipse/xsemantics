package it.xsemantics.dsl.tests.ui.contentassist;

import it.xsemantics.dsl.XsemanticsUiInjectorProvider;
import it.xsemantics.dsl.tests.ui.contentassist.XsemanticsTestFilesForContentAssist;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
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
  
  @Test
  public void testProposalsForInjectionsInConclusion() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForInjections = this.testInputs.inputForInjections();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForInjections);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- EObject o : my");
      ContentAssistProcessorTestBuilder _append_1 = _append.append(_builder.toString());
      _append_1.assertProposal("mylist");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProposalsForInjectionsInPremises() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForInjections = this.testInputs.inputForInjections();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForInjections);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- EObject o : EClass myOutputParam");
      _builder.newLine();
      _builder.append("from {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my");
      ContentAssistProcessorTestBuilder _append_1 = _append.append(_builder.toString());
      _append_1.assertProposal("mylist");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProposalsForOutputParam() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForInjections = this.testInputs.inputForInjections();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForInjections);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- EObject o : EClass myOutputParam");
      _builder.newLine();
      _builder.append("from {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my");
      ContentAssistProcessorTestBuilder _append_1 = _append.append(_builder.toString());
      _append_1.assertProposal("myOutputParam");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProposalsForVarDeclInRuleInvocation() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForInjections = this.testInputs.inputForInjections();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForInjections);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- EObject o : EClass myOutputParam");
      _builder.newLine();
      _builder.append("from {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- o : var EClass myNewVar");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my");
      ContentAssistProcessorTestBuilder _append_1 = _append.append(_builder.toString());
      _append_1.assertProposal("myNewVar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProposalsForVarDeclInRuleInvocation2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      String _inputForRuleInvocation = this.testInputs.inputForRuleInvocation();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_inputForRuleInvocation);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- EObject o : EClass o1 : EClass o2");
      _builder.newLine();
      _builder.append("from {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("G |- o : var EClass myNewVar : my");
      ContentAssistProcessorTestBuilder _append_1 = _append.append(_builder.toString());
      ICompletionProposal[] _computeCompletionProposals = _append_1.computeCompletionProposals();
      final Procedure1<ICompletionProposal> _function = new Procedure1<ICompletionProposal>() {
          public void apply(final ICompletionProposal proposal) {
            String _displayString = proposal.getDisplayString();
            Assert.assertNotEquals(_displayString, "myNewVar");
          }
        };
      IterableExtensions.<ICompletionProposal>forEach(((Iterable<ICompletionProposal>)Conversions.doWrapArray(_computeCompletionProposals)), _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

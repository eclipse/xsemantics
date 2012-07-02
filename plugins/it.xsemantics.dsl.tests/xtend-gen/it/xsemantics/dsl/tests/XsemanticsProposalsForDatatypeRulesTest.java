package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.services.XsemanticsProposalsForDatatypeRules;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import java.util.List;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsProposalsForDatatypeRulesTest extends XsemanticsBaseTest {
  @Inject
  private XsemanticsProposalsForDatatypeRules proposalProvider;
  
  @Test
  public void testProposalsForJudgmentSymbol() {
    List<String> _judgmentSymbols = this.proposalProvider.judgmentSymbols();
    this.assertEqualsStrings("[||-, |-, ||~, |~, ||=, |=, ||>, |>]", _judgmentSymbols);
  }
  
  @Test
  public void testProposalsForRelationSymbol() {
    List<String> _relationSymbols = this.proposalProvider.relationSymbols();
    this.assertEqualsStrings("[<!, !>, <<!, !>>, <~!, !~>, :, <:, :>, <<, >>, ~~, <|, |>, <-, -->, <~, ~>]", _relationSymbols);
  }
}

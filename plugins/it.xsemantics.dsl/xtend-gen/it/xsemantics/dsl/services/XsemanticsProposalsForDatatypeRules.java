package it.xsemantics.dsl.services;

import com.google.inject.Inject;
import it.xsemantics.dsl.services.XsemanticsGrammarAccess;
import java.util.List;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author bettini
 */
@SuppressWarnings("all")
public class XsemanticsProposalsForDatatypeRules {
  @Inject
  private XsemanticsGrammarAccess grammarAccess;
  
  public List<String> judgmentSymbols() {
    ParserRule _judgmentSymbolRule = this.grammarAccess.getJudgmentSymbolRule();
    AbstractElement _alternatives = _judgmentSymbolRule.getAlternatives();
    List<Keyword> _allContentsOfType = EcoreUtil2.<Keyword>getAllContentsOfType(_alternatives, Keyword.class);
    final Function1<Keyword,String> _function = new Function1<Keyword,String>() {
        public String apply(final Keyword it) {
          String _value = it.getValue();
          return _value;
        }
      };
    List<String> _map = ListExtensions.<Keyword, String>map(_allContentsOfType, _function);
    return _map;
  }
  
  public List<String> relationSymbols() {
    ParserRule _relationSymbolRule = this.grammarAccess.getRelationSymbolRule();
    AbstractElement _alternatives = _relationSymbolRule.getAlternatives();
    List<Keyword> _allContentsOfType = EcoreUtil2.<Keyword>getAllContentsOfType(_alternatives, Keyword.class);
    final Function1<Keyword,String> _function = new Function1<Keyword,String>() {
        public String apply(final Keyword it) {
          String _value = it.getValue();
          return _value;
        }
      };
    List<String> _map = ListExtensions.<Keyword, String>map(_allContentsOfType, _function);
    return _map;
  }
}

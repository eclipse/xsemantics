package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class QualifiedNameTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Test
  public void testParsingOfName() {
    try {
      CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
      XsemanticsSystem _parse = this.parser.parse(_testSimpleRule);
      EList<Rule> _rules = _parse.getRules();
      final Rule rule = _rules.get(0);
      QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(rule);
      String _string = _fullyQualifiedName.toString();
      Assert.assertEquals("it.xsemantics.test.TypeSystem.EClassEObject", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

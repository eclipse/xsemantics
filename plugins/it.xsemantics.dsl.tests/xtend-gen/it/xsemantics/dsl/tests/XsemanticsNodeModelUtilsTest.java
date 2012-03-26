package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XsemanticsNodeModelUtilsTest extends XsemanticsBaseTest {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsNodeModelUtils nodeModelUtils;
  
  @Test
  public void testRuleInvocationString() {
      CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
      XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
      XsemanticsSystem ts = _parseAndAssertNoError;
      List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
      final List<RuleInvocation> ruleInvocations = _ruleInvocations;
      int _size = ruleInvocations.size();
      Assert.assertEquals(2, _size);
      RuleInvocation _get = ruleInvocations.get(0);
      String _programText = this.nodeModelUtils.getProgramText(_get);
      Assert.assertEquals("G |- object.eClass : eClass", _programText);
      RuleInvocation _get_1 = ruleInvocations.get(1);
      String _programText_1 = this.nodeModelUtils.getProgramText(_get_1);
      Assert.assertEquals("G |- eClass : object.eClass", _programText_1);
  }
  
  @Test
  public void testNoNodeForObject() {
      EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
      final EClass eClass = _createEClass;
      String _programText = this.nodeModelUtils.getProgramText(eClass);
      boolean _operator_equals = ObjectExtensions.operator_equals(_programText, null);
      Assert.assertTrue(_operator_equals);
  }
}

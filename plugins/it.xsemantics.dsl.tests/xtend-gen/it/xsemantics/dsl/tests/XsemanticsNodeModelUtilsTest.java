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

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsNodeModelUtilsTest extends XsemanticsBaseTest {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsNodeModelUtils nodeModelUtils;
  
  @Test
  public void testRuleInvocationString() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    XsemanticsSystem ts = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
    final List<RuleInvocation> ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
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
    final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
    String _programText = this.nodeModelUtils.getProgramText(eClass);
    boolean _equals = ObjectExtensions.operator_equals(_programText, null);
    Assert.assertTrue(_equals);
  }
}

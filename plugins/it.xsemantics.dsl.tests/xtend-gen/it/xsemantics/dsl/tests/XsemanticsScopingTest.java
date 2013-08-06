package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsScopingTest extends XsemanticsBaseTest {
  @Test
  public void testScopingForParameters() {
    CharSequence _testScopingForParameters = this.testFiles.testScopingForParameters();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testScopingForParameters);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _head_1 = IterableExtensions.<XExpression>head(_expressions);
    final XExpression leftOperandReferringToOutputParam = ((XBinaryOperation) _head_1).getLeftOperand();
    JvmIdentifiableElement _feature = ((XMemberFeatureCall) leftOperandReferringToOutputParam).getFeature();
    InputOutput.<JvmIdentifiableElement>println(_feature);
    EList<XExpression> _expressions_1 = xBlockExpression.getExpressions();
    XExpression _head_2 = IterableExtensions.<XExpression>head(_expressions_1);
    final XExpression leftOperandReferringToInputParam = ((XBinaryOperation) _head_2).getLeftOperand();
    JvmIdentifiableElement _feature_1 = ((XMemberFeatureCall) leftOperandReferringToInputParam).getFeature();
    InputOutput.<JvmIdentifiableElement>println(_feature_1);
  }
}

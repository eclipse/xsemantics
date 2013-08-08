package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsScopingTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testScopingForParameters() {
    CharSequence _testScopingForParameters = this.testFiles.testScopingForParameters();
    final XsemanticsSystem system = this.parse(_testScopingForParameters);
    this._validationTestHelper.assertNoErrors(system);
    EList<Rule> _rules = system.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _head_1 = IterableExtensions.<XExpression>head(_expressions);
    final XExpression leftOperandReferringToOutputParam = ((XBinaryOperation) _head_1).getLeftOperand();
    EList<XExpression> _expressions_1 = xBlockExpression.getExpressions();
    XExpression _get = _expressions_1.get(1);
    final XExpression leftOperandReferringToInputParam = ((XBinaryOperation) _get).getLeftOperand();
    JvmIdentifiableElement _feature = ((XMemberFeatureCall) leftOperandReferringToInputParam).getFeature();
    String _identifier = _feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.EObject.eContainer()", _identifier);
    JvmIdentifiableElement _feature_1 = ((XMemberFeatureCall) leftOperandReferringToOutputParam).getFeature();
    String _identifier_1 = _feature_1.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.ENamedElement.getName()", _identifier_1);
  }
  
  @Test
  public void testScopingForVariableAsOutputParam() {
    CharSequence _testScopingForVariableDeclarationAsOutputArgument = this.testFiles.testScopingForVariableDeclarationAsOutputArgument();
    final XsemanticsSystem system = this.parse(_testScopingForVariableDeclarationAsOutputArgument);
    EList<Rule> _rules = system.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _get = _expressions.get(1);
    final XExpression leftOperandReferringToOutputParam = ((XBinaryOperation) _get).getLeftOperand();
    JvmIdentifiableElement _feature = ((XMemberFeatureCall) leftOperandReferringToOutputParam).getFeature();
    String _identifier = _feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.ENamedElement.getName()", _identifier);
  }
}

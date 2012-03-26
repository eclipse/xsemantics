package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.typing.TupleType;
import it.xsemantics.dsl.typing.XsemanticsSubtyping;
import it.xsemantics.dsl.typing.XsemanticsTypingSystem;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsFactory;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import junit.framework.Assert;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XsemanticsSubtypingTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsTypingSystem typingSystem;
  
  @Inject
  protected TypeReferences typeReferences;
  
  @Inject
  protected XsemanticsSubtyping subtyping;
  
  @Test
  public void testEObjectSubtyping() {
    this.assertSubtyping(org.eclipse.emf.common.notify.Notifier.class, org.eclipse.emf.ecore.EObject.class);
  }
  
  @Test
  public void testObjectSubtyping() {
    this.assertSubtyping(java.lang.Object.class, org.eclipse.emf.ecore.EObject.class);
  }
  
  @Test
  public void testNotEquals() {
    this.assertEquals(org.eclipse.emf.common.notify.Notifier.class, org.eclipse.emf.ecore.EObject.class, false);
  }
  
  @Test
  public void testEquals() {
    this.assertEquals(org.eclipse.emf.ecore.EObject.class, org.eclipse.emf.ecore.EObject.class, true);
  }
  
  @Test
  public void testIsEObject() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(it.xsemantics.dsl.xsemantics.XsemanticsSystem.class, ts);
      boolean _isEObject = this.subtyping.isEObject(_typeForName, ts);
      Assert.assertTrue(_isEObject);
  }
  
  @Test
  public void testIsEObjectFails() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(java.lang.String.class, ts);
      boolean _isEObject = this.subtyping.isEObject(_typeForName, ts);
      Assert.assertFalse(_isEObject);
  }
  
  @Test
  public void testIsEStructuralFeature() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EAttribute.class, ts);
      boolean _isEStructuralFeature = this.subtyping.isEStructuralFeature(_typeForName, ts);
      Assert.assertTrue(_isEStructuralFeature);
  }
  
  @Test
  public void testIsEStructuralFeatureFails() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(it.xsemantics.dsl.xsemantics.XsemanticsSystem.class, ts);
      boolean _isEStructuralFeature = this.subtyping.isEStructuralFeature(_typeForName, ts);
      Assert.assertFalse(_isEStructuralFeature);
  }
  
  @Test
  public void testTupleTypeDifferentSize() {
      TupleType _tupleType = new TupleType();
      final TupleType tupleType = _tupleType;
      JvmTypeReference _typeForName = this.typeForName(org.eclipse.emf.ecore.EAttribute.class);
      tupleType.add(_typeForName);
      ArrayList<JudgmentParameter> _arrayList = new ArrayList<JudgmentParameter>();
      boolean _isConformant = this.subtyping.isConformant(_arrayList, tupleType);
      Assert.assertFalse(_isConformant);
  }
  
  @Test
  public void testTupleTypeTrue() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EClass.class, ts);
      TupleType _tupleType = this.tupleType(_typeForName, _typeForName_1);
      final TupleType tupleType = _tupleType;
      JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(org.eclipse.emf.common.notify.Notifier.class, ts);
      ArrayList<JudgmentParameter> _judgmentParameters = this.judgmentParameters(_typeForName_2, _typeForName_3);
      final ArrayList<JudgmentParameter> judgmentParameters = _judgmentParameters;
      boolean _isConformant = this.subtyping.isConformant(judgmentParameters, tupleType);
      Assert.assertTrue(_isConformant);
  }
  
  @Test
  public void testTupleTypeFalse() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(java.lang.Object.class, ts);
      TupleType _tupleType = this.tupleType(_typeForName, _typeForName_1);
      final TupleType tupleType = _tupleType;
      JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(org.eclipse.emf.common.notify.Notifier.class, ts);
      ArrayList<JudgmentParameter> _judgmentParameters = this.judgmentParameters(_typeForName_2, _typeForName_3);
      final ArrayList<JudgmentParameter> judgmentParameters = _judgmentParameters;
      boolean _isConformant = this.subtyping.isConformant(judgmentParameters, tupleType);
      Assert.assertFalse(_isConformant);
  }
  
  @Test
  public void testTupleTypeNotEqualsDifferentSize() {
      TupleType _tupleType = new TupleType();
      final TupleType tupleType = _tupleType;
      JvmTypeReference _typeForName = this.typeForName(org.eclipse.emf.ecore.EAttribute.class);
      tupleType.add(_typeForName);
      TupleType _tupleType_1 = new TupleType();
      boolean _equals = this.subtyping.equals(_tupleType_1, tupleType);
      Assert.assertFalse(_equals);
  }
  
  @Test
  public void testTupleTypeEquals() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EClass.class, ts);
      TupleType _tupleType = this.tupleType(_typeForName, _typeForName_1);
      final TupleType tupleType1 = _tupleType;
      JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EClass.class, ts);
      TupleType _tupleType_1 = this.tupleType(_typeForName_2, _typeForName_3);
      final TupleType tupleType2 = _tupleType_1;
      boolean _equals = this.subtyping.equals(tupleType2, tupleType1);
      Assert.assertTrue(_equals);
  }
  
  @Test
  public void testTupleTypeNotEquals() {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EClass.class, ts);
      TupleType _tupleType = this.tupleType(_typeForName, _typeForName_1);
      final TupleType tupleType1 = _tupleType;
      JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(org.eclipse.emf.ecore.EObject.class, ts);
      JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(org.eclipse.emf.common.notify.Notifier.class, ts);
      TupleType _tupleType_1 = this.tupleType(_typeForName_2, _typeForName_3);
      final TupleType tupleType2 = _tupleType_1;
      boolean _equals = this.subtyping.equals(tupleType2, tupleType1);
      Assert.assertFalse(_equals);
  }
  
  public JvmTypeReference typeForName(final Class clazz) {
    JvmTypeReference _xblockexpression = null;
    {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(clazz, ts);
      _xblockexpression = (_typeForName);
    }
    return _xblockexpression;
  }
  
  public TupleType tupleType(final JvmTypeReference c1, final JvmTypeReference c2) {
    TupleType _xblockexpression = null;
    {
      TupleType _tupleType = new TupleType();
      final TupleType tupleType = _tupleType;
      tupleType.add(c1);
      tupleType.add(c2);
      _xblockexpression = (tupleType);
    }
    return _xblockexpression;
  }
  
  public ArrayList<JudgmentParameter> judgmentParameters(final JvmTypeReference c1, final JvmTypeReference c2) {
    ArrayList<JudgmentParameter> _xblockexpression = null;
    {
      ArrayList<JudgmentParameter> _arrayList = new ArrayList<JudgmentParameter>();
      final ArrayList<JudgmentParameter> tupleType = _arrayList;
      OutputParameter _judgmentParameter = this.judgmentParameter(c1);
      tupleType.add(_judgmentParameter);
      OutputParameter _judgmentParameter_1 = this.judgmentParameter(c2);
      tupleType.add(_judgmentParameter_1);
      _xblockexpression = (tupleType);
    }
    return _xblockexpression;
  }
  
  public OutputParameter judgmentParameter(final JvmTypeReference typeRef) {
    OutputParameter _xblockexpression = null;
    {
      OutputParameter _createOutputParameter = XsemanticsFactory.eINSTANCE.createOutputParameter();
      final OutputParameter judgmentParameter = _createOutputParameter;
      judgmentParameter.setJvmTypeReference(typeRef);
      _xblockexpression = (judgmentParameter);
    }
    return _xblockexpression;
  }
  
  public void assertSubtyping(final Class expected, final Class actual) {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(expected, ts);
      JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(actual, ts);
      boolean _isConformant = this.subtyping.isConformant(_typeForName, _typeForName_1);
      Assert.assertTrue(_isConformant);
  }
  
  public void assertEquals(final Class left, final Class right, final boolean expectedEquals) {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
      final XsemanticsSystem ts = _parse;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(left, ts);
      JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(right, ts);
      this.assertEquals(_typeForName, _typeForName_1, expectedEquals);
  }
  
  public void assertEquals(final JvmTypeReference left, final JvmTypeReference right, final boolean expectedEquals) {
    boolean _equals = this.subtyping.equals(left, right);
    boolean _operator_equals = BooleanExtensions.operator_equals(_equals, expectedEquals);
    Assert.assertTrue(_operator_equals);
  }
}

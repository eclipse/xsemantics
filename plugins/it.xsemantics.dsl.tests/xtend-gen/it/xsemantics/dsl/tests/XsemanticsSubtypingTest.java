package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.typing.TupleType;
import it.xsemantics.dsl.typing.XsemanticsSubtyping;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsFactory;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import junit.framework.Assert;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsSubtypingTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsTypeSystem typeSystem;
  
  @Inject
  protected TypeReferences typeReferences;
  
  @Inject
  protected XsemanticsSubtyping subtyping;
  
  @Test
  public void testEObjectSubtyping() {
    this.assertSubtyping(Notifier.class, EObject.class);
  }
  
  @Test
  public void testObjectSubtyping() {
    this.assertSubtyping(Object.class, EObject.class);
  }
  
  @Test
  public void testNotEquals() {
    this.assertEquals(Notifier.class, EObject.class, false);
  }
  
  @Test
  public void testEquals() {
    this.assertEquals(EObject.class, EObject.class, true);
  }
  
  @Test
  public void testIsEObject() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(XsemanticsSystem.class, ts);
    boolean _isEObject = this.subtyping.isEObject(_typeForName, ts);
    Assert.assertTrue(_isEObject);
  }
  
  @Test
  public void testIsEObjectFails() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(String.class, ts);
    boolean _isEObject = this.subtyping.isEObject(_typeForName, ts);
    Assert.assertFalse(_isEObject);
  }
  
  @Test
  public void testIsEStructuralFeature() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EAttribute.class, ts);
    boolean _isEStructuralFeature = this.subtyping.isEStructuralFeature(_typeForName, ts);
    Assert.assertTrue(_isEStructuralFeature);
  }
  
  @Test
  public void testIsEStructuralFeatureFails() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(XsemanticsSystem.class, ts);
    boolean _isEStructuralFeature = this.subtyping.isEStructuralFeature(_typeForName, ts);
    Assert.assertFalse(_isEStructuralFeature);
  }
  
  @Test
  public void testTupleTypeDifferentSize() {
    TupleType _tupleType = new TupleType();
    final TupleType tupleType = _tupleType;
    JvmTypeReference _typeForName = this.typeForName(EAttribute.class);
    tupleType.add(_typeForName);
    ArrayList<JudgmentParameter> _arrayList = new ArrayList<JudgmentParameter>();
    boolean _isConformant = this.subtyping.isConformant(_arrayList, tupleType);
    Assert.assertFalse(_isConformant);
  }
  
  @Test
  public void testTupleTypeTrue() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType = this.tupleType(_typeForName, _typeForName_1);
    JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(Notifier.class, ts);
    final ArrayList<JudgmentParameter> judgmentParameters = this.judgmentParameters(_typeForName_2, _typeForName_3);
    boolean _isConformant = this.subtyping.isConformant(judgmentParameters, tupleType);
    Assert.assertTrue(_isConformant);
  }
  
  @Test
  public void testTupleTypeFalse() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(Object.class, ts);
    final TupleType tupleType = this.tupleType(_typeForName, _typeForName_1);
    JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(Notifier.class, ts);
    final ArrayList<JudgmentParameter> judgmentParameters = this.judgmentParameters(_typeForName_2, _typeForName_3);
    boolean _isConformant = this.subtyping.isConformant(judgmentParameters, tupleType);
    Assert.assertFalse(_isConformant);
  }
  
  @Test
  public void testTupleTypeNotEqualsDifferentSize() {
    TupleType _tupleType = new TupleType();
    final TupleType tupleType = _tupleType;
    JvmTypeReference _typeForName = this.typeForName(EAttribute.class);
    tupleType.add(_typeForName);
    TupleType _tupleType_1 = new TupleType();
    boolean _equals = this.subtyping.equals(_tupleType_1, tupleType);
    Assert.assertFalse(_equals);
  }
  
  @Test
  public void testTupleTypeEquals() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType1 = this.tupleType(_typeForName, _typeForName_1);
    JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType2 = this.tupleType(_typeForName_2, _typeForName_3);
    boolean _equals = this.subtyping.equals(tupleType2, tupleType1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void testTupleTypeNotEquals() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType1 = this.tupleType(_typeForName, _typeForName_1);
    JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(Notifier.class, ts);
    final TupleType tupleType2 = this.tupleType(_typeForName_2, _typeForName_3);
    boolean _equals = this.subtyping.equals(tupleType2, tupleType1);
    Assert.assertFalse(_equals);
  }
  
  public JvmTypeReference typeForName(final Class clazz) {
    JvmTypeReference _xblockexpression = null;
    {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
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
      final OutputParameter judgmentParameter = XsemanticsFactory.eINSTANCE.createOutputParameter();
      judgmentParameter.setJvmTypeReference(typeRef);
      _xblockexpression = (judgmentParameter);
    }
    return _xblockexpression;
  }
  
  public void assertSubtyping(final Class expected, final Class actual) {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(expected, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(actual, ts);
    boolean _isConformant = this.subtyping.isConformant(_typeForName, _typeForName_1);
    Assert.assertTrue(_isConformant);
  }
  
  public void assertEquals(final Class left, final Class right, final boolean expectedEquals) {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(left, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(right, ts);
    this.assertEquals(_typeForName, _typeForName_1, expectedEquals);
  }
  
  public void assertEquals(final JvmTypeReference left, final JvmTypeReference right, final boolean expectedEquals) {
    boolean _equals = this.subtyping.equals(left, right);
    boolean _equals_1 = (_equals == expectedEquals);
    Assert.assertTrue(_equals_1);
  }
}

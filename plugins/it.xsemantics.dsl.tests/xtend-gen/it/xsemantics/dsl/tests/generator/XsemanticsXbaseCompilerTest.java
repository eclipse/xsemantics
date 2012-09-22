package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsXbaseCompilerTest extends XsemanticsGeneratorBaseTest {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsXbaseCompiler xbaseCompiler;
  
  @Test
  public void testXbaseCompilationOfXBlock() {
    CharSequence _testRuleWithBlockExpressionInConclusion = this.testFiles.testRuleWithBlockExpressionInConclusion();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EClass _xblockexpression = null;");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final EClass result = EcoreFactory.eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("result.setName(\"MyEClass\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_xblockexpression = (result);");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfRightExpression(_testRuleWithBlockExpressionInConclusion, 
      "_xblockexpression", _builder);
  }
  
  @Test
  public void testXbaseCompilationOfXExpression() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EObject _createEObject = EcoreFactory.eINSTANCE.createEObject();");
    this.checkCompilationOfRightExpression(_testRuleWithExpressionInConclusion, 
      "_createEObject", _builder);
  }
  
  @Test
  public void testRuleWithExpressionInConclusionWithParamNameAsXbaseGeneratedVariable() {
    CharSequence _testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable = this.testFiles.testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EObject _createEObject = EcoreFactory.eINSTANCE.createEObject();");
    this.checkCompilationOfRightExpression(_testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable, 
      "_createEObject", _builder);
  }
  
  @Test
  public void testWithConfiguredAppendable() {
    final FakeTreeAppendable appendable = this.createAppendable();
    String _string = new String();
    appendable.declareVariable(_string, "_createEObject");
    CharSequence _testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable = this.testFiles.testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EObject _createEObject_1 = EcoreFactory.eINSTANCE.createEObject();");
    this.checkCompilationOfRightExpression(_testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable, 
      "_createEObject_1", _builder, appendable);
  }
  
  @Test
  public void testRuleInvokingAnotherRule() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _firstUpper = StringExtensions.toFirstUpper(\"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _plus = (_string + _firstUpper);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals = Objects.equal(\"foo\", _plus);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() + \"bar\".toFirstUpper */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() + \\\"bar\\\".toFirstUpper\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typeInternal(G, _trace_, _eClass, eClass);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- eClass : object.eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass_1 = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typeInternal(G, _trace_, eClass, _eClass_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final EClass eC = EcoreFactory.eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("eC.setName(\"MyEClass\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name = eC.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals_1 = Objects.equal(_name, \"MyEClass2\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _not = (!_equals_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* !(eC.name == \'MyEClass2\') */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_not) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"!(eC.name == \\\'MyEClass2\\\')\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name_1 = eC.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("int _length = _name_1.length();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _lessThan = (_length < 10);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eC.name.length < 10 */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_lessThan) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eC.name.length < 10\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals_2 = Objects.equal(eClass, eC);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass == eC */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!Boolean.valueOf(_equals_2)) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass == eC\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfPremises(_testRuleInvokingAnotherRule, _builder);
  }
  
  @Test
  public void testRuleInvokingAnotherRuleWithOutputParams() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- eClass : object : feat */");
    _builder.newLine();
    _builder.append("Result<EObject> result = typeInternal(G, _trace_, eClass, feat);");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("object = (EObject) result.getFirst();");
    _builder.newLine();
    this.checkCompilationOfPremises(_testRuleWithOutputParams, _builder);
  }
  
  @Test
  public void testRuleInvokingAnotherRuleWithCollectionOutputParam() {
    CharSequence _testRuleWithCollectionOutputParam = this.testFiles.testRuleWithCollectionOutputParam();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- eClass : features */");
    _builder.newLine();
    _builder.append("Result<List<EStructuralFeature>> result = typeInternal(G, _trace_, eClass);");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getFirst(), List.class);");
    _builder.newLine();
    _builder.append("features = (List<EStructuralFeature>) result.getFirst();");
    _builder.newLine();
    this.checkCompilationOfPremises(_testRuleWithCollectionOutputParam, _builder);
  }
  
  @Test
  public void testRuleInvokingAnotherRuleWithTwoOutputParams() {
    CharSequence _testRuleWithTwoOutputParams = this.testFiles.testRuleWithTwoOutputParams();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G ||- eClass : object : feat */");
    _builder.newLine();
    _builder.append("Result2<EObject,EStructuralFeature> result = type2Internal(G, _trace_, eClass);");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("object = (EObject) result.getFirst();");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getSecond(), EStructuralFeature.class);");
    _builder.newLine();
    _builder.append("feat = (EStructuralFeature) result.getSecond();");
    _builder.newLine();
    this.checkCompilationOfPremises(_testRuleWithTwoOutputParams, _builder);
  }
  
  @Test
  public void testRuleInvokingAnotherRuleWithThreeOutputParams() {
    CharSequence _testRuleWith3OutputParams = this.testFiles.testRuleWith3OutputParams();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- eClass : object : feat : s */");
    _builder.newLine();
    _builder.append("Result3<EObject,EStructuralFeature,String> result = typeInternal(G, _trace_, eClass);");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("object = (EObject) result.getFirst();");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getSecond(), EStructuralFeature.class);");
    _builder.newLine();
    _builder.append("feat = (EStructuralFeature) result.getSecond();");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getThird(), String.class);");
    _builder.newLine();
    _builder.append("s = (String) result.getThird();");
    _builder.newLine();
    this.checkCompilationOfPremises(_testRuleWith3OutputParams, _builder);
  }
  
  @Test
  public void testRuleWithOutputParamAsLocalVariable() {
    CharSequence _testRuleWithOutputArgAsLocalVariable = this.testFiles.testRuleWithOutputArgAsLocalVariable();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EObject objectResult = null;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- eClass : objectResult : feat */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Result<EObject> result = typeInternal(G, _trace_, eClass, feat);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("objectResult = (EObject) result.getFirst();");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EObject myObject = null;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("myObject = objectResult;");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfPremises(_testRuleWithOutputArgAsLocalVariable, _builder);
  }
  
  @Test
  public void testRuleWithOutputParamsAndExplicitAssignment() {
    CharSequence _testRuleWithOutputParamsAndExplicitAssignment = this.testFiles.testRuleWithOutputParamsAndExplicitAssignment();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EObject objectResult = null;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- eClass : object : feat */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Result<EObject> result = typeInternal(G, _trace_, eClass, feat);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("object = (EObject) result.getFirst();");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("object = objectResult;");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfPremises(_testRuleWithOutputParamsAndExplicitAssignment, _builder);
  }
  
  @Test
  public void testRuleOnlyInvokingOtherRules() {
    CharSequence _testRuleOnlyInvokingRules = this.testFiles.testRuleOnlyInvokingRules();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typeInternal(G, _trace_, _eClass, eClass);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- eClass : object.eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass_1 = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typeInternal(G, _trace_, eClass, _eClass_1);");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfPremises(_testRuleOnlyInvokingRules, _builder);
  }
  
  @Test
  public void testCheckRule() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass result = null;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* empty |- obj : result */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Result<EClass> result_1 = typeInternal(emptyEnvironment(), _trace_, obj);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("checkAssignableTo(result_1.getFirst(), EClass.class);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("result = (EClass) result_1.getFirst();");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfPremisesOfCheckRule(_testCheckRule, _builder);
  }
  
  @Test
  public void testRuleInvocation() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("typeInternal(G, _trace_, _eClass, eClass);");
    this.checkCompilationOfRuleInvocation(_testRuleInvokingAnotherRule, 0, _builder);
  }
  
  @Test
  public void testRuleInvocation2() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- eClass : object.eClass */");
    _builder.newLine();
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("typeInternal(G, _trace_, eClass, _eClass);");
    this.checkCompilationOfRuleInvocation(_testRuleInvokingAnotherRule, 1, _builder);
  }
  
  @Test
  public void testOrExpression() {
    CharSequence _testOrExpression = this.testFiles.testOrExpression();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* eClass.name == \'foo\' or object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name = eClass.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals = Objects.equal(_name, \"foo\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.name == \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name_1 = _eClass.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals_1 = Objects.equal(_name_1, \"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals_1) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfOr(_testOrExpression, 0, _builder);
  }
  
  @Test
  public void testOrExpression2() {
    CharSequence _testOrExpression2 = this.testFiles.testOrExpression2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* eClass.name == \'foo\' or object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name = eClass.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals = Objects.equal(_name, \"foo\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.name == \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name_1 = _eClass.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals_1 = Objects.equal(_name_1, \"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals_1) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfOr(_testOrExpression2, 0, _builder);
  }
  
  @Test
  public void testOrExpressionWithBlocks() {
    CharSequence _testOrExpressionWithBlocks = this.testFiles.testOrExpressionWithBlocks();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* {eClass.name == \'foo\' eClass.name == \'foo\'} or {object.eClass.name == \'bar\' object.eClass.name == \'bar\'} */");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _xblockexpression = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _name = eClass.getName();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _equals = Objects.equal(_name, \"foo\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_equals) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.name == \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _name_1 = eClass.getName();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _equals_1 = Objects.equal(_name_1, \"foo\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_equals_1) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.name == \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_xblockexpression = (_equals_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _name_2 = _eClass.getName();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _equals_2 = Objects.equal(_name_2, \"bar\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_equals_2) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EClass _eClass_1 = object.eClass();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _name_3 = _eClass_1.getName();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _equals_3 = Objects.equal(_name_3, \"bar\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_equals_3) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfOr(_testOrExpressionWithBlocks, 0, _builder);
  }
  
  @Test
  public void testOrExpressionWithManyBranches() {
    CharSequence _testOrExpressionWithManyBranches = this.testFiles.testOrExpressionWithManyBranches();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- object.eClass : eClass or G |- object.eClass : eClass or {G |- object.eClass : eClass object.eClass.name == \'bar\'} or object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typeInternal(G, _trace_, _eClass, eClass);");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- object.eClass : eClass or {G |- object.eClass : eClass object.eClass.name == \'bar\'} or object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EClass _eClass_1 = object.eClass();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("typeInternal(G, _trace_, _eClass_1, eClass);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (Exception e_1) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* {G |- object.eClass : eClass object.eClass.name == \'bar\'} or object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("boolean _xblockexpression = false;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/* G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("EClass _eClass_2 = object.eClass();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("typeInternal(G, _trace_, _eClass_2, eClass);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("EClass _eClass_3 = object.eClass();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String _name = _eClass_3.getName();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("boolean _equals = Objects.equal(_name, \"bar\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!_equals) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_xblockexpression = (_equals);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception e_2) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("EClass _eClass_4 = object.eClass();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("String _name_1 = _eClass_4.getName();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("boolean _equals_1 = Objects.equal(_name_1, \"bar\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (!_equals_1) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfOr(_testOrExpressionWithManyBranches, 0, _builder);
  }
  
  @Test
  public void testRuleInvocationResultVariable() {
    final FakeTreeAppendable appendable = this.createAppendable();
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    this.checkRuleInvocationVariable(_testRuleInvokingAnotherRule, 0, appendable, "result");
    CharSequence _testRuleInvokingAnotherRule_1 = this.testFiles.testRuleInvokingAnotherRule();
    this.checkRuleInvocationVariable(_testRuleInvokingAnotherRule_1, 1, appendable, "result_1");
  }
  
  @Test
  public void testFeatureCallExpressions() {
    CharSequence _testRuleWithFeatureCalls = this.testFiles.testRuleWithFeatureCalls();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _or = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals = Objects.equal(\"foo\", _string);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (_equals) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_or = true;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _string_1 = new String();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _equals_1 = Objects.equal(\"bar\", _string_1);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_or = (_equals || _equals_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() || \'bar\' == new String() */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_or) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() || \\\'bar\\\' == new String()\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _and = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string_2 = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals_2 = Objects.equal(\"foo\", _string_2);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals_2) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_and = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _string_3 = new String();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _equals_3 = Objects.equal(\"bar\", _string_3);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_and = (_equals_2 && _equals_3);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() && \'bar\' == new String() */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_and) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() && \\\'bar\\\' == new String()\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string_4 = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _firstUpper = StringExtensions.toFirstUpper(\"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _plus = (_string_4 + _firstUpper);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _equals_4 = Objects.equal(\"foo\", _plus);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() + \'bar\'.toFirstUpper */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_equals_4) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() + \\\'bar\\\'.toFirstUpper\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string_5 = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _firstUpper_1 = StringExtensions.toFirstUpper(\"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _plus_1 = (_string_5 + _firstUpper_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _notEquals = (!Objects.equal(\"foo\", _plus_1));");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' != new String() + \'bar\'.toFirstUpper */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_notEquals) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' != new String() + \\\'bar\\\'.toFirstUpper\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string_6 = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _firstUpper_2 = StringExtensions.toFirstUpper(\"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final String temp = (_string_6 + _firstUpper_2);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _contains = \"foo\".contains(\"f\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\'.contains(\'f\') */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_contains) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\'.contains(\\\'f\\\')\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"foo\".concat(\"f\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _contains_1 = \"foo\".contains(\"f\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _not = (!_contains_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* !(\'foo\'.contains(\'f\')) */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_not) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"!(\\\'foo\\\'.contains(\\\'f\\\'))\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final EClass eC = EcoreFactory.eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfAllPremises(_testRuleWithFeatureCalls, _builder);
  }
  
  @Test
  public void testThrowRuleFailedException() {
    final FakeTreeAppendable a = this.createAppendable();
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(0);
    this.xbaseCompiler.throwNewRuleFailedException(_xAbstractFeatureCall, a);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() || \\\'bar\\\' == new String()\");");
    String _string = a.toString();
    this.assertEqualsStrings(_builder, _string);
  }
  
  @Test
  public void testCompilationOfEnvironmentAccess() {
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* env(G, eClass.name, EClass) */");
    _builder.newLine();
    _builder.append("String _name = eClass.getName();");
    _builder.newLine();
    _builder.append("environmentAccess(G, _name, EClass.class);");
    this.checkCompilationOfXExpression(_testWithEnvironmentAccess, 3, _builder);
  }
  
  @Test
  public void testCompilationOfEnvironmentAccessAsExpression() {
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* env(G, eClass.name, EClass) */");
    _builder.newLine();
    _builder.append("String _name = eClass.getName();");
    _builder.newLine();
    _builder.append("EClass _environmentaccess = environmentAccess(G, _name, EClass.class);");
    _builder.newLine();
    _builder.append("String _instanceClassName = _environmentaccess.getInstanceClassName();");
    _builder.newLine();
    _builder.append("Objects.equal(\"foo\", _instanceClassName);");
    this.checkCompilationOfXExpression(_testWithEnvironmentAccess, 4, _builder);
  }
  
  @Test
  public void testEmptyEnvironmentSpecification() {
    CharSequence _testEmptyEnvironment = this.testFiles.testEmptyEnvironment();
    this.checkCompilationOfEnvironmentSpecfication(_testEmptyEnvironment, 
      "emptyEnvironment()");
  }
  
  @Test
  public void testEnvironmentReference() {
    CharSequence _testRuleOnlyInvokingRules = this.testFiles.testRuleOnlyInvokingRules();
    this.checkCompilationOfEnvironmentSpecfication(_testRuleOnlyInvokingRules, 
      "G");
  }
  
  @Test
  public void testSingleEnvironmentMapping() {
    CharSequence _testSingleEnvironmentMapping = this.testFiles.testSingleEnvironmentMapping();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("environmentEntry(\"this\", object)");
    this.checkCompilationOfEnvironmentSpecfication(_testSingleEnvironmentMapping, _builder);
  }
  
  @Test
  public void testEnvironmentComposition() {
    CharSequence _testEnvironmentCompositionWithMapping = this.testFiles.testEnvironmentCompositionWithMapping();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("environmentComposition(");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("G, environmentEntry(\"this\", object)");
    _builder.newLine();
    _builder.append(")");
    this.checkCompilationOfEnvironmentSpecfication(_testEnvironmentCompositionWithMapping, _builder);
  }
  
  @Test
  public void testRuleInvocationEnvironmentComposition() {
    CharSequence _testEnvironmentComposition2 = this.testFiles.testEnvironmentComposition2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* empty, G, empty, G |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("typeInternal(environmentComposition(");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("emptyEnvironment(), environmentComposition(");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("G, environmentComposition(");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("emptyEnvironment(), G");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("), _trace_, _eClass, eClass);");
    this.checkCompilationOfRuleInvocation(_testEnvironmentComposition2, 0, _builder);
  }
  
  @Test
  public void testRuleInvocationEnvironmentComposition2() {
    CharSequence _testEnvironmentMapping2 = this.testFiles.testEnvironmentMapping2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G, \'this\' <- object, object <- EcoreFactory::eINSTANCE.createEClass() |- object.eClass : eClass */");
    _builder.newLine();
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("typeInternal(environmentComposition(");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("G, environmentComposition(");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("environmentEntry(\"this\", object), environmentEntry(object, _createEClass)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("), _trace_, _eClass, eClass);");
    this.checkCompilationOfRuleInvocation(_testEnvironmentMapping2, 0, _builder);
  }
  
  @Test
  public void testForFail() {
    CharSequence _testForFail = this.testFiles.testForFail();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* empty |- obj : eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, obj);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("checkAssignableTo(result.getFirst(), EClass.class);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("eClass = (EClass) result.getFirst();");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* fail */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("throwForExplicitFail();");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfAllPremises(_testForFail, _builder);
  }
  
  @Test
  public void testForFailWithErrorSpecification() {
    CharSequence _testForFailWithErrorSpecification = this.testFiles.testForFailWithErrorSpecification();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* empty |- obj : eClass */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, obj);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("checkAssignableTo(result.getFirst(), EClass.class);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("eClass = (EClass) result.getFirst();");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* fail error \"this is the error\" source obj */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String error = \"this is the error\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EObject source = obj;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("throwForExplicitFail(error, new ErrorInformation(source, null));");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfAllPremises(_testForFailWithErrorSpecification, _builder);
  }
  
  @Test
  public void testForClosures() {
    CharSequence _testForClosures = this.testFiles.testForClosures();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("public Boolean apply(final EStructuralFeature it) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String _name = it.getName();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("boolean _notEquals = (!Objects.equal(_name, \"foo\"));");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Boolean.valueOf(_notEquals);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _forall = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures, _function);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.EStructuralFeatures.forall [ it.name != \'foo\' ] */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_forall) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.EStructuralFeatures.forall [ it.name != \\\'foo\\\' ]\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EList<EStructuralFeature> _eStructuralFeatures_1 = eClass.getEStructuralFeatures();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final Function1<EStructuralFeature,Boolean> _function_1 = new Function1<EStructuralFeature,Boolean>() {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("public Boolean apply(final EStructuralFeature it) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String _name = it.getName();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("boolean _notEquals = (!Objects.equal(_name, \"foo\"));");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/* it.name != \'foo\' */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!Boolean.valueOf(_notEquals)) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("sneakyThrowRuleFailedException(\"it.name != \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Boolean.valueOf(_notEquals);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _forall_1 = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures_1, _function_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.EStructuralFeatures.forall [ { it.name != \'foo\' } ] */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_forall_1) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.EStructuralFeatures.forall [ { it.name != \\\'foo\\\' } ]\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EList<EStructuralFeature> _eStructuralFeatures_2 = eClass.getEStructuralFeatures();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final Function1<EStructuralFeature,Boolean> _function_2 = new Function1<EStructuralFeature,Boolean>() {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("public Boolean apply(final EStructuralFeature it) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/* G ||- it */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("uselessInternal(G, _trace_, it);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _forall_2 = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures_2, _function_2);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.EStructuralFeatures.forall [ G ||- it ] */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_forall_2) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.EStructuralFeatures.forall [ G ||- it ]\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EList<EStructuralFeature> _eStructuralFeatures_3 = eClass.getEStructuralFeatures();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EStructuralFeature _get = _eStructuralFeatures_3.get(0);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _name = _get.getName();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _notEquals = (!Objects.equal(_name, \"foo\"));");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.EStructuralFeatures.get(0).name != \'foo\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!Boolean.valueOf(_notEquals)) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.EStructuralFeatures.get(0).name != \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfAllPremises(_testForClosures, _builder);
  }
  
  @Test
  public void testForClosureWithExpressionWithNoSideEffect() {
    CharSequence _testForClosureWithExpressionWithNoSideEffect = this.testFiles.testForClosureWithExpressionWithNoSideEffect();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();");
    _builder.newLine();
    _builder.append("final Procedure1<EStructuralFeature> _function = new Procedure1<EStructuralFeature>() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void apply(final EStructuralFeature it) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("String _name = it.getName();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("boolean _notEquals = (!Objects.equal(_name, \"foo\"));");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("IterableExtensions.<EStructuralFeature>forEach(_eStructuralFeatures, _function);");
    this.checkCompilationOfAllPremises(_testForClosureWithExpressionWithNoSideEffect, _builder);
  }
  
  @Test
  public void testForScopeOfThisInRule() {
    CharSequence _testForScopeOfThisInRule = this.testFiles.testForScopeOfThisInRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EClass _eClass = obj.eClass();");
    _builder.newLine();
    _builder.append("EClass _clone = this.<EClass>clone(_eClass);");
    _builder.newLine();
    _builder.append("eClass = _clone;");
    this.checkCompilationOfAllPremises(_testForScopeOfThisInRule, _builder);
  }
  
  @Test
  public void testForScopeOfThisInClosure() {
    CharSequence _testForScopeOfThisInClosure = this.testFiles.testForScopeOfThisInClosure();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EList<EStructuralFeature> _eAllStructuralFeatures = eClass.getEAllStructuralFeatures();");
    _builder.newLine();
    _builder.append("final Procedure1<EStructuralFeature> _function = new Procedure1<EStructuralFeature>() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void apply(final EStructuralFeature it) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("EClass _eClass = obj.eClass();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("final EClass e = TypeSystem.this.<EClass>clone(_eClass);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("InputOutput.<EClass>println(e);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("IterableExtensions.<EStructuralFeature>forEach(_eAllStructuralFeatures, _function);");
    this.checkCompilationOfAllPremises(_testForScopeOfThisInClosure, _builder);
  }
  
  @Test
  public void testForScopeOfThisInCheckRule() {
    CharSequence _testForScopeOfThisInCheckRule = this.testFiles.testForScopeOfThisInCheckRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EClass _eClass = obj.eClass();");
    _builder.newLine();
    _builder.append("final EClass eClass = this.<EClass>clone(_eClass);");
    this.checkCompilationOfAllPremisesOfCheckRule(_testForScopeOfThisInCheckRule, _builder);
  }
  
  @Test
  public void testRuleInvocationWithVarDeclarationAsOutputArg() {
    CharSequence _testVariableDeclarationAsOutputArgument = this.testFiles.testVariableDeclarationAsOutputArgument();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* G |- o : var EClass e */");
    _builder.newLine();
    _builder.append("EClass e = null;");
    _builder.newLine();
    _builder.append("Result<EClass> result = typeInternal(G, _trace_, o);");
    _builder.newLine();
    _builder.append("checkAssignableTo(result.getFirst(), EClass.class);");
    _builder.newLine();
    _builder.append("e = (EClass) result.getFirst();");
    _builder.newLine();
    this.checkCompilationOfRuleInvocation(_testVariableDeclarationAsOutputArgument, 0, _builder);
  }
  
  @Test
  public void testRuleInvocationWithDuplicateVarDeclarationAsOutputArg() {
    CharSequence _testDuplicateVariableDeclarationAsOutputArgument = this.testFiles.testDuplicateVariableDeclarationAsOutputArgument();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* var temp = c or { G |- o : var EClass temp } */");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass temp = c;");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* G |- o : var EClass temp */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass temp_1 = null;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Result<EClass> result = typeInternal(G, _trace_, o);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("checkAssignableTo(result.getFirst(), EClass.class);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("temp_1 = (EClass) result.getFirst();");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfPremises(_testDuplicateVariableDeclarationAsOutputArgument, _builder);
  }
  
  public void checkCompilationOfRightExpression(final CharSequence inputCode, final String expectedExpName, final CharSequence expected) {
    FakeTreeAppendable _createAppendable = this.createAppendable();
    this.checkCompilationOfRightExpression(inputCode, expectedExpName, expected, _createAppendable);
  }
  
  public void checkCompilationOfRightExpression(final CharSequence inputCode, final String expectedExpName, final CharSequence expected, final ITreeAppendable appendable) {
    Rule _firstRule = this.getFirstRule(inputCode);
    RuleConclusion _conclusion = _firstRule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    RuleConclusionElement _get = _conclusionElements.get(1);
    ExpressionInConclusion _ruleExpression = this.ruleExpression(_get);
    final XExpression xexp = _ruleExpression.getExpression();
    this.xbaseCompiler.toJavaStatement(xexp, appendable, true);
    String _string = expected.toString();
    String _string_1 = appendable.toString();
    Assert.assertEquals(_string, _string_1);
    final String expName = appendable.getName(xexp);
    Assert.assertEquals(expectedExpName, expName);
  }
  
  public void checkCompilationOfPremises(final CharSequence inputCode, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    final XBlockExpression xexp = this.getRulePremisesAsBlock(rule);
    final ITreeAppendable appendable = this.createAppendable(rule);
    this.xbaseCompiler.toJavaStatement(xexp, appendable, false);
    String _string = expected.toString();
    String _string_1 = appendable.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfPremisesOfCheckRule(final CharSequence inputCode, final CharSequence expected) {
    CheckRule _firstCheckRule = this.getFirstCheckRule(inputCode);
    final XBlockExpression xexp = this.getRulePremisesAsBlock(_firstCheckRule);
    final FakeTreeAppendable appendable = this.createAppendable();
    this.xbaseCompiler.toJavaStatement(xexp, appendable, false);
    String _string = expected.toString();
    String _string_1 = appendable.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfRuleInvocation(final CharSequence inputCode, final int index, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(rule);
    final RuleInvocation xexp = _ruleInvocations.get(index);
    final ITreeAppendable result = this.createAppendable(rule);
    this.xbaseCompiler.toJavaStatement(xexp, result, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfOr(final CharSequence inputCode, final int index, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    List<OrExpression> _ors = this._xsemanticsUtils.getOrs(rule);
    final OrExpression xexp = _ors.get(index);
    final ITreeAppendable result = this.createAppendable(rule);
    this.xbaseCompiler.toJavaStatement(xexp, result, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkRuleInvocationVariable(final CharSequence inputCode, final int index, final ITreeAppendable appendable, final String expectedVariableName) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(inputCode);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_parseAndAssertNoError);
    final RuleInvocation xexp = _ruleInvocations.get(index);
    final String variable = this.xbaseCompiler.declareResultVariable(xexp, appendable);
    Assert.assertEquals(expectedVariableName, variable);
  }
  
  public void checkCompilationOfAllPremises(final CharSequence inputCode, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    final TreeAppendable result = this.createJvmModelGeneratorConfiguredAppendable(rule);
    final XBlockExpression xexp = this.getRulePremisesAsBlock(rule);
    this.xbaseCompiler.toJavaStatement(xexp, result, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfAllPremisesOfCheckRule(final CharSequence inputCode, final CharSequence expected) {
    final CheckRule rule = this.getFirstCheckRule(inputCode);
    final ITreeAppendable result = this.createAppendable(rule);
    final XBlockExpression xexp = this.getRulePremisesAsBlock(rule);
    this.xbaseCompiler.toJavaStatement(xexp, result, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfXExpression(final CharSequence inputCode, final int index, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    EList<XExpression> _rulePremises = this.getRulePremises(rule);
    final XExpression xexp = _rulePremises.get(index);
    final ITreeAppendable result = this.createAppendable(rule);
    this.xbaseCompiler.toJavaStatement(xexp, result, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfEnvironmentSpecfication(final CharSequence inputCode, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    final EnvironmentSpecification xexp = this.getEnvironmentSpecificationOfRuleInvocation(rule);
    final ITreeAppendable result = this.createAppendable(rule);
    this.xbaseCompiler.generateEnvironmentSpecificationAsExpression(xexp, result);
    this.assertEqualsStrings(expected, result);
  }
}

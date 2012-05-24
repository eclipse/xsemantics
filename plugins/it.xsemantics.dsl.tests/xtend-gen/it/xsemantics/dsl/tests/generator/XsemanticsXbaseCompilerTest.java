package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsXbaseCompilerTest extends XsemanticsGeneratorBaseTest {
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
    _builder.append("if (!_equals_2) {");
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
    _builder.append("Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);");
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
    final ITreeAppendable result = this.xbaseCompiler.compile(xexp, appendable, true);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
    final String expName = result.getName(xexp);
    Assert.assertEquals(expectedExpName, expName);
  }
  
  public void checkCompilationOfPremises(final CharSequence inputCode, final CharSequence expected) {
    final Rule rule = this.getFirstRule(inputCode);
    final XBlockExpression xexp = this.getRulePremisesAsBlock(rule);
    final ITreeAppendable appendable = this.createAppendable(rule);
    final ITreeAppendable result = this.xbaseCompiler.compile(xexp, appendable, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfPremisesOfCheckRule(final CharSequence inputCode, final CharSequence expected) {
    CheckRule _firstCheckRule = this.getFirstCheckRule(inputCode);
    final XBlockExpression xexp = this.getRulePremisesAsBlock(_firstCheckRule);
    FakeTreeAppendable _createAppendable = this.createAppendable();
    final ITreeAppendable result = this.xbaseCompiler.compile(xexp, _createAppendable, false);
    String _string = expected.toString();
    String _string_1 = result.toString();
    Assert.assertEquals(_string, _string_1);
  }
}

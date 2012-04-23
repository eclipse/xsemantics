package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.XsemanticsXExpressionCompiler;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.Rule;
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
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XsemanticsXExpressionCompilerTest extends XsemanticsGeneratorBaseTest {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsXExpressionCompiler xbaseCompiler;
  
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
    _builder.append("boolean _operator_equals = ObjectExtensions.operator_equals(_name, \"foo\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_equals) {");
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
    _builder.append("boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, \"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_equals_1) {");
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
    _builder.append("boolean _operator_equals = ObjectExtensions.operator_equals(_name, \"foo\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_equals) {");
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
    _builder.append("boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, \"bar\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_equals_1) {");
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
    _builder.append("boolean _operator_equals = ObjectExtensions.operator_equals(_name, \"foo\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_operator_equals) {");
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
    _builder.append("boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, \"foo\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* eClass.name == \'foo\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_operator_equals_1) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass.name == \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_xblockexpression = (_operator_equals_1);");
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
    _builder.append("boolean _operator_equals_2 = ObjectExtensions.operator_equals(_name_2, \"bar\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_operator_equals_2) {");
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
    _builder.append("boolean _operator_equals_3 = ObjectExtensions.operator_equals(_name_3, \"bar\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!_operator_equals_3) {");
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
    _builder.append("boolean _operator_equals = ObjectExtensions.operator_equals(_name, \"bar\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!_operator_equals) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("sneakyThrowRuleFailedException(\"object.eClass.name == \\\'bar\\\'\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_xblockexpression = (_operator_equals);");
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
    _builder.append("boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, \"bar\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("/* object.eClass.name == \'bar\' */");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (!_operator_equals_1) {");
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
      StringBuilderBasedAppendable _createAppendable = this.createAppendable();
      final StringBuilderBasedAppendable appendable = _createAppendable;
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
    _builder.append("boolean _operator_or = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _operator_equals = ObjectExtensions.operator_equals(\"foo\", _string);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (_operator_equals) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_operator_or = true;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _string_1 = new String();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _operator_equals_1 = ObjectExtensions.operator_equals(\"bar\", _string_1);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() || \'bar\' == new String() */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_or) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() || \\\'bar\\\' == new String()\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _operator_and = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("String _string_2 = new String();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _operator_equals_2 = ObjectExtensions.operator_equals(\"foo\", _string_2);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_equals_2) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_operator_and = false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _string_3 = new String();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean _operator_equals_3 = ObjectExtensions.operator_equals(\"bar\", _string_3);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_operator_and = BooleanExtensions.operator_and(_operator_equals_2, _operator_equals_3);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() && \'bar\' == new String() */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_and) {");
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
    _builder.append("String _operator_plus = StringExtensions.operator_plus(_string_4, _firstUpper);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _operator_equals_4 = ObjectExtensions.operator_equals(\"foo\", _operator_plus);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' == new String() + \'bar\'.toFirstUpper */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_equals_4) {");
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
    _builder.append("String _operator_plus_1 = StringExtensions.operator_plus(_string_5, _firstUpper_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolean _operator_notEquals = ObjectExtensions.operator_notEquals(\"foo\", _operator_plus_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* \'foo\' != new String() + \'bar\'.toFirstUpper */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_notEquals) {");
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
    _builder.append("StringExtensions.operator_plus(_string_6, _firstUpper_2);");
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
    _builder.append("boolean _operator_not = BooleanExtensions.operator_not(_contains_1);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* !(\'foo\'.contains(\'f\')) */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_not) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sneakyThrowRuleFailedException(\"!(\\\'foo\\\'.contains(\\\'f\\\'))\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final EClass eC = _createEClass;");
    _builder.newLine();
    _builder.append("}");
    this.checkCompilationOfAllPremises(_testRuleWithFeatureCalls, _builder);
  }
  
  @Test
  public void testThrowRuleFailedException() {
      StringBuilderBasedAppendable _createAppendable = this.createAppendable();
      final StringBuilderBasedAppendable a = _createAppendable;
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
    _builder.append("ObjectExtensions.operator_equals(\"foo\", _instanceClassName);");
    this.checkCompilationOfXExpression(_testWithEnvironmentAccess, 4, _builder);
  }
  
  @Test
  public void testEmptyEnvironmentSpecification() {
    CharSequence _testEmptyEnvironment = this.testFiles.testEmptyEnvironment();
    this.checkCompilationOfEnvironmentSpecfication(_testEmptyEnvironment, "emptyEnvironment()");
  }
  
  @Test
  public void testEnvironmentReference() {
    CharSequence _testRuleOnlyInvokingRules = this.testFiles.testRuleOnlyInvokingRules();
    this.checkCompilationOfEnvironmentSpecfication(_testRuleOnlyInvokingRules, "G");
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
    _builder.append("boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, \"foo\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Boolean.valueOf(_operator_notEquals);");
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
    _builder.append("boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, \"foo\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/* it.name != \'foo\' */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!Boolean.valueOf(_operator_notEquals)) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("sneakyThrowRuleFailedException(\"it.name != \\\'foo\\\'\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Boolean.valueOf(_operator_notEquals);");
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
    _builder.append("boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, \"foo\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("/* eClass.EStructuralFeatures.get(0).name != \'foo\' */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (!_operator_notEquals) {");
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
    _builder.append("EClass _clone = TypeSystem.this.<EClass>clone(_eClass);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("eClass = _clone;");
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
    _builder.append("EClass _clone = this.<EClass>clone(_eClass);");
    _builder.newLine();
    _builder.append("final EClass eClass = _clone;");
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
  
  public void checkCompilationOfRuleInvocation(final CharSequence inputCode, final int index, final CharSequence expected) {
      Rule _firstRule = this.getFirstRule(inputCode);
      final Rule rule = _firstRule;
      List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(rule);
      RuleInvocation _get = _ruleInvocations.get(index);
      final RuleInvocation xexp = _get;
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(rule);
      final StringBuilderBasedAppendable result = _createAppendable;
      this.xbaseCompiler.toJavaStatement(xexp, result, false);
      String _string = expected.toString();
      String _string_1 = result.toString();
      Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfOr(final CharSequence inputCode, final int index, final CharSequence expected) {
      Rule _firstRule = this.getFirstRule(inputCode);
      final Rule rule = _firstRule;
      List<OrExpression> _ors = this._xsemanticsUtils.getOrs(rule);
      OrExpression _get = _ors.get(index);
      final OrExpression xexp = _get;
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(rule);
      final StringBuilderBasedAppendable result = _createAppendable;
      this.xbaseCompiler.toJavaStatement(xexp, result, false);
      String _string = expected.toString();
      String _string_1 = result.toString();
      Assert.assertEquals(_string, _string_1);
  }
  
  public void checkRuleInvocationVariable(final CharSequence inputCode, final int index, final IAppendable appendable, final String expectedVariableName) {
      XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(inputCode);
      List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_parseAndAssertNoError);
      RuleInvocation _get = _ruleInvocations.get(index);
      final RuleInvocation xexp = _get;
      String _declareResultVariable = this.xbaseCompiler.declareResultVariable(xexp, appendable);
      final String variable = _declareResultVariable;
      Assert.assertEquals(expectedVariableName, variable);
  }
  
  public void checkCompilationOfAllPremises(final CharSequence inputCode, final CharSequence expected) {
      Rule _firstRule = this.getFirstRule(inputCode);
      final Rule rule = _firstRule;
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(rule);
      final StringBuilderBasedAppendable result = _createAppendable;
      XBlockExpression _rulePremisesAsBlock = this.getRulePremisesAsBlock(rule);
      final XBlockExpression xexp = _rulePremisesAsBlock;
      this.xbaseCompiler.toJavaStatement(xexp, result, false);
      String _string = expected.toString();
      String _string_1 = result.toString();
      Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfAllPremisesOfCheckRule(final CharSequence inputCode, final CharSequence expected) {
      CheckRule _firstCheckRule = this.getFirstCheckRule(inputCode);
      final CheckRule rule = _firstCheckRule;
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(rule);
      final StringBuilderBasedAppendable result = _createAppendable;
      XBlockExpression _rulePremisesAsBlock = this.getRulePremisesAsBlock(rule);
      final XBlockExpression xexp = _rulePremisesAsBlock;
      this.xbaseCompiler.toJavaStatement(xexp, result, false);
      String _string = expected.toString();
      String _string_1 = result.toString();
      Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfXExpression(final CharSequence inputCode, final int index, final CharSequence expected) {
      Rule _firstRule = this.getFirstRule(inputCode);
      final Rule rule = _firstRule;
      EList<XExpression> _rulePremises = this.getRulePremises(rule);
      XExpression _get = _rulePremises.get(index);
      final XExpression xexp = _get;
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(rule);
      final StringBuilderBasedAppendable result = _createAppendable;
      this.xbaseCompiler.toJavaStatement(xexp, result, false);
      String _string = expected.toString();
      String _string_1 = result.toString();
      Assert.assertEquals(_string, _string_1);
  }
  
  public void checkCompilationOfEnvironmentSpecfication(final CharSequence inputCode, final CharSequence expected) {
      Rule _firstRule = this.getFirstRule(inputCode);
      final Rule rule = _firstRule;
      EnvironmentSpecification _environmentSpecificationOfRuleInvocation = this.getEnvironmentSpecificationOfRuleInvocation(rule);
      final EnvironmentSpecification xexp = _environmentSpecificationOfRuleInvocation;
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(rule);
      final StringBuilderBasedAppendable result = _createAppendable;
      this.xbaseCompiler.generateEnvironmentSpecificationAsExpression(xexp, result);
      this.assertEqualsStrings(expected, result);
  }
}

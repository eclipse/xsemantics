package it.xsemantics.dsl.tests.generator;

import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.xsemantics.Rule;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XsemanticsRuleGeneratorTest extends XsemanticsGeneratorBaseTest {
  @Test
  public void testAppendableForXbaseGeneratedVariables() {
    CharSequence _testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable = this.testFiles.testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable();
    this.checkDeclaredVariable(
      "_createEObject", 
      "_createEObject_1", _testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable);
  }
  
  @Test
  public void testOutputParamFromInputParam() {
    CharSequence _testOutputParamFromInputParam = this.testFiles.testOutputParamFromInputParam();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final EClass eClass) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RuleFailedException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new Result<EClass>(eClass);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkCompileApplyMethod(_testOutputParamFromInputParam, _builder);
  }
  
  @Test
  public void testRuleWithErrorSpecifications() {
    CharSequence _testRuleWithErrorSpecifications = this.testFiles.testRuleWithErrorSpecifications();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final EClass eClass, final EObject object) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RuleFailedException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("RuleApplicationTrace _subtrace_ = newTrace(_trace_);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addToTrace(_trace_, ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addAsSubtrace(_trace_, _subtrace_);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return _result_;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception e_applyRuleEClassEObject) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String _stringRep = this.stringRep(object);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String _plus = (\"this \" + _stringRep);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EObject source = _eClass;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EClass _eClass_1 = object.eClass();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EStructuralFeature _eContainingFeature = _eClass_1.eContainingFeature();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ECLASSEOBJECT, e_applyRuleEClassEObject,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new ErrorInformation(source, feature));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkCompileDispatcherImplMethod(_testRuleWithErrorSpecifications, _builder);
  }
  
  public void checkDeclaredVariable(final String newVarName, final String expected, final CharSequence inputProgram) {
    Rule _firstRule = this.getFirstRule(inputProgram);
    FakeTreeAppendable _createAppendable = this.createAppendable(_firstRule);
    this.checkDeclaredVariable(newVarName, expected, _createAppendable);
  }
  
  public void checkDeclaredVariable(final String newVarName, final String expected, final IAppendable appendable) {
    String _string = new String();
    String _declareVariable = appendable.declareVariable(_string, newVarName);
    this.assertEqualsStrings(expected, _declareVariable);
  }
  
  public void checkCompileApplyMethod(final CharSequence program, final CharSequence expected) {
    final Rule rule = this.getFirstRule(program);
    ImportManager _createImportManager = this.createImportManager();
    CharSequence _compileApplyMethod = this.ruleGenerator.compileApplyMethod(rule, _createImportManager);
    this.assertEqualsStrings(expected, _compileApplyMethod);
  }
  
  public void checkCompileDispatcherImplMethod(final CharSequence program, final CharSequence expected) {
    final Rule rule = this.getFirstRule(program);
    ImportManager _createImportManager = this.createImportManager();
    CharSequence _compileDispatcherImplMethod = this.ruleGenerator.compileDispatcherImplMethod(rule, _createImportManager);
    this.assertEqualsStrings(expected, _compileDispatcherImplMethod);
  }
}

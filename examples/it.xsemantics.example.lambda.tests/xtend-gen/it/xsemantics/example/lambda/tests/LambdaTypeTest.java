package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.Variable;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import it.xsemantics.example.lambda.tests.LambdaInjectorWithNonBeautifiedTypesProvider;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaTypeTest extends LambdaBaseTest {
  @Test
  public void testStringConstantType() {
    this.assertAbstractionTermType("lambda x . \'foo\'", "String", "");
  }
  
  @Test
  public void testIntConstantType() {
    this.assertAbstractionTermType("lambda x . 10", "int", "");
  }
  
  @Test
  public void testExplicitParamType() {
    this.assertParamType("lambda x : int . x", "int");
  }
  
  @Test
  public void testImplicitParamType() {
    this.assertParamType("lambda x . x", "X1");
  }
  
  @Test
  public void testExplicitVariableType() {
      Abstraction _abstraction = this.getAbstraction("lambda x : int . x");
      final Abstraction abstraction = _abstraction;
      RuleEnvironment _environmentForParam = this.environmentForParam(abstraction);
      Term _term = abstraction.getTerm();
      Variable _variable = this.getVariable(_term);
      this.assertType(_environmentForParam, _variable, "int", "");
  }
  
  @Test
  public void testImplicitVariableType() {
      Abstraction _abstraction = this.getAbstraction("lambda x . x");
      final Abstraction abstraction = _abstraction;
      RuleEnvironment _environmentForParam = this.environmentForParam(abstraction);
      Term _term = abstraction.getTerm();
      Variable _variable = this.getVariable(_term);
      this.assertType(_environmentForParam, _variable, "X1", "");
  }
  
  @Test
  public void testArithmeticsConstantType() {
    this.assertAbstractionTermType("lambda x . -10", "int", "");
  }
  
  @Test
  public void testArithmeticsWithTypeVariable() {
    this.assertAbstractionType("lambda x . -x", "int -> int", "X1=int");
  }
  
  @Test
  public void testArithmeticsFails() {
    CharSequence _arithmeticsFails = this.traces.arithmeticsFails();
    this.assertAbstractionTypeFailureTrace("lambda x . - \'foo\'", _arithmeticsFails);
  }
  
  @Test
  public void testAbstractionExplicitVariableType() {
    this.assertAbstractionType("lambda x : int . x", "int -> int", "");
  }
  
  @Test
  public void testAbstractionImplicitVariableType() {
      Abstraction _abstraction = this.getAbstraction("lambda x . x");
      final Abstraction abstraction = _abstraction;
      this.assertType(abstraction, "a -> a", "");
  }
  
  @Test
  public void testAbstractionWithArithmetics() {
    Abstraction _abstraction = this.getAbstraction("lambda x . -x");
    this.assertType(_abstraction, "int -> int", "X1=int");
  }
  
  @Test
  public void testApplicationType() {
    this.assertAbstractionType("lambda x .lambda y . x y", "(a -> b) -> a -> b", "X1=(X3 -> X4), X2=X5, X3=X5");
  }
  
  @Test
  public void testApplicationType2() {
    this.assertAbstractionType("lambda x .lambda y . y x", "a -> (a -> b) -> b", "X1=X5, X2=(X3 -> X4), X3=X5");
  }
  
  @Test
  public void testCompose() {
    this.assertAbstractionType("lambda f . lambda g. lambda x. (f (g x))", "(a -> b) -> (c -> a) -> c -> b", "X1=(X4 -> X5), X2=(X6 -> X7), X3=X8, X4=X9, X6=X8, X7=X9");
  }
  
  @Test
  public void testCompose2() {
    this.assertAbstractionType("lambda f . lambda g. lambda x. (g (f x))", "(a -> b) -> (b -> c) -> a -> c", "X1=(X6 -> X7), X2=(X4 -> X5), X3=X8, X4=X9, X6=X8, X7=X9");
  }
  
  @Test
  public void testCompose3() {
    this.assertAbstractionType("lambda x . lambda y. lambda z. x z (y z)", "(a -> b -> c) -> (a -> b) -> a -> c", "X1=(X4 -> X5), X2=(X9 -> X10), X3=X6, X10=X12, X4=X6, X5=(X7 -> X8), X6=X11, X7=X12, X9=X11");
  }
  
  @Test
  public void testOmega() {
    CharSequence _omegaFails = this.traces.omegaFails();
    this.assertAbstractionTypeFailureTrace("lambda x . x x", _omegaFails);
  }
  
  public RuleEnvironment environmentForParam(final Abstraction abstraction) {
    RuleEnvironment _xblockexpression = null;
    {
      RuleEnvironment _ruleEnvironment = new RuleEnvironment();
      final RuleEnvironment env = _ruleEnvironment;
      Parameter _param = abstraction.getParam();
      Parameter _param_1 = abstraction.getParam();
      Result<Type> _paramtype = this.system.paramtype(_param_1);
      Type _value = _paramtype.getValue();
      env.add(_param, _value);
      _xblockexpression = (env);
    }
    return _xblockexpression;
  }
  
  public void assertParamType(final CharSequence prog, final String expectedType) {
    Abstraction _abstraction = this.getAbstraction(prog);
    Parameter _param = _abstraction.getParam();
    Result<Type> _paramtype = this.system.paramtype(_param);
    this.<Type>assertResultAsString(_paramtype, expectedType);
  }
  
  public void assertAbstractionTypeFailureTrace(final CharSequence prog, final CharSequence expectedTrace) {
    Abstraction _abstraction = this.getAbstraction(prog);
    Result<Type> _type = this.system.type(this.substitutions, _abstraction);
    this.<Type>assertFailureTrace(_type, expectedTrace);
  }
  
  public void assertAbstractionType(final CharSequence prog, final String expectedType, final String expectedSubsts) {
    Abstraction _abstraction = this.getAbstraction(prog);
    this.assertType(null, _abstraction, expectedType, expectedSubsts);
  }
  
  public void assertAbstractionTermType(final CharSequence prog, final String expectedType, final String expectedSubsts) {
    Abstraction _abstraction = this.getAbstraction(prog);
    Term _term = _abstraction.getTerm();
    this.assertType(null, _term, expectedType, expectedSubsts);
  }
  
  public void assertType(final CharSequence prog, final String expectedType, final String expectedSubsts) {
    Term _term = this.getTerm(prog);
    this.assertType(null, _term, expectedType, expectedSubsts);
  }
  
  public void assertType(final Term term, final String expectedType, final String expectedSubsts) {
    this.assertType(null, term, expectedType, expectedSubsts);
  }
  
  public void assertType(final RuleEnvironment env, final Term term, final String expectedType, final String expectedSubsts) {
      Result<Type> _type = this.system.type(env, null, this.substitutions, term);
      this.<Type>assertResultAsStringBeautifier(_type, expectedType);
      this.assertTypeSubstitutions(this.substitutions, expectedSubsts);
  }
}

package it.xsemantics.example.lambda.tests;

import com.google.inject.Inject;
import com.google.inject.Injector;
import it.xsemantics.example.lambda.LambdaInjectorProvider;
import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.Constant;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.lambda.Variable;
import it.xsemantics.example.lambda.tests.LambdaExpectedTraces;
import it.xsemantics.example.lambda.validation.LambdaJavaValidator;
import it.xsemantics.example.lambda.xsemantics.LambdaStringRepresentation;
import it.xsemantics.example.lambda.xsemantics.LambdaStringRepresentationWithTypeBeautifier;
import it.xsemantics.example.lambda.xsemantics.LambdaUtils;
import it.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;
import it.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.StringRepresentation;
import it.xsemantics.runtime.util.TraceUtils;
import junit.framework.Assert;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = LambdaInjectorProvider.class)
@SuppressWarnings("all")
public class LambdaBaseTest {
  @Inject
  protected LambdaJavaValidator validator;
  
  @Inject
  protected Injector injector;
  
  @Inject
  private ParseHelper<Program> _parseHelper;
  
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  protected LambdaXsemanticsSystem system;
  
  @Inject
  private StringRepresentation _stringRepresentation;
  
  @Inject
  protected LambdaExpectedTraces traces;
  
  @Inject
  private TraceUtils _traceUtils;
  
  protected TypeSubstitutions substitutions;
  
  @Inject
  protected LambdaStringRepresentation reprForSubstitutions;
  
  @Inject
  protected LambdaStringRepresentationWithTypeBeautifier reprBeautifier;
  
  @Inject
  protected LambdaUtils lambdaUtils;
  
  protected RuleApplicationTrace trace;
  
  @BeforeClass
  public static void setNewLine() {
    System.setProperty("line.separator", "\n");
  }
  
  @Before
  public void setUp() {
    this.lambdaUtils.resetCounter();
    TypeSubstitutions _typeSubstitutions = new TypeSubstitutions();
    this.substitutions = _typeSubstitutions;
    RuleApplicationTrace _ruleApplicationTrace = new RuleApplicationTrace();
    this.trace = _ruleApplicationTrace;
  }
  
  public Program parseAndGetProgram(final CharSequence prog) {
    try {
      Program _parse = this._parseHelper.parse(prog);
      return _parse;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Program parseAndAssertNoError(final CharSequence prog) {
    try {
      Program _xblockexpression = null;
      {
        final Program model = this._parseHelper.parse(prog);
        this._validationTestHelper.assertNoErrors(model);
        _xblockexpression = (model);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public <T extends Object> void assertFailure(final Result<T> result) {
    boolean _failed = result.failed();
    boolean _not = (!_failed);
    if (_not) {
      T _value = result.getValue();
      String _string = this._stringRepresentation.string(_value);
      String _plus = ("should have failed, instead got: " + _string);
      boolean _failed_1 = result.failed();
      Assert.assertTrue(_plus, _failed_1);
    }
  }
  
  public <T extends Object> void assertFailureTrace(final Result<T> result, final CharSequence expectedTrace) {
    this.<T>assertFailure(result);
    RuleFailedException _ruleFailedException = result.getRuleFailedException();
    String _failureTraceAsString = this._traceUtils.failureTraceAsString(_ruleFailedException);
    this.assertStrings(expectedTrace, _failureTraceAsString);
  }
  
  public void assertStrings(final Object expected, final Object actual) {
    String _string = expected.toString();
    String _string_1 = actual.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  public <T extends Object> void assertResultAsString(final Result<T> result, final String expected) {
    boolean _failed = result.failed();
    if (_failed) {
      RuleFailedException _ruleFailedException = result.getRuleFailedException();
      String _failureTraceAsString = this._traceUtils.failureTraceAsString(_ruleFailedException);
      String _plus = ("should not have failed: " + _failureTraceAsString);
      boolean _failed_1 = result.failed();
      Assert.assertFalse(_plus, _failed_1);
    }
    T _value = result.getValue();
    String _string = this._stringRepresentation.string(_value);
    Assert.assertEquals(expected, _string);
  }
  
  public <T extends Object> void assertResultAsStringBeautifier(final Result<T> result, final String expected) {
    boolean _failed = result.failed();
    if (_failed) {
      RuleFailedException _ruleFailedException = result.getRuleFailedException();
      String _failureTraceAsString = this._traceUtils.failureTraceAsString(_ruleFailedException);
      String _plus = ("should not have failed: " + _failureTraceAsString);
      boolean _failed_1 = result.failed();
      Assert.assertFalse(_plus, _failed_1);
    }
    T _value = result.getValue();
    String _string = this.reprBeautifier.string(_value);
    Assert.assertEquals(expected, _string);
  }
  
  public <T extends Object, V extends Object> void assertResult2AsString(final Result2<T,V> result, final String expected) {
    boolean _failed = result.failed();
    Assert.assertFalse("should not have failed", _failed);
    T _first = result.getFirst();
    String _string = this._stringRepresentation.string(_first);
    String _plus = (_string + " -- ");
    V _second = result.getSecond();
    String _string_1 = this._stringRepresentation.string(_second);
    String _plus_1 = (_plus + _string_1);
    Assert.assertEquals(expected, _plus_1);
  }
  
  public void assertResultTrue(final Result<Boolean> result) {
    this.<Boolean>assertResultAsString(result, "true");
  }
  
  public TypeVariable getTypeVariable(final Type type) {
    return ((TypeVariable) type);
  }
  
  public ArrowType getArrowType(final Type type) {
    return ((ArrowType) type);
  }
  
  public Term getTerm(final CharSequence prog) {
    Program _parseAndGetProgram = this.parseAndGetProgram(prog);
    Term _term = _parseAndGetProgram.getTerm();
    return _term;
  }
  
  public Abstraction getAbstraction(final CharSequence prog) {
    Term _term = this.getTerm(prog);
    Abstraction _abstraction = this.getAbstraction(_term);
    return _abstraction;
  }
  
  public Abstraction getAbstraction(final Term term) {
    return ((Abstraction) term);
  }
  
  public Variable getVariable(final Term term) {
    return ((Variable) term);
  }
  
  public Constant getConstant(final Term term) {
    return ((Constant) term);
  }
  
  public void assertTypeVariable(final Type type, final String expectedName) {
    TypeVariable _typeVariable = this.getTypeVariable(type);
    String _typevarName = _typeVariable.getTypevarName();
    Assert.assertEquals(expectedName, _typevarName);
  }
  
  public void assertArrowType(final Type type, final String expectedName) {
    ArrowType _arrowType = this.getArrowType(type);
    String _string = this._stringRepresentation.string(_arrowType);
    Assert.assertEquals(expectedName, _string);
  }
  
  public void assertTypeSubstitutions(final TypeSubstitutions substitutions, final String expected) {
    String _plus = ("subst{" + expected);
    String _plus_1 = (_plus + "}");
    String _string = this.reprForSubstitutions.string(substitutions);
    this.assertStrings(_plus_1, _string);
  }
}

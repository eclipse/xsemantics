package it.xsemantics.dsl.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import java.util.Arrays;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.Later;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CustomXbaseCompiler extends XbaseCompiler {
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  @Extension
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  @Extension
  private XsemanticsNodeModelUtils _xsemanticsNodeModelUtils;
  
  @Inject
  @Extension
  private XsemanticsTypeSystem _xsemanticsTypeSystem;
  
  public ITreeAppendable compile(final XExpression obj, final ITreeAppendable appendable, final JvmTypeReference expectedReturnType, final Set<JvmTypeReference> declaredExceptions) {
    final EObject rule = obj.eContainer();
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof RuleWithPremises) {
        final RuleWithPremises _ruleWithPremises = (RuleWithPremises)rule;
        _matched=true;
        this._xsemanticsGeneratorExtensions.declareVariablesForOutputParams(_ruleWithPremises, appendable);
        JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_ruleWithPremises);
        JvmTypeReference _resultType = this._xsemanticsGeneratorExtensions.resultType(_judgmentDescription);
        this.compileRuleBody(_ruleWithPremises, _resultType, appendable);
        return appendable;
      }
    }
    if (!_matched) {
      if (rule instanceof CheckRule) {
        final CheckRule _checkRule = (CheckRule)rule;
        _matched=true;
        this.compilePremises(_checkRule, appendable);
        String _string = appendable.toString();
        boolean _isEmpty = _string.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          appendable.newLine();
        }
        appendable.append("return new ");
        this._xsemanticsGeneratorExtensions.resultType(_checkRule, appendable);
        appendable.append("(true);");
      }
    }
    return super.compile(obj, appendable, expectedReturnType, declaredExceptions);
  }
  
  public void compileRuleBody(final Rule rule, final JvmTypeReference resultType, final ITreeAppendable result) {
    this.compilePremises(rule, result);
    this._xsemanticsGeneratorExtensions.compileReturnResult(rule, resultType, result);
  }
  
  protected void _compilePremises(final Rule rule, final ITreeAppendable result) {
    return;
  }
  
  protected void _compilePremises(final RuleWithPremises rule, final ITreeAppendable result) {
    XExpression _premises = rule.getPremises();
    this.toJavaStatement(_premises, result, false);
  }
  
  protected void _compilePremises(final CheckRule rule, final ITreeAppendable result) {
    XExpression _premises = rule.getPremises();
    this.toJavaStatement(_premises, result, false);
  }
  
  public String compileErrorOfErrorSpecification(final ErrorSpecification errorSpecification, final ITreeAppendable b) {
    XExpression _error = errorSpecification.getError();
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(String.class, errorSpecification);
    return this.compileAndAssignToLocalVariable(_error, b, _typeForName, "error");
  }
  
  public String compileSourceOfErrorSpecification(final ErrorSpecification errorSpecification, final ITreeAppendable b) {
    XExpression _source = errorSpecification.getSource();
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(EObject.class, errorSpecification);
    return this.compileAndAssignToLocalVariable(_source, b, _typeForName, "source");
  }
  
  public String compileFeatureOfErrorSpecification(final ErrorSpecification errorSpecification, final ITreeAppendable b) {
    XExpression _feature = errorSpecification.getFeature();
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(EStructuralFeature.class, errorSpecification);
    return this.compileAndAssignToLocalVariable(_feature, b, _typeForName, "feature");
  }
  
  protected String compileAndAssignToLocalVariable(final XExpression expression, final ITreeAppendable b, final JvmTypeReference expectedType, final String proposedVariable) {
    boolean _equals = Objects.equal(expression, null);
    if (_equals) {
      return "null";
    }
    this.toJavaStatement(expression, b, true);
    Object _object = new Object();
    final Object syntheticObject = _object;
    final String varName = b.declareSyntheticVariable(syntheticObject, proposedVariable);
    b.append("\n");
    this.serialize(expectedType, expression, b);
    ITreeAppendable _append = b.append(" ");
    ITreeAppendable _append_1 = _append.append(varName);
    _append_1.append(" = ");
    this.toJavaExpression(expression, b);
    b.append(";");
    return b.getName(syntheticObject);
  }
  
  /**
   * We need to wrap boolean expressions with try-catch-throw RuleFailedException,
   * since in Xsemantics a boolean expression is an assertion
   */
  protected void _toJavaStatement(final XBlockExpression expr, final ITreeAppendable b, final boolean isReferenced) {
    boolean _insideClosure = this.insideClosure(expr);
    if (_insideClosure) {
      boolean _or = false;
      if (isReferenced) {
        _or = true;
      } else {
        boolean _and = false;
        EList<XExpression> _expressions = expr.getExpressions();
        int _size = _expressions.size();
        boolean _equals = (_size == 1);
        if (!_equals) {
          _and = false;
        } else {
          EList<XExpression> _expressions_1 = expr.getExpressions();
          XExpression _get = _expressions_1.get(0);
          boolean _isBooleanPremise = this._xsemanticsTypeSystem.isBooleanPremise(_get);
          _and = (_equals && _isBooleanPremise);
        }
        _or = (isReferenced || _and);
      }
      super._toJavaStatement(expr, b, _or);
    } else {
      EList<XExpression> _expressions_2 = expr.getExpressions();
      boolean _isEmpty = _expressions_2.isEmpty();
      if (_isEmpty) {
        return;
      }
      EList<XExpression> _expressions_3 = expr.getExpressions();
      int _size_1 = _expressions_3.size();
      boolean _equals_1 = (_size_1 == 1);
      if (_equals_1) {
        EList<XExpression> _expressions_4 = expr.getExpressions();
        XExpression _get_1 = _expressions_4.get(0);
        this.compileBooleanXExpression(_get_1, b, isReferenced);
        return;
      }
      if (isReferenced) {
        this.declareSyntheticVariable(expr, b);
      }
      ITreeAppendable _append = b.append("\n{");
      _append.increaseIndentation();
      final EList<XExpression> expressions = expr.getExpressions();
      int i = 0;
      for (final XExpression ex : expressions) {
        {
          boolean hasToBeReferenced = isReferenced;
          int _size_2 = expressions.size();
          int _minus = (_size_2 - 1);
          boolean _lessThan = (i < _minus);
          if (_lessThan) {
            hasToBeReferenced = false;
          }
          this.compileBooleanXExpression(ex, b, hasToBeReferenced);
          if (hasToBeReferenced) {
            ITreeAppendable _append_1 = b.append("\n");
            String _varName = this.getVarName(expr, b);
            ITreeAppendable _append_2 = _append_1.append(_varName);
            _append_2.append(" = (");
            this.internalToConvertedExpression(ex, b, null);
            b.append(");");
          }
          int _plus = (i + 1);
          i = _plus;
        }
      }
      ITreeAppendable _decreaseIndentation = b.decreaseIndentation();
      _decreaseIndentation.append("\n}");
    }
  }
  
  /**
   * If it's boolean, wraps in an if with throw RuleFailedException
   * 
   * @param expression
   * @param b
   * @param hasToBeReferenced
   */
  public void compileBooleanXExpression(final XExpression expression, final ITreeAppendable b, final boolean toBeReferenced) {
    boolean hasToBeReferenced = toBeReferenced;
    if ((expression instanceof XBlockExpression)) {
      this.internalToJavaStatement(expression, b, hasToBeReferenced);
      return;
    }
    final boolean isBoolean = this._xsemanticsTypeSystem.isBooleanPremise(expression);
    if (isBoolean) {
      hasToBeReferenced = true;
    }
    this.internalToJavaStatement(expression, b, hasToBeReferenced);
    if (isBoolean) {
      this.generateCommentWithOriginalCode(expression, b);
      this.newLine(b);
      b.append("if (!");
      this.toJavaExpression(expression, b);
      b.append(") {");
      b.increaseIndentation();
      this.newLine(b);
      this.throwNewRuleFailedException(expression, b);
      this.closeBracket(b);
    }
  }
  
  public void throwNewRuleFailedException(final XExpression expression, final ITreeAppendable b) {
    String _sneakyThrowRuleFailedException = this._xsemanticsGeneratorExtensions.sneakyThrowRuleFailedException();
    b.append(_sneakyThrowRuleFailedException);
    b.append("(");
    this.generateStringWithOriginalCode(expression, b);
    b.append(");");
  }
  
  protected void _doInternalToJavaStatement(final XExpression e, final ITreeAppendable b, final boolean isReferenced) {
    super.doInternalToJavaStatement(e, b, isReferenced);
  }
  
  protected void _internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable) {
    super.internalToConvertedExpression(obj, appendable);
  }
  
  protected void _doInternalToJavaStatement(final EnvironmentAccess environmentAccess, final ITreeAppendable b, final boolean isReferenced) {
    this.generateCommentWithOriginalCode(environmentAccess, b);
    XExpression _argument = environmentAccess.getArgument();
    this.toJavaStatement(_argument, b, true);
    if (isReferenced) {
      final Later _function = new Later() {
          public void exec(final ITreeAppendable app) {
            CustomXbaseCompiler.this.compileEnvironmentAccess(environmentAccess, app);
          }
        };
      this.declareFreshLocalVariable(environmentAccess, b, _function);
    } else {
      this.newLine(b);
      this.compileEnvironmentAccess(environmentAccess, b);
      b.append(";");
    }
  }
  
  protected void _internalToConvertedExpression(final EnvironmentAccess environmentAccess, final ITreeAppendable b) {
    String _name = b.getName(environmentAccess);
    b.append(_name);
  }
  
  public void generateCommentWithOriginalCode(final EObject modelElement, final ITreeAppendable b) {
    ITreeAppendable _append = b.append("\n");
    ITreeAppendable _append_1 = _append.append("/* ");
    String _programText = this._xsemanticsNodeModelUtils.getProgramText(modelElement);
    ITreeAppendable _append_2 = _append_1.append(_programText);
    _append_2.append(" */");
  }
  
  public void generateStringWithOriginalCode(final EObject modelElement, final ITreeAppendable b) {
    ITreeAppendable _append = b.append("\"");
    String _programText = this._xsemanticsNodeModelUtils.getProgramText(modelElement);
    String _javaString = this._xsemanticsGeneratorExtensions.javaString(_programText);
    ITreeAppendable _append_1 = _append.append(_javaString);
    _append_1.append("\"");
  }
  
  public void compileEnvironmentAccess(final EnvironmentAccess environmentAccess, final ITreeAppendable b) {
    String _environmentAccessMethod = this._xsemanticsGeneratorExtensions.environmentAccessMethod();
    b.append(_environmentAccessMethod);
    b.append("(");
    Environment _environment = environmentAccess.getEnvironment();
    String _name = _environment.getName();
    b.append(_name);
    this.comma(b);
    XExpression _argument = environmentAccess.getArgument();
    this.toJavaExpression(_argument, b);
    this.comma(b);
    JvmTypeReference _type = environmentAccess.getType();
    this.generateJavaClassReference(_type, environmentAccess, b);
    b.append(")");
  }
  
  public void comma(final ITreeAppendable b) {
    b.append(", ");
  }
  
  public void newLine(final ITreeAppendable b) {
    b.append("\n");
  }
  
  public void closeBracket(final ITreeAppendable b) {
    b.decreaseIndentation();
    this.newLine(b);
    b.append("}");
  }
  
  public void generateJavaClassReference(final JvmTypeReference expressionType, final XExpression expression, final ITreeAppendable b) {
    JvmType _type = expressionType.getType();
    b.append(_type);
    b.append(".class");
  }
  
  public boolean insideClosure(final XBlockExpression expr) {
    EObject _eContainer = expr.eContainer();
    return (_eContainer instanceof XClosure);
  }
  
  public void compilePremises(final EObject rule, final ITreeAppendable result) {
    if (rule instanceof RuleWithPremises) {
      _compilePremises((RuleWithPremises)rule, result);
      return;
    } else if (rule instanceof CheckRule) {
      _compilePremises((CheckRule)rule, result);
      return;
    } else if (rule instanceof Rule) {
      _compilePremises((Rule)rule, result);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rule, result).toString());
    }
  }
  
  public void doInternalToJavaStatement(final XExpression environmentAccess, final ITreeAppendable b, final boolean isReferenced) {
    if (environmentAccess instanceof EnvironmentAccess) {
      _doInternalToJavaStatement((EnvironmentAccess)environmentAccess, b, isReferenced);
      return;
    } else if (environmentAccess != null) {
      _doInternalToJavaStatement(environmentAccess, b, isReferenced);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(environmentAccess, b, isReferenced).toString());
    }
  }
  
  public void internalToConvertedExpression(final XExpression environmentAccess, final ITreeAppendable b) {
    if (environmentAccess instanceof EnvironmentAccess) {
      _internalToConvertedExpression((EnvironmentAccess)environmentAccess, b);
      return;
    } else if (environmentAccess != null) {
      _internalToConvertedExpression(environmentAccess, b);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(environmentAccess, b).toString());
    }
  }
}

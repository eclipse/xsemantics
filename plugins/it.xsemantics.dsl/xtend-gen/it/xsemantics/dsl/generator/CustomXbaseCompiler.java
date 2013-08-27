package it.xsemantics.dsl.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
  
  public void generateJavaClassReference(final JvmTypeReference expressionType, final XExpression expression, final ITreeAppendable b) {
    JvmType _type = expressionType.getType();
    b.append(_type);
    b.append(".class");
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

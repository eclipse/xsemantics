package it.xsemantics.dsl.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import java.util.Arrays;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
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
}

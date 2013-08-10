package it.xsemantics.dsl.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CustomXbaseCompiler extends XbaseCompiler {
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  @Extension
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  public ITreeAppendable compile(final XExpression obj, final ITreeAppendable appendable, final JvmTypeReference expectedReturnType, final Set<JvmTypeReference> declaredExceptions) {
    EObject _eContainer = obj.eContainer();
    if ((_eContainer instanceof RuleWithPremises)) {
      EObject _eContainer_1 = obj.eContainer();
      final RuleWithPremises rule = ((RuleWithPremises) _eContainer_1);
      this._xsemanticsGeneratorExtensions.declareVariablesForOutputParams(rule, appendable);
      JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
      JvmTypeReference _resultType = this._xsemanticsGeneratorExtensions.resultType(_judgmentDescription);
      this.compileRuleBody(rule, _resultType, appendable);
      return appendable;
    }
    return super.compile(obj, appendable, expectedReturnType, declaredExceptions);
  }
  
  public ITreeAppendable compileRuleBody(final Rule rule, final JvmTypeReference resultType, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      this.compilePremises(rule, result);
      this.compileRuleConclusionElements(rule, result);
      ITreeAppendable _compileReturnResult = this.compileReturnResult(rule, resultType, result);
      _xblockexpression = (_compileReturnResult);
    }
    return _xblockexpression;
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
  
  public void compileRuleConclusionElements(final Rule rule, final ITreeAppendable result) {
    List<ExpressionInConclusion> _expressionsInConclusion = this._xsemanticsUtils.expressionsInConclusion(rule);
    final Procedure1<ExpressionInConclusion> _function = new Procedure1<ExpressionInConclusion>() {
        public void apply(final ExpressionInConclusion it) {
          XExpression _expression = it.getExpression();
          CustomXbaseCompiler.this.toJavaStatement(_expression, result, true);
        }
      };
    IterableExtensions.<ExpressionInConclusion>forEach(_expressionsInConclusion, _function);
  }
  
  public ITreeAppendable compileReturnResult(final Rule rule, final JvmTypeReference resultType, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      final List<RuleConclusionElement> expressions = this._xsemanticsUtils.outputConclusionElements(rule);
      String _string = result.toString();
      boolean _isEmpty = _string.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        result.append("\n");
      }
      result.append("return new ");
      this.serialize(resultType, rule, result);
      result.append("(");
      int _size = expressions.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        result.append("true");
      } else {
        final Iterator<RuleConclusionElement> iterator = expressions.iterator();
        boolean _hasNext = iterator.hasNext();
        boolean _while = _hasNext;
        while (_while) {
          {
            final RuleConclusionElement elem = iterator.next();
            boolean _matched = false;
            if (!_matched) {
              if (elem instanceof RuleParameter) {
                final RuleParameter _ruleParameter = (RuleParameter)elem;
                _matched=true;
                JvmFormalParameter _parameter = _ruleParameter.getParameter();
                String _name = result.getName(_parameter);
                result.append(_name);
              }
            }
            if (!_matched) {
              if (elem instanceof ExpressionInConclusion) {
                final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)elem;
                _matched=true;
                XExpression _expression = _expressionInConclusion.getExpression();
                this.toJavaExpression(_expression, result);
              }
            }
            boolean _hasNext_1 = iterator.hasNext();
            if (_hasNext_1) {
              result.append(", ");
            }
          }
          boolean _hasNext_1 = iterator.hasNext();
          _while = _hasNext_1;
        }
      }
      ITreeAppendable _append = result.append(");");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
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

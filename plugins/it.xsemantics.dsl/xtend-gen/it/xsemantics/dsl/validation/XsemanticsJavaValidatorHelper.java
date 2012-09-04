package it.xsemantics.dsl.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XsemanticsJavaValidatorHelper {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  public boolean noRulesWithTheSameNameOfCheckRule(final Rule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<CheckRule> _checkrules = _containingTypeSystem.getCheckrules();
    final Function1<CheckRule,Boolean> _function = new Function1<CheckRule,Boolean>() {
        public Boolean apply(final CheckRule it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, rule));
          if (!_notEquals) {
            _and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    CheckRule _findFirst = IterableExtensions.<CheckRule>findFirst(_checkrules, _function);
    boolean _equals = Objects.equal(_findFirst, null);
    return _equals;
  }
  
  public boolean noRulesWithTheSameName(final Rule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<Rule> _rules = _containingTypeSystem.getRules();
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, rule));
          if (!_notEquals) {
            _and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    Rule _findFirst = IterableExtensions.<Rule>findFirst(_rules, _function);
    boolean _equals = Objects.equal(_findFirst, null);
    return _equals;
  }
  
  public boolean noCheckRulesWithTheSameNameOfRule(final CheckRule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<Rule> _rules = _containingTypeSystem.getRules();
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, rule));
          if (!_notEquals) {
            _and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    Rule _findFirst = IterableExtensions.<Rule>findFirst(_rules, _function);
    boolean _equals = Objects.equal(_findFirst, null);
    return _equals;
  }
  
  public boolean noCheckRulesWithTheSameName(final CheckRule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<CheckRule> _checkrules = _containingTypeSystem.getCheckrules();
    final Function1<CheckRule,Boolean> _function = new Function1<CheckRule,Boolean>() {
        public Boolean apply(final CheckRule it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, rule));
          if (!_notEquals) {
            _and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    CheckRule _findFirst = IterableExtensions.<CheckRule>findFirst(_checkrules, _function);
    boolean _equals = Objects.equal(_findFirst, null);
    return _equals;
  }
  
  public JudgmentDescription judgmentDescriptionWithTheSameName(final JudgmentDescription j) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(j);
    ArrayList<JudgmentDescription> _allJudgments = this._xsemanticsUtils.allJudgments(_containingTypeSystem);
    final Function1<JudgmentDescription,Boolean> _function = new Function1<JudgmentDescription,Boolean>() {
        public Boolean apply(final JudgmentDescription it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, j));
          if (!_notEquals) {
            _and = false;
          } else {
            String _name = it.getName();
            String _name_1 = j.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    JudgmentDescription _findFirst = IterableExtensions.<JudgmentDescription>findFirst(_allJudgments, _function);
    return _findFirst;
  }
  
  public boolean findDuplicateParameter(final RuleParameter param) {
    Rule _containingRule = this._xsemanticsUtils.containingRule(param);
    RuleConclusion _conclusion = _containingRule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_conclusionElements, RuleParameter.class);
    final Function1<RuleParameter,JvmFormalParameter> _function = new Function1<RuleParameter,JvmFormalParameter>() {
        public JvmFormalParameter apply(final RuleParameter it) {
          JvmFormalParameter _parameter = it.getParameter();
          return _parameter;
        }
      };
    List<JvmFormalParameter> _map = ListExtensions.<RuleParameter, JvmFormalParameter>map(_typeSelect, _function);
    JvmFormalParameter _parameter = param.getParameter();
    boolean _findDuplicateJvmFormalParameter = this.findDuplicateJvmFormalParameter(_map, _parameter);
    return _findDuplicateJvmFormalParameter;
  }
  
  public boolean findDuplicateParameter(final InputParameter param) {
    JudgmentDescription _containingJudgmentDescription = this._xsemanticsUtils.containingJudgmentDescription(param);
    EList<JudgmentParameter> _judgmentParameters = _containingJudgmentDescription.getJudgmentParameters();
    List<InputParameter> _typeSelect = EcoreUtil2.<InputParameter>typeSelect(_judgmentParameters, InputParameter.class);
    final Function1<InputParameter,JvmFormalParameter> _function = new Function1<InputParameter,JvmFormalParameter>() {
        public JvmFormalParameter apply(final InputParameter it) {
          JvmFormalParameter _parameter = it.getParameter();
          return _parameter;
        }
      };
    List<JvmFormalParameter> _map = ListExtensions.<InputParameter, JvmFormalParameter>map(_typeSelect, _function);
    JvmFormalParameter _parameter = param.getParameter();
    boolean _findDuplicateJvmFormalParameter = this.findDuplicateJvmFormalParameter(_map, _parameter);
    return _findDuplicateJvmFormalParameter;
  }
  
  public boolean findDuplicateJvmFormalParameter(final Iterable<JvmFormalParameter> params, final JvmFormalParameter param) {
    final Function1<JvmFormalParameter,Boolean> _function = new Function1<JvmFormalParameter,Boolean>() {
        public Boolean apply(final JvmFormalParameter it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, param));
          if (!_notEquals) {
            _and = false;
          } else {
            String _name = it.getName();
            String _name_1 = param.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    boolean _exists = IterableExtensions.<JvmFormalParameter>exists(params, _function);
    return _exists;
  }
}

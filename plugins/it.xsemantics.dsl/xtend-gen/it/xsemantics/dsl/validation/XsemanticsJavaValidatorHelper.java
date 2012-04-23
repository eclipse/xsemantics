package it.xsemantics.dsl.validation;

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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class XsemanticsJavaValidatorHelper {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  public boolean noRulesWithTheSameNameOfCheckRule(final Rule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<CheckRule> _checkrules = _containingTypeSystem.getCheckrules();
    final Function1<CheckRule,Boolean> _function = new Function1<CheckRule,Boolean>() {
        public Boolean apply(final CheckRule it) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(it, rule);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, _name_1);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    CheckRule _findFirst = IterableExtensions.<CheckRule>findFirst(_checkrules, _function);
    boolean _operator_equals = ObjectExtensions.operator_equals(_findFirst, null);
    return _operator_equals;
  }
  
  public boolean noRulesWithTheSameName(final Rule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<Rule> _rules = _containingTypeSystem.getRules();
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(it, rule);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, _name_1);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    Rule _findFirst = IterableExtensions.<Rule>findFirst(_rules, _function);
    boolean _operator_equals = ObjectExtensions.operator_equals(_findFirst, null);
    return _operator_equals;
  }
  
  public boolean noCheckRulesWithTheSameNameOfRule(final CheckRule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<Rule> _rules = _containingTypeSystem.getRules();
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(it, rule);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, _name_1);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    Rule _findFirst = IterableExtensions.<Rule>findFirst(_rules, _function);
    boolean _operator_equals = ObjectExtensions.operator_equals(_findFirst, null);
    return _operator_equals;
  }
  
  public boolean noCheckRulesWithTheSameName(final CheckRule rule) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
    EList<CheckRule> _checkrules = _containingTypeSystem.getCheckrules();
    final Function1<CheckRule,Boolean> _function = new Function1<CheckRule,Boolean>() {
        public Boolean apply(final CheckRule it) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(it, rule);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            String _name = it.getName();
            String _name_1 = rule.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, _name_1);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    CheckRule _findFirst = IterableExtensions.<CheckRule>findFirst(_checkrules, _function);
    boolean _operator_equals = ObjectExtensions.operator_equals(_findFirst, null);
    return _operator_equals;
  }
  
  public boolean noJudgmentDescriptionsWithTheSameName(final JudgmentDescription j) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(j);
    EList<JudgmentDescription> _judgmentDescriptions = _containingTypeSystem.getJudgmentDescriptions();
    final Function1<JudgmentDescription,Boolean> _function = new Function1<JudgmentDescription,Boolean>() {
        public Boolean apply(final JudgmentDescription it) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(it, j);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            String _name = it.getName();
            String _name_1 = j.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, _name_1);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    JudgmentDescription _findFirst = IterableExtensions.<JudgmentDescription>findFirst(_judgmentDescriptions, _function);
    boolean _operator_equals = ObjectExtensions.operator_equals(_findFirst, null);
    return _operator_equals;
  }
  
  public boolean findDuplicateParameter(final RuleParameter param) {
    Rule _containingRule = this._xsemanticsUtils.containingRule(param);
    RuleConclusion _conclusion = _containingRule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_conclusionElements, it.xsemantics.dsl.xsemantics.RuleParameter.class);
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
    List<InputParameter> _typeSelect = EcoreUtil2.<InputParameter>typeSelect(_judgmentParameters, it.xsemantics.dsl.xsemantics.InputParameter.class);
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
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(it, param);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            String _name = it.getName();
            String _name_1 = param.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, _name_1);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    boolean _exists = IterableExtensions.<JvmFormalParameter>exists(params, _function);
    return _exists;
  }
}

package it.xsemantics.dsl.validation;

import com.google.inject.Inject;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class XsemanticsJavaValidatorHelper {
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  public boolean noRulesWithTheSameName(final Rule rule) {
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
  
  public boolean noRulesWithTheSameName(final CheckRule rule) {
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
}

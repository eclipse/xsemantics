package it.xsemantics.dsl.generator;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class GeneratorUtils {
  public static ArrayList<? extends Object> onlyErrors(final List<Issue> issues) {
    final Function1<Issue,Boolean> _function = new Function1<Issue,Boolean>() {
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          boolean _operator_equals = ObjectExtensions.operator_equals(_severity, Severity.ERROR);
          return Boolean.valueOf(_operator_equals);
        }
      };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
    ArrayList<Issue> _newArrayList = Lists.<Issue>newArrayList(_filter);
    return _newArrayList;
  }
  
  public static boolean hasErrors(final List<Issue> issues) {
    ArrayList<? extends Object> _onlyErrors = GeneratorUtils.onlyErrors(issues);
    boolean _isEmpty = _onlyErrors.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    return _operator_not;
  }
}

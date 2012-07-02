package it.xsemantics.dsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GeneratorUtils {
  public static ArrayList<Issue> onlyErrors(final List<Issue> issues) {
    final Function1<Issue,Boolean> _function = new Function1<Issue,Boolean>() {
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          boolean _equals = Objects.equal(_severity, Severity.ERROR);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
    ArrayList<Issue> _newArrayList = Lists.<Issue>newArrayList(_filter);
    return _newArrayList;
  }
  
  public static boolean hasErrors(final List<Issue> issues) {
    ArrayList<Issue> _onlyErrors = GeneratorUtils.onlyErrors(issues);
    boolean _isEmpty = _onlyErrors.isEmpty();
    boolean _not = (!_isEmpty);
    return _not;
  }
}

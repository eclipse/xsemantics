package it.xsemantics.example.lambda.validation;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;
import it.xsemantics.runtime.validation.XsemanticsValidatorFilter;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class LambdaValidatorFilter extends XsemanticsValidatorFilter {
  @Inject
  private TraceUtils _traceUtils;
  
  public Iterable<RuleFailedException> filterRuleFailedExceptions(final RuleFailedException e) {
    final RuleFailedException inner = this._traceUtils.innermostRuleFailedExceptionWithNodeModelSources(e);
    boolean _notEquals = ObjectExtensions.operator_notEquals(inner, null);
    if (_notEquals) {
      return this._traceUtils.failureAsList(inner);
    } else {
      return Lists.<RuleFailedException>newArrayList(e);
    }
  }
}

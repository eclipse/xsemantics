package it.xsemantics.example.lambda.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;
import it.xsemantics.runtime.validation.XsemanticsValidatorFilter;

@SuppressWarnings("all")
public class LambdaValidatorFilter extends XsemanticsValidatorFilter {
  @Inject
  private TraceUtils _traceUtils;
  
  public Iterable<RuleFailedException> filterRuleFailedExceptions(final RuleFailedException e) {
    final RuleFailedException inner = this._traceUtils.innermostRuleFailedExceptionWithNodeModelSources(e);
    boolean _notEquals = (!Objects.equal(inner, null));
    if (_notEquals) {
      return this._traceUtils.failureAsList(inner);
    } else {
      return Lists.<RuleFailedException>newArrayList(e);
    }
  }
}

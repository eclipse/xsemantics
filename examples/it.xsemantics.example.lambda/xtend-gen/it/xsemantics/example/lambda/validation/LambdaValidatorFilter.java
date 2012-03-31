package it.xsemantics.example.lambda.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;
import it.xsemantics.runtime.validation.XsemanticsValidatorFilter;
import java.util.LinkedList;

@SuppressWarnings("all")
public class LambdaValidatorFilter extends XsemanticsValidatorFilter {
  @Inject
  private TraceUtils _traceUtils;
  
  public Iterable<RuleFailedException> filterRuleFailedExceptions(final RuleFailedException e) {
    RuleFailedException _innermostRuleFailedExceptionWithNodeModelSources = this._traceUtils.innermostRuleFailedExceptionWithNodeModelSources(e);
    LinkedList<RuleFailedException> _failureAsList = this._traceUtils.failureAsList(_innermostRuleFailedExceptionWithNodeModelSources);
    return _failureAsList;
  }
}

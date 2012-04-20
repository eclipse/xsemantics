package it.xsemantics.example.lambda.validation;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;
import it.xsemantics.runtime.validation.XsemanticsValidatorFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class LambdaValidatorFilter extends XsemanticsValidatorFilter {
  @Inject
  private TraceUtils _traceUtils;
  
  public Iterable<RuleFailedException> filterRuleFailedExceptions(final RuleFailedException e) {
      RuleFailedException _innermostRuleFailedExceptionWithNodeModelSources = this._traceUtils.innermostRuleFailedExceptionWithNodeModelSources(e);
      final RuleFailedException inner = _innermostRuleFailedExceptionWithNodeModelSources;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(inner, null);
      if (_operator_notEquals) {
        LinkedList<RuleFailedException> _failureAsList = this._traceUtils.failureAsList(inner);
        return _failureAsList;
      } else {
        ArrayList<RuleFailedException> _newArrayList = Lists.<RuleFailedException>newArrayList(e);
        return _newArrayList;
      }
  }
}

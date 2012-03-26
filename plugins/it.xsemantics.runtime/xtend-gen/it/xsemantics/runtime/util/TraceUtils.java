package it.xsemantics.runtime.util;

import com.google.common.collect.Lists;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleFailedException;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TraceUtils {
  public LinkedList<RuleFailedException> failureAsList(final RuleFailedException e) {
    LinkedList<RuleFailedException> _xblockexpression = null;
    {
      LinkedList<RuleFailedException> _newLinkedList = CollectionLiterals.<RuleFailedException>newLinkedList(e);
      final LinkedList<RuleFailedException> list = _newLinkedList;
      RuleFailedException _previous = e.getPrevious();
      RuleFailedException ex = _previous;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(ex, null);
      boolean _while = _operator_notEquals;
      while (_while) {
        {
          String _message = ex.getMessage();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_message, null);
          if (_operator_notEquals_1) {
            list.add(ex);
          }
          RuleFailedException _previous_1 = ex.getPrevious();
          ex = _previous_1;
        }
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(ex, null);
        _while = _operator_notEquals_2;
      }
      _xblockexpression = (list);
    }
    return _xblockexpression;
  }
  
  public List<String> failureTraceAsStrings(final RuleFailedException e) {
    List<String> _xblockexpression = null;
    {
      StringBuffer _stringBuffer = new StringBuffer("");
      final StringBuffer indent = _stringBuffer;
      LinkedList<RuleFailedException> _failureAsList = this.failureAsList(e);
      final Function1<RuleFailedException,String> _function = new Function1<RuleFailedException,String>() {
          public String apply(final RuleFailedException it) {
            String _xblockexpression = null;
            {
              String _string = indent.toString();
              String _message = it.getMessage();
              String _removeLeadingWhitespace = Strings.removeLeadingWhitespace(_message);
              String _operator_plus = StringExtensions.operator_plus(_string, _removeLeadingWhitespace);
              final String listElem = _operator_plus;
              indent.append(" ");
              _xblockexpression = (listElem);
            }
            return _xblockexpression;
          }
        };
      List<String> _map = ListExtensions.<RuleFailedException, String>map(_failureAsList, _function);
      _xblockexpression = (_map);
    }
    return _xblockexpression;
  }
  
  public String failureTraceAsString(final RuleFailedException e) {
    List<String> _failureTraceAsStrings = this.failureTraceAsStrings(e);
    String _join = IterableExtensions.join(_failureTraceAsStrings, "\n");
    return _join;
  }
  
  public LinkedList<String> traceAsStrings(final RuleApplicationTrace ruleTrace) {
    LinkedList<String> _xblockexpression = null;
    {
      LinkedList<String> _linkedList = new LinkedList<String>();
      final LinkedList<String> result = _linkedList;
      List<Object> _trace = ruleTrace.getTrace();
      for (final Object e : _trace) {
        this.buildTrace(result, e, 0);
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public boolean buildTrace(final List<String> trace, final Object element, final int inc) {
    boolean _xifexpression = false;
    if ((element instanceof RuleApplicationTrace)) {
      List<Object> _trace = ((RuleApplicationTrace) element).getTrace();
      for (final Object e : _trace) {
        int _operator_plus = IntegerExtensions.operator_plus(inc, 1);
        this.buildTrace(trace, e, _operator_plus);
      }
    } else {
      String _increment = this.increment(inc);
      String _string = element.toString();
      String _removeLeadingWhitespace = Strings.removeLeadingWhitespace(_string);
      String _operator_plus_1 = StringExtensions.operator_plus(_increment, _removeLeadingWhitespace);
      boolean _add = trace.add(_operator_plus_1);
      _xifexpression = _add;
    }
    return _xifexpression;
  }
  
  public String traceAsString(final RuleApplicationTrace ruleTrace) {
    LinkedList<String> _traceAsStrings = this.traceAsStrings(ruleTrace);
    String _join = IterableExtensions.join(_traceAsStrings, "\n");
    return _join;
  }
  
  public String increment(final int inc) {
    String _xblockexpression = null;
    {
      StringBuffer _stringBuffer = new StringBuffer();
      StringBuffer buffer = _stringBuffer;
      int i = 0;
      boolean _operator_lessThan = IntegerExtensions.operator_lessThan(i, inc);
      boolean _while = _operator_lessThan;
      while (_while) {
        {
          buffer.append(" ");
          int _operator_plus = IntegerExtensions.operator_plus(i, 1);
          i = _operator_plus;
        }
        boolean _operator_lessThan_1 = IntegerExtensions.operator_lessThan(i, inc);
        _while = _operator_lessThan_1;
      }
      String _string = buffer.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public LinkedList<ErrorInformation> allErrorInformation(final RuleFailedException e) {
    LinkedList<ErrorInformation> _xblockexpression = null;
    {
      List<ErrorInformation> _errorInformations = e.getErrorInformations();
      LinkedList<ErrorInformation> _newLinkedList = Lists.<ErrorInformation>newLinkedList(_errorInformations);
      final LinkedList<ErrorInformation> list = _newLinkedList;
      RuleFailedException _previous = e.getPrevious();
      RuleFailedException ex = _previous;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(ex, null);
      boolean _while = _operator_notEquals;
      while (_while) {
        {
          List<ErrorInformation> _errorInformations_1 = ex.getErrorInformations();
          CollectionExtensions.<ErrorInformation>addAll(list, _errorInformations_1);
          RuleFailedException _previous_1 = ex.getPrevious();
          ex = _previous_1;
        }
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(ex, null);
        _while = _operator_notEquals_1;
      }
      _xblockexpression = (list);
    }
    return _xblockexpression;
  }
  
  public List<ErrorInformation> removeDuplicateErrorInformation(final Iterable<ErrorInformation> errorInformations) {
    List<ErrorInformation> _xblockexpression = null;
    {
      LinkedList<ErrorInformation> _linkedList = new LinkedList<ErrorInformation>();
      final List<ErrorInformation> noDuplicates = _linkedList;
      final Procedure1<ErrorInformation> _function = new Procedure1<ErrorInformation>() {
          public void apply(final ErrorInformation errorInformation) {
            final Function1<ErrorInformation,Boolean> _function = new Function1<ErrorInformation,Boolean>() {
                public Boolean apply(final ErrorInformation it) {
                  boolean _operator_and = false;
                  EObject _source = it.getSource();
                  EObject _source_1 = errorInformation.getSource();
                  boolean _operator_equals = ObjectExtensions.operator_equals(_source, _source_1);
                  if (!_operator_equals) {
                    _operator_and = false;
                  } else {
                    EStructuralFeature _feature = it.getFeature();
                    EStructuralFeature _feature_1 = errorInformation.getFeature();
                    boolean _operator_equals_1 = ObjectExtensions.operator_equals(_feature, _feature_1);
                    _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
                  }
                  return Boolean.valueOf(_operator_and);
                }
              };
            boolean _exists = IterableExtensions.<ErrorInformation>exists(noDuplicates, _function);
            boolean _operator_not = BooleanExtensions.operator_not(_exists);
            if (_operator_not) {
              noDuplicates.add(errorInformation);
            }
          }
        };
      IterableExtensions.<ErrorInformation>forEach(errorInformations, _function);
      _xblockexpression = (noDuplicates);
    }
    return _xblockexpression;
  }
  
  public LinkedList<ErrorInformation> removeNonNodeModelSources(final Iterable<ErrorInformation> errorInformations) {
    final Function1<ErrorInformation,Boolean> _function = new Function1<ErrorInformation,Boolean>() {
        public Boolean apply(final ErrorInformation it) {
          EObject _source = it.getSource();
          ICompositeNode _node = NodeModelUtils.getNode(_source);
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_node, null);
          return Boolean.valueOf(_operator_notEquals);
        }
      };
    Iterable<ErrorInformation> _filter = IterableExtensions.<ErrorInformation>filter(errorInformations, _function);
    LinkedList<ErrorInformation> _newLinkedList = Lists.<ErrorInformation>newLinkedList(_filter);
    return _newLinkedList;
  }
  
  public LinkedList<ErrorInformation> filteredErrorInformation(final RuleFailedException e) {
    LinkedList<ErrorInformation> _allErrorInformation = this.allErrorInformation(e);
    List<ErrorInformation> _removeDuplicateErrorInformation = this.removeDuplicateErrorInformation(_allErrorInformation);
    LinkedList<ErrorInformation> _removeNonNodeModelSources = this.removeNonNodeModelSources(_removeDuplicateErrorInformation);
    return _removeNonNodeModelSources;
  }
  
  public RuleFailedException innermostRuleFailedExceptionWithNodeModelSources(final RuleFailedException e) {
    LinkedList<RuleFailedException> _failureAsList = this.failureAsList(e);
    final Function1<RuleFailedException,Boolean> _function = new Function1<RuleFailedException,Boolean>() {
        public Boolean apply(final RuleFailedException it) {
          LinkedList<ErrorInformation> _filteredErrorInformation = TraceUtils.this.filteredErrorInformation(it);
          boolean _isEmpty = _filteredErrorInformation.isEmpty();
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          return Boolean.valueOf(_operator_not);
        }
      };
    RuleFailedException _findLast = IterableExtensions.<RuleFailedException>findLast(_failureAsList, _function);
    return _findLast;
  }
}

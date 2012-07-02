package it.xsemantics.runtime.util;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TraceUtils {
  public LinkedList<RuleFailedException> failureAsList(final RuleFailedException e) {
    LinkedList<RuleFailedException> _xblockexpression = null;
    {
      final LinkedList<RuleFailedException> list = CollectionLiterals.<RuleFailedException>newLinkedList(e);
      RuleFailedException ex = e.getPrevious();
      boolean _notEquals = (!Objects.equal(ex, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          String _message = ex.getMessage();
          boolean _notEquals_1 = (!Objects.equal(_message, null));
          if (_notEquals_1) {
            list.add(ex);
          }
          RuleFailedException _previous = ex.getPrevious();
          ex = _previous;
        }
        boolean _notEquals_1 = (!Objects.equal(ex, null));
        _while = _notEquals_1;
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
              final String listElem = (_string + _removeLeadingWhitespace);
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
        int _plus = (inc + 1);
        this.buildTrace(trace, e, _plus);
      }
    } else {
      String _increment = this.increment(inc);
      String _string = element.toString();
      String _removeLeadingWhitespace = Strings.removeLeadingWhitespace(_string);
      String _plus_1 = (_increment + _removeLeadingWhitespace);
      boolean _add = trace.add(_plus_1);
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
      boolean _lessThan = (i < inc);
      boolean _while = _lessThan;
      while (_while) {
        {
          buffer.append(" ");
          int _plus = (i + 1);
          i = _plus;
        }
        boolean _lessThan_1 = (i < inc);
        _while = _lessThan_1;
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
      final LinkedList<ErrorInformation> list = Lists.<ErrorInformation>newLinkedList(_errorInformations);
      RuleFailedException ex = e.getPrevious();
      boolean _notEquals = (!Objects.equal(ex, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          List<ErrorInformation> _errorInformations_1 = ex.getErrorInformations();
          Iterables.<ErrorInformation>addAll(list, _errorInformations_1);
          RuleFailedException _previous = ex.getPrevious();
          ex = _previous;
        }
        boolean _notEquals_1 = (!Objects.equal(ex, null));
        _while = _notEquals_1;
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
                  boolean _and = false;
                  EObject _source = it.getSource();
                  EObject _source_1 = errorInformation.getSource();
                  boolean _equals = Objects.equal(_source, _source_1);
                  if (!_equals) {
                    _and = false;
                  } else {
                    EStructuralFeature _feature = it.getFeature();
                    EStructuralFeature _feature_1 = errorInformation.getFeature();
                    boolean _equals_1 = Objects.equal(_feature, _feature_1);
                    _and = (_equals && _equals_1);
                  }
                  return Boolean.valueOf(_and);
                }
              };
            boolean _exists = IterableExtensions.<ErrorInformation>exists(noDuplicates, _function);
            boolean _not = (!_exists);
            if (_not) {
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
          boolean _notEquals = (!Objects.equal(_node, null));
          return Boolean.valueOf(_notEquals);
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
          boolean _not = (!_isEmpty);
          return Boolean.valueOf(_not);
        }
      };
    RuleFailedException _findLast = IterableExtensions.<RuleFailedException>findLast(_failureAsList, _function);
    return _findLast;
  }
}

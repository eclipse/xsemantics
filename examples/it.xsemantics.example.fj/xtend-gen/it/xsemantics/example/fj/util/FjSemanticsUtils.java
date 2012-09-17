package it.xsemantics.example.fj.util;

import it.xsemantics.example.fj.fj.Constant;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.ParamRef;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.This;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FjSemanticsUtils {
  protected boolean _isValue(final Expression exp) {
    return false;
  }
  
  protected boolean _isValue(final Constant exp) {
    return true;
  }
  
  protected boolean _isValue(final New exp) {
    EList<Expression> _args = exp.getArgs();
    final Function1<Expression,Boolean> _function = new Function1<Expression,Boolean>() {
        public Boolean apply(final Expression it) {
          boolean _isValue = FjSemanticsUtils.this.isValue(it);
          return Boolean.valueOf(_isValue);
        }
      };
    boolean _forall = IterableExtensions.<Expression>forall(_args, _function);
    return _forall;
  }
  
  public void replaceThis(final Expression exp, final Expression replacement) {
    List<This> _allContentsOfType = EcoreUtil2.<This>getAllContentsOfType(exp, This.class);
    final Procedure1<This> _function = new Procedure1<This>() {
        public void apply(final This it) {
          EObject _eContainer = it.eContainer();
          EStructuralFeature _eContainingFeature = it.eContainingFeature();
          Expression _copy = EcoreUtil.<Expression>copy(replacement);
          EcoreUtil.replace(_eContainer, _eContainingFeature, it, _copy);
        }
      };
    IterableExtensions.<This>forEach(_allContentsOfType, _function);
  }
  
  public void replaceParams(final Expression exp, final List<Parameter> params, final List<Expression> args) {
    List<ParamRef> _allContentsOfType = EcoreUtil2.<ParamRef>getAllContentsOfType(exp, ParamRef.class);
    final Procedure1<ParamRef> _function = new Procedure1<ParamRef>() {
        public void apply(final ParamRef it) {
          Parameter _parameter = it.getParameter();
          final int paramIndex = params.indexOf(_parameter);
          EObject _eContainer = it.eContainer();
          EStructuralFeature _eContainingFeature = it.eContainingFeature();
          Expression _get = args.get(paramIndex);
          Expression _copy = EcoreUtil.<Expression>copy(_get);
          EcoreUtil.replace(_eContainer, _eContainingFeature, it, _copy);
        }
      };
    IterableExtensions.<ParamRef>forEach(_allContentsOfType, _function);
  }
  
  public boolean isValue(final Expression exp) {
    if (exp instanceof Constant) {
      return _isValue((Constant)exp);
    } else if (exp instanceof New) {
      return _isValue((New)exp);
    } else if (exp != null) {
      return _isValue(exp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(exp).toString());
    }
  }
}

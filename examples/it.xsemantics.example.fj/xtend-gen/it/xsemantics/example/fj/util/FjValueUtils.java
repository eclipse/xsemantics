package it.xsemantics.example.fj.util;

import it.xsemantics.example.fj.fj.Constant;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.New;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FjValueUtils {
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
          boolean _isValue = FjValueUtils.this.isValue(it);
          return Boolean.valueOf(_isValue);
        }
      };
    boolean _forall = IterableExtensions.<Expression>forall(_args, _function);
    return _forall;
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

package it.xsemantics.example.lambda.xsemantics;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Term;
import java.util.List;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LambdaTermUtils {
  public static Term cloneWithoutTypes(final Term term) {
    Term _xblockexpression = null;
    {
      final Term clone = EcoreUtil.<Term>copy(term);
      List<Abstraction> _eAllOfType = EcoreUtil2.<Abstraction>eAllOfType(clone, Abstraction.class);
      final Procedure1<Abstraction> _function = new Procedure1<Abstraction>() {
        public void apply(final Abstraction it) {
          Parameter _param = it.getParam();
          _param.setType(null);
        }
      };
      IterableExtensions.<Abstraction>forEach(_eAllOfType, _function);
      _xblockexpression = (clone);
    }
    return _xblockexpression;
  }
}

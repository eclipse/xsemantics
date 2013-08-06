package it.xsemantics.dsl.typing;

import com.google.inject.Singleton;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import java.util.Arrays;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;

/**
 * Custom version of XbaseTypeProvider for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
@SuppressWarnings("all")
public class XsemanticsTypeProvider extends XbaseBatchTypeProvider {
  public JvmTypeReference getType(final XExpression e) {
    JvmTypeReference _type = this.type(e);
    return _type;
  }
  
  protected JvmTypeReference _type(final XExpression e) {
    JvmTypeReference _type = super.getType(e);
    return _type;
  }
  
  protected JvmTypeReference _type(final RuleInvocation exp) {
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(exp);
    return _createAnyTypeReference;
  }
  
  protected JvmTypeReference _type(final OrExpression exp) {
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(exp);
    return _createAnyTypeReference;
  }
  
  protected JvmTypeReference _type(final Fail exp) {
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(exp);
    return _createAnyTypeReference;
  }
  
  protected JvmTypeReference _type(final EnvironmentAccess exp) {
    JvmTypeReference _type = exp.getType();
    return _type;
  }
  
  public JvmTypeReference type(final XExpression exp) {
    if (exp instanceof EnvironmentAccess) {
      return _type((EnvironmentAccess)exp);
    } else if (exp instanceof Fail) {
      return _type((Fail)exp);
    } else if (exp instanceof OrExpression) {
      return _type((OrExpression)exp);
    } else if (exp instanceof RuleInvocation) {
      return _type((RuleInvocation)exp);
    } else if (exp != null) {
      return _type(exp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(exp).toString());
    }
  }
}

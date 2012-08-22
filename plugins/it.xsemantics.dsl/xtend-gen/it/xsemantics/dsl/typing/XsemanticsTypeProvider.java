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
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

/**
 * Custom version of XbaseTypeProvider for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
@SuppressWarnings("all")
public class XsemanticsTypeProvider extends XbaseTypeProvider {
  protected JvmTypeReference _type(final RuleInvocation exp, final JvmTypeReference rawExpectation, final boolean rawType) {
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(exp);
    return _createAnyTypeReference;
  }
  
  protected JvmTypeReference _type(final OrExpression exp, final JvmTypeReference rawExpectation, final boolean rawType) {
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(exp);
    return _createAnyTypeReference;
  }
  
  protected JvmTypeReference _type(final Fail exp, final JvmTypeReference rawExpectation, final boolean rawType) {
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(exp);
    return _createAnyTypeReference;
  }
  
  protected JvmTypeReference _type(final EnvironmentAccess exp, final JvmTypeReference rawExpectation, final boolean rawType) {
    JvmTypeReference _type = exp.getType();
    return _type;
  }
  
  public JvmTypeReference type(final XExpression featureCall, final JvmTypeReference rawExpectation, final boolean rawType) {
    if (featureCall instanceof XFeatureCall) {
      return _type((XFeatureCall)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof EnvironmentAccess) {
      return _type((EnvironmentAccess)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof Fail) {
      return _type((Fail)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof OrExpression) {
      return _type((OrExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof RuleInvocation) {
      return _type((RuleInvocation)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XAbstractFeatureCall) {
      return _type((XAbstractFeatureCall)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XAbstractWhileExpression) {
      return _type((XAbstractWhileExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XBlockExpression) {
      return _type((XBlockExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XBooleanLiteral) {
      return _type((XBooleanLiteral)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XCastedExpression) {
      return _type((XCastedExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XClosure) {
      return _type((XClosure)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XConstructorCall) {
      return _type((XConstructorCall)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XForLoopExpression) {
      return _type((XForLoopExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XIfExpression) {
      return _type((XIfExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XInstanceOfExpression) {
      return _type((XInstanceOfExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XNullLiteral) {
      return _type((XNullLiteral)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XNumberLiteral) {
      return _type((XNumberLiteral)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XReturnExpression) {
      return _type((XReturnExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XStringLiteral) {
      return _type((XStringLiteral)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XSwitchExpression) {
      return _type((XSwitchExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XThrowExpression) {
      return _type((XThrowExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XTryCatchFinallyExpression) {
      return _type((XTryCatchFinallyExpression)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XTypeLiteral) {
      return _type((XTypeLiteral)featureCall, rawExpectation, rawType);
    } else if (featureCall instanceof XVariableDeclaration) {
      return _type((XVariableDeclaration)featureCall, rawExpectation, rawType);
    } else if (featureCall != null) {
      return _type(featureCall, rawExpectation, rawType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(featureCall, rawExpectation, rawType).toString());
    }
  }
}

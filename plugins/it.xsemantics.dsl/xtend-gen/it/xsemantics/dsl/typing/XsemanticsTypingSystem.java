package it.xsemantics.dsl.typing;

import com.google.inject.Inject;
import it.xsemantics.dsl.typing.TupleType;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

@SuppressWarnings("all")
public class XsemanticsTypingSystem {
  @Inject
  protected ITypeProvider typeProvider;
  
  @Inject
  private XbaseTypeConformanceComputer conformanceComputer;
  
  @Inject
  private TypeReferences typeReferences;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  public JvmTypeReference getType(final EObject element) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof ExpressionInConclusion) {
        final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)element;
        _matched=true;
        XExpression _expression = _expressionInConclusion.getExpression();
        JvmTypeReference _type = this.typeProvider.getType(_expression);
        _switchResult = _type;
      }
    }
    if (!_matched) {
      if (element instanceof RuleParameter) {
        final RuleParameter _ruleParameter = (RuleParameter)element;
        _matched=true;
        JvmFormalParameter _parameter = _ruleParameter.getParameter();
        JvmTypeReference _parameterType = _parameter.getParameterType();
        _switchResult = _parameterType;
      }
    }
    if (!_matched) {
      if (element instanceof RuleInvocationExpression) {
        final RuleInvocationExpression _ruleInvocationExpression = (RuleInvocationExpression)element;
        _matched=true;
        XExpression _expression = _ruleInvocationExpression.getExpression();
        JvmTypeReference _type = this.typeProvider.getType(_expression);
        _switchResult = _type;
      }
    }
    if (!_matched) {
      if (element instanceof InputParameter) {
        final InputParameter _inputParameter = (InputParameter)element;
        _matched=true;
        JvmFormalParameter _parameter = _inputParameter.getParameter();
        JvmTypeReference _parameterType = _parameter.getParameterType();
        _switchResult = _parameterType;
      }
    }
    if (!_matched) {
      if (element instanceof OutputParameter) {
        final OutputParameter _outputParameter = (OutputParameter)element;
        _matched=true;
        JvmTypeReference _jvmTypeReference = _outputParameter.getJvmTypeReference();
        _switchResult = _jvmTypeReference;
      }
    }
    if (!_matched) {
      if (element instanceof XExpression) {
        final XExpression _xExpression = (XExpression)element;
        _matched=true;
        JvmTypeReference _type = this.typeProvider.getType(_xExpression);
        _switchResult = _type;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public TupleType getInputTypes(final Rule rule) {
    TupleType _tupleType = new TupleType();
    final TupleType tupleType = _tupleType;
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(rule);
    final Procedure1<RuleParameter> _function = new Procedure1<RuleParameter>() {
        public void apply(final RuleParameter it) {
          JvmTypeReference _type = XsemanticsTypingSystem.this.getType(it);
          tupleType.add(_type);
        }
      };
    IterableExtensions.<RuleParameter>forEach(_inputParams, _function);
    return tupleType;
  }
  
  public boolean isBooleanPremise(final XExpression expression) {
    boolean _isExpressionToCheck = this.isExpressionToCheck(expression);
    boolean _not = (!_isExpressionToCheck);
    if (_not) {
      return false;
    } else {
      final JvmTypeReference booleanType = this.typeReferences.getTypeForName(Boolean.TYPE, expression);
      final JvmTypeReference operationType = this.typeProvider.getType(expression);
      return this.conformanceComputer.isConformant(booleanType, operationType);
    }
  }
  
  public boolean isExpressionToCheck(final XExpression expression) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _or_2 = false;
    boolean _or_3 = false;
    if ((expression instanceof XFeatureCall)) {
      _or_3 = true;
    } else {
      _or_3 = ((expression instanceof XFeatureCall) || (expression instanceof XBinaryOperation));
    }
    if (_or_3) {
      _or_2 = true;
    } else {
      _or_2 = (_or_3 || (expression instanceof XUnaryOperation));
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      _or_1 = (_or_2 || (expression instanceof XMemberFeatureCall));
    }
    if (_or_1) {
      _or = true;
    } else {
      _or = (_or_1 || (expression instanceof XBooleanLiteral));
    }
    return _or;
  }
}

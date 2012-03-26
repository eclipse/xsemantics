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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
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
    boolean matched = false;
    if (!matched) {
      if (element instanceof ExpressionInConclusion) {
        final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)element;
        matched=true;
        XExpression _expression = _expressionInConclusion.getExpression();
        JvmTypeReference _type = this.typeProvider.getType(_expression);
        _switchResult = _type;
      }
    }
    if (!matched) {
      if (element instanceof RuleParameter) {
        final RuleParameter _ruleParameter = (RuleParameter)element;
        matched=true;
        JvmFormalParameter _parameter = _ruleParameter.getParameter();
        JvmTypeReference _parameterType = _parameter.getParameterType();
        _switchResult = _parameterType;
      }
    }
    if (!matched) {
      if (element instanceof RuleInvocationExpression) {
        final RuleInvocationExpression _ruleInvocationExpression = (RuleInvocationExpression)element;
        matched=true;
        XExpression _expression = _ruleInvocationExpression.getExpression();
        JvmTypeReference _type = this.typeProvider.getType(_expression);
        _switchResult = _type;
      }
    }
    if (!matched) {
      if (element instanceof InputParameter) {
        final InputParameter _inputParameter = (InputParameter)element;
        matched=true;
        JvmFormalParameter _parameter = _inputParameter.getParameter();
        JvmTypeReference _parameterType = _parameter.getParameterType();
        _switchResult = _parameterType;
      }
    }
    if (!matched) {
      if (element instanceof OutputParameter) {
        final OutputParameter _outputParameter = (OutputParameter)element;
        matched=true;
        JvmTypeReference _jvmTypeReference = _outputParameter.getJvmTypeReference();
        _switchResult = _jvmTypeReference;
      }
    }
    if (!matched) {
      if (element instanceof XExpression) {
        final XExpression _xExpression = (XExpression)element;
        matched=true;
        JvmTypeReference _type = this.typeProvider.getType(_xExpression);
        _switchResult = _type;
      }
    }
    if (!matched) {
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
    boolean _operator_not = BooleanExtensions.operator_not(_isExpressionToCheck);
    if (_operator_not) {
      return false;
    } else {
      {
        JvmTypeReference _typeForName = this.typeReferences.getTypeForName(Boolean.TYPE, expression);
        final JvmTypeReference booleanType = _typeForName;
        JvmTypeReference _type = this.typeProvider.getType(expression);
        final JvmTypeReference operationType = _type;
        boolean _isConformant = this.conformanceComputer.isConformant(booleanType, operationType);
        return _isConformant;
      }
    }
  }
  
  public boolean isExpressionToCheck(final XExpression expression) {
    boolean _operator_or = false;
    boolean _operator_or_1 = false;
    boolean _operator_or_2 = false;
    if ((expression instanceof XFeatureCall)) {
      _operator_or_2 = true;
    } else {
      _operator_or_2 = BooleanExtensions.operator_or((expression instanceof XFeatureCall), (expression instanceof XBinaryOperation));
    }
    if (_operator_or_2) {
      _operator_or_1 = true;
    } else {
      _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, (expression instanceof XUnaryOperation));
    }
    if (_operator_or_1) {
      _operator_or = true;
    } else {
      _operator_or = BooleanExtensions.operator_or(_operator_or_1, (expression instanceof XMemberFeatureCall));
    }
    return _operator_or;
  }
}

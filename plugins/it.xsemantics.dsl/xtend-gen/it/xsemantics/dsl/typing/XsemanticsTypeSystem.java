package it.xsemantics.dsl.typing;

import com.google.inject.Inject;
import it.xsemantics.dsl.typing.TupleType;
import it.xsemantics.dsl.typing.XsemanticsTypeSystemGen;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

@SuppressWarnings("all")
public class XsemanticsTypeSystem {
  @Inject
  private XbaseTypeConformanceComputer conformanceComputer;
  
  @Inject
  private TypeReferences typeReferences;
  
  @Inject
  private XsemanticsTypeSystemGen xsemanticsTypeSystemGen;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  public JvmTypeReference getType(final EObject element) {
    Result<JvmTypeReference> _type = this.xsemanticsTypeSystemGen.type(element);
    JvmTypeReference _value = _type.getValue();
    return _value;
  }
  
  public TupleType getInputTypes(final Rule rule) {
    TupleType _tupleType = new TupleType();
    final TupleType tupleType = _tupleType;
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(rule);
    final Procedure1<RuleParameter> _function = new Procedure1<RuleParameter>() {
        public void apply(final RuleParameter it) {
          JvmTypeReference _type = XsemanticsTypeSystem.this.getType(it);
          tupleType.add(_type);
        }
      };
    IterableExtensions.<RuleParameter>forEach(_inputParams, _function);
    return tupleType;
  }
  
  public boolean equals(final TupleType tupleType1, final TupleType tupleType2) {
    int _size = tupleType1.size();
    int _size_1 = tupleType2.size();
    boolean _notEquals = (_size != _size_1);
    if (_notEquals) {
      return false;
    }
    final Iterator<JvmTypeReference> judgmentParametersIt = tupleType1.iterator();
    for (final JvmTypeReference jvmTypeReference : tupleType2) {
      JvmTypeReference _next = judgmentParametersIt.next();
      boolean _equals = this.equals(_next, jvmTypeReference);
      boolean _not = (!_equals);
      if (_not) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(final JudgmentDescription j1, final JudgmentDescription j2) {
    EList<JudgmentParameter> _judgmentParameters = j1.getJudgmentParameters();
    int _size = _judgmentParameters.size();
    EList<JudgmentParameter> _judgmentParameters_1 = j2.getJudgmentParameters();
    int _size_1 = _judgmentParameters_1.size();
    boolean _notEquals = (_size != _size_1);
    if (_notEquals) {
      return false;
    }
    EList<JudgmentParameter> _judgmentParameters_2 = j1.getJudgmentParameters();
    final Iterator<JudgmentParameter> judgmentParametersIt = _judgmentParameters_2.iterator();
    EList<JudgmentParameter> _judgmentParameters_3 = j2.getJudgmentParameters();
    for (final JudgmentParameter jParam2 : _judgmentParameters_3) {
      {
        final JudgmentParameter jParam1 = judgmentParametersIt.next();
        boolean _or = false;
        EClass _eClass = jParam1.eClass();
        EClass _eClass_1 = jParam2.eClass();
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_eClass, _eClass_1);
        if (_notEquals_1) {
          _or = true;
        } else {
          JvmTypeReference _type = this.getType(jParam1);
          JvmTypeReference _type_1 = this.getType(jParam2);
          boolean _equals = this.equals(_type, _type_1);
          boolean _not = (!_equals);
          _or = (_notEquals_1 || _not);
        }
        if (_or) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean equals(final JvmTypeReference t1, final JvmTypeReference t2) {
    boolean _and = false;
    boolean _isConformant = this.isConformant(t1, t2);
    if (!_isConformant) {
      _and = false;
    } else {
      boolean _isConformant_1 = this.isConformant(t2, t1);
      _and = (_isConformant && _isConformant_1);
    }
    return _and;
  }
  
  public boolean isConformant(final JvmTypeReference expected, final JvmTypeReference actual) {
    boolean _isConformant = this.conformanceComputer.isConformant(expected, actual);
    return _isConformant;
  }
  
  public boolean isEObject(final JvmTypeReference type, final EObject context) {
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, context);
    boolean _isConformant = this.isConformant(_typeForName, type);
    return _isConformant;
  }
  
  public boolean isAbstractDeclarativeValidator(final JvmTypeReference type, final EObject context) {
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(AbstractDeclarativeValidator.class, context);
    boolean _isConformant = this.isConformant(_typeForName, type);
    return _isConformant;
  }
  
  public boolean isEStructuralFeature(final JvmTypeReference type, final EObject context) {
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(
      EStructuralFeature.class, context);
    boolean _isConformant = this.isConformant(_typeForName, type);
    return _isConformant;
  }
  
  public boolean isValidSuperSystem(final JvmTypeReference type, final EObject context) {
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(
      XsemanticsRuntimeSystem.class, context);
    boolean _isConformant = this.isConformant(_typeForName, type);
    return _isConformant;
  }
  
  public boolean isBooleanPremise(final XExpression expression) {
    boolean _isExpressionToCheck = this.isExpressionToCheck(expression);
    boolean _not = (!_isExpressionToCheck);
    if (_not) {
      return false;
    } else {
      final JvmTypeReference booleanType = this.typeReferences.getTypeForName(Boolean.TYPE, expression);
      final JvmTypeReference operationType = this.getType(expression);
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

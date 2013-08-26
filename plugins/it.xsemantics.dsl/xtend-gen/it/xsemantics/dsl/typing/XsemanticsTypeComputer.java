package it.xsemantics.dsl.typing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * Custom version of type computer for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
@SuppressWarnings("all")
public class XsemanticsTypeComputer extends XbaseWithAnnotationsTypeComputer {
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof RuleInvocation) {
        final RuleInvocation _ruleInvocation = (RuleInvocation)expression;
        _matched=true;
        this._computeTypes(_ruleInvocation, state);
      }
    }
    if (!_matched) {
      if (expression instanceof OrExpression) {
        final OrExpression _orExpression = (OrExpression)expression;
        _matched=true;
        this._computeTypes(_orExpression, state);
      }
    }
    if (!_matched) {
      if (expression instanceof Fail) {
        final Fail _fail = (Fail)expression;
        _matched=true;
        this._computeTypes(_fail, state);
      }
    }
    if (!_matched) {
      if (expression instanceof ErrorSpecification) {
        final ErrorSpecification _errorSpecification = (ErrorSpecification)expression;
        _matched=true;
        this._computeTypes(_errorSpecification, state);
      }
    }
    if (!_matched) {
      if (expression instanceof EnvironmentAccess) {
        final EnvironmentAccess _environmentAccess = (EnvironmentAccess)expression;
        _matched=true;
        this._computeTypes(_environmentAccess, state);
      }
    }
    if (!_matched) {
      super.computeTypes(expression, state);
    }
  }
  
  public void _computeTypes(final XBlockExpression b, final ITypeComputationState typeState) {
    ITypeComputationState state = typeState;
    boolean _or = false;
    boolean _or_1 = false;
    EObject _eContainer = b.eContainer();
    boolean _equals = Objects.equal(_eContainer, null);
    if (_equals) {
      _or_1 = true;
    } else {
      EObject _eContainer_1 = b.eContainer();
      _or_1 = (_equals || (_eContainer_1 instanceof Rule));
    }
    if (_or_1) {
      _or = true;
    } else {
      EObject _eContainer_2 = b.eContainer();
      _or = (_or_1 || 
        (_eContainer_2 instanceof CheckRule));
    }
    if (_or) {
      ITypeComputationState _withoutRootExpectation = state.withoutRootExpectation();
      state = _withoutRootExpectation;
    }
    EObject _eContainer_3 = b.eContainer();
    if ((_eContainer_3 instanceof RuleWithPremises)) {
      EObject _eContainer_4 = b.eContainer();
      final RuleWithPremises rule = ((RuleWithPremises) _eContainer_4);
      List<RuleParameter> _outputParams = this._xsemanticsUtils.outputParams(rule);
      for (final RuleParameter outputParam : _outputParams) {
        JvmFormalParameter _parameter = outputParam.getParameter();
        state.addLocalToCurrentScope(_parameter);
      }
    }
    List<? extends ITypeExpectation> _expectations = state.getExpectations();
    for (final ITypeExpectation expectation : _expectations) {
      {
        final LightweightTypeReference expectedType = expectation.getExpectedType();
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(expectedType, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _isPrimitiveVoid = expectedType.isPrimitiveVoid();
          _and = (_notEquals && _isPrimitiveVoid);
        }
        if (_and) {
          final EList<XExpression> expressions = b.getExpressions();
          boolean _isEmpty = expressions.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            for (final XExpression expression : expressions) {
              {
                final ITypeComputationState expressionState = state.withoutExpectation();
                expressionState.computeTypes(expression);
                this.addVariableDeclarationsToScope(expression, state);
              }
            }
          }
          LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
          expectation.acceptActualType(_primitiveVoid, ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
        } else {
          final EList<XExpression> expressions_1 = b.getExpressions();
          boolean _isEmpty_1 = expressions_1.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            int _size = expressions_1.size();
            int _minus = (_size - 1);
            List<XExpression> _subList = expressions_1.subList(0, _minus);
            for (final XExpression expression_1 : _subList) {
              {
                final ITypeComputationState expressionState = state.withoutExpectation();
                expressionState.computeTypes(expression_1);
                this.addVariableDeclarationsToScope(expression_1, state);
              }
            }
            final XExpression lastExpression = IterableExtensions.<XExpression>last(expressions_1);
            state.computeTypes(lastExpression);
            this.addVariableDeclarationsToScope(lastExpression, state);
          } else {
            ITypeReferenceOwner _referenceOwner = expectation.getReferenceOwner();
            AnyTypeReference _anyTypeReference = new AnyTypeReference(_referenceOwner);
            expectation.acceptActualType(_anyTypeReference, ConformanceHint.UNCHECKED);
          }
        }
      }
    }
  }
  
  protected void addVariableDeclarationsToScope(final XExpression e, final ITypeComputationState state) {
    boolean _matched = false;
    if (!_matched) {
      if (e instanceof XVariableDeclaration) {
        final XVariableDeclaration _xVariableDeclaration = (XVariableDeclaration)e;
        _matched=true;
        this.addLocalToCurrentScope(_xVariableDeclaration, state);
      }
    }
    if (!_matched) {
      if (e instanceof RuleInvocation) {
        final RuleInvocation _ruleInvocation = (RuleInvocation)e;
        _matched=true;
        EList<XExpression> _expressions = _ruleInvocation.getExpressions();
        for (final XExpression exp : _expressions) {
          if ((exp instanceof XVariableDeclaration)) {
            this.addLocalToCurrentScope(((XVariableDeclaration) exp), state);
          }
        }
      }
    }
  }
  
  protected void _computeTypes(final RuleInvocation e, final ITypeComputationState state) {
    EList<XExpression> _expressions = e.getExpressions();
    for (final XExpression expression : _expressions) {
      {
        final ITypeComputationState expressionState = state.withoutExpectation();
        expressionState.computeTypes(expression);
      }
    }
    LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
    state.acceptActualType(_primitiveVoid);
  }
  
  protected void _computeTypes(final OrExpression e, final ITypeComputationState state) {
    EList<XExpression> _branches = e.getBranches();
    final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
        public void apply(final XExpression it) {
          ITypeComputationState _withoutExpectation = state.withoutExpectation();
          XsemanticsTypeComputer.this.computeTypes(it, _withoutExpectation);
        }
      };
    IterableExtensions.<XExpression>forEach(_branches, _function);
    LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
    state.acceptActualType(_primitiveVoid);
  }
  
  protected void _computeTypes(final Fail e, final ITypeComputationState state) {
    XExpression _error = e.getError();
    if (_error!=null) {
      this.computeTypes(_error, state);
    }
    LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
    state.acceptActualType(_primitiveVoid);
  }
  
  protected void _computeTypes(final ErrorSpecification e, final ITypeComputationState state) {
    XExpression _error = e.getError();
    if (_error!=null) {
      ITypeComputationState _withoutExpectation = state.withoutExpectation();
      this.computeTypes(_error, _withoutExpectation);
    }
    XExpression _source = e.getSource();
    if (_source!=null) {
      ITypeComputationState _withoutExpectation_1 = state.withoutExpectation();
      this.computeTypes(_source, _withoutExpectation_1);
    }
    XExpression _feature = e.getFeature();
    if (_feature!=null) {
      ITypeComputationState _withoutExpectation_2 = state.withoutExpectation();
      this.computeTypes(_feature, _withoutExpectation_2);
    }
    LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
    state.acceptActualType(_primitiveVoid);
  }
  
  protected void _computeTypes(final EnvironmentAccess exp, final ITypeComputationState state) {
    OwnedConverter _converter = state.getConverter();
    JvmTypeReference _type = exp.getType();
    LightweightTypeReference _lightweightReference = _converter.toLightweightReference(_type);
    state.acceptActualType(_lightweightReference);
  }
}

package it.xsemantics.dsl.typing;

import com.google.inject.Singleton;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * Custom version of type computer for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
@SuppressWarnings("all")
public class XsemanticsTypeComputer extends XbaseWithAnnotationsTypeComputer {
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
  
  protected void _computeTypes(final RuleInvocation e, final ITypeComputationState state) {
    EList<RuleInvocationExpression> _expressions = e.getExpressions();
    final Procedure1<RuleInvocationExpression> _function = new Procedure1<RuleInvocationExpression>() {
        public void apply(final RuleInvocationExpression it) {
          XExpression _expression = it.getExpression();
          XsemanticsTypeComputer.this.computeTypes(_expression, state);
        }
      };
    IterableExtensions.<RuleInvocationExpression>forEach(_expressions, _function);
    LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
    state.acceptActualType(_primitiveVoid);
  }
  
  protected void _computeTypes(final OrExpression e, final ITypeComputationState state) {
    EList<XExpression> _branches = e.getBranches();
    final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
        public void apply(final XExpression it) {
          XsemanticsTypeComputer.this.computeTypes(it, state);
        }
      };
    IterableExtensions.<XExpression>forEach(_branches, _function);
    LightweightTypeReference _primitiveVoid = this.getPrimitiveVoid(state);
    state.acceptActualType(_primitiveVoid);
  }
  
  protected void _computeTypes(final Fail e, final ITypeComputationState state) {
    ErrorSpecification _error = e.getError();
    final Procedure1<ErrorSpecification> _function = new Procedure1<ErrorSpecification>() {
        public void apply(final ErrorSpecification it) {
          XExpression _error = it.getError();
          if (_error!=null) {
            XsemanticsTypeComputer.this.computeTypes(_error, state);
          }
          XExpression _source = it.getSource();
          if (_source!=null) {
            XsemanticsTypeComputer.this.computeTypes(_source, state);
          }
          XExpression _feature = it.getFeature();
          if (_feature!=null) {
            XsemanticsTypeComputer.this.computeTypes(_feature, state);
          }
        }
      };
    ObjectExtensions.<ErrorSpecification>operator_doubleArrow(_error, _function);
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

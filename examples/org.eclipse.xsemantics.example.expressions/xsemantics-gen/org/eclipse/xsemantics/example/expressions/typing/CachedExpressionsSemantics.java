/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.expressions.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.example.expressions.expressions.ExpressionsPackage;
import org.eclipse.xsemantics.example.expressions.expressions.Type;
import org.eclipse.xsemantics.example.expressions.expressions.Variable;
import org.eclipse.xsemantics.example.expressions.typing.ExtendedExpressionsSemantics;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * This system caches typing for variables, which involves
 * expensive type inference
 */
@SuppressWarnings("all")
public class CachedExpressionsSemantics extends ExtendedExpressionsSemantics {
  private PolymorphicDispatcher<Result<Type>> vartypeDispatcher;
  
  public CachedExpressionsSemantics() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    vartypeDispatcher = buildPolymorphicDispatcher1(
    	"vartypeImpl", 3, "||-", ":");
  }
  
  @Override
  public Result<Type> vartype(final Variable variable) {
    return vartype(new RuleEnvironment(), null, variable);
  }
  
  @Override
  public Result<Type> vartype(final RuleEnvironment _environment_, final Variable variable) {
    return vartype(_environment_, null, variable);
  }
  
  @Override
  public Result<Type> vartype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Variable variable) {
    return getFromCache("vartype", _environment_, _trace_,
    	new XsemanticsProvider<Result<Type>>(_environment_, _trace_) {
    		public Result<Type> doGet() {
    			try {
    				return vartypeInternal(_environment_, _trace_, variable);
    			} catch (Exception _e_vartype) {
    				return resultForFailure(_e_vartype);
    			}
    		}
    	}, variable);
  }
  
  @Override
  protected Result<Type> vartypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Variable variable) {
    return getFromCache("vartypeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Type>>(_environment_, _trace_) {
    		public Result<Type> doGet() {
    			try {
    				checkParamsNotNull(variable);
    				return vartypeDispatcher.invoke(_environment_, _trace_, variable);
    			} catch (Exception _e_vartype) {
    				sneakyThrowRuleFailedException(_e_vartype);
    				return null;
    			}
    		}
    	}, variable);
  }
  
  @Override
  protected void vartypeThrowException(final String _error, final String _issue, final Exception _ex, final Variable variable, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(variable);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = variable;
    EReference _variable_Expression = ExpressionsPackage.eINSTANCE.getVariable_Expression();
    EStructuralFeature feature = _variable_Expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
  }
}

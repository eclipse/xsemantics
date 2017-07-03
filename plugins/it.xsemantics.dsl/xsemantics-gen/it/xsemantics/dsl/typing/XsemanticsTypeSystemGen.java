/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package it.xsemantics.dsl.typing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class XsemanticsTypeSystemGen extends XsemanticsRuntimeSystem {
  public final static String XEXPRESSIONTYPE = "it.xsemantics.dsl.typing.XExpressionType";
  
  public final static String XVARIABLEDECLARATIONTYPE = "it.xsemantics.dsl.typing.XVariableDeclarationType";
  
  public final static String EXPRESSIONINCONCLUSIONTYPE = "it.xsemantics.dsl.typing.ExpressionInConclusionType";
  
  public final static String RULEPARAMETERTYPE = "it.xsemantics.dsl.typing.RuleParameterType";
  
  public final static String INPUTPARAMETERTYPE = "it.xsemantics.dsl.typing.InputParameterType";
  
  public final static String OUTPUTPARAMETERTYPE = "it.xsemantics.dsl.typing.OutputParameterType";
  
  public final static String JVMFORMALPARAMETERTYPE = "it.xsemantics.dsl.typing.JvmFormalParameterType";
  
  public final static String AUXILIARYDESCRIPTIONTYPE = "it.xsemantics.dsl.typing.AuxiliaryDescriptionType";
  
  @Inject
  @Extension
  private TypeReferences typeReferences;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  private PolymorphicDispatcher<Result<JvmTypeReference>> typeDispatcher;
  
  public XsemanticsTypeSystemGen() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }
  
  public TypeReferences getTypeReferences() {
    return this.typeReferences;
  }
  
  public void setTypeReferences(final TypeReferences typeReferences) {
    this.typeReferences = typeReferences;
  }
  
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
  
  public void setTypeResolver(final IBatchTypeResolver typeResolver) {
    this.typeResolver = typeResolver;
  }
  
  public Result<JvmTypeReference> type(final EObject exp) {
    return type(new RuleEnvironment(), null, exp);
  }
  
  public Result<JvmTypeReference> type(final RuleEnvironment _environment_, final EObject exp) {
    return type(_environment_, null, exp);
  }
  
  public Result<JvmTypeReference> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject exp) {
    try {
    	return typeInternal(_environment_, _trace_, exp);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  protected Result<JvmTypeReference> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject exp) {
    try {
    	checkParamsNotNull(exp);
    	return typeDispatcher.invoke(_environment_, _trace_, exp);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject exp, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XExpression e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleXExpressionType(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("XExpressionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleXExpressionType) {
    	typeThrowException(ruleName("XExpressionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
    		XEXPRESSIONTYPE,
    		e_applyRuleXExpressionType, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleXExpressionType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XExpression e) throws RuleFailedException {
    
    return new Result<JvmTypeReference>(_applyRuleXExpressionType_1(G, e));
  }
  
  private JvmTypeReference _applyRuleXExpressionType_1(final RuleEnvironment G, final XExpression e) throws RuleFailedException {
    IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(e);
    LightweightTypeReference _actualType = _resolveTypes.getActualType(e);
    JvmTypeReference _typeReference = null;
    if (_actualType!=null) {
      _typeReference=_actualType.toTypeReference();
    }
    return _typeReference;
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XVariableDeclaration e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleXVariableDeclarationType(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("XVariableDeclarationType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleXVariableDeclarationType) {
    	typeThrowException(ruleName("XVariableDeclarationType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
    		XVARIABLEDECLARATIONTYPE,
    		e_applyRuleXVariableDeclarationType, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleXVariableDeclarationType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XVariableDeclaration e) throws RuleFailedException {
    
    return new Result<JvmTypeReference>(_applyRuleXVariableDeclarationType_1(G, e));
  }
  
  private JvmTypeReference _applyRuleXVariableDeclarationType_1(final RuleEnvironment G, final XVariableDeclaration e) throws RuleFailedException {
    JvmTypeReference _type = e.getType();
    return _type;
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ExpressionInConclusion e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleExpressionInConclusionType(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ExpressionInConclusionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleExpressionInConclusionType) {
    	typeThrowException(ruleName("ExpressionInConclusionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
    		EXPRESSIONINCONCLUSIONTYPE,
    		e_applyRuleExpressionInConclusionType, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleExpressionInConclusionType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ExpressionInConclusion e) throws RuleFailedException {
    JvmTypeReference type = null; // output parameter
    /* G |- e.expression : type */
    XExpression _expression = e.getExpression();
    Result<JvmTypeReference> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), JvmTypeReference.class);
    type = (JvmTypeReference) result.getFirst();
    
    return new Result<JvmTypeReference>(type);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RuleParameter p) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleRuleParameterType(G, _subtrace_, p);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RuleParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRuleParameterType) {
    	typeThrowException(ruleName("RuleParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
    		RULEPARAMETERTYPE,
    		e_applyRuleRuleParameterType, p, new ErrorInformation[] {new ErrorInformation(p)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleRuleParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RuleParameter p) throws RuleFailedException {
    
    return new Result<JvmTypeReference>(_applyRuleRuleParameterType_1(G, p));
  }
  
  private JvmTypeReference _applyRuleRuleParameterType_1(final RuleEnvironment G, final RuleParameter p) throws RuleFailedException {
    JvmFormalParameter _parameter = p.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    return _parameterType;
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final InputParameter p) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleInputParameterType(G, _subtrace_, p);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInputParameterType) {
    	typeThrowException(ruleName("InputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
    		INPUTPARAMETERTYPE,
    		e_applyRuleInputParameterType, p, new ErrorInformation[] {new ErrorInformation(p)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleInputParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final InputParameter p) throws RuleFailedException {
    
    return new Result<JvmTypeReference>(_applyRuleInputParameterType_1(G, p));
  }
  
  private JvmTypeReference _applyRuleInputParameterType_1(final RuleEnvironment G, final InputParameter p) throws RuleFailedException {
    JvmFormalParameter _parameter = p.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    return _parameterType;
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OutputParameter p) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleOutputParameterType(G, _subtrace_, p);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("OutputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleOutputParameterType) {
    	typeThrowException(ruleName("OutputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
    		OUTPUTPARAMETERTYPE,
    		e_applyRuleOutputParameterType, p, new ErrorInformation[] {new ErrorInformation(p)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleOutputParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OutputParameter p) throws RuleFailedException {
    
    return new Result<JvmTypeReference>(_applyRuleOutputParameterType_1(G, p));
  }
  
  private JvmTypeReference _applyRuleOutputParameterType_1(final RuleEnvironment G, final OutputParameter p) throws RuleFailedException {
    JvmTypeReference _jvmTypeReference = p.getJvmTypeReference();
    return _jvmTypeReference;
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final JvmFormalParameter p) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleJvmFormalParameterType(G, _subtrace_, p);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("JvmFormalParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleJvmFormalParameterType) {
    	typeThrowException(ruleName("JvmFormalParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
    		JVMFORMALPARAMETERTYPE,
    		e_applyRuleJvmFormalParameterType, p, new ErrorInformation[] {new ErrorInformation(p)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleJvmFormalParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final JvmFormalParameter p) throws RuleFailedException {
    
    return new Result<JvmTypeReference>(_applyRuleJvmFormalParameterType_1(G, p));
  }
  
  private JvmTypeReference _applyRuleJvmFormalParameterType_1(final RuleEnvironment G, final JvmFormalParameter p) throws RuleFailedException {
    JvmTypeReference _parameterType = p.getParameterType();
    return _parameterType;
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AuxiliaryDescription aux) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<JvmTypeReference> _result_ = applyRuleAuxiliaryDescriptionType(G, _subtrace_, aux);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AuxiliaryDescriptionType") + stringRepForEnv(G) + " |- " + stringRep(aux) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAuxiliaryDescriptionType) {
    	typeThrowException(ruleName("AuxiliaryDescriptionType") + stringRepForEnv(G) + " |- " + stringRep(aux) + " : " + "JvmTypeReference",
    		AUXILIARYDESCRIPTIONTYPE,
    		e_applyRuleAuxiliaryDescriptionType, aux, new ErrorInformation[] {new ErrorInformation(aux)});
    	return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleAuxiliaryDescriptionType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AuxiliaryDescription aux) throws RuleFailedException {
    JvmTypeReference type = null; // output parameter
    /* { aux.type != null type = aux.type } or type = getTypeForName(Boolean, aux) */
    try {
      JvmTypeReference _type = aux.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      /* aux.type != null */
      if (!_notEquals) {
        sneakyThrowRuleFailedException("aux.type != null");
      }
      JvmTypeReference _type_1 = aux.getType();
      type = _type_1;
    } catch (Exception e) {
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(Boolean.class, aux);
      type = _typeForName;
    }
    return new Result<JvmTypeReference>(type);
  }
}

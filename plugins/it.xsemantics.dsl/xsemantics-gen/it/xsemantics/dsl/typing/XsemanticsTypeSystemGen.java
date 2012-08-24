package it.xsemantics.dsl.typing;

import com.google.inject.Inject;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
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
import org.eclipse.xtext.xbase.typing.ITypeProvider;

public class XsemanticsTypeSystemGen extends XsemanticsRuntimeSystem {
  public final static String XEXPRESSIONTYPE = "it.xsemantics.dsl.typing.rules.XExpressionType";
  
  public final static String XVARIABLEDECLARATIONTYPE = "it.xsemantics.dsl.typing.rules.XVariableDeclarationType";
  
  public final static String RULEINVOCATIONEXPRESSIONTYPE = "it.xsemantics.dsl.typing.rules.RuleInvocationExpressionType";
  
  public final static String EXPRESSIONINCONCLUSIONTYPE = "it.xsemantics.dsl.typing.rules.ExpressionInConclusionType";
  
  public final static String RULEPARAMETERTYPE = "it.xsemantics.dsl.typing.rules.RuleParameterType";
  
  public final static String INPUTPARAMETERTYPE = "it.xsemantics.dsl.typing.rules.InputParameterType";
  
  public final static String OUTPUTPARAMETERTYPE = "it.xsemantics.dsl.typing.rules.OutputParameterType";
  
  @Inject
  private TypeReferences typeReferences;
  
  @Inject
  private ITypeProvider typeProvider;
  
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
  
  public ITypeProvider getTypeProvider() {
    return this.typeProvider;
  }
  
  public void setTypeProvider(final ITypeProvider typeProvider) {
    this.typeProvider = typeProvider;
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
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XExpression e) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleXExpressionType(G, _subtrace_, e);
      addToTrace(_trace_, ruleName("XExpressionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleXExpressionType) {
      throwRuleFailedException(ruleName("XExpressionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
      	XEXPRESSIONTYPE,
      	e_applyRuleXExpressionType, new ErrorInformation(e));
      return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleXExpressionType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XExpression e) throws RuleFailedException {
    
    JvmTypeReference _type = this.typeProvider.getType(e);
    return new Result<JvmTypeReference>(_type);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XVariableDeclaration e) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleXVariableDeclarationType(G, _subtrace_, e);
      addToTrace(_trace_, ruleName("XVariableDeclarationType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleXVariableDeclarationType) {
      throwRuleFailedException(ruleName("XVariableDeclarationType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
      	XVARIABLEDECLARATIONTYPE,
      	e_applyRuleXVariableDeclarationType, new ErrorInformation(e));
      return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleXVariableDeclarationType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final XVariableDeclaration e) throws RuleFailedException {
    
    JvmTypeReference _type = e.getType();
    return new Result<JvmTypeReference>(_type);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RuleInvocationExpression e) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleRuleInvocationExpressionType(G, _subtrace_, e);
      addToTrace(_trace_, ruleName("RuleInvocationExpressionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleRuleInvocationExpressionType) {
      throwRuleFailedException(ruleName("RuleInvocationExpressionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
      	RULEINVOCATIONEXPRESSIONTYPE,
      	e_applyRuleRuleInvocationExpressionType, new ErrorInformation(e));
      return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleRuleInvocationExpressionType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RuleInvocationExpression e) throws RuleFailedException {
    JvmTypeReference type = null; // output parameter
    
    /* G |- e.expression : type */
    XExpression _expression = e.getExpression();
    Result<JvmTypeReference> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), JvmTypeReference.class);
    type = (JvmTypeReference) result.getFirst();
    
    return new Result<JvmTypeReference>(type);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ExpressionInConclusion e) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleExpressionInConclusionType(G, _subtrace_, e);
      addToTrace(_trace_, ruleName("ExpressionInConclusionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleExpressionInConclusionType) {
      throwRuleFailedException(ruleName("ExpressionInConclusionType") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "JvmTypeReference",
      	EXPRESSIONINCONCLUSIONTYPE,
      	e_applyRuleExpressionInConclusionType, new ErrorInformation(e));
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
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleRuleParameterType(G, _subtrace_, p);
      addToTrace(_trace_, ruleName("RuleParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleRuleParameterType) {
      throwRuleFailedException(ruleName("RuleParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
      	RULEPARAMETERTYPE,
      	e_applyRuleRuleParameterType, new ErrorInformation(p));
      return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleRuleParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RuleParameter p) throws RuleFailedException {
    
    JvmFormalParameter _parameter = p.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    return new Result<JvmTypeReference>(_parameterType);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final InputParameter p) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleInputParameterType(G, _subtrace_, p);
      addToTrace(_trace_, ruleName("InputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleInputParameterType) {
      throwRuleFailedException(ruleName("InputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
      	INPUTPARAMETERTYPE,
      	e_applyRuleInputParameterType, new ErrorInformation(p));
      return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleInputParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final InputParameter p) throws RuleFailedException {
    
    JvmFormalParameter _parameter = p.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    return new Result<JvmTypeReference>(_parameterType);
  }
  
  protected Result<JvmTypeReference> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OutputParameter p) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<JvmTypeReference> _result_ = applyRuleOutputParameterType(G, _subtrace_, p);
      addToTrace(_trace_, ruleName("OutputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleOutputParameterType) {
      throwRuleFailedException(ruleName("OutputParameterType") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "JvmTypeReference",
      	OUTPUTPARAMETERTYPE,
      	e_applyRuleOutputParameterType, new ErrorInformation(p));
      return null;
    }
  }
  
  protected Result<JvmTypeReference> applyRuleOutputParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OutputParameter p) throws RuleFailedException {
    
    JvmTypeReference _jvmTypeReference = p.getJvmTypeReference();
    return new Result<JvmTypeReference>(_jvmTypeReference);
  }
}

package it.xsemantics.dsl.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorConstants;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.EmptyEnvironment;
import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentMapping;
import it.xsemantics.dsl.xsemantics.EnvironmentReference;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.compiler.Later;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XsemanticsXbaseCompiler extends XbaseCompiler {
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  @Extension
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  @Extension
  private XsemanticsNodeModelUtils _xsemanticsNodeModelUtils;
  
  @Inject
  @Extension
  private XsemanticsTypeSystem typeSystem;
  
  public ITreeAppendable compile(final XExpression obj, final ITreeAppendable appendable, final JvmTypeReference expectedReturnType, final Set<JvmTypeReference> declaredExceptions) {
    final EObject rule = obj.eContainer();
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof RuleWithPremises) {
        final RuleWithPremises _ruleWithPremises = (RuleWithPremises)rule;
        _matched=true;
        this._xsemanticsGeneratorExtensions.declareVariablesForOutputParams(_ruleWithPremises, appendable);
        JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_ruleWithPremises);
        JvmTypeReference _resultType = this._xsemanticsGeneratorExtensions.resultType(_judgmentDescription);
        this.compileRuleBody(_ruleWithPremises, _resultType, appendable);
        return appendable;
      }
    }
    if (!_matched) {
      if (rule instanceof CheckRule) {
        final CheckRule _checkRule = (CheckRule)rule;
        _matched=true;
        this.compilePremises(_checkRule, appendable);
        String _string = appendable.toString();
        boolean _isEmpty = _string.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          appendable.newLine();
        }
        appendable.append("return new ");
        this._xsemanticsGeneratorExtensions.resultType(_checkRule, appendable);
        appendable.append("(true);");
        return appendable;
      }
    }
    boolean _matched_1 = false;
    if (!_matched_1) {
      if (obj instanceof ErrorSpecification) {
        final ErrorSpecification _errorSpecification = (ErrorSpecification)obj;
        _matched_1=true;
        final String error = this.compileErrorOfErrorSpecification(_errorSpecification, appendable);
        final String source = this.compileSourceOfErrorSpecification(_errorSpecification, appendable);
        final String feature = this.compileFeatureOfErrorSpecification(_errorSpecification, appendable);
        appendable.newLine();
        EObject _eContainer = _errorSpecification.eContainer();
        this.compileFinalPartOfThrowExceptionMethod(_eContainer, appendable, error, source, feature);
        return appendable;
      }
    }
    return super.compile(obj, appendable, expectedReturnType, declaredExceptions);
  }
  
  public void compileRuleBody(final Rule rule, final JvmTypeReference resultType, final ITreeAppendable result) {
    this.compilePremises(rule, result);
    this._xsemanticsGeneratorExtensions.compileReturnResult(rule, resultType, result);
  }
  
  protected void _compilePremises(final Rule rule, final ITreeAppendable result) {
    return;
  }
  
  protected void _compilePremises(final RuleWithPremises rule, final ITreeAppendable result) {
    XExpression _premises = rule.getPremises();
    this.toJavaStatement(_premises, result, false);
  }
  
  protected void _compilePremises(final CheckRule rule, final ITreeAppendable result) {
    XExpression _premises = rule.getPremises();
    this.toJavaStatement(_premises, result, false);
  }
  
  protected ITreeAppendable _compileFinalPartOfThrowExceptionMethod(final EObject o, final ITreeAppendable a, final String error, final String source, final String feature) {
    ITreeAppendable _append = a.append("/* NOT IMPLEMENTED */");
    return _append;
  }
  
  protected ITreeAppendable _compileFinalPartOfThrowExceptionMethod(final JudgmentDescription judgmentDescription, final ITreeAppendable a, final String error, final String source, final String feature) {
    ITreeAppendable _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _throwRuleFailedExceptionMethod = this._xsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
      _builder.append(_throwRuleFailedExceptionMethod, "");
      _builder.append("(");
      _builder.append(error, "");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("_issue, _ex, new ");
      a.append(_builder);
      JvmTypeReference _errorInformationType = this._xsemanticsGeneratorExtensions.errorInformationType(judgmentDescription);
      this.serialize(_errorInformationType, judgmentDescription, a);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      _builder_1.append(source, "");
      _builder_1.append(", ");
      _builder_1.append(feature, "");
      _builder_1.append("));");
      ITreeAppendable _append = a.append(_builder_1);
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _compileFinalPartOfThrowExceptionMethod(final RuleConclusion ruleConclusion, final ITreeAppendable a, final String error, final String source, final String feature) {
    ITreeAppendable _xblockexpression = null;
    {
      final Rule rule = this._xsemanticsUtils.containingRule(ruleConclusion);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _throwRuleFailedExceptionMethod = this._xsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
      _builder.append(_throwRuleFailedExceptionMethod, "");
      _builder.append("(");
      _builder.append(error, "");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _ruleIssueString = this._xsemanticsGeneratorExtensions.ruleIssueString(rule);
      _builder.append(_ruleIssueString, "	");
      _builder.append(", e_");
      CharSequence _applyRuleName = this._xsemanticsGeneratorExtensions.applyRuleName(rule);
      _builder.append(_applyRuleName, "	");
      _builder.append(", new ");
      a.append(_builder);
      JvmTypeReference _errorInformationType = this._xsemanticsGeneratorExtensions.errorInformationType(rule);
      this.serialize(_errorInformationType, rule, a);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      _builder_1.append(source, "");
      _builder_1.append(", ");
      _builder_1.append(feature, "");
      _builder_1.append("));");
      ITreeAppendable _append = a.append(_builder_1);
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _compileFinalPartOfThrowExceptionMethod(final AuxiliaryDescription aux, final ITreeAppendable a, final String error, final String source, final String feature) {
    ITreeAppendable _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _throwRuleFailedExceptionMethod = this._xsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
      _builder.append(_throwRuleFailedExceptionMethod, "");
      _builder.append("(");
      _builder.append(error, "");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("_issue, _ex, new ");
      a.append(_builder);
      JvmTypeReference _errorInformationType = this._xsemanticsGeneratorExtensions.errorInformationType(aux);
      this.serialize(_errorInformationType, aux, a);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      _builder_1.append(source, "");
      _builder_1.append(", ");
      _builder_1.append(feature, "");
      _builder_1.append("));");
      ITreeAppendable _append = a.append(_builder_1);
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public String compileErrorOfErrorSpecification(final ErrorSpecification errorSpecification, final ITreeAppendable b) {
    XExpression _error = errorSpecification.getError();
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(String.class, errorSpecification);
    return this.compileAndAssignToLocalVariable(_error, b, _typeForName, "error");
  }
  
  public String compileSourceOfErrorSpecification(final ErrorSpecification errorSpecification, final ITreeAppendable b) {
    XExpression _source = errorSpecification.getSource();
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(EObject.class, errorSpecification);
    return this.compileAndAssignToLocalVariable(_source, b, _typeForName, "source");
  }
  
  public String compileFeatureOfErrorSpecification(final ErrorSpecification errorSpecification, final ITreeAppendable b) {
    XExpression _feature = errorSpecification.getFeature();
    TypeReferences _typeReferences = this.getTypeReferences();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(EStructuralFeature.class, errorSpecification);
    return this.compileAndAssignToLocalVariable(_feature, b, _typeForName, "feature");
  }
  
  protected String compileAndAssignToLocalVariable(final XExpression expression, final ITreeAppendable b, final JvmTypeReference expectedType, final String proposedVariable) {
    boolean _equals = Objects.equal(expression, null);
    if (_equals) {
      return "null";
    }
    this.toJavaStatement(expression, b, true);
    Object _object = new Object();
    final Object syntheticObject = _object;
    final String varName = b.declareSyntheticVariable(syntheticObject, proposedVariable);
    b.append("\n");
    this.serialize(expectedType, expression, b);
    ITreeAppendable _append = b.append(" ");
    ITreeAppendable _append_1 = _append.append(varName);
    _append_1.append(" = ");
    this.toJavaExpression(expression, b);
    b.append(";");
    return b.getName(syntheticObject);
  }
  
  /**
   * We need to wrap boolean expressions with try-catch-throw RuleFailedException,
   * since in Xsemantics a boolean expression is an assertion
   */
  protected void _toJavaStatement(final XBlockExpression expr, final ITreeAppendable b, final boolean isReferenced) {
    boolean _insideClosure = this.insideClosure(expr);
    if (_insideClosure) {
      boolean _or = false;
      if (isReferenced) {
        _or = true;
      } else {
        boolean _and = false;
        EList<XExpression> _expressions = expr.getExpressions();
        int _size = _expressions.size();
        boolean _equals = (_size == 1);
        if (!_equals) {
          _and = false;
        } else {
          EList<XExpression> _expressions_1 = expr.getExpressions();
          XExpression _get = _expressions_1.get(0);
          boolean _isBooleanPremise = this.typeSystem.isBooleanPremise(_get);
          _and = (_equals && _isBooleanPremise);
        }
        _or = (isReferenced || _and);
      }
      super._toJavaStatement(expr, b, _or);
    } else {
      EList<XExpression> _expressions_2 = expr.getExpressions();
      boolean _isEmpty = _expressions_2.isEmpty();
      if (_isEmpty) {
        return;
      }
      EList<XExpression> _expressions_3 = expr.getExpressions();
      int _size_1 = _expressions_3.size();
      boolean _equals_1 = (_size_1 == 1);
      if (_equals_1) {
        EList<XExpression> _expressions_4 = expr.getExpressions();
        XExpression _get_1 = _expressions_4.get(0);
        this.compileBooleanXExpression(_get_1, b, isReferenced);
        return;
      }
      if (isReferenced) {
        this.declareSyntheticVariable(expr, b);
      }
      final boolean needsBraces = isReferenced;
      if (needsBraces) {
        ITreeAppendable _newLine = b.newLine();
        ITreeAppendable _append = _newLine.append("{");
        _append.increaseIndentation();
        b.openPseudoScope();
      }
      final EList<XExpression> expressions = expr.getExpressions();
      int i = 0;
      for (final XExpression ex : expressions) {
        {
          boolean hasToBeReferenced = isReferenced;
          int _size_2 = expressions.size();
          int _minus = (_size_2 - 1);
          boolean _lessThan = (i < _minus);
          if (_lessThan) {
            hasToBeReferenced = false;
          }
          this.compileBooleanXExpression(ex, b, hasToBeReferenced);
          if (hasToBeReferenced) {
            ITreeAppendable _append_1 = b.append("\n");
            String _varName = this.getVarName(expr, b);
            ITreeAppendable _append_2 = _append_1.append(_varName);
            _append_2.append(" = (");
            this.internalToConvertedExpression(ex, b, null);
            b.append(");");
          }
          int _plus = (i + 1);
          i = _plus;
        }
      }
      if (needsBraces) {
        b.closeScope();
        ITreeAppendable _decreaseIndentation = b.decreaseIndentation();
        ITreeAppendable _newLine_1 = _decreaseIndentation.newLine();
        _newLine_1.append("}");
      }
    }
  }
  
  /**
   * If it's boolean, wraps in an if with throw RuleFailedException
   * 
   * @param expression
   * @param b
   * @param hasToBeReferenced
   */
  public void compileBooleanXExpression(final XExpression expression, final ITreeAppendable b, final boolean toBeReferenced) {
    boolean hasToBeReferenced = toBeReferenced;
    if ((expression instanceof XBlockExpression)) {
      this.internalToJavaStatement(expression, b, hasToBeReferenced);
      return;
    }
    final boolean isBoolean = this.typeSystem.isBooleanPremise(expression);
    if (isBoolean) {
      hasToBeReferenced = true;
    }
    this.internalToJavaStatement(expression, b, hasToBeReferenced);
    if (isBoolean) {
      this.generateCommentWithOriginalCode(expression, b);
      this.newLine(b);
      b.append("if (!");
      this.toJavaExpression(expression, b);
      b.append(") {");
      b.increaseIndentation();
      this.newLine(b);
      this.throwNewRuleFailedException(expression, b);
      this.closeBracket(b);
    }
  }
  
  /**
   * When we invoke an auxiliary function we must also add the
   * trace argument.
   */
  protected void appendFeatureCall(final XAbstractFeatureCall call, final ITreeAppendable b) {
    final JvmIdentifiableElement feature = call.getFeature();
    final AuxiliaryDescription auxiliaryDescription = this._xsemanticsGeneratorExtensions.associatedAuxiliaryDescription(feature);
    boolean _equals = Objects.equal(auxiliaryDescription, null);
    if (_equals) {
      super.appendFeatureCall(call, b);
      return;
    }
    final CharSequence name = this._xsemanticsGeneratorExtensions.entryPointInternalMethodName(auxiliaryDescription);
    ITreeAppendable _trace = b.trace(call, Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0);
    _trace.append(name);
    if ((feature instanceof JvmExecutable)) {
      b.append("(");
      CharSequence _ruleApplicationTraceName = this._xsemanticsGeneratorExtensions.ruleApplicationTraceName();
      b.append(_ruleApplicationTraceName);
      final EList<XExpression> arguments = call.getActualArguments();
      boolean _isEmpty = arguments.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        b.append(", ");
        XExpression _xifexpression = null;
        if ((call instanceof XMemberFeatureCall)) {
          XExpression _memberCallTarget = ((XMemberFeatureCall) call).getMemberCallTarget();
          _xifexpression = _memberCallTarget;
        } else {
          _xifexpression = null;
        }
        final XExpression receiver = _xifexpression;
        boolean _or = false;
        boolean _equals_1 = Objects.equal(receiver, null);
        if (_equals_1) {
          _or = true;
        } else {
          XExpression _get = arguments.get(0);
          boolean _notEquals = (!Objects.equal(_get, receiver));
          _or = (_equals_1 || _notEquals);
        }
        final boolean shouldBreakFirstArgument = _or;
        this.appendArguments(arguments, b, shouldBreakFirstArgument);
      }
      b.append(")");
    }
  }
  
  public void throwNewRuleFailedException(final XExpression expression, final ITreeAppendable b) {
    String _sneakyThrowRuleFailedException = this._xsemanticsGeneratorExtensions.sneakyThrowRuleFailedException();
    b.append(_sneakyThrowRuleFailedException);
    b.append("(");
    this.generateStringWithOriginalCode(expression, b);
    b.append(");");
  }
  
  protected void _doInternalToJavaStatement(final XExpression e, final ITreeAppendable b, final boolean isReferenced) {
    super.doInternalToJavaStatement(e, b, isReferenced);
  }
  
  protected void _internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable) {
    super.internalToConvertedExpression(obj, appendable);
  }
  
  protected void _doInternalToJavaStatement(final EnvironmentAccess environmentAccess, final ITreeAppendable b, final boolean isReferenced) {
    this.generateCommentWithOriginalCode(environmentAccess, b);
    XExpression _argument = environmentAccess.getArgument();
    this.toJavaStatement(_argument, b, true);
    if (isReferenced) {
      final Later _function = new Later() {
          public void exec(final ITreeAppendable app) {
            XsemanticsXbaseCompiler.this.compileEnvironmentAccess(environmentAccess, app);
          }
        };
      this.declareFreshLocalVariable(environmentAccess, b, _function);
    } else {
      this.newLine(b);
      this.compileEnvironmentAccess(environmentAccess, b);
      b.append(";");
    }
  }
  
  protected void _doInternalToJavaStatement(final OrExpression orExpression, final ITreeAppendable b, final boolean isReferenced) {
    this.generateCommentWithOriginalCode(orExpression, b);
    EList<XExpression> _branches = orExpression.getBranches();
    final XExpression left = _branches.get(0);
    EList<XExpression> _branches_1 = orExpression.getBranches();
    final XExpression right = _branches_1.get(1);
    this.tryStmnt(b);
    this.compileBooleanXExpression(left, b, false);
    this.catchStmnt(b, orExpression);
    this.compileBooleanXExpression(right, b, false);
    this.closeBracket(b);
  }
  
  protected void _doInternalToJavaStatement(final Fail fail, final ITreeAppendable b, final boolean isReference) {
    this.generateCommentWithOriginalCode(fail, b);
    final XExpression errorSpecification = fail.getError();
    boolean _equals = Objects.equal(errorSpecification, null);
    if (_equals) {
      this.newLine(b);
      b.append("throwForExplicitFail();");
    } else {
      this.toJavaStatement(errorSpecification, b, isReference);
    }
  }
  
  protected void _doInternalToJavaStatement(final ErrorSpecification errorSpecification, final ITreeAppendable b, final boolean isReference) {
    final String errorMessageVar = this.compileErrorOfErrorSpecification(errorSpecification, b);
    final String sourceVar = this.compileSourceOfErrorSpecification(errorSpecification, b);
    final String featureVar = this.compileFeatureOfErrorSpecification(errorSpecification, b);
    this.newLine(b);
    b.append("throwForExplicitFail(");
    b.append(errorMessageVar);
    this.comma(b);
    b.append("new ");
    JvmTypeReference _errorInformationType = this._xsemanticsGeneratorExtensions.errorInformationType(errorSpecification);
    JvmType _type = _errorInformationType.getType();
    b.append(_type);
    b.append("(");
    b.append(sourceVar);
    this.comma(b);
    b.append(featureVar);
    b.append(")");
    b.append(");");
  }
  
  protected void _doInternalToJavaStatement(final RuleInvocation ruleInvocation, final ITreeAppendable b, final boolean isReferenced) {
    this.generateCommentWithOriginalCode(ruleInvocation, b);
    String _judgmentSymbol = ruleInvocation.getJudgmentSymbol();
    EList<String> _relationSymbols = ruleInvocation.getRelationSymbols();
    final JudgmentDescription judgmentDescription = this._xsemanticsUtils.judgmentDescription(ruleInvocation, _judgmentSymbol, _relationSymbols);
    final EList<XExpression> ruleInvocationExpressions = ruleInvocation.getExpressions();
    this.ruleInvocationExpressionsToJavaStatements(b, ruleInvocationExpressions);
    EnvironmentSpecification _environment = ruleInvocation.getEnvironment();
    this.generateEnvironmentSpecificationAsStatements(_environment, b);
    final boolean hasOutputParams = this._xsemanticsUtils.hasOutputParams(ruleInvocation);
    this.newLine(b);
    String resultVariable = "";
    if (hasOutputParams) {
      this._xsemanticsGeneratorExtensions.resultType(judgmentDescription, b);
      this.space(b);
      String _generateResultVariable = this.generateResultVariable(ruleInvocation, b);
      resultVariable = _generateResultVariable;
      this.assign(b);
    }
    CharSequence _entryPointInternalMethodName = this._xsemanticsGeneratorExtensions.entryPointInternalMethodName(judgmentDescription);
    String _string = _entryPointInternalMethodName.toString();
    b.append(_string);
    b.append("(");
    EnvironmentSpecification _environment_1 = ruleInvocation.getEnvironment();
    this.generateEnvironmentSpecificationAsExpression(_environment_1, b);
    this.comma(b);
    CharSequence _additionalArgsForRuleInvocation = this._xsemanticsGeneratorExtensions.additionalArgsForRuleInvocation(ruleInvocation);
    String _string_1 = _additionalArgsForRuleInvocation.toString();
    b.append(_string_1);
    this.comma(b);
    this.ruleInvocationExpressionsToJavaExpressions(b, ruleInvocation);
    b.append(");");
    if (hasOutputParams) {
      this.reassignResults(b, ruleInvocation, resultVariable, true);
    }
  }
  
  protected void ruleInvocationExpressionsToJavaStatements(final ITreeAppendable b, final List<XExpression> ruleInvocationExpressions) {
    for (final XExpression ruleInvocationExpression : ruleInvocationExpressions) {
      this.toJavaStatement(ruleInvocationExpression, b, true);
    }
  }
  
  protected void generateEnvironmentSpecificationAsStatements(final EnvironmentSpecification environmentSpecification, final ITreeAppendable b) {
    if ((environmentSpecification instanceof EnvironmentMapping)) {
      final EnvironmentMapping mapping = ((EnvironmentMapping) environmentSpecification);
      XExpression _key = mapping.getKey();
      this.toJavaStatement(_key, b, true);
      XExpression _value = mapping.getValue();
      this.toJavaStatement(_value, b, true);
    } else {
      if ((environmentSpecification instanceof EnvironmentComposition)) {
        final EnvironmentComposition composition = ((EnvironmentComposition) environmentSpecification);
        EnvironmentSpecification _currentEnvironment = composition.getCurrentEnvironment();
        this.generateEnvironmentSpecificationAsStatements(_currentEnvironment, b);
        EnvironmentSpecification _subEnvironment = composition.getSubEnvironment();
        this.generateEnvironmentSpecificationAsStatements(_subEnvironment, b);
      }
    }
  }
  
  public void generateEnvironmentSpecificationAsExpression(final EnvironmentSpecification environmentSpecification, final ITreeAppendable b) {
    if ((environmentSpecification instanceof EmptyEnvironment)) {
      String _emptyEnvironmentInvocation = this._xsemanticsGeneratorExtensions.emptyEnvironmentInvocation();
      b.append(_emptyEnvironmentInvocation);
    } else {
      if ((environmentSpecification instanceof EnvironmentReference)) {
        Environment _environment = ((EnvironmentReference) environmentSpecification).getEnvironment();
        String _name = _environment.getName();
        b.append(_name);
      }
    }
    if ((environmentSpecification instanceof EnvironmentMapping)) {
      final EnvironmentMapping mapping = ((EnvironmentMapping) environmentSpecification);
      String _environmentEntryInvocation = this._xsemanticsGeneratorExtensions.environmentEntryInvocation();
      b.append(_environmentEntryInvocation);
      b.append("(");
      XExpression _key = mapping.getKey();
      this.toJavaExpression(_key, b);
      this.comma(b);
      XExpression _value = mapping.getValue();
      this.toJavaExpression(_value, b);
      b.append(")");
    } else {
      if ((environmentSpecification instanceof EnvironmentComposition)) {
        final EnvironmentComposition composition = ((EnvironmentComposition) environmentSpecification);
        String _environmentCompositionInvocation = this._xsemanticsGeneratorExtensions.environmentCompositionInvocation();
        b.append(_environmentCompositionInvocation);
        b.append("(");
        b.increaseIndentation();
        this.newLine(b);
        EnvironmentSpecification _currentEnvironment = composition.getCurrentEnvironment();
        this.generateEnvironmentSpecificationAsExpression(_currentEnvironment, b);
        this.comma(b);
        EnvironmentSpecification _subEnvironment = composition.getSubEnvironment();
        this.generateEnvironmentSpecificationAsExpression(_subEnvironment, b);
        b.decreaseIndentation();
        this.newLine(b);
        b.append(")");
      }
    }
  }
  
  protected String generateResultVariable(final RuleInvocation ruleInvocation, final ITreeAppendable b) {
    final String declareResultVariable = this.declareResultVariable(ruleInvocation, b);
    b.append(declareResultVariable);
    return declareResultVariable;
  }
  
  public String declareResultVariable(final RuleInvocation ruleInvocation, final ITreeAppendable b) {
    return b.declareSyntheticVariable(ruleInvocation, "result");
  }
  
  protected void ruleInvocationExpressionsToJavaExpressions(final ITreeAppendable b, final RuleInvocation ruleInvocation) {
    List<XExpression> _inputArgsExpressions = this._xsemanticsUtils.inputArgsExpressions(ruleInvocation);
    this.ruleInvocationExpressionsToJavaExpressions(b, _inputArgsExpressions);
  }
  
  protected void ruleInvocationExpressionsToJavaExpressions(final ITreeAppendable b, final List<XExpression> inputArgsExpressions) {
    final Iterator<XExpression> expIt = inputArgsExpressions.iterator();
    boolean _hasNext = expIt.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        XExpression _next = expIt.next();
        this.toJavaExpression(_next, b);
        boolean _hasNext_1 = expIt.hasNext();
        if (_hasNext_1) {
          this.comma(b);
        }
      }
      boolean _hasNext_1 = expIt.hasNext();
      _while = _hasNext_1;
    }
  }
  
  protected void reassignResults(final ITreeAppendable b, final RuleInvocation ruleInvocation, final String resultVariable, final boolean checkAssignable) {
    final List<XExpression> expIt = this._xsemanticsUtils.outputArgsExpressions(ruleInvocation);
    boolean _isEmpty = expIt.isEmpty();
    if (_isEmpty) {
      return;
    }
    this.newLine(b);
    Iterable<String> _resultGetMethods = XsemanticsGeneratorConstants.getResultGetMethods();
    final Iterator<String> getMethods = _resultGetMethods.iterator();
    for (final XExpression expression : expIt) {
      {
        final JvmTypeReference expressionType = this.typeSystem.getType(expression);
        final String getMethod = getMethods.next();
        if (checkAssignable) {
          b.append("checkAssignableTo");
          b.append("(");
          String _plus = (resultVariable + ".");
          String _plus_1 = (_plus + getMethod);
          b.append(_plus_1);
          this.comma(b);
          this.generateJavaClassReference(expressionType, expression, b);
          b.append(");");
          this.newLine(b);
        }
        if ((expression instanceof XVariableDeclaration)) {
          final XVariableDeclaration varDecl = ((XVariableDeclaration) expression);
          String _name = b.getName(varDecl);
          b.append(_name);
        } else {
          this.toJavaExpression(expression, b);
        }
        this.assign(b);
        b.append("(");
        this.serialize(expressionType, expression, b);
        b.append(")");
        this.space(b);
        String _plus_2 = (resultVariable + ".");
        String _plus_3 = (_plus_2 + getMethod);
        b.append(_plus_3);
        b.append(";");
        this.newLine(b);
      }
    }
  }
  
  protected void _internalToConvertedExpression(final EnvironmentAccess environmentAccess, final ITreeAppendable b) {
    String _name = b.getName(environmentAccess);
    b.append(_name);
  }
  
  public void generateCommentWithOriginalCode(final EObject modelElement, final ITreeAppendable b) {
    ITreeAppendable _append = b.append("\n");
    ITreeAppendable _append_1 = _append.append("/* ");
    String _programText = this._xsemanticsNodeModelUtils.getProgramText(modelElement);
    ITreeAppendable _append_2 = _append_1.append(_programText);
    _append_2.append(" */");
  }
  
  public void generateStringWithOriginalCode(final EObject modelElement, final ITreeAppendable b) {
    ITreeAppendable _append = b.append("\"");
    String _programText = this._xsemanticsNodeModelUtils.getProgramText(modelElement);
    String _javaString = this._xsemanticsGeneratorExtensions.javaString(_programText);
    ITreeAppendable _append_1 = _append.append(_javaString);
    _append_1.append("\"");
  }
  
  public void compileEnvironmentAccess(final EnvironmentAccess environmentAccess, final ITreeAppendable b) {
    String _environmentAccessMethod = this._xsemanticsGeneratorExtensions.environmentAccessMethod();
    b.append(_environmentAccessMethod);
    b.append("(");
    Environment _environment = environmentAccess.getEnvironment();
    String _name = _environment.getName();
    b.append(_name);
    this.comma(b);
    XExpression _argument = environmentAccess.getArgument();
    this.toJavaExpression(_argument, b);
    this.comma(b);
    JvmTypeReference _type = environmentAccess.getType();
    this.generateJavaClassReference(_type, environmentAccess, b);
    b.append(")");
  }
  
  public void comma(final ITreeAppendable b) {
    b.append(", ");
  }
  
  public void newLine(final ITreeAppendable b) {
    b.append("\n");
  }
  
  public void space(final ITreeAppendable b) {
    b.append(" ");
  }
  
  public void assign(final ITreeAppendable b) {
    this.space(b);
    b.append("=");
    this.space(b);
  }
  
  public void closeBracket(final ITreeAppendable b) {
    b.decreaseIndentation();
    this.newLine(b);
    b.append("}");
  }
  
  public void tryStmnt(final ITreeAppendable b) {
    this.newLine(b);
    b.append("try {");
    b.increaseIndentation();
  }
  
  /**
   * Also declares a RuleFailedException variable for the passed expressions
   * 
   * @param b
   * @param expression
   * @return
   */
  public String catchStmnt(final ITreeAppendable b, final XExpression expression) {
    b.decreaseIndentation();
    this.newLine(b);
    b.append("} catch (");
    JvmTypeReference _exceptionType = this._xsemanticsGeneratorExtensions.exceptionType(expression);
    JvmType _type = _exceptionType.getType();
    b.append(_type);
    b.append(" ");
    final String declareExceptionVariable = this.declareExceptionVariable(expression, b);
    b.append(declareExceptionVariable);
    b.append(") {");
    b.increaseIndentation();
    return declareExceptionVariable;
  }
  
  public String declareExceptionVariable(final XExpression expression, final ITreeAppendable b) {
    return b.declareSyntheticVariable(expression, "e");
  }
  
  public void generateJavaClassReference(final JvmTypeReference expressionType, final XExpression expression, final ITreeAppendable b) {
    JvmType _type = expressionType.getType();
    b.append(_type);
    b.append(".class");
  }
  
  public boolean insideClosure(final XBlockExpression expr) {
    EObject _eContainer = expr.eContainer();
    return (_eContainer instanceof XClosure);
  }
  
  public void compilePremises(final EObject rule, final ITreeAppendable result) {
    if (rule instanceof RuleWithPremises) {
      _compilePremises((RuleWithPremises)rule, result);
      return;
    } else if (rule instanceof CheckRule) {
      _compilePremises((CheckRule)rule, result);
      return;
    } else if (rule instanceof Rule) {
      _compilePremises((Rule)rule, result);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rule, result).toString());
    }
  }
  
  public ITreeAppendable compileFinalPartOfThrowExceptionMethod(final EObject aux, final ITreeAppendable a, final String error, final String source, final String feature) {
    if (aux instanceof AuxiliaryDescription) {
      return _compileFinalPartOfThrowExceptionMethod((AuxiliaryDescription)aux, a, error, source, feature);
    } else if (aux instanceof JudgmentDescription) {
      return _compileFinalPartOfThrowExceptionMethod((JudgmentDescription)aux, a, error, source, feature);
    } else if (aux instanceof RuleConclusion) {
      return _compileFinalPartOfThrowExceptionMethod((RuleConclusion)aux, a, error, source, feature);
    } else if (aux != null) {
      return _compileFinalPartOfThrowExceptionMethod(aux, a, error, source, feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(aux, a, error, source, feature).toString());
    }
  }
  
  public void doInternalToJavaStatement(final XExpression environmentAccess, final ITreeAppendable b, final boolean isReferenced) {
    if (environmentAccess instanceof EnvironmentAccess) {
      _doInternalToJavaStatement((EnvironmentAccess)environmentAccess, b, isReferenced);
      return;
    } else if (environmentAccess instanceof ErrorSpecification) {
      _doInternalToJavaStatement((ErrorSpecification)environmentAccess, b, isReferenced);
      return;
    } else if (environmentAccess instanceof Fail) {
      _doInternalToJavaStatement((Fail)environmentAccess, b, isReferenced);
      return;
    } else if (environmentAccess instanceof OrExpression) {
      _doInternalToJavaStatement((OrExpression)environmentAccess, b, isReferenced);
      return;
    } else if (environmentAccess instanceof RuleInvocation) {
      _doInternalToJavaStatement((RuleInvocation)environmentAccess, b, isReferenced);
      return;
    } else if (environmentAccess != null) {
      _doInternalToJavaStatement(environmentAccess, b, isReferenced);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(environmentAccess, b, isReferenced).toString());
    }
  }
  
  public void internalToConvertedExpression(final XExpression environmentAccess, final ITreeAppendable b) {
    if (environmentAccess instanceof EnvironmentAccess) {
      _internalToConvertedExpression((EnvironmentAccess)environmentAccess, b);
      return;
    } else if (environmentAccess != null) {
      _internalToConvertedExpression(environmentAccess, b);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(environmentAccess, b).toString());
    }
  }
}

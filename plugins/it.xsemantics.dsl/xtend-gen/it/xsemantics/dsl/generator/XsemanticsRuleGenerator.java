package it.xsemantics.dsl.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class XsemanticsRuleGenerator {
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsXbaseCompiler xbaseCompiler;
  
  @Inject
  private XsemanticsErrorSpecificationGenerator errSpecGenerator;
  
  public CharSequence compileDispatcherImplMethod(final Rule rule, final ImportManager importManager) {
    CharSequence _xblockexpression = null;
    {
      final String resultType = this._xsemanticsGeneratorExtensions.resultType(rule, importManager);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected ");
      _builder.append(resultType, "");
      _builder.append(" ");
      JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
      CharSequence _polymorphicDispatcherImpl = this._xsemanticsGeneratorExtensions.polymorphicDispatcherImpl(_judgmentDescription);
      _builder.append(_polymorphicDispatcherImpl, "");
      _builder.append("(");
      CharSequence _additionalParamsDeclaration = this._xsemanticsGeneratorExtensions.additionalParamsDeclaration(rule, importManager);
      _builder.append(_additionalParamsDeclaration, "");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _inputParameters = this._xsemanticsGeneratorExtensions.inputParameters(rule, importManager);
      _builder.append(_inputParameters, "		");
      _builder.append(") ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("throws ");
      CharSequence _ruleFailedExceptionClass = this._xsemanticsGeneratorExtensions.ruleFailedExceptionClass(importManager);
      _builder.append(_ruleFailedExceptionClass, "		");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t\t");
      CharSequence _ruleApplicationSubtraceDeclaration = this._xsemanticsGeneratorExtensions.ruleApplicationSubtraceDeclaration(importManager);
      _builder.append(_ruleApplicationSubtraceDeclaration, "		");
      _builder.append(" = ");
      CharSequence _ruleApplicationTraceName = this._xsemanticsGeneratorExtensions.ruleApplicationTraceName();
      CharSequence _newTraceMethod = this._xsemanticsGeneratorExtensions.newTraceMethod(_ruleApplicationTraceName);
      _builder.append(_newTraceMethod, "		");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append(resultType, "		");
      _builder.append(" _result_ = ");
      CharSequence _applyRuleName = this._xsemanticsGeneratorExtensions.applyRuleName(rule);
      _builder.append(_applyRuleName, "		");
      _builder.append("(");
      CharSequence _additionalArgsForRule = this._xsemanticsGeneratorExtensions.additionalArgsForRule(rule);
      _builder.append(_additionalArgsForRule, "		");
      _builder.append(", ");
      String _inputParameterNames = this._xsemanticsGeneratorExtensions.inputParameterNames(rule);
      _builder.append(_inputParameterNames, "		");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      CharSequence _ruleApplicationTraceName_1 = this._xsemanticsGeneratorExtensions.ruleApplicationTraceName();
      String _traceStringForRule = this._xsemanticsGeneratorExtensions.traceStringForRule(rule);
      CharSequence _addToTraceMethod = this._xsemanticsGeneratorExtensions.addToTraceMethod(_ruleApplicationTraceName_1, _traceStringForRule);
      _builder.append(_addToTraceMethod, "		");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      CharSequence _ruleApplicationTraceName_2 = this._xsemanticsGeneratorExtensions.ruleApplicationTraceName();
      CharSequence _ruleApplicationSubtraceName = this._xsemanticsGeneratorExtensions.ruleApplicationSubtraceName();
      CharSequence _addAsSubtraceMethod = this._xsemanticsGeneratorExtensions.addAsSubtraceMethod(_ruleApplicationTraceName_2, _ruleApplicationSubtraceName);
      _builder.append(_addAsSubtraceMethod, "		");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return _result_;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} catch (");
      CharSequence _exceptionClass = this._xsemanticsGeneratorExtensions.exceptionClass(importManager);
      _builder.append(_exceptionClass, "	");
      _builder.append(" e_");
      CharSequence _applyRuleName_1 = this._xsemanticsGeneratorExtensions.applyRuleName(rule);
      _builder.append(_applyRuleName_1, "	");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      CharSequence _compileFinalThrow = this.compileFinalThrow(rule, importManager);
      _builder.append(_compileFinalThrow, "		");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence compileApplyMethod(final Rule rule, final ImportManager importManager) {
    CharSequence _xblockexpression = null;
    {
      final String resultType = this._xsemanticsGeneratorExtensions.resultType(rule, importManager);
      final FakeTreeAppendable appendable = this.createAndConfigureAppendable(rule, importManager);
      this.declareVariablesForOutputParams(rule, appendable);
      this.compileRuleBody(rule, resultType, appendable);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("protected ");
      _builder.append(resultType, "");
      _builder.append(" applyRule");
      String _javaClassName = this._xsemanticsGeneratorExtensions.toJavaClassName(rule);
      _builder.append(_javaClassName, "");
      _builder.append("(");
      CharSequence _additionalParamsDeclaration = this._xsemanticsGeneratorExtensions.additionalParamsDeclaration(rule, importManager);
      _builder.append(_additionalParamsDeclaration, "");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _inputParameters = this._xsemanticsGeneratorExtensions.inputParameters(rule, importManager);
      _builder.append(_inputParameters, "		");
      _builder.append(") ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("throws ");
      CharSequence _ruleFailedExceptionClass = this._xsemanticsGeneratorExtensions.ruleFailedExceptionClass(importManager);
      _builder.append(_ruleFailedExceptionClass, "		");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(appendable, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence compileFinalThrow(final Rule rule, final ImportManager importManager) {
    CharSequence _xifexpression = null;
    RuleConclusion _conclusion = rule.getConclusion();
    ErrorSpecification _error = _conclusion.getError();
    boolean _notEquals = (!Objects.equal(_error, null));
    if (_notEquals) {
      CharSequence _xblockexpression = null;
      {
        RuleConclusion _conclusion_1 = rule.getConclusion();
        final ErrorSpecification errorSpecification = _conclusion_1.getError();
        final FakeTreeAppendable b = this.createAndConfigureAppendable(rule, importManager);
        final String error = this.errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, b);
        final String source = this.errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, b);
        final String feature = this.errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, b);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(b, "");
        _builder.newLineIfNotEmpty();
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
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new ");
        CharSequence _errorInformationClass = this._xsemanticsGeneratorExtensions.errorInformationClass(importManager);
        _builder.append(_errorInformationClass, "	");
        _builder.append("(");
        _builder.append(source, "	");
        _builder.append(", ");
        _builder.append(feature, "	");
        _builder.append("))");
        _xblockexpression = (_builder);
      }
      _xifexpression = _xblockexpression;
    } else {
      CharSequence _xifexpression_1 = null;
      JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
      ErrorSpecification _error_1 = _judgmentDescription.getError();
      boolean _notEquals_1 = (!Objects.equal(_error_1, null));
      if (_notEquals_1) {
        StringConcatenation _builder = new StringConcatenation();
        JudgmentDescription _judgmentDescription_1 = this._xsemanticsUtils.judgmentDescription(rule);
        CharSequence _throwExpectionMethod = this._xsemanticsGeneratorExtensions.throwExpectionMethod(_judgmentDescription_1);
        _builder.append(_throwExpectionMethod, "");
        _builder.append("(");
        String _ruleIssueString = this._xsemanticsGeneratorExtensions.ruleIssueString(rule);
        _builder.append(_ruleIssueString, "");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("e_");
        CharSequence _applyRuleName = this._xsemanticsGeneratorExtensions.applyRuleName(rule);
        _builder.append(_applyRuleName, "	");
        _builder.append(", ");
        String _inputParameterNames = this._xsemanticsGeneratorExtensions.inputParameterNames(rule);
        _builder.append(_inputParameterNames, "	");
        _builder.append(")");
        _xifexpression_1 = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _throwRuleFailedExceptionMethod = this._xsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
        _builder_1.append(_throwRuleFailedExceptionMethod, "");
        _builder_1.append("(");
        String _errorForRule = this._xsemanticsGeneratorExtensions.errorForRule(rule);
        _builder_1.append(_errorForRule, "");
        _builder_1.append(",");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        String _ruleIssueString_1 = this._xsemanticsGeneratorExtensions.ruleIssueString(rule);
        _builder_1.append(_ruleIssueString_1, "	");
        _builder_1.append(",");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("e_");
        CharSequence _applyRuleName_1 = this._xsemanticsGeneratorExtensions.applyRuleName(rule);
        _builder_1.append(_applyRuleName_1, "	");
        String _errorInformationArgs = this._xsemanticsGeneratorExtensions.errorInformationArgs(rule, importManager);
        _builder_1.append(_errorInformationArgs, "	");
        _builder_1.append(")");
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence compileCheckRule(final CheckRule rule, final ImportManager importManager) {
    CharSequence _xblockexpression = null;
    {
      final CharSequence resultType = this._xsemanticsGeneratorExtensions.resultType(rule, importManager);
      final FakeTreeAppendable appendable = this.createAndConfigureAppendable(rule, importManager);
      final CharSequence inputParam = this._xsemanticsGeneratorExtensions.inputParameter(rule, importManager);
      this.compilePremises(rule, appendable);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public ");
      _builder.append(resultType, "");
      _builder.append(" ");
      String _methodName = this._xsemanticsGeneratorExtensions.methodName(rule);
      _builder.append(_methodName, "");
      _builder.append("(");
      _builder.append(inputParam, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return ");
      String _methodName_1 = this._xsemanticsGeneratorExtensions.methodName(rule);
      _builder.append(_methodName_1, "		");
      _builder.append("Internal(null, ");
      CharSequence _inputParameterName = this._xsemanticsGeneratorExtensions.inputParameterName(rule);
      _builder.append(_inputParameterName, "		");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("} catch (");
      CharSequence _exceptionClass = this._xsemanticsGeneratorExtensions.exceptionClass(importManager);
      _builder.append(_exceptionClass, "	");
      _builder.append(" e) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return resultForFailure(e);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public ");
      _builder.append(resultType, "");
      _builder.append(" ");
      String _methodName_2 = this._xsemanticsGeneratorExtensions.methodName(rule);
      _builder.append(_methodName_2, "");
      _builder.append("Internal(");
      CharSequence _ruleApplicationTraceDeclaration = this._xsemanticsGeneratorExtensions.ruleApplicationTraceDeclaration(importManager);
      CharSequence _javaFinalParam = this._xsemanticsGeneratorExtensions.javaFinalParam(_ruleApplicationTraceDeclaration);
      _builder.append(_javaFinalParam, "");
      _builder.append(", ");
      _builder.append(inputParam, "");
      _builder.append(") ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("throws ");
      CharSequence _ruleFailedExceptionClass = this._xsemanticsGeneratorExtensions.ruleFailedExceptionClass(importManager);
      _builder.append(_ruleFailedExceptionClass, "		");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(appendable, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("return new ");
      _builder.append(resultType, "	");
      _builder.append("(true);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public FakeTreeAppendable createAndConfigureAppendable(final Rule rule, final ImportManager importManager) {
    FakeTreeAppendable _xblockexpression = null;
    {
      final FakeTreeAppendable appendable = this._xsemanticsGeneratorExtensions.createConfiguredAppendable(rule, importManager);
      List<RuleParameter> _ruleParams = this._xsemanticsUtils.ruleParams(rule);
      final Procedure1<RuleParameter> _function = new Procedure1<RuleParameter>() {
          public void apply(final RuleParameter it) {
            JvmFormalParameter _parameter = it.getParameter();
            JvmFormalParameter _parameter_1 = it.getParameter();
            String _simpleName = _parameter_1.getSimpleName();
            appendable.declareVariable(_parameter, _simpleName);
          }
        };
      IterableExtensions.<RuleParameter>forEach(_ruleParams, _function);
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public FakeTreeAppendable createAndConfigureAppendable(final CheckRule rule, final ImportManager importManager) {
    FakeTreeAppendable _xblockexpression = null;
    {
      final FakeTreeAppendable appendable = this._xsemanticsGeneratorExtensions.createConfiguredAppendable(rule, importManager);
      RuleParameter _element = rule.getElement();
      JvmFormalParameter _parameter = _element.getParameter();
      RuleParameter _element_1 = rule.getElement();
      JvmFormalParameter _parameter_1 = _element_1.getParameter();
      String _simpleName = _parameter_1.getSimpleName();
      appendable.declareVariable(_parameter, _simpleName);
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public void declareVariablesForOutputParams(final Rule rule, final ITreeAppendable appendable) {
    List<RuleParameter> _outputParams = this._xsemanticsUtils.outputParams(rule);
    final Procedure1<RuleParameter> _function = new Procedure1<RuleParameter>() {
        public void apply(final RuleParameter it) {
          IAppendable _declareVariable = XsemanticsRuleGenerator.this._xsemanticsGeneratorExtensions.declareVariable(it, appendable);
          _declareVariable.append("\n");
        }
      };
    IterableExtensions.<RuleParameter>forEach(_outputParams, _function);
  }
  
  public ITreeAppendable compileRuleBody(final Rule rule, final String resultType, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      this.compilePremises(rule, result);
      this.compileRuleConclusionElements(rule, result);
      ITreeAppendable _compileReturnResult = this.compileReturnResult(rule, resultType, result);
      _xblockexpression = (_compileReturnResult);
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable compilePremises(final Rule rule, final ITreeAppendable result) {
    ITreeAppendable _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof RuleWithPremises) {
        final RuleWithPremises _ruleWithPremises = (RuleWithPremises)rule;
        _matched=true;
        XExpression _premises = _ruleWithPremises.getPremises();
        ITreeAppendable _compile = this.xbaseCompiler.compile(_premises, result, false);
        _switchResult = _compile;
      }
    }
    return _switchResult;
  }
  
  public ITreeAppendable compilePremises(final CheckRule rule, final ITreeAppendable result) {
    XExpression _premises = rule.getPremises();
    ITreeAppendable _compile = this.xbaseCompiler.compile(_premises, result, false);
    return _compile;
  }
  
  public void compileRuleConclusionElements(final Rule rule, final ITreeAppendable result) {
    List<ExpressionInConclusion> _expressionsInConclusion = this._xsemanticsUtils.expressionsInConclusion(rule);
    final Procedure1<ExpressionInConclusion> _function = new Procedure1<ExpressionInConclusion>() {
        public void apply(final ExpressionInConclusion it) {
          XExpression _expression = it.getExpression();
          XsemanticsRuleGenerator.this.xbaseCompiler.compile(_expression, result, true);
        }
      };
    IterableExtensions.<ExpressionInConclusion>forEach(_expressionsInConclusion, _function);
  }
  
  public ITreeAppendable compileReturnResult(final Rule rule, final String resultType, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      final List<RuleConclusionElement> expressions = this._xsemanticsUtils.outputConclusionElements(rule);
      String _string = result.toString();
      boolean _isEmpty = _string.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        result.append("\n");
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return new ");
      _builder.append(resultType, "");
      _builder.append("(");
      String _string_1 = _builder.toString();
      result.append(_string_1);
      int _size = expressions.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        result.append("true");
      } else {
        final Iterator<RuleConclusionElement> iterator = expressions.iterator();
        boolean _hasNext = iterator.hasNext();
        boolean _while = _hasNext;
        while (_while) {
          {
            final RuleConclusionElement elem = iterator.next();
            boolean _matched = false;
            if (!_matched) {
              if (elem instanceof RuleParameter) {
                final RuleParameter _ruleParameter = (RuleParameter)elem;
                _matched=true;
                JvmFormalParameter _parameter = _ruleParameter.getParameter();
                String _name = result.getName(_parameter);
                result.append(_name);
              }
            }
            if (!_matched) {
              if (elem instanceof ExpressionInConclusion) {
                final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)elem;
                _matched=true;
                XExpression _expression = _expressionInConclusion.getExpression();
                this.xbaseCompiler.compileAsJavaExpression(_expression, result);
              }
            }
            boolean _hasNext_1 = iterator.hasNext();
            if (_hasNext_1) {
              result.append(", ");
            }
          }
          boolean _hasNext_1 = iterator.hasNext();
          _while = _hasNext_1;
        }
      }
      ITreeAppendable _append = result.append(");");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
}

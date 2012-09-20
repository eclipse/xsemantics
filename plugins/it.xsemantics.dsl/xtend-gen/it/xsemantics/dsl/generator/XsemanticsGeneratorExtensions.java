package it.xsemantics.dsl.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.UniqueNames;
import it.xsemantics.dsl.generator.XsemanticsGeneratorConstants;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription;
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XsemanticsGeneratorExtensions {
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsTypeSystem _xsemanticsTypeSystem;
  
  @Inject
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  public String toJavaFullyQualifiedName(final XsemanticsSystem ts) {
    String _xblockexpression = null;
    {
      String _package = this.toPackage(ts);
      final String packageString = _package==null?(String)null:_package.toString();
      String _xifexpression = null;
      int _length = packageString==null?0:packageString.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _plus = (packageString + ".");
        String _javaClassName = this.toJavaClassName(ts);
        String _plus_1 = (_plus + _javaClassName);
        _xifexpression = _plus_1;
      } else {
        String _javaClassName_1 = this.toJavaClassName(ts);
        _xifexpression = _javaClassName_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toPackage(final XsemanticsSystem ts) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ts);
    QualifiedName _skipLast = _fullyQualifiedName==null?(QualifiedName)null:_fullyQualifiedName.skipLast(1);
    String _string = _skipLast==null?(String)null:_skipLast.toString();
    return _string;
  }
  
  public String toJavaClassName(final XsemanticsSystem ts) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ts);
    String _lastSegment = _fullyQualifiedName==null?(String)null:_fullyQualifiedName.getLastSegment();
    return _lastSegment;
  }
  
  public String toJavaFullyQualifiedName(final Rule rule) {
    String _package = this.toPackage(rule);
    String _plus = (_package + ".");
    String _javaClassName = this.toJavaClassName(rule);
    String _plus_1 = (_plus + _javaClassName);
    return _plus_1;
  }
  
  public String toPackage(final Rule rule) {
    String _xblockexpression = null;
    {
      XsemanticsSystem _containingSystem = this._xsemanticsUtils.containingSystem(rule);
      final String typeSystemPackage = this.toPackage(_containingSystem);
      String _xifexpression = null;
      int _length = typeSystemPackage.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _plus = (typeSystemPackage + ".");
        String _plus_1 = (_plus + "rules");
        _xifexpression = _plus_1;
      } else {
        _xifexpression = "rules";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toJavaClassName(final Rule rule) {
    String _name = rule.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public String toJavaClassName(final AuxiliaryFunction aux) {
    String _name = aux.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public String toJavaFullyQualifiedName(final AuxiliaryDescription desc) {
    String _package = this.toPackage(desc);
    String _plus = (_package + ".");
    String _javaClassName = this.toJavaClassName(desc);
    String _plus_1 = (_plus + _javaClassName);
    return _plus_1;
  }
  
  public String toPackage(final AuxiliaryDescription desc) {
    String _xblockexpression = null;
    {
      XsemanticsSystem _containingSystem = this._xsemanticsUtils.containingSystem(desc);
      final String typeSystemPackage = this.toPackage(_containingSystem);
      String _xifexpression = null;
      int _length = typeSystemPackage.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _plus = (typeSystemPackage + ".");
        String _plus_1 = (_plus + "auxiliary");
        _xifexpression = _plus_1;
      } else {
        _xifexpression = "auxiliary";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toJavaClassName(final AuxiliaryDescription desc) {
    String _name = desc.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public String toValidatorPackage(final XsemanticsSystem ts) {
    String _xblockexpression = null;
    {
      final String typeSystemPackage = this.toPackage(ts);
      String _xifexpression = null;
      int _length = typeSystemPackage==null?0:typeSystemPackage.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _plus = (typeSystemPackage + ".");
        String _plus_1 = (_plus + "validation");
        _xifexpression = _plus_1;
      } else {
        _xifexpression = "validation";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toValidatorJavaClassName(final XsemanticsSystem ts) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ts);
    String _lastSegment = _fullyQualifiedName==null?(String)null:_fullyQualifiedName.getLastSegment();
    String _plus = (_lastSegment + "Validator");
    return _plus;
  }
  
  public String toValidatorJavaFullyQualifiedName(final XsemanticsSystem ts) {
    String _validatorPackage = this.toValidatorPackage(ts);
    String _plus = (_validatorPackage + ".");
    String _validatorJavaClassName = this.toValidatorJavaClassName(ts);
    String _plus_1 = (_plus + _validatorJavaClassName);
    return _plus_1;
  }
  
  public String ruleIssueString(final Rule rule) {
    String _name = rule.getName();
    String _upperCase = _name.toUpperCase();
    return _upperCase;
  }
  
  public String ruleIssueString(final AuxiliaryDescription aux) {
    String _name = aux.getName();
    String _upperCase = _name.toUpperCase();
    return _upperCase;
  }
  
  public CharSequence polymorphicDispatcherField(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
    _builder.append(_name, "");
    _builder.append("Dispatcher");
    return _builder;
  }
  
  public CharSequence polymorphicDispatcherField(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = aux.getName();
    _builder.append(_name, "");
    _builder.append("Dispatcher");
    return _builder;
  }
  
  public String relationSymbolsArgs(final JudgmentDescription judgmentDescription) {
    EList<String> _relationSymbols = judgmentDescription.getRelationSymbols();
    final Function1<String,CharSequence> _function = new Function1<String,CharSequence>() {
        public CharSequence apply(final String it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"");
          _builder.append(it, "");
          _builder.append("\"");
          return _builder;
        }
      };
    List<CharSequence> _map = ListExtensions.<String, CharSequence>map(_relationSymbols, _function);
    String _join = IterableExtensions.join(_map, ", ");
    return _join;
  }
  
  public CharSequence polymorphicDispatcherImpl(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
    _builder.append(_name, "");
    _builder.append("Impl");
    return _builder;
  }
  
  public CharSequence polymorphicDispatcherBuildMethod(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("buildPolymorphicDispatcher");
    int _polymorphicDispatcherBuildMethodSuffix = this.polymorphicDispatcherBuildMethodSuffix(judgmentDescription);
    _builder.append(_polymorphicDispatcherBuildMethodSuffix, "");
    return _builder;
  }
  
  public int polymorphicDispatcherBuildMethodSuffix(final JudgmentDescription judgmentDescription) {
    int _xifexpression = (int) 0;
    List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
    int _size = _outputJudgmentParameters.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      _xifexpression = 1;
    } else {
      List<OutputParameter> _outputJudgmentParameters_1 = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      int _size_1 = _outputJudgmentParameters_1.size();
      _xifexpression = _size_1;
    }
    return _xifexpression;
  }
  
  public CharSequence polymorphicDispatcherImpl(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = aux.getName();
    _builder.append(_name, "");
    _builder.append("Impl");
    return _builder;
  }
  
  public CharSequence polymorphicDispatcherNumOfArgs(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(judgmentDescription);
    int _size = _inputParams.size();
    int _plus = (_size + 2);
    _builder.append(_plus, "");
    return _builder;
  }
  
  public CharSequence polymorphicDispatcherNumOfArgs(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    EList<JvmFormalParameter> _parameters = aux.getParameters();
    int _size = _parameters.size();
    int _plus = (_size + 1);
    _builder.append(_plus, "");
    return _builder;
  }
  
  public CharSequence entryPointMethodName(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence entryPointMethodName(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = aux.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public String inputArgs(final JudgmentDescription judgmentDescription) {
    String _xblockexpression = null;
    {
      UniqueNames _uniqueNames = new UniqueNames();
      final UniqueNames names = _uniqueNames;
      List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(judgmentDescription);
      final Function1<InputParameter,CharSequence> _function = new Function1<InputParameter,CharSequence>() {
          public CharSequence apply(final InputParameter it) {
            StringConcatenation _builder = new StringConcatenation();
            String _inputParameterName = XsemanticsGeneratorExtensions.this.inputParameterName(it);
            String _createName = names.createName(_inputParameterName);
            _builder.append(_createName, "");
            return _builder;
          }
        };
      List<CharSequence> _map = ListExtensions.<InputParameter, CharSequence>map(_inputParams, _function);
      String _join = IterableExtensions.join(_map, ", ");
      _xblockexpression = (_join);
    }
    return _xblockexpression;
  }
  
  public String inputArgs(final AuxiliaryDescription aux) {
    EList<JvmFormalParameter> _parameters = aux.getParameters();
    final Function1<JvmFormalParameter,String> _function = new Function1<JvmFormalParameter,String>() {
        public String apply(final JvmFormalParameter it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function);
    String _join = IterableExtensions.join(_map, ", ");
    return _join;
  }
  
  public String inputParameterName(final InputParameter param) {
    JvmFormalParameter _parameter = param.getParameter();
    String _name = _parameter.getName();
    return _name;
  }
  
  public CharSequence environmentName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_environment_");
    return _builder;
  }
  
  public CharSequence entryPointInternalMethodName(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _entryPointMethodName = this.entryPointMethodName(judgmentDescription);
    _builder.append(_entryPointMethodName, "");
    _builder.append("Internal");
    return _builder;
  }
  
  public CharSequence entryPointInternalMethodName(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _entryPointMethodName = this.entryPointMethodName(aux);
    _builder.append(_entryPointMethodName, "");
    _builder.append("Internal");
    return _builder;
  }
  
  public CharSequence additionalArgs() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _environmentName = this.environmentName();
    _builder.append(_environmentName, "");
    _builder.append(", ");
    CharSequence _ruleApplicationTraceName = this.ruleApplicationTraceName();
    _builder.append(_ruleApplicationTraceName, "");
    return _builder;
  }
  
  public CharSequence ruleApplicationTraceName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_trace_");
    return _builder;
  }
  
  public CharSequence ruleApplicationSubtraceName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_subtrace_");
    return _builder;
  }
  
  public CharSequence exceptionVarName(final JudgmentDescription j) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_e_");
    String _name = j.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence exceptionVarName(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_e_");
    String _name = aux.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public String suffixStartingFrom2(final JudgmentDescription judgmentDescription) {
    String _xblockexpression = null;
    {
      List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      final int numOfOutputParams = _outputJudgmentParameters.size();
      String _xifexpression = null;
      boolean _greaterThan = (numOfOutputParams > 1);
      if (_greaterThan) {
        String _plus = ("" + Integer.valueOf(numOfOutputParams));
        _xifexpression = _plus;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence throwExceptionMethod(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    _builder.append(_firstLower, "");
    _builder.append("ThrowException");
    return _builder;
  }
  
  public CharSequence throwExceptionMethod(final AuxiliaryDescription aux) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = aux.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    _builder.append(_firstLower, "");
    _builder.append("ThrowException");
    return _builder;
  }
  
  public CharSequence throwRuleFailedExceptionMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throwRuleFailedException");
    return _builder;
  }
  
  public CharSequence newTraceMethod(final CharSequence trace) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newTrace(");
    _builder.append(trace, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence applyRuleName(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("applyRule");
    String _name = rule.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence additionalArgsForRule(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    String _ruleEnvName = this.ruleEnvName(rule);
    _builder.append(_ruleEnvName, "");
    _builder.append(", ");
    CharSequence _ruleApplicationSubtraceName = this.ruleApplicationSubtraceName();
    _builder.append(_ruleApplicationSubtraceName, "");
    return _builder;
  }
  
  public CharSequence additionalArgsForRuleInvocation(final RuleInvocation ruleInvocation) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _ruleApplicationTraceName = this.ruleApplicationTraceName();
    _builder.append(_ruleApplicationTraceName, "");
    return _builder;
  }
  
  public String ruleEnvName(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    Environment _environment = _conclusion.getEnvironment();
    String _name = _environment.getName();
    return _name;
  }
  
  public CharSequence addToTraceMethod(final CharSequence trace, final CharSequence toAdd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("addToTrace(");
    _builder.append(trace, "");
    _builder.append(", ");
    _builder.append(toAdd, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence addAsSubtraceMethod(final CharSequence trace, final CharSequence subtrace) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("addAsSubtrace(");
    _builder.append(trace, "");
    _builder.append(", ");
    _builder.append(subtrace, "");
    _builder.append(")");
    return _builder;
  }
  
  public String traceStringForRule(final Rule rule) {
    String _xblockexpression = null;
    {
      Iterable<String> _resultGetMethods = XsemanticsGeneratorConstants.getResultGetMethods();
      final Iterator<String> getMethods = _resultGetMethods.iterator();
      final Function1<RuleConclusionElement,CharSequence> _function = new Function1<RuleConclusionElement,CharSequence>() {
          public CharSequence apply(final RuleConclusionElement it) {
            StringConcatenation _builder = new StringConcatenation();
            CharSequence _resultVariableForTrace = XsemanticsGeneratorExtensions.this.resultVariableForTrace();
            _builder.append(_resultVariableForTrace, "");
            _builder.append(".");
            String _next = getMethods.next();
            _builder.append(_next, "");
            CharSequence _wrapInStringRepr = XsemanticsGeneratorExtensions.this.wrapInStringRepr(_builder);
            return _wrapInStringRepr;
          }
        };
      final Function1<RuleConclusionElement,CharSequence> _function_1 = new Function1<RuleConclusionElement,CharSequence>() {
          public CharSequence apply(final RuleConclusionElement it) {
            String _ruleConclusionInputParamForError = XsemanticsGeneratorExtensions.this.ruleConclusionInputParamForError(it);
            CharSequence _wrapInStringRepr = XsemanticsGeneratorExtensions.this.wrapInStringRepr(_ruleConclusionInputParamForError);
            return _wrapInStringRepr;
          }
        };
      String _stringForRule = this.stringForRule(rule, _function, _function_1);
      _xblockexpression = (_stringForRule);
    }
    return _xblockexpression;
  }
  
  public String stringForRule(final Rule rule, final Function1<? super RuleConclusionElement,? extends CharSequence> forOutput, final Function1<? super RuleConclusionElement,? extends CharSequence> forInput) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      String _name = rule.getName();
      CharSequence _ruleNameInvocation = this.ruleNameInvocation(_name);
      _builder.append(_ruleNameInvocation, "");
      _builder.append(" + ");
      String _ruleEnvName = this.ruleEnvName(rule);
      CharSequence _wrapInStringReprForEnv = this.wrapInStringReprForEnv(_ruleEnvName);
      _builder.append(_wrapInStringReprForEnv, "");
      _builder.append(" + \" ");
      RuleConclusion _conclusion = rule.getConclusion();
      String _judgmentSymbol = _conclusion.getJudgmentSymbol();
      _builder.append(_judgmentSymbol, "");
      _builder.append(" \"");
      StringBuffer _stringBuffer = new StringBuffer(_builder.toString());
      final StringBuffer buffer = _stringBuffer;
      JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      final Iterator<JudgmentParameter> judgmentParameters = _judgmentParameters.iterator();
      RuleConclusion _conclusion_1 = rule.getConclusion();
      EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
      final Iterator<String> relationSymbols = _relationSymbols.iterator();
      RuleConclusion _conclusion_2 = rule.getConclusion();
      EList<RuleConclusionElement> _conclusionElements = _conclusion_2.getConclusionElements();
      final Procedure1<RuleConclusionElement> _function = new Procedure1<RuleConclusionElement>() {
          public void apply(final RuleConclusionElement it) {
            buffer.append(" + ");
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsGeneratorExtensions.this._xsemanticsUtils.isOutputParameter(_next);
            if (_isOutputParameter) {
              CharSequence _apply = forOutput.apply(it);
              buffer.append(_apply);
            } else {
              CharSequence _apply_1 = forInput.apply(it);
              buffer.append(_apply_1);
            }
            boolean _hasNext = relationSymbols.hasNext();
            if (_hasNext) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(" ");
              _builder.append("+ \" ");
              String _next_1 = relationSymbols.next();
              _builder.append(_next_1, " ");
              _builder.append(" \"");
              buffer.append(_builder.toString());
            }
          }
        };
      IterableExtensions.<RuleConclusionElement>forEach(_conclusionElements, _function);
      String _string = buffer.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public CharSequence ruleNameInvocation(final String ruleName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ruleName(\"");
    _builder.append(ruleName, "");
    _builder.append("\")");
    return _builder;
  }
  
  public CharSequence wrapInStringReprForEnv(final CharSequence s) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _stringRepresentationForEnv = this.stringRepresentationForEnv();
    _builder.append(_stringRepresentationForEnv, "");
    _builder.append("(");
    _builder.append(s, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence stringRepresentationForEnv() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("stringRepForEnv");
    return _builder;
  }
  
  public CharSequence stringRepresentation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("stringRep");
    return _builder;
  }
  
  public CharSequence wrapInStringRepr(final CharSequence s) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _stringRepresentation = this.stringRepresentation();
    _builder.append(_stringRepresentation, "");
    _builder.append("(");
    _builder.append(s, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence resultVariableForTrace() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_result_");
    return _builder;
  }
  
  public String environmentAccessMethod() {
    return "environmentAccess";
  }
  
  public String sneakyThrowRuleFailedException() {
    return "sneakyThrowRuleFailedException";
  }
  
  public String ruleConclusionInputParamForError(final RuleConclusionElement element) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof RuleParameter) {
        final RuleParameter _ruleParameter = (RuleParameter)element;
        _matched=true;
        JvmFormalParameter _parameter = _ruleParameter.getParameter();
        String _name = _parameter.getName();
        _switchResult = _name;
      }
    }
    if (!_matched) {
      if (element instanceof ExpressionInConclusion) {
        final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)element;
        _matched=true;
        JvmTypeReference _type = this._xsemanticsTypeSystem.getType(_expressionInConclusion);
        String _simpleName = _type.getSimpleName();
        _switchResult = _simpleName;
      }
    }
    return _switchResult;
  }
  
  public String inputParameterNames(final Rule rule) {
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(rule);
    final Function1<RuleParameter,String> _function = new Function1<RuleParameter,String>() {
        public String apply(final RuleParameter it) {
          JvmFormalParameter _parameter = it.getParameter();
          String _name = _parameter.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<RuleParameter, String>map(_inputParams, _function);
    String _join = IterableExtensions.join(_map, ", ");
    return _join;
  }
  
  public String errorForRule(final Rule rule) {
    final Function1<RuleConclusionElement,CharSequence> _function = new Function1<RuleConclusionElement,CharSequence>() {
        public CharSequence apply(final RuleConclusionElement it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"");
          String _ruleConclusionOutputParamForError = XsemanticsGeneratorExtensions.this.ruleConclusionOutputParamForError(it);
          _builder.append(_ruleConclusionOutputParamForError, "");
          _builder.append("\"");
          return _builder;
        }
      };
    final Function1<RuleConclusionElement,CharSequence> _function_1 = new Function1<RuleConclusionElement,CharSequence>() {
        public CharSequence apply(final RuleConclusionElement it) {
          String _ruleConclusionInputParamForError = XsemanticsGeneratorExtensions.this.ruleConclusionInputParamForError(it);
          CharSequence _wrapInStringRepr = XsemanticsGeneratorExtensions.this.wrapInStringRepr(_ruleConclusionInputParamForError);
          return _wrapInStringRepr;
        }
      };
    String _stringForRule = this.stringForRule(rule, _function, _function_1);
    return _stringForRule;
  }
  
  public String ruleConclusionOutputParamForError(final RuleConclusionElement element) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof RuleParameter) {
        final RuleParameter _ruleParameter = (RuleParameter)element;
        _matched=true;
        JvmFormalParameter _parameter = _ruleParameter.getParameter();
        JvmTypeReference _parameterType = _parameter.getParameterType();
        String _simpleName = _parameterType.getSimpleName();
        _switchResult = _simpleName;
      }
    }
    if (!_matched) {
      if (element instanceof ExpressionInConclusion) {
        final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)element;
        _matched=true;
        JvmTypeReference _type = this._xsemanticsTypeSystem.getType(_expressionInConclusion);
        String _simpleName = _type.getSimpleName();
        _switchResult = _simpleName;
      }
    }
    return _switchResult;
  }
  
  public String javaString(final String s) {
    String _convertToJavaString = Strings.convertToJavaString(s);
    return _convertToJavaString;
  }
  
  public void resultType(final JudgmentDescription judgmentDescription, final IAppendable b) {
    JvmTypeReference _resultType = this.resultType(judgmentDescription);
    this._typeReferenceSerializer.serialize(_resultType, judgmentDescription, b);
  }
  
  public JvmTypeReference resultType(final JudgmentDescription e) {
    JvmTypeReference _xblockexpression = null;
    {
      final List<JvmTypeReference> resultTypeArguments = this.resultJvmTypeReferences(e);
      JvmTypeReference resultT = null;
      JvmTypeReference _xifexpression = null;
      int _size = resultTypeArguments.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        JvmTypeReference _get = resultTypeArguments.get(0);
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, Result.class, _get);
        JvmTypeReference _resultT = resultT = _newTypeRef;
        _xifexpression = _resultT;
      } else {
        JvmTypeReference _get_1 = resultTypeArguments.get(0);
        JvmTypeReference _get_2 = resultTypeArguments.get(1);
        JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(e, Result2.class, _get_1, _get_2);
        JvmTypeReference _resultT_1 = resultT = _newTypeRef_1;
        _xifexpression = _resultT_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public JvmTypeReference resultType(final AuxiliaryDescription e) {
    JvmTypeReference _type = e.getType();
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, Boolean.class);
    JvmTypeReference _elvis = ObjectExtensions.<JvmTypeReference>operator_elvis(_type, _newTypeRef);
    return _elvis;
  }
  
  public List<JvmTypeReference> resultJvmTypeReferences(final JudgmentDescription e) {
    List<JvmTypeReference> _xblockexpression = null;
    {
      final List<OutputParameter> outputParams = this._xsemanticsUtils.outputJudgmentParameters(e);
      List<JvmTypeReference> _xifexpression = null;
      int _size = outputParams.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, Boolean.class);
        ArrayList<JvmTypeReference> _newArrayList = CollectionLiterals.<JvmTypeReference>newArrayList(_newTypeRef);
        _xifexpression = _newArrayList;
      } else {
        final Function1<OutputParameter,JvmTypeReference> _function = new Function1<OutputParameter,JvmTypeReference>() {
            public JvmTypeReference apply(final OutputParameter it) {
              JvmTypeReference _jvmTypeReference = it.getJvmTypeReference();
              return _jvmTypeReference;
            }
          };
        List<JvmTypeReference> _map = ListExtensions.<OutputParameter, JvmTypeReference>map(outputParams, _function);
        _xifexpression = _map;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public void resultType(final CheckRule checkRule, final IAppendable b) {
    JvmTypeReference _resultType = this.resultType(checkRule);
    this._typeReferenceSerializer.serialize(_resultType, checkRule, b);
  }
  
  public JvmTypeReference resultType(final CheckRule checkRule) {
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(checkRule, Boolean.class);
    JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(checkRule, Result.class, _newTypeRef);
    return _newTypeRef_1;
  }
  
  public JvmTypeReference errorInformationType(final EObject o) {
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(o, ErrorInformation.class);
    return _newTypeRef;
  }
  
  public JvmTypeReference exceptionType(final EObject o) {
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(o, Exception.class);
    return _newTypeRef;
  }
  
  public String emptyEnvironmentInvocation() {
    return "emptyEnvironment()";
  }
  
  public String environmentEntryInvocation() {
    return "environmentEntry";
  }
  
  public String environmentCompositionInvocation() {
    return "environmentComposition";
  }
  
  public String methodName(final CheckRule rule) {
    String _name = rule.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return _firstLower;
  }
}

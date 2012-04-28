package it.xsemantics.dsl.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.UniqueNames;
import it.xsemantics.dsl.generator.XsemanticsGeneratorConstants;
import it.xsemantics.dsl.typing.XsemanticsTypingSystem;
import it.xsemantics.dsl.util.XsemanticsUtils;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XsemanticsGeneratorExtensions {
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  @Inject
  private XsemanticsTypingSystem _xsemanticsTypingSystem;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Inject
  private JvmModelGenerator jvmModelGenerator;
  
  @Inject
  private JvmModelAssociator associator;
  
  public String toPackage(final XsemanticsSystem ts) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ts);
    QualifiedName _skipLast = _fullyQualifiedName.skipLast(1);
    String _string = _skipLast.toString();
    return _string;
  }
  
  public String toJavaClassFile(final XsemanticsSystem ts) {
    String _javaFullyQualifiedName = this.toJavaFullyQualifiedName(ts);
    String _replace = _javaFullyQualifiedName.replace(".", "/");
    String _operator_plus = StringExtensions.operator_plus(_replace, ".java");
    return _operator_plus;
  }
  
  public String toJavaClassName(final XsemanticsSystem ts) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ts);
    String _lastSegment = _fullyQualifiedName.getLastSegment();
    return _lastSegment;
  }
  
  public String toJavaFullyQualifiedName(final XsemanticsSystem ts) {
    String _xblockexpression = null;
    {
      String _package = this.toPackage(ts);
      String _string = _package.toString();
      final String packageString = _string;
      String _xifexpression = null;
      int _length = packageString.length();
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(_length, 0);
      if (_operator_greaterThan) {
        String _operator_plus = StringExtensions.operator_plus(packageString, ".");
        String _javaClassName = this.toJavaClassName(ts);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _javaClassName);
        _xifexpression = _operator_plus_1;
      } else {
        String _javaClassName_1 = this.toJavaClassName(ts);
        _xifexpression = _javaClassName_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toPackage(final Rule rule) {
    String _xblockexpression = null;
    {
      XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
      String _package = this.toPackage(_containingTypeSystem);
      final String typeSystemPackage = _package;
      String _xifexpression = null;
      int _length = typeSystemPackage.length();
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(_length, 0);
      if (_operator_greaterThan) {
        String _operator_plus = StringExtensions.operator_plus(typeSystemPackage, ".");
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "rules");
        _xifexpression = _operator_plus_1;
      } else {
        _xifexpression = "rules";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toJavaClassFile(final Rule rule) {
    String _javaFullyQualifiedName = this.toJavaFullyQualifiedName(rule);
    String _replace = _javaFullyQualifiedName.replace(".", "/");
    String _operator_plus = StringExtensions.operator_plus(_replace, ".java");
    return _operator_plus;
  }
  
  public String toJavaClassName(final Rule rule) {
    String _name = rule.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public String toJavaFullyQualifiedName(final Rule rule) {
    String _package = this.toPackage(rule);
    String _operator_plus = StringExtensions.operator_plus(_package, ".");
    String _javaClassName = this.toJavaClassName(rule);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _javaClassName);
    return _operator_plus_1;
  }
  
  public String toValidatorPackage(final XsemanticsSystem ts) {
    String _xblockexpression = null;
    {
      String _package = this.toPackage(ts);
      final String typeSystemPackage = _package;
      String _xifexpression = null;
      int _length = typeSystemPackage.length();
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(_length, 0);
      if (_operator_greaterThan) {
        String _operator_plus = StringExtensions.operator_plus(typeSystemPackage, ".");
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "validation");
        _xifexpression = _operator_plus_1;
      } else {
        _xifexpression = "validation";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toValidatorJavaClassFile(final XsemanticsSystem ts) {
    String _validatorJavaFullyQualifiedName = this.toValidatorJavaFullyQualifiedName(ts);
    String _replace = _validatorJavaFullyQualifiedName.replace(".", "/");
    String _operator_plus = StringExtensions.operator_plus(_replace, ".java");
    return _operator_plus;
  }
  
  public String toValidatorJavaClassName(final XsemanticsSystem ts) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ts);
    String _lastSegment = _fullyQualifiedName.getLastSegment();
    String _operator_plus = StringExtensions.operator_plus(_lastSegment, "Validator");
    return _operator_plus;
  }
  
  public String toValidatorJavaFullyQualifiedName(final XsemanticsSystem ts) {
    String _validatorPackage = this.toValidatorPackage(ts);
    String _operator_plus = StringExtensions.operator_plus(_validatorPackage, ".");
    String _validatorJavaClassName = this.toValidatorJavaClassName(ts);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _validatorJavaClassName);
    return _operator_plus_1;
  }
  
  public JvmGenericType createJvmType(final XsemanticsSystem ts) {
    String _javaClassName = this.toJavaClassName(ts);
    String _package = this.toPackage(ts);
    JvmGenericType _createJvmType = this.createJvmType(_javaClassName, _package);
    return _createJvmType;
  }
  
  public JvmGenericType createValidatorJvmType(final XsemanticsSystem ts) {
    String _validatorJavaClassName = this.toValidatorJavaClassName(ts);
    String _validatorPackage = this.toValidatorPackage(ts);
    JvmGenericType _createJvmType = this.createJvmType(_validatorJavaClassName, _validatorPackage);
    return _createJvmType;
  }
  
  public JvmGenericType createJvmType(final Rule rule) {
    String _javaClassName = this.toJavaClassName(rule);
    String _package = this.toPackage(rule);
    JvmGenericType _createJvmType = this.createJvmType(_javaClassName, _package);
    return _createJvmType;
  }
  
  public JvmGenericType createJvmTypeForTypeSystemBaseClass() {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.XsemanticsRuntimeSystem.class);
    return _createJvmType;
  }
  
  public JvmGenericType createJvmType(final String simpleName, final String packageName) {
    JvmGenericType _xblockexpression = null;
    {
      JvmGenericType _createJvmGenericType = TypesFactory.eINSTANCE.createJvmGenericType();
      final JvmGenericType declaredType = _createJvmGenericType;
      declaredType.setSimpleName(simpleName);
      declaredType.setPackageName(packageName);
      _xblockexpression = (declaredType);
    }
    return _xblockexpression;
  }
  
  public JvmGenericType createJvmType(final Class clazz) {
    JvmGenericType _xblockexpression = null;
    {
      String _name = clazz.getName();
      final String fullName = _name;
      String _simpleName = clazz.getSimpleName();
      int _lastIndexOf = fullName.lastIndexOf(".");
      String _substring = fullName.substring(0, _lastIndexOf);
      JvmGenericType _createJvmType = this.createJvmType(_simpleName, _substring);
      _xblockexpression = (_createJvmType);
    }
    return _xblockexpression;
  }
  
  public CharSequence environmentClass(final ImportManager importManager) {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.RuleEnvironment.class);
    CharSequence _serialize = importManager.serialize(_createJvmType);
    return _serialize;
  }
  
  public CharSequence stringClass(final ImportManager importManager) {
    JvmGenericType _createJvmType = this.createJvmType(java.lang.String.class);
    CharSequence _serialize = importManager.serialize(_createJvmType);
    return _serialize;
  }
  
  public CharSequence errorInformationClass(final ImportManager importManager) {
    JvmGenericType _errorInformationClass = this.errorInformationClass();
    CharSequence _serialize = importManager.serialize(_errorInformationClass);
    return _serialize;
  }
  
  public JvmGenericType errorInformationClass() {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.ErrorInformation.class);
    return _createJvmType;
  }
  
  public String injectAnnotation(final ImportManager importManager) {
    JvmGenericType _createJvmType = this.createJvmType(com.google.inject.Inject.class);
    CharSequence _serialize = importManager.serialize(_createJvmType);
    String _operator_plus = StringExtensions.operator_plus("@", _serialize);
    return _operator_plus;
  }
  
  public String checkAnnotation(final ImportManager importManager) {
    JvmGenericType _createJvmType = this.createJvmType(org.eclipse.xtext.validation.Check.class);
    CharSequence _serialize = importManager.serialize(_createJvmType);
    String _operator_plus = StringExtensions.operator_plus("@", _serialize);
    return _operator_plus;
  }
  
  public CharSequence ruleApplicationTraceClass(final ImportManager importManager) {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.RuleApplicationTrace.class);
    CharSequence _serialize = importManager.serialize(_createJvmType);
    return _serialize;
  }
  
  public JvmGenericType booleanClass() {
    JvmGenericType _createJvmType = this.createJvmType(java.lang.Boolean.class);
    return _createJvmType;
  }
  
  public CharSequence ruleFailedExceptionClass(final ImportManager importManager) {
    JvmGenericType _ruleFailedExceptionClass = this.ruleFailedExceptionClass();
    CharSequence _serialize = importManager.serialize(_ruleFailedExceptionClass);
    return _serialize;
  }
  
  public JvmGenericType ruleFailedExceptionClass() {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.RuleFailedException.class);
    return _createJvmType;
  }
  
  public CharSequence exceptionClass(final ImportManager importManager) {
    JvmGenericType _exceptionClass = this.exceptionClass();
    CharSequence _serialize = importManager.serialize(_exceptionClass);
    return _serialize;
  }
  
  public JvmGenericType exceptionClass() {
    JvmGenericType _createJvmType = this.createJvmType(java.lang.Exception.class);
    return _createJvmType;
  }
  
  public CharSequence polymorphicDispatcherClass(final ImportManager importManager) {
    JvmGenericType _createJvmType = this.createJvmType(org.eclipse.xtext.util.PolymorphicDispatcher.class);
    CharSequence _serialize = importManager.serialize(_createJvmType);
    return _serialize;
  }
  
  public IAppendable ruleResultTypeParameters(final Rule rule, final ImportManager importManager) {
    List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(rule);
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
    IAppendable _resultTypeParameters = this.resultTypeParameters(_outputJudgmentParameters, _stringBuilderBasedAppendable);
    return _resultTypeParameters;
  }
  
  public IAppendable resultTypeParameters(final List<OutputParameter> outputParams, final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      boolean _isEmpty = outputParams.isEmpty();
      if (_isEmpty) {
        JvmGenericType _booleanClass = this.booleanClass();
        appendable.append(_booleanClass);
      } else {
        {
          Iterator<OutputParameter> _iterator = outputParams.iterator();
          final Iterator<OutputParameter> iterator = _iterator;
          boolean _hasNext = iterator.hasNext();
          boolean _while = _hasNext;
          while (_while) {
            {
              OutputParameter _next = iterator.next();
              this.judgmentParameterCompile(_next, appendable);
              boolean _hasNext_1 = iterator.hasNext();
              if (_hasNext_1) {
                appendable.append(", ");
              }
            }
            boolean _hasNext_2 = iterator.hasNext();
            _while = _hasNext_2;
          }
        }
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public String inputParameters(final Rule rule, final ImportManager importManager) {
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(rule);
    final Function1<RuleParameter,CharSequence> _function = new Function1<RuleParameter,CharSequence>() {
        public CharSequence apply(final RuleParameter it) {
          StringConcatenation _builder = new StringConcatenation();
          StringBuilderBasedAppendable _ruleParameterTypeCompile = XsemanticsGeneratorExtensions.this.ruleParameterTypeCompile(it, importManager);
          _builder.append(_ruleParameterTypeCompile, "");
          _builder.append(" ");
          JvmFormalParameter _parameter = it.getParameter();
          String _name = _parameter.getName();
          _builder.append(_name, "");
          CharSequence _javaFinalParam = XsemanticsGeneratorExtensions.this.javaFinalParam(_builder);
          return _javaFinalParam;
        }
      };
    List<CharSequence> _map = ListExtensions.<RuleParameter, CharSequence>map(_inputParams, _function);
    String _join = IterableExtensions.join(_map, ", ");
    return _join;
  }
  
  public String methodName(final CheckRule rule) {
    String _name = rule.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return _firstLower;
  }
  
  public CharSequence inputParameter(final CheckRule rule, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    RuleParameter _element = rule.getElement();
    StringBuilderBasedAppendable _ruleParameterTypeCompile = this.ruleParameterTypeCompile(_element, importManager);
    _builder.append(_ruleParameterTypeCompile, "");
    _builder.append(" ");
    CharSequence _inputParameterName = this.inputParameterName(rule);
    _builder.append(_inputParameterName, "");
    CharSequence _javaFinalParam = this.javaFinalParam(_builder);
    return _javaFinalParam;
  }
  
  public CharSequence inputParameterName(final CheckRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    RuleParameter _element = rule.getElement();
    JvmFormalParameter _parameter = _element.getParameter();
    String _name = _parameter.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public String errorInformationArgs(final Rule rule, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      List<RuleParameter> _inputEObjectParams = this._xsemanticsUtils.inputEObjectParams(rule);
      final Function1<RuleParameter,CharSequence> _function = new Function1<RuleParameter,CharSequence>() {
          public CharSequence apply(final RuleParameter it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("new ");
            CharSequence _errorInformationClass = XsemanticsGeneratorExtensions.this.errorInformationClass(importManager);
            _builder.append(_errorInformationClass, "");
            _builder.append("(");
            JvmFormalParameter _parameter = it.getParameter();
            String _name = _parameter.getName();
            _builder.append(_name, "");
            _builder.append(")");
            return _builder;
          }
        };
      List<CharSequence> _map = ListExtensions.<RuleParameter, CharSequence>map(_inputEObjectParams, _function);
      String _join = IterableExtensions.join(_map, ", ");
      final String result = _join;
      String _xifexpression = null;
      boolean _isEmpty = result.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        String _operator_plus = StringExtensions.operator_plus(", ", result);
        _xifexpression = _operator_plus;
      } else {
        _xifexpression = result;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
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
  
  public String inputParameters(final JudgmentDescription judgmentDescription, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      UniqueNames _uniqueNames = new UniqueNames();
      final UniqueNames names = _uniqueNames;
      List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(judgmentDescription);
      final Function1<InputParameter,CharSequence> _function = new Function1<InputParameter,CharSequence>() {
          public CharSequence apply(final InputParameter it) {
            StringConcatenation _builder = new StringConcatenation();
            StringBuilderBasedAppendable _judgmentParameterCompile = XsemanticsGeneratorExtensions.this.judgmentParameterCompile(it, importManager);
            _builder.append(_judgmentParameterCompile, "");
            _builder.append(" ");
            String _inputParameterName = XsemanticsGeneratorExtensions.this.inputParameterName(it);
            String _createName = names.createName(_inputParameterName);
            _builder.append(_createName, "");
            CharSequence _javaFinalParam = XsemanticsGeneratorExtensions.this.javaFinalParam(_builder);
            return _javaFinalParam;
          }
        };
      List<CharSequence> _map = ListExtensions.<InputParameter, CharSequence>map(_inputParams, _function);
      String _join = IterableExtensions.join(_map, ", ");
      _xblockexpression = (_join);
    }
    return _xblockexpression;
  }
  
  public CharSequence javaFinalParam(final CharSequence decl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final ");
    _builder.append(decl, "");
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
  
  public String inputParameterName(final InputParameter param) {
    JvmFormalParameter _parameter = param.getParameter();
    String _name = _parameter.getName();
    return _name;
  }
  
  public StringBuilderBasedAppendable ruleConclusionElementType(final RuleConclusionElement element, final ImportManager importManager) {
    JvmTypeReference _type = this._xsemanticsTypingSystem.getType(element);
    StringBuilderBasedAppendable _typeCompile = this.typeCompile(_type, element, importManager);
    return _typeCompile;
  }
  
  public IAppendable outputTypeParameters(final JudgmentDescription judgmentDescription, final ImportManager importManager) {
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
    IAppendable _outputTypeParameters = this.outputTypeParameters(judgmentDescription, _stringBuilderBasedAppendable);
    return _outputTypeParameters;
  }
  
  public IAppendable outputTypeParameters(final JudgmentDescription judgmentDescription, final IAppendable appendable) {
    List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
    IAppendable _resultTypeParameters = this.resultTypeParameters(_outputJudgmentParameters, appendable);
    return _resultTypeParameters;
  }
  
  public StringBuilderBasedAppendable judgmentParameterCompile(final InputParameter inputParameter, final ImportManager importManager) {
    JvmFormalParameter _parameter = inputParameter.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    StringBuilderBasedAppendable _typeCompile = this.typeCompile(_parameterType, inputParameter, importManager);
    return _typeCompile;
  }
  
  public void judgmentParameterCompile(final InputParameter inputParameter, final IAppendable appendable) {
    JvmFormalParameter _parameter = inputParameter.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    this.typeCompile(_parameterType, inputParameter, appendable);
  }
  
  public void judgmentParameterCompile(final OutputParameter outputParameter, final IAppendable appendable) {
    JvmTypeReference _jvmTypeReference = outputParameter.getJvmTypeReference();
    this.typeCompile(_jvmTypeReference, outputParameter, appendable);
  }
  
  public StringBuilderBasedAppendable ruleParameterTypeCompile(final RuleParameter ruleParameter, final ImportManager importManager) {
    JvmFormalParameter _parameter = ruleParameter.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    StringBuilderBasedAppendable _typeCompile = this.typeCompile(_parameterType, ruleParameter, importManager);
    return _typeCompile;
  }
  
  public void ruleParameterTypeCompile(final RuleParameter ruleParameter, final IAppendable appendable) {
    JvmFormalParameter _parameter = ruleParameter.getParameter();
    JvmTypeReference _parameterType = _parameter.getParameterType();
    this.typeCompile(_parameterType, ruleParameter, appendable);
  }
  
  public StringBuilderBasedAppendable typeCompile(final JvmTypeReference typeRef, final EObject context, final ImportManager importManager) {
    StringBuilderBasedAppendable _xblockexpression = null;
    {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
      final StringBuilderBasedAppendable elemType = _stringBuilderBasedAppendable;
      this.typeCompile(typeRef, context, elemType);
      _xblockexpression = (elemType);
    }
    return _xblockexpression;
  }
  
  public void typeCompile(final JvmTypeReference typeRef, final EObject context, final IAppendable appendable) {
    this._typeReferenceSerializer.serialize(typeRef, context, appendable);
  }
  
  public String resultType(final Rule rule, final ImportManager importManager) {
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
    String _resultType = this.resultType(_judgmentDescription, importManager);
    return _resultType;
  }
  
  public CharSequence resultType(final CheckRule rule, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    JvmGenericType _resultClass = this.resultClass();
    CharSequence _serialize = importManager.serialize(_resultClass);
    _builder.append(_serialize, "");
    _builder.append("<");
    JvmGenericType _booleanClass = this.booleanClass();
    CharSequence _serialize_1 = importManager.serialize(_booleanClass);
    _builder.append(_serialize_1, "");
    _builder.append(">");
    return _builder;
  }
  
  public IAppendable declareVariable(final RuleParameter ruleParam, final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      this.ruleParameterTypeCompile(ruleParam, appendable);
      appendable.append(" ");
      JvmFormalParameter _parameter = ruleParam.getParameter();
      String _name = _parameter.getName();
      appendable.append(_name);
      IAppendable _append = appendable.append(" = null;");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public String resultType(final JudgmentDescription judgmentDescription, final ImportManager importManager) {
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
    IAppendable _resultType = this.resultType(judgmentDescription, _stringBuilderBasedAppendable);
    String _string = _resultType.toString();
    return _string;
  }
  
  public IAppendable resultType(final JudgmentDescription judgmentDescription, final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      JvmGenericType _resultClass = this.resultClass(judgmentDescription);
      IAppendable _append = appendable.append(_resultClass);
      _append.append("<");
      this.outputTypeParameters(judgmentDescription, appendable);
      IAppendable _append_1 = appendable.append(">");
      _xblockexpression = (_append_1);
    }
    return _xblockexpression;
  }
  
  public CharSequence resultClass(final JudgmentDescription judgmentDescription, final ImportManager importManager) {
    JvmGenericType _resultClass = this.resultClass(judgmentDescription);
    CharSequence _serialize = importManager.serialize(_resultClass);
    return _serialize;
  }
  
  public JvmGenericType resultClass(final JudgmentDescription judgmentDescription) {
    JvmGenericType _xblockexpression = null;
    {
      List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      int _size = _outputJudgmentParameters.size();
      final int numOfOutputParams = _size;
      JvmGenericType _xifexpression = null;
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(numOfOutputParams, 1);
      if (_operator_greaterThan) {
        JvmGenericType _result2Class = this.result2Class();
        _xifexpression = _result2Class;
      } else {
        JvmGenericType _resultClass = this.resultClass();
        _xifexpression = _resultClass;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public JvmGenericType resultClass() {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.Result.class);
    return _createJvmType;
  }
  
  public JvmGenericType result2Class() {
    JvmGenericType _createJvmType = this.createJvmType(it.xsemantics.runtime.Result2.class);
    return _createJvmType;
  }
  
  public String suffixStartingFrom2(final JudgmentDescription judgmentDescription) {
    String _xblockexpression = null;
    {
      List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      int _size = _outputJudgmentParameters.size();
      final int numOfOutputParams = _size;
      String _xifexpression = null;
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(numOfOutputParams, 1);
      if (_operator_greaterThan) {
        String _operator_plus = StringExtensions.operator_plus("", Integer.valueOf(numOfOutputParams));
        _xifexpression = _operator_plus;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence polymorphicDispatcherField(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
    _builder.append(_name, "");
    _builder.append("Dispatcher");
    return _builder;
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
    boolean _operator_equals = IntegerExtensions.operator_equals(_size, 0);
    if (_operator_equals) {
      _xifexpression = 1;
    } else {
      List<OutputParameter> _outputJudgmentParameters_1 = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      int _size_1 = _outputJudgmentParameters_1.size();
      _xifexpression = _size_1;
    }
    return _xifexpression;
  }
  
  public CharSequence polymorphicDispatcherNumOfArgs(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(judgmentDescription);
    int _size = _inputParams.size();
    int _operator_plus = IntegerExtensions.operator_plus(_size, 2);
    _builder.append(_operator_plus, "");
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
  
  public CharSequence throwExpectionMethod(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
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
  
  public CharSequence applyRuleName(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("applyRule");
    String _name = rule.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence entryPointMethodName(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = judgmentDescription.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence entryPointInternalMethodName(final JudgmentDescription judgmentDescription) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _entryPointMethodName = this.entryPointMethodName(judgmentDescription);
    _builder.append(_entryPointMethodName, "");
    _builder.append("Internal");
    return _builder;
  }
  
  public String ruleEnvName(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    Environment _environment = _conclusion.getEnvironment();
    String _name = _environment.getName();
    return _name;
  }
  
  public CharSequence additionalParamsDeclaration(final Rule rule, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    String _ruleEnvName = this.ruleEnvName(rule);
    CharSequence _environmentDeclaration = this.environmentDeclaration(importManager, _ruleEnvName);
    CharSequence _javaFinalParam = this.javaFinalParam(_environmentDeclaration);
    _builder.append(_javaFinalParam, "");
    _builder.append(", ");
    CharSequence _ruleApplicationTraceDeclaration = this.ruleApplicationTraceDeclaration(importManager);
    CharSequence _javaFinalParam_1 = this.javaFinalParam(_ruleApplicationTraceDeclaration);
    _builder.append(_javaFinalParam_1, "");
    return _builder;
  }
  
  public CharSequence additionalParamsDeclaration(final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _environmentDeclaration = this.environmentDeclaration(importManager);
    CharSequence _javaFinalParam = this.javaFinalParam(_environmentDeclaration);
    _builder.append(_javaFinalParam, "");
    _builder.append(", ");
    CharSequence _ruleApplicationTraceDeclaration = this.ruleApplicationTraceDeclaration(importManager);
    CharSequence _javaFinalParam_1 = this.javaFinalParam(_ruleApplicationTraceDeclaration);
    _builder.append(_javaFinalParam_1, "");
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
  
  public CharSequence environmentDeclaration(final ImportManager importManager, final CharSequence envName) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _environmentClass = this.environmentClass(importManager);
    _builder.append(_environmentClass, "");
    _builder.append(" ");
    _builder.append(envName, "");
    return _builder;
  }
  
  public CharSequence environmentDeclaration(final ImportManager importManager) {
    CharSequence _environmentName = this.environmentName();
    CharSequence _environmentDeclaration = this.environmentDeclaration(importManager, _environmentName);
    return _environmentDeclaration;
  }
  
  public CharSequence environmentName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_environment_");
    return _builder;
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
  
  public String stringRepInvocation() {
    return "stringRep";
  }
  
  public CharSequence ruleApplicationTraceDeclaration(final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _ruleApplicationTraceClass = this.ruleApplicationTraceClass(importManager);
    _builder.append(_ruleApplicationTraceClass, "");
    _builder.append(" ");
    CharSequence _ruleApplicationTraceName = this.ruleApplicationTraceName();
    _builder.append(_ruleApplicationTraceName, "");
    return _builder;
  }
  
  public CharSequence ruleApplicationSubtraceDeclaration(final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _ruleApplicationTraceClass = this.ruleApplicationTraceClass(importManager);
    _builder.append(_ruleApplicationTraceClass, "");
    _builder.append(" ");
    CharSequence _ruleApplicationSubtraceName = this.ruleApplicationSubtraceName();
    _builder.append(_ruleApplicationSubtraceName, "");
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
  
  public String javaString(final String s) {
    String _convertToJavaString = Strings.convertToJavaString(s);
    return _convertToJavaString;
  }
  
  public CharSequence stringRepresentation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("stringRep");
    return _builder;
  }
  
  public CharSequence stringRepresentationForEnv() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("stringRepForEnv");
    return _builder;
  }
  
  public CharSequence ruleNameInvocation(final String ruleName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ruleName(\"");
    _builder.append(ruleName, "");
    _builder.append("\")");
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
  
  public String traceStringForRule(final Rule rule) {
    String _xblockexpression = null;
    {
      Iterable<String> _resultGetMethods = XsemanticsGeneratorConstants.getResultGetMethods();
      Iterator<String> _iterator = _resultGetMethods.iterator();
      final Iterator<String> getMethods = _iterator;
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
      StringBuffer _stringBuffer = new StringBuffer(_builder);
      final StringBuffer buffer = _stringBuffer;
      JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      Iterator<JudgmentParameter> _iterator = _judgmentParameters.iterator();
      final Iterator<JudgmentParameter> judgmentParameters = _iterator;
      RuleConclusion _conclusion_1 = rule.getConclusion();
      EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
      Iterator<String> _iterator_1 = _relationSymbols.iterator();
      final Iterator<String> relationSymbols = _iterator_1;
      RuleConclusion _conclusion_2 = rule.getConclusion();
      EList<RuleConclusionElement> _conclusionElements = _conclusion_2.getConclusionElements();
      final Procedure1<RuleConclusionElement> _function = new Procedure1<RuleConclusionElement>() {
          public void apply(final RuleConclusionElement it) {
            {
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
                buffer.append(_builder);
              }
            }
          }
        };
      IterableExtensions.<RuleConclusionElement>forEach(_conclusionElements, _function);
      String _string = buffer.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String ruleConclusionOutputParamForError(final RuleConclusionElement element) {
    String _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (element instanceof RuleParameter) {
        final RuleParameter _ruleParameter = (RuleParameter)element;
        matched=true;
        JvmFormalParameter _parameter = _ruleParameter.getParameter();
        JvmTypeReference _parameterType = _parameter.getParameterType();
        String _simpleName = _parameterType.getSimpleName();
        _switchResult = _simpleName;
      }
    }
    if (!matched) {
      if (element instanceof ExpressionInConclusion) {
        final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)element;
        matched=true;
        JvmTypeReference _type = this._xsemanticsTypingSystem.getType(_expressionInConclusion);
        String _simpleName = _type.getSimpleName();
        _switchResult = _simpleName;
      }
    }
    return _switchResult;
  }
  
  public String ruleConclusionInputParamForError(final RuleConclusionElement element) {
    String _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (element instanceof RuleParameter) {
        final RuleParameter _ruleParameter = (RuleParameter)element;
        matched=true;
        JvmFormalParameter _parameter = _ruleParameter.getParameter();
        String _name = _parameter.getName();
        _switchResult = _name;
      }
    }
    if (!matched) {
      if (element instanceof ExpressionInConclusion) {
        final ExpressionInConclusion _expressionInConclusion = (ExpressionInConclusion)element;
        matched=true;
        JvmTypeReference _type = this._xsemanticsTypingSystem.getType(_expressionInConclusion);
        String _simpleName = _type.getSimpleName();
        _switchResult = _simpleName;
      }
    }
    return _switchResult;
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
  
  public CharSequence wrapInStringReprForEnv(final CharSequence s) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _stringRepresentationForEnv = this.stringRepresentationForEnv();
    _builder.append(_stringRepresentationForEnv, "");
    _builder.append("(");
    _builder.append(s, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence newTraceMethod(final CharSequence trace) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newTrace(");
    _builder.append(trace, "");
    _builder.append(")");
    return _builder;
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
  
  public String ruleIssueString(final Rule rule) {
    String _name = rule.getName();
    String _upperCase = _name.toUpperCase();
    return _upperCase;
  }
  
  public CharSequence ruleIssueDeclaration(final Rule rule, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public final static ");
    CharSequence _stringClass = this.stringClass(importManager);
    _builder.append(_stringClass, "");
    _builder.append(" ");
    String _ruleIssueString = this.ruleIssueString(rule);
    _builder.append(_ruleIssueString, "");
    _builder.append(" = \"");
    String _javaFullyQualifiedName = this.toJavaFullyQualifiedName(rule);
    _builder.append(_javaFullyQualifiedName, "");
    _builder.append("\";");
    return _builder;
  }
  
  public JvmTypeReference referenceForBaseRuntimeSystem(final EObject context) {
    JvmTypeReference _typeForName = this._typeReferences.getTypeForName(it.xsemantics.runtime.XsemanticsRuntimeSystem.class, context);
    return _typeForName;
  }
  
  public StringBuilderBasedAppendable createAndConfigureAppendable(final JudgmentDescription jDesc, final ImportManager importManager) {
    StringBuilderBasedAppendable _xblockexpression = null;
    {
      StringBuilderBasedAppendable _createConfiguredAppendable = this.createConfiguredAppendable(jDesc, importManager);
      final StringBuilderBasedAppendable appendable = _createConfiguredAppendable;
      this.configureAppendable(jDesc, appendable);
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public void configureAppendable(final JudgmentDescription jDesc, final IAppendable appendable) {
      Set<EObject> _jvmElements = this.associator.getJvmElements(jDesc);
      EObject _head = IterableExtensions.<EObject>head(_jvmElements);
      final JvmOperation op = ((JvmOperation) _head);
      EList<JvmFormalParameter> _parameters = op.getParameters();
      final Procedure1<JvmFormalParameter> _function = new Procedure1<JvmFormalParameter>() {
          public void apply(final JvmFormalParameter it) {
            String _simpleName = it.getSimpleName();
            appendable.declareVariable(it, _simpleName);
          }
        };
      IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function);
  }
  
  public StringBuilderBasedAppendable createConfiguredAppendable(final EObject context, final ImportManager importManager) {
    StringBuilderBasedAppendable _xblockexpression = null;
    {
      JvmIdentifiableElement _nearestLogicalContainer = this.associator.getNearestLogicalContainer(context);
      final JvmIdentifiableElement container = _nearestLogicalContainer;
      StringBuilderBasedAppendable _createAppendable = this.jvmModelGenerator.createAppendable(container, importManager);
      _xblockexpression = (_createAppendable);
    }
    return _xblockexpression;
  }
  
  public CharSequence exceptionVarName(final JudgmentDescription j) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_e_");
    String _name = j.getName();
    _builder.append(_name, "");
    return _builder;
  }
}

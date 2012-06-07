package it.xsemantics.dsl.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.generator.TempXsemanticsGeneratorExtensions;
import it.xsemantics.dsl.generator.UniqueNames;
import it.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator;
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class TempJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TempXsemanticsGeneratorExtensions _tempXsemanticsGeneratorExtensions;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  @Inject
  private XsemanticsXbaseCompiler xbaseCompiler;
  
  @Inject
  private XsemanticsErrorSpecificationGenerator errSpecGenerator;
  
  /**
   * The dispatch method {@code infer} is called for each instance of the
   * given element's type that is contained in a resource.
   * 
   * @param element
   *            the model to create one or more
   *            {@link org.eclipse.xtext.common.types.JvmDeclaredType declared
   *            types} from.
   * @param acceptor
   *            each created
   *            {@link org.eclipse.xtext.common.types.JvmDeclaredType type}
   *            without a container should be passed to the acceptor in order
   *            get attached to the current resource. The acceptor's
   *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
   *            accept(..)} method takes the constructed empty type for the
   *            pre-indexing phase. This one is further initialized in the
   *            indexing phase using the closure you pass to the returned
   *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
   *            initializeLater(..)}.
   * @param isPreIndexingPhase
   *            whether the method is called in a pre-indexing phase, i.e.
   *            when the global index is not yet fully updated. You must not
   *            rely on linking using the index if isPreIndexingPhase is
   *            <code>true</code>.
   */
  protected void _infer(final XsemanticsSystem ts, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    String _javaFullyQualifiedName = this._tempXsemanticsGeneratorExtensions.toJavaFullyQualifiedName(ts);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(ts, _javaFullyQualifiedName);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          String _documentation = TempJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(ts);
          TempJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = TempJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(ts, XsemanticsRuntimeSystem.class);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
          final ArrayList<JvmField> issues = CollectionLiterals.<JvmField>newArrayList();
          EList<Rule> _rules = ts.getRules();
          final Procedure1<Rule> _function = new Procedure1<Rule>() {
              public void apply(final Rule it) {
                JvmField _genIssueField = TempJvmModelInferrer.this.genIssueField(it);
                issues.add(_genIssueField);
              }
            };
          IterableExtensions.<Rule>forEach(_rules, _function);
          EList<JvmMember> _members = it.getMembers();
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmField>operator_add(_members, issues);
          final ArrayList<JvmField> polymorphicDispatchers = CollectionLiterals.<JvmField>newArrayList();
          EList<JudgmentDescription> _judgmentDescriptions = ts.getJudgmentDescriptions();
          final Procedure1<JudgmentDescription> _function_1 = new Procedure1<JudgmentDescription>() {
              public void apply(final JudgmentDescription it) {
                JvmField _genPolymorphicDispatcherField = TempJvmModelInferrer.this.genPolymorphicDispatcherField(it);
                polymorphicDispatchers.add(_genPolymorphicDispatcherField);
              }
            };
          IterableExtensions.<JudgmentDescription>forEach(_judgmentDescriptions, _function_1);
          EList<JvmMember> _members_1 = it.getMembers();
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmField>operator_add(_members_1, polymorphicDispatchers);
          EList<JvmMember> _members_2 = it.getMembers();
          JvmConstructor _genConstructor = TempJvmModelInferrer.this.genConstructor(ts);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_2, _genConstructor);
          EList<JvmMember> _members_3 = it.getMembers();
          JvmOperation _genInit = TempJvmModelInferrer.this.genInit(ts);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _genInit);
          EList<JudgmentDescription> _judgmentDescriptions_1 = ts.getJudgmentDescriptions();
          final Procedure1<JudgmentDescription> _function_2 = new Procedure1<JudgmentDescription>() {
              public void apply(final JudgmentDescription j) {
                EList<JvmMember> _members = it.getMembers();
                ArrayList<JvmOperation> _genEntryPointMethods = TempJvmModelInferrer.this.genEntryPointMethods(j);
                TempJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _genEntryPointMethods);
              }
            };
          IterableExtensions.<JudgmentDescription>forEach(_judgmentDescriptions_1, _function_2);
          EList<JudgmentDescription> _judgmentDescriptions_2 = ts.getJudgmentDescriptions();
          final Procedure1<JudgmentDescription> _function_3 = new Procedure1<JudgmentDescription>() {
              public void apply(final JudgmentDescription j) {
                EList<JvmMember> _members = it.getMembers();
                JvmOperation _compileInternalMethod = TempJvmModelInferrer.this.compileInternalMethod(j);
                TempJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _compileInternalMethod);
                final JvmOperation throwExceptionMethod = TempJvmModelInferrer.this.compileThrowExceptionMethod(j);
                boolean _notEquals = (!Objects.equal(throwExceptionMethod, null));
                if (_notEquals) {
                  EList<JvmMember> _members_1 = it.getMembers();
                  TempJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, throwExceptionMethod);
                }
              }
            };
          IterableExtensions.<JudgmentDescription>forEach(_judgmentDescriptions_2, _function_3);
          EList<Rule> _rules_1 = ts.getRules();
          final Procedure1<Rule> _function_4 = new Procedure1<Rule>() {
              public void apply(final Rule rule) {
                EList<JvmMember> _members = it.getMembers();
                JvmOperation _compileImplMethod = TempJvmModelInferrer.this.compileImplMethod(rule);
                TempJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _compileImplMethod);
                EList<JvmMember> _members_1 = it.getMembers();
                JvmOperation _compileApplyMethod = TempJvmModelInferrer.this.compileApplyMethod(rule);
                TempJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _compileApplyMethod);
              }
            };
          IterableExtensions.<Rule>forEach(_rules_1, _function_4);
        }
      };
    _accept.initializeLater(_function);
  }
  
  public JvmField genIssueField(final Rule rule) {
    JvmField _xblockexpression = null;
    {
      XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
      String _ruleIssueString = this._tempXsemanticsGeneratorExtensions.ruleIssueString(rule);
      JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(rule, String.class);
      final Procedure1<JvmField> _function = new Procedure1<JvmField>() {
          public void apply(final JvmField it) {
            it.setVisibility(JvmVisibility.PUBLIC);
            it.setStatic(true);
            it.setFinal(true);
          }
        };
      final JvmField issueField = this._jvmTypesBuilder.toField(_containingTypeSystem, _ruleIssueString, _newTypeRef, _function);
      final Procedure1<ITreeAppendable> _function_1 = new Procedure1<ITreeAppendable>() {
          public void apply(final ITreeAppendable it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("\"");
            String _javaFullyQualifiedName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.toJavaFullyQualifiedName(rule);
            _builder.append(_javaFullyQualifiedName, "");
            _builder.append("\"");
            it.append(_builder);
          }
        };
      this._jvmTypesBuilder.setInitializer(issueField, _function_1);
      _xblockexpression = (issueField);
    }
    return _xblockexpression;
  }
  
  public JvmConstructor genConstructor(final XsemanticsSystem ts) {
    final Procedure1<JvmConstructor> _function = new Procedure1<JvmConstructor>() {
        public void apply(final JvmConstructor it) {
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
              public void apply(final ITreeAppendable it) {
                it.append("init();");
              }
            };
          TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(ts, _function);
    return _constructor;
  }
  
  public JvmField genPolymorphicDispatcherField(final JudgmentDescription e) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(e);
    CharSequence _polymorphicDispatcherField = this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherField(e);
    String _string = _polymorphicDispatcherField.toString();
    JvmTypeReference _polymorphicDispatcherType = this.polymorphicDispatcherType(e);
    JvmField _field = this._jvmTypesBuilder.toField(_containingTypeSystem, _string, _polymorphicDispatcherType);
    return _field;
  }
  
  public JvmTypeReference polymorphicDispatcherType(final JudgmentDescription e) {
    JvmTypeReference _resultType = this._tempXsemanticsGeneratorExtensions.resultType(e);
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, PolymorphicDispatcher.class, _resultType);
    return _newTypeRef;
  }
  
  public JvmOperation genInit(final XsemanticsSystem ts) {
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
              public void apply(final ITreeAppendable it) {
                EList<JudgmentDescription> _judgmentDescriptions = ts.getJudgmentDescriptions();
                final Function1<JudgmentDescription,CharSequence> _function = new Function1<JudgmentDescription,CharSequence>() {
                    public CharSequence apply(final JudgmentDescription desc) {
                      CharSequence _genPolymorphicDispatcherInit = TempJvmModelInferrer.this.genPolymorphicDispatcherInit(desc);
                      return _genPolymorphicDispatcherInit;
                    }
                  };
                List<CharSequence> _map = ListExtensions.<JudgmentDescription, CharSequence>map(_judgmentDescriptions, _function);
                String _join = IterableExtensions.join(_map, "\n");
                it.append(_join);
              }
            };
          TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(ts, "init", null, _function);
    return _method;
  }
  
  public CharSequence genPolymorphicDispatcherInit(final JudgmentDescription judgmentDescription) {
    CharSequence _xblockexpression = null;
    {
      final String relationSymbols = this._tempXsemanticsGeneratorExtensions.relationSymbolsArgs(judgmentDescription);
      String _xifexpression = null;
      boolean _isEmpty = relationSymbols.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _plus = (", " + relationSymbols);
        _xifexpression = _plus;
      } else {
        _xifexpression = "";
      }
      final String relationSymbolArgs = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _polymorphicDispatcherField = this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherField(judgmentDescription);
      _builder.append(_polymorphicDispatcherField, "");
      _builder.append(" = ");
      CharSequence _polymorphicDispatcherBuildMethod = this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherBuildMethod(judgmentDescription);
      _builder.append(_polymorphicDispatcherBuildMethod, "");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("\"");
      CharSequence _polymorphicDispatcherImpl = this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherImpl(judgmentDescription);
      _builder.append(_polymorphicDispatcherImpl, "	");
      _builder.append("\", ");
      CharSequence _polymorphicDispatcherNumOfArgs = this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherNumOfArgs(judgmentDescription);
      _builder.append(_polymorphicDispatcherNumOfArgs, "	");
      _builder.append(", ");
      _builder.append("\"");
      String _judgmentSymbol = judgmentDescription.getJudgmentSymbol();
      _builder.append(_judgmentSymbol, "	");
      _builder.append("\"");
      _builder.append(relationSymbolArgs, "	");
      _builder.append(");");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public ArrayList<JvmOperation> genEntryPointMethods(final JudgmentDescription judgmentDescription) {
    ArrayList<JvmOperation> _xblockexpression = null;
    {
      final ArrayList<JvmOperation> entryPointMethods = CollectionLiterals.<JvmOperation>newArrayList();
      XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName = this._tempXsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string = _entryPointMethodName.toString();
      JvmTypeReference _resultType = this._tempXsemanticsGeneratorExtensions.resultType(judgmentDescription);
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _inputParameters);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("return ");
                  CharSequence _entryPointMethodName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
                  _builder.append(_entryPointMethodName, "");
                  _builder.append("(new ");
                  it.append(_builder);
                  JvmTypeReference _environmentType = TempJvmModelInferrer.this.environmentType(judgmentDescription);
                  JvmType _type = _environmentType.getType();
                  it.append(_type);
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("(), null, ");
                  String _inputArgs = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputArgs(judgmentDescription);
                  _builder_1.append(_inputArgs, "");
                  _builder_1.append(");");
                  it.append(_builder_1);
                }
              };
            TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(_containingTypeSystem, _string, _resultType, _function);
      entryPointMethods.add(_method);
      XsemanticsSystem _containingTypeSystem_1 = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName_1 = this._tempXsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string_1 = _entryPointMethodName_1.toString();
      JvmTypeReference _resultType_1 = this._tempXsemanticsGeneratorExtensions.resultType(judgmentDescription);
      final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            JvmFormalParameter _environmentParam = TempJvmModelInferrer.this.environmentParam(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
            EList<JvmFormalParameter> _parameters_1 = it.getParameters();
            List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _inputParameters);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("return ");
                  CharSequence _entryPointMethodName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
                  _builder.append(_entryPointMethodName, "");
                  _builder.append("(");
                  CharSequence _environmentName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.environmentName();
                  _builder.append(_environmentName, "");
                  _builder.append(", null, ");
                  String _inputArgs = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputArgs(judgmentDescription);
                  _builder.append(_inputArgs, "");
                  _builder.append(");");
                  it.append(_builder);
                }
              };
            TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(_containingTypeSystem_1, _string_1, _resultType_1, _function_1);
      entryPointMethods.add(_method_1);
      XsemanticsSystem _containingTypeSystem_2 = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName_2 = this._tempXsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string_2 = _entryPointMethodName_2.toString();
      JvmTypeReference _resultType_2 = this._tempXsemanticsGeneratorExtensions.resultType(judgmentDescription);
      final Procedure1<JvmOperation> _function_2 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            JvmFormalParameter _environmentParam = TempJvmModelInferrer.this.environmentParam(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
            EList<JvmFormalParameter> _parameters_1 = it.getParameters();
            JvmFormalParameter _ruleApplicationTraceParam = TempJvmModelInferrer.this.ruleApplicationTraceParam(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _ruleApplicationTraceParam);
            EList<JvmFormalParameter> _parameters_2 = it.getParameters();
            List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("try {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("return ");
                  CharSequence _entryPointInternalMethodName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.entryPointInternalMethodName(judgmentDescription);
                  _builder.append(_entryPointInternalMethodName, "	");
                  _builder.append("(");
                  CharSequence _additionalArgs = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.additionalArgs();
                  _builder.append(_additionalArgs, "	");
                  _builder.append(", ");
                  String _inputArgs = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputArgs(judgmentDescription);
                  _builder.append(_inputArgs, "	");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("} catch (");
                  it.append(_builder);
                  JvmTypeReference _exceptionType = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionType(judgmentDescription);
                  TempJvmModelInferrer.this._typeReferenceSerializer.serialize(_exceptionType, judgmentDescription, it);
                  it.append(" ");
                  StringConcatenation _builder_1 = new StringConcatenation();
                  CharSequence _exceptionVarName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionVarName(judgmentDescription);
                  _builder_1.append(_exceptionVarName, "");
                  _builder_1.append(") {");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t");
                  _builder_1.append("return resultForFailure");
                  String _suffixStartingFrom2 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.suffixStartingFrom2(judgmentDescription);
                  _builder_1.append(_suffixStartingFrom2, "	");
                  _builder_1.append("(");
                  CharSequence _exceptionVarName_1 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionVarName(judgmentDescription);
                  _builder_1.append(_exceptionVarName_1, "	");
                  _builder_1.append(");");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("}");
                  it.append(_builder_1);
                }
              };
            TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(_containingTypeSystem_2, _string_2, _resultType_2, _function_2);
      entryPointMethods.add(_method_2);
      _xblockexpression = (entryPointMethods);
    }
    return _xblockexpression;
  }
  
  public List<JvmFormalParameter> inputParameters(final JudgmentDescription judgmentDescription) {
    List<JvmFormalParameter> _xblockexpression = null;
    {
      UniqueNames _uniqueNames = new UniqueNames();
      final UniqueNames names = _uniqueNames;
      List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(judgmentDescription);
      final Function1<InputParameter,JvmFormalParameter> _function = new Function1<InputParameter,JvmFormalParameter>() {
          public JvmFormalParameter apply(final InputParameter it) {
            String _inputParameterName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputParameterName(it);
            String _createName = names.createName(_inputParameterName);
            JvmFormalParameter _parameter = it.getParameter();
            JvmTypeReference _parameterType = _parameter.getParameterType();
            JvmFormalParameter _parameter_1 = TempJvmModelInferrer.this._jvmTypesBuilder.toParameter(it, _createName, _parameterType);
            return _parameter_1;
          }
        };
      List<JvmFormalParameter> _map = ListExtensions.<InputParameter, JvmFormalParameter>map(_inputParams, _function);
      _xblockexpression = (_map);
    }
    return _xblockexpression;
  }
  
  public JvmFormalParameter environmentParam(final JudgmentDescription e) {
    CharSequence _environmentName = this._tempXsemanticsGeneratorExtensions.environmentName();
    String _string = _environmentName.toString();
    JvmTypeReference _environmentType = this.environmentType(e);
    JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(e, _string, _environmentType);
    return _parameter;
  }
  
  public JvmFormalParameter ruleApplicationTraceParam(final JudgmentDescription e) {
    CharSequence _ruleApplicationTraceName = this._tempXsemanticsGeneratorExtensions.ruleApplicationTraceName();
    String _string = _ruleApplicationTraceName.toString();
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, RuleApplicationTrace.class);
    JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(e, _string, _newTypeRef);
    return _parameter;
  }
  
  public JvmOperation compileThrowExceptionMethod(final JudgmentDescription judgmentDescription) {
    JvmOperation _xblockexpression = null;
    {
      final ErrorSpecification errorSpecification = judgmentDescription.getError();
      boolean _equals = Objects.equal(errorSpecification, null);
      if (_equals) {
        return null;
      }
      CharSequence _throwExceptionMethod = this._tempXsemanticsGeneratorExtensions.throwExceptionMethod(judgmentDescription);
      String _string = _throwExceptionMethod.toString();
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            it.setVisibility(JvmVisibility.PROTECTED);
            EList<JvmTypeReference> _exceptions = it.getExceptions();
            JvmTypeReference _ruleFailedExceptionType = TempJvmModelInferrer.this.ruleFailedExceptionType(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_exceptions, _ruleFailedExceptionType);
            EList<JvmFormalParameter> _parameters = it.getParameters();
            JvmTypeReference _newTypeRef = TempJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(judgmentDescription, String.class);
            JvmFormalParameter _parameter = TempJvmModelInferrer.this._jvmTypesBuilder.toParameter(judgmentDescription, "_issue", _newTypeRef);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
            EList<JvmFormalParameter> _parameters_1 = it.getParameters();
            JvmTypeReference _exceptionType = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionType(judgmentDescription);
            JvmFormalParameter _parameter_1 = TempJvmModelInferrer.this._jvmTypesBuilder.toParameter(judgmentDescription, "_ex", _exceptionType);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
            EList<JvmFormalParameter> _parameters_2 = it.getParameters();
            List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
            TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  final String error = TempJvmModelInferrer.this.errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, it);
                  final String source = TempJvmModelInferrer.this.errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, it);
                  final String feature = TempJvmModelInferrer.this.errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, it);
                  it.newLine();
                  StringConcatenation _builder = new StringConcatenation();
                  CharSequence _throwRuleFailedExceptionMethod = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
                  _builder.append(_throwRuleFailedExceptionMethod, "");
                  _builder.append("(");
                  _builder.append(error, "");
                  _builder.append(",");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("_issue, _ex, new ");
                  it.append(_builder);
                  JvmTypeReference _errorInformationType = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.errorInformationType(judgmentDescription);
                  TempJvmModelInferrer.this._typeReferenceSerializer.serialize(_errorInformationType, judgmentDescription, it);
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("(");
                  _builder_1.append(source, "");
                  _builder_1.append(", ");
                  _builder_1.append(feature, "");
                  _builder_1.append("));");
                  it.append(_builder_1);
                }
              };
            TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(judgmentDescription, _string, 
        null, _function);
      _xblockexpression = (_method);
    }
    return _xblockexpression;
  }
  
  public JvmOperation compileInternalMethod(final JudgmentDescription judgmentDescription) {
    CharSequence _entryPointInternalMethodName = this._tempXsemanticsGeneratorExtensions.entryPointInternalMethodName(judgmentDescription);
    String _string = _entryPointInternalMethodName.toString();
    JvmTypeReference _resultType = this._tempXsemanticsGeneratorExtensions.resultType(judgmentDescription);
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          it.setVisibility(JvmVisibility.PROTECTED);
          EList<JvmFormalParameter> _parameters = it.getParameters();
          JvmFormalParameter _environmentParam = TempJvmModelInferrer.this.environmentParam(judgmentDescription);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
          EList<JvmFormalParameter> _parameters_1 = it.getParameters();
          JvmFormalParameter _ruleApplicationTraceParam = TempJvmModelInferrer.this.ruleApplicationTraceParam(judgmentDescription);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _ruleApplicationTraceParam);
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
              public void apply(final ITreeAppendable it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("try {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("checkParamsNotNull(");
                String _inputArgs = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputArgs(judgmentDescription);
                _builder.append(_inputArgs, "	");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("return ");
                CharSequence _polymorphicDispatcherField = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherField(judgmentDescription);
                _builder.append(_polymorphicDispatcherField, "	");
                _builder.append(".invoke(");
                CharSequence _additionalArgs = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.additionalArgs();
                _builder.append(_additionalArgs, "	");
                _builder.append(", ");
                String _inputArgs_1 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputArgs(judgmentDescription);
                _builder.append(_inputArgs_1, "	");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("} catch (");
                it.append(_builder);
                JvmTypeReference _exceptionType = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionType(judgmentDescription);
                TempJvmModelInferrer.this._typeReferenceSerializer.serialize(_exceptionType, judgmentDescription, it);
                it.append(" ");
                StringConcatenation _builder_1 = new StringConcatenation();
                CharSequence _exceptionVarName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionVarName(judgmentDescription);
                _builder_1.append(_exceptionVarName, "");
                _builder_1.append(") {");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                _builder_1.append("sneakyThrowRuleFailedException(");
                CharSequence _exceptionVarName_1 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionVarName(judgmentDescription);
                _builder_1.append(_exceptionVarName_1, "	");
                _builder_1.append(");");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                _builder_1.append("return null;");
                _builder_1.newLine();
                _builder_1.append("}");
                it.append(_builder_1);
              }
            };
          TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(judgmentDescription, _string, _resultType, _function);
    return _method;
  }
  
  public JvmTypeReference ruleFailedExceptionType(final EObject o) {
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(o, RuleFailedException.class);
    return _newTypeRef;
  }
  
  public JvmTypeReference environmentType(final EObject o) {
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(o, RuleEnvironment.class);
    return _newTypeRef;
  }
  
  public JvmOperation compileImplMethod(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
    CharSequence _polymorphicDispatcherImpl = this._tempXsemanticsGeneratorExtensions.polymorphicDispatcherImpl(_judgmentDescription);
    _builder.append(_polymorphicDispatcherImpl, "");
    String _string = _builder.toString();
    JudgmentDescription _judgmentDescription_1 = this._xsemanticsUtils.judgmentDescription(rule);
    JvmTypeReference _resultType = this._tempXsemanticsGeneratorExtensions.resultType(_judgmentDescription_1);
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          it.setVisibility(JvmVisibility.PROTECTED);
          EList<JvmTypeReference> _exceptions = it.getExceptions();
          JvmTypeReference _ruleFailedExceptionType = TempJvmModelInferrer.this.ruleFailedExceptionType(rule);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_exceptions, _ruleFailedExceptionType);
          EList<JvmFormalParameter> _parameters = it.getParameters();
          JvmFormalParameter _paramForEnvironment = TempJvmModelInferrer.this.paramForEnvironment(rule);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _paramForEnvironment);
          EList<JvmFormalParameter> _parameters_1 = it.getParameters();
          JudgmentDescription _judgmentDescription = TempJvmModelInferrer.this._xsemanticsUtils.judgmentDescription(rule);
          JvmFormalParameter _ruleApplicationTraceParam = TempJvmModelInferrer.this.ruleApplicationTraceParam(_judgmentDescription);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _ruleApplicationTraceParam);
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(rule);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
              public void apply(final ITreeAppendable it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("try {");
                ITreeAppendable _append = it.append(_builder);
                ITreeAppendable _increaseIndentation = _append.increaseIndentation();
                _increaseIndentation.newLine();
                JvmTypeReference _ruleApplicationTraceType = TempJvmModelInferrer.this.ruleApplicationTraceType(rule);
                JvmType _type = _ruleApplicationTraceType.getType();
                it.append(_type);
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append(" ");
                CharSequence _ruleApplicationSubtraceName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.ruleApplicationSubtraceName();
                _builder_1.append(_ruleApplicationSubtraceName, " ");
                _builder_1.append(" = ");
                CharSequence _ruleApplicationTraceName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.ruleApplicationTraceName();
                CharSequence _newTraceMethod = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.newTraceMethod(_ruleApplicationTraceName);
                _builder_1.append(_newTraceMethod, " ");
                _builder_1.append(";");
                ITreeAppendable _append_1 = it.append(_builder_1);
                _append_1.newLine();
                JudgmentDescription _judgmentDescription = TempJvmModelInferrer.this._xsemanticsUtils.judgmentDescription(rule);
                TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.resultType(_judgmentDescription, it);
                it.append(" ");
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("_result_ = ");
                CharSequence _applyRuleName = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.applyRuleName(rule);
                _builder_2.append(_applyRuleName, "");
                _builder_2.append("(");
                CharSequence _additionalArgsForRule = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.additionalArgsForRule(rule);
                _builder_2.append(_additionalArgsForRule, "");
                _builder_2.append(", ");
                String _inputParameterNames = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.inputParameterNames(rule);
                _builder_2.append(_inputParameterNames, "");
                _builder_2.append(");");
                _builder_2.newLineIfNotEmpty();
                CharSequence _ruleApplicationTraceName_1 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.ruleApplicationTraceName();
                String _traceStringForRule = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.traceStringForRule(rule);
                CharSequence _addToTraceMethod = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.addToTraceMethod(_ruleApplicationTraceName_1, _traceStringForRule);
                _builder_2.append(_addToTraceMethod, "");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                CharSequence _ruleApplicationTraceName_2 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.ruleApplicationTraceName();
                CharSequence _ruleApplicationSubtraceName_1 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.ruleApplicationSubtraceName();
                CharSequence _addAsSubtraceMethod = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.addAsSubtraceMethod(_ruleApplicationTraceName_2, _ruleApplicationSubtraceName_1);
                _builder_2.append(_addAsSubtraceMethod, "");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("return _result_;");
                ITreeAppendable _append_2 = it.append(_builder_2);
                ITreeAppendable _decreaseIndentation = _append_2.decreaseIndentation();
                _decreaseIndentation.newLine();
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("} catch (");
                it.append(_builder_3);
                JvmTypeReference _exceptionType = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.exceptionType(rule);
                TempJvmModelInferrer.this._typeReferenceSerializer.serialize(_exceptionType, rule, it);
                it.append(" ");
                StringConcatenation _builder_4 = new StringConcatenation();
                it.append(_builder_4);
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("e_");
                CharSequence _applyRuleName_1 = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.applyRuleName(rule);
                _builder_5.append(_applyRuleName_1, "");
                _builder_5.append(") {");
                ITreeAppendable _append_3 = it.append(_builder_5);
                ITreeAppendable _increaseIndentation_1 = _append_3.increaseIndentation();
                _increaseIndentation_1.newLine();
                TempJvmModelInferrer.this.compileFinalThrow(rule, it);
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append(";");
                ITreeAppendable _append_4 = it.append(_builder_6);
                _append_4.newLine();
                StringConcatenation _builder_7 = new StringConcatenation();
                _builder_7.append("return null;");
                ITreeAppendable _append_5 = it.append(_builder_7);
                ITreeAppendable _decreaseIndentation_1 = _append_5.decreaseIndentation();
                _decreaseIndentation_1.newLine();
                StringConcatenation _builder_8 = new StringConcatenation();
                _builder_8.append("}");
                it.append(_builder_8);
              }
            };
          TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(rule, _string, _resultType, _function);
    return _method;
  }
  
  public JvmTypeReference ruleApplicationTraceType(final EObject o) {
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(o, RuleApplicationTrace.class);
    return _newTypeRef;
  }
  
  public ITreeAppendable compileFinalThrow(final Rule rule, final ITreeAppendable b) {
    ITreeAppendable _xifexpression = null;
    RuleConclusion _conclusion = rule.getConclusion();
    ErrorSpecification _error = _conclusion.getError();
    boolean _notEquals = (!Objects.equal(_error, null));
    if (_notEquals) {
      ITreeAppendable _xblockexpression = null;
      {
        RuleConclusion _conclusion_1 = rule.getConclusion();
        final ErrorSpecification errorSpecification = _conclusion_1.getError();
        final String error = this.errSpecGenerator.compileErrorOfErrorSpecification(errorSpecification, b);
        final String source = this.errSpecGenerator.compileSourceOfErrorSpecification(errorSpecification, b);
        final String feature = this.errSpecGenerator.compileFeatureOfErrorSpecification(errorSpecification, b);
        b.newLine();
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _throwRuleFailedExceptionMethod = this._tempXsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
        _builder.append(_throwRuleFailedExceptionMethod, "");
        _builder.append("(");
        _builder.append(error, "");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _ruleIssueString = this._tempXsemanticsGeneratorExtensions.ruleIssueString(rule);
        _builder.append(_ruleIssueString, "	");
        _builder.append(", e_");
        CharSequence _applyRuleName = this._tempXsemanticsGeneratorExtensions.applyRuleName(rule);
        _builder.append(_applyRuleName, "	");
        _builder.append(", new ");
        b.append(_builder);
        JvmTypeReference _errorInformationType = this._tempXsemanticsGeneratorExtensions.errorInformationType(rule);
        this._typeReferenceSerializer.serialize(_errorInformationType, rule, b);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        _builder_1.append(source, "");
        _builder_1.append(", ");
        _builder_1.append(feature, "");
        _builder_1.append("));");
        ITreeAppendable _append = b.append(_builder_1);
        _xblockexpression = (_append);
      }
      _xifexpression = _xblockexpression;
    } else {
      ITreeAppendable _xifexpression_1 = null;
      JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
      ErrorSpecification _error_1 = _judgmentDescription.getError();
      boolean _notEquals_1 = (!Objects.equal(_error_1, null));
      if (_notEquals_1) {
        StringConcatenation _builder = new StringConcatenation();
        JudgmentDescription _judgmentDescription_1 = this._xsemanticsUtils.judgmentDescription(rule);
        CharSequence _throwExceptionMethod = this._tempXsemanticsGeneratorExtensions.throwExceptionMethod(_judgmentDescription_1);
        _builder.append(_throwExceptionMethod, "");
        _builder.append("(");
        String _ruleIssueString = this._tempXsemanticsGeneratorExtensions.ruleIssueString(rule);
        _builder.append(_ruleIssueString, "");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("e_");
        CharSequence _applyRuleName = this._tempXsemanticsGeneratorExtensions.applyRuleName(rule);
        _builder.append(_applyRuleName, "	");
        _builder.append(", ");
        String _inputParameterNames = this._tempXsemanticsGeneratorExtensions.inputParameterNames(rule);
        _builder.append(_inputParameterNames, "	");
        _builder.append(")");
        ITreeAppendable _append = b.append(_builder);
        _xifexpression_1 = _append;
      } else {
        ITreeAppendable _xblockexpression_1 = null;
        {
          StringConcatenation _builder_1 = new StringConcatenation();
          CharSequence _throwRuleFailedExceptionMethod = this._tempXsemanticsGeneratorExtensions.throwRuleFailedExceptionMethod();
          _builder_1.append(_throwRuleFailedExceptionMethod, "");
          _builder_1.append("(");
          String _errorForRule = this._tempXsemanticsGeneratorExtensions.errorForRule(rule);
          _builder_1.append(_errorForRule, "");
          _builder_1.append(",");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          String _ruleIssueString_1 = this._tempXsemanticsGeneratorExtensions.ruleIssueString(rule);
          _builder_1.append(_ruleIssueString_1, "	");
          _builder_1.append(",");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("e_");
          CharSequence _applyRuleName_1 = this._tempXsemanticsGeneratorExtensions.applyRuleName(rule);
          _builder_1.append(_applyRuleName_1, "	");
          b.append(_builder_1);
          this.errorInformationArgs(rule, b);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(")");
          ITreeAppendable _append_1 = b.append(_builder_2);
          _xblockexpression_1 = (_append_1);
        }
        _xifexpression_1 = _xblockexpression_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public void errorInformationArgs(final Rule rule, final ITreeAppendable b) {
    final List<RuleParameter> inputEObjects = this._xsemanticsUtils.inputEObjectParams(rule);
    boolean _isEmpty = inputEObjects.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      b.append(", ");
    }
    final Iterator<RuleParameter> iter = inputEObjects.iterator();
    JvmTypeReference _errorInformationType = this._tempXsemanticsGeneratorExtensions.errorInformationType(rule);
    final JvmType errInfoType = _errorInformationType.getType();
    boolean _hasNext = iter.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        b.append("new ");
        b.append(errInfoType);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        RuleParameter _next = iter.next();
        JvmFormalParameter _parameter = _next.getParameter();
        String _name = _parameter.getName();
        _builder.append(_name, "");
        _builder.append(")");
        b.append(_builder);
        boolean _hasNext_1 = iter.hasNext();
        if (_hasNext_1) {
          b.append(", ");
        }
      }
      boolean _hasNext_1 = iter.hasNext();
      _while = _hasNext_1;
    }
  }
  
  public JvmOperation compileApplyMethod(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("applyRule");
    String _javaClassName = this._tempXsemanticsGeneratorExtensions.toJavaClassName(rule);
    _builder.append(_javaClassName, "");
    String _string = _builder.toString();
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(rule);
    JvmTypeReference _resultType = this._tempXsemanticsGeneratorExtensions.resultType(_judgmentDescription);
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          it.setVisibility(JvmVisibility.PROTECTED);
          EList<JvmTypeReference> _exceptions = it.getExceptions();
          JvmTypeReference _ruleFailedExceptionType = TempJvmModelInferrer.this.ruleFailedExceptionType(rule);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_exceptions, _ruleFailedExceptionType);
          EList<JvmFormalParameter> _parameters = it.getParameters();
          JvmFormalParameter _paramForEnvironment = TempJvmModelInferrer.this.paramForEnvironment(rule);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _paramForEnvironment);
          EList<JvmFormalParameter> _parameters_1 = it.getParameters();
          JudgmentDescription _judgmentDescription = TempJvmModelInferrer.this._xsemanticsUtils.judgmentDescription(rule);
          JvmFormalParameter _ruleApplicationTraceParam = TempJvmModelInferrer.this.ruleApplicationTraceParam(_judgmentDescription);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _ruleApplicationTraceParam);
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(rule);
          TempJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
              public void apply(final ITreeAppendable it) {
                TempJvmModelInferrer.this.declareVariablesForOutputParams(rule, it);
                JudgmentDescription _judgmentDescription = TempJvmModelInferrer.this._xsemanticsUtils.judgmentDescription(rule);
                JvmTypeReference _resultType = TempJvmModelInferrer.this._tempXsemanticsGeneratorExtensions.resultType(_judgmentDescription);
                TempJvmModelInferrer.this.compileRuleBody(rule, _resultType, it);
              }
            };
          TempJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(rule, _string, _resultType, _function);
    return _method;
  }
  
  public JvmFormalParameter paramForEnvironment(final Rule rule) {
    String _ruleEnvName = this._tempXsemanticsGeneratorExtensions.ruleEnvName(rule);
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(rule, RuleEnvironment.class);
    JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(rule, _ruleEnvName, _newTypeRef);
    return _parameter;
  }
  
  public void declareVariablesForOutputParams(final Rule rule, final ITreeAppendable appendable) {
    List<RuleParameter> _outputParams = this._xsemanticsUtils.outputParams(rule);
    final Procedure1<RuleParameter> _function = new Procedure1<RuleParameter>() {
        public void apply(final RuleParameter it) {
          ITreeAppendable _declareVariableForOutputParam = TempJvmModelInferrer.this.declareVariableForOutputParam(it, appendable);
          _declareVariableForOutputParam.append("\n");
        }
      };
    IterableExtensions.<RuleParameter>forEach(_outputParams, _function);
  }
  
  public ITreeAppendable declareVariableForOutputParam(final RuleParameter ruleParam, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmFormalParameter _parameter = ruleParam.getParameter();
      JvmFormalParameter _parameter_1 = ruleParam.getParameter();
      String _simpleName = _parameter_1.getSimpleName();
      final String outputVarName = appendable.declareVariable(_parameter, _simpleName);
      JvmFormalParameter _parameter_2 = ruleParam.getParameter();
      final ITreeAppendable childAppendable = appendable.trace(_parameter_2, true);
      JvmFormalParameter _parameter_3 = ruleParam.getParameter();
      JvmTypeReference _parameterType = _parameter_3.getParameterType();
      JvmFormalParameter _parameter_4 = ruleParam.getParameter();
      this._typeReferenceSerializer.serialize(_parameterType, _parameter_4, childAppendable);
      String _plus = (" " + outputVarName);
      String _plus_1 = (_plus + " = null; // output parameter");
      ITreeAppendable _append = childAppendable.append(_plus_1);
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public List<JvmFormalParameter> inputParameters(final Rule rule) {
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(rule);
    final Function1<RuleParameter,JvmFormalParameter> _function = new Function1<RuleParameter,JvmFormalParameter>() {
        public JvmFormalParameter apply(final RuleParameter it) {
          JvmFormalParameter _parameter = it.getParameter();
          String _name = _parameter.getName();
          JvmFormalParameter _parameter_1 = it.getParameter();
          JvmTypeReference _parameterType = _parameter_1.getParameterType();
          JvmFormalParameter _parameter_2 = TempJvmModelInferrer.this._jvmTypesBuilder.toParameter(it, _name, _parameterType);
          return _parameter_2;
        }
      };
    List<JvmFormalParameter> _map = ListExtensions.<RuleParameter, JvmFormalParameter>map(_inputParams, _function);
    return _map;
  }
  
  public ITreeAppendable compileRuleBody(final Rule rule, final JvmTypeReference resultType, final ITreeAppendable result) {
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
  
  public void compileRuleConclusionElements(final Rule rule, final ITreeAppendable result) {
    List<ExpressionInConclusion> _expressionsInConclusion = this._xsemanticsUtils.expressionsInConclusion(rule);
    final Procedure1<ExpressionInConclusion> _function = new Procedure1<ExpressionInConclusion>() {
        public void apply(final ExpressionInConclusion it) {
          XExpression _expression = it.getExpression();
          TempJvmModelInferrer.this.xbaseCompiler.compile(_expression, result, true);
        }
      };
    IterableExtensions.<ExpressionInConclusion>forEach(_expressionsInConclusion, _function);
  }
  
  public ITreeAppendable compileReturnResult(final Rule rule, final JvmTypeReference resultType, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      final List<RuleConclusionElement> expressions = this._xsemanticsUtils.outputConclusionElements(rule);
      String _string = result.toString();
      boolean _isEmpty = _string.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        result.append("\n");
      }
      result.append("return new ");
      this._typeReferenceSerializer.serialize(resultType, rule, result);
      result.append("(");
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
  
  public void infer(final EObject ts, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (ts instanceof XsemanticsSystem) {
      _infer((XsemanticsSystem)ts, acceptor, isPreIndexingPhase);
      return;
    } else if (ts != null) {
      _infer(ts, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ts, acceptor, isPreIndexingPhase).toString());
    }
  }
}

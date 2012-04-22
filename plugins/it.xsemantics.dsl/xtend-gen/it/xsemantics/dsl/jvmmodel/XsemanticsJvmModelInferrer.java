package it.xsemantics.dsl.jvmmodel;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.PolymorphicDispatcher;
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
public class XsemanticsJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
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
    String _javaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(ts);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(ts, _javaFullyQualifiedName);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          String _documentation = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(ts);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(ts, XsemanticsRuntimeSystem.class);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
          final ArrayList<JvmField> issues = CollectionLiterals.<JvmField>newArrayList();
          EList<Rule> _rules = ts.getRules();
          final Procedure1<Rule> _function = new Procedure1<Rule>() {
              public void apply(final Rule it) {
                JvmField _genIssueField = XsemanticsJvmModelInferrer.this.genIssueField(it);
                issues.add(_genIssueField);
              }
            };
          IterableExtensions.<Rule>forEach(_rules, _function);
          EList<JvmMember> _members = it.getMembers();
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmField>operator_add(_members, issues);
          EList<JvmMember> _members_1 = it.getMembers();
          JvmConstructor _genConstructor = XsemanticsJvmModelInferrer.this.genConstructor(ts);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_1, _genConstructor);
          EList<JvmMember> _members_2 = it.getMembers();
          JvmOperation _genInit = XsemanticsJvmModelInferrer.this.genInit(ts);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _genInit);
        }
      };
    _accept.initializeLater(_function);
  }
  
  public JvmField genIssueField(final Rule rule) {
    JvmField _xblockexpression = null;
    {
      XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(rule);
      String _ruleIssueString = this._xsemanticsGeneratorExtensions.ruleIssueString(rule);
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
            String _javaFullyQualifiedName = XsemanticsJvmModelInferrer.this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(rule);
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
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(ts, _function);
    return _constructor;
  }
  
  public JvmOperation genInit(final XsemanticsSystem ts) {
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
              public void apply(final ITreeAppendable it) {
                it.append("/* TODO */");
              }
            };
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
        }
      };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(ts, "init", null, _function);
    return _method;
  }
  
  public JvmField genPolymorphicDispatcherField(final JudgmentDescription e) {
    XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(e);
    CharSequence _polymorphicDispatcherField = this._xsemanticsGeneratorExtensions.polymorphicDispatcherField(e);
    String _string = _polymorphicDispatcherField.toString();
    JvmParameterizedTypeReference _polymorphicDispatcherType = this.polymorphicDispatcherType(e);
    JvmField _field = this._jvmTypesBuilder.toField(_containingTypeSystem, _string, _polymorphicDispatcherType);
    return _field;
  }
  
  public JvmParameterizedTypeReference polymorphicDispatcherType(final JudgmentDescription e) {
    JvmParameterizedTypeReference _xblockexpression = null;
    {
      JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, PolymorphicDispatcher.class);
      final JvmParameterizedTypeReference t = ((JvmParameterizedTypeReference) _newTypeRef);
      EList<JvmTypeReference> _arguments = t.getArguments();
      _arguments.clear();
      EList<JvmTypeReference> _arguments_1 = t.getArguments();
      List<JvmTypeReference> _resultJvmTypeReferences = this.resultJvmTypeReferences(e);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_arguments_1, _resultJvmTypeReferences);
      JvmParameterizedTypeReference resultT = null;
      EList<JvmTypeReference> _arguments_2 = t.getArguments();
      int _size = _arguments_2.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(e, Result.class);
        resultT = ((JvmParameterizedTypeReference) _newTypeRef_1);
      } else {
        JvmTypeReference _newTypeRef_2 = this._jvmTypesBuilder.newTypeRef(e, Result2.class);
        resultT = ((JvmParameterizedTypeReference) _newTypeRef_2);
      }
      EList<JvmTypeReference> _arguments_3 = resultT.getArguments();
      _arguments_3.clear();
      EList<JvmTypeReference> _arguments_4 = resultT.getArguments();
      this._jvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_arguments_4, t);
      _xblockexpression = (resultT);
    }
    return _xblockexpression;
  }
  
  public List<JvmTypeReference> resultJvmTypeReferences(final JudgmentDescription judgmentDescription) {
    List<JvmTypeReference> _xblockexpression = null;
    {
      final List<OutputParameter> outputParams = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      List<JvmTypeReference> _xifexpression = null;
      int _size = outputParams.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(judgmentDescription, Boolean.class);
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

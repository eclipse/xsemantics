package it.xsemantics.dsl.jvmmodel;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.UniqueNames;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * temporary implementation for experiments
 */
@SuppressWarnings("all")
public class TempJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
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
  protected void _infer(final XsemanticsSystem ts, final IAcceptor<JvmDeclaredType> acceptor, final boolean isPreIndexingPhase) {
    String _javaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(ts);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          {
            String _documentation = TempJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(ts);
            TempJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _newTypeRef = TempJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(ts, it.xsemantics.runtime.XsemanticsRuntimeSystem.class);
            CollectionExtensions.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
            EList<JudgmentDescription> _judgmentDescriptions = ts.getJudgmentDescriptions();
            final Procedure1<JudgmentDescription> _function = new Procedure1<JudgmentDescription>() {
                public void apply(final JudgmentDescription j) {
                  EList<JvmMember> _members = it.getMembers();
                  ArrayList<JvmOperation> _genEntryPointMethods = TempJvmModelInferrer.this.genEntryPointMethods(j);
                  CollectionExtensions.<JvmMember>operator_add(_members, _genEntryPointMethods);
                }
              };
            IterableExtensions.<JudgmentDescription>forEach(_judgmentDescriptions, _function);
          }
        }
      };
    JvmGenericType _class = this._jvmTypesBuilder.toClass(ts, _javaFullyQualifiedName, _function);
    acceptor.accept(_class);
  }
  
  public JvmTypeReference resultType(final JudgmentDescription e) {
    JvmTypeReference _xblockexpression = null;
    {
      List<JvmTypeReference> _resultJvmTypeReferences = this.resultJvmTypeReferences(e);
      final List<JvmTypeReference> resultTypeArguments = _resultJvmTypeReferences;
      JvmTypeReference resultT = null;
      JvmTypeReference _xifexpression = null;
      int _size = resultTypeArguments.size();
      boolean _operator_equals = IntegerExtensions.operator_equals(_size, 1);
      if (_operator_equals) {
        JvmTypeReference _get = resultTypeArguments.get(0);
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, it.xsemantics.runtime.Result.class, _get);
        JvmTypeReference _resultT = resultT = _newTypeRef;
        _xifexpression = _resultT;
      } else {
        JvmTypeReference _get_1 = resultTypeArguments.get(0);
        JvmTypeReference _get_2 = resultTypeArguments.get(1);
        JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(e, it.xsemantics.runtime.Result2.class, _get_1, _get_2);
        JvmTypeReference _resultT_1 = resultT = _newTypeRef_1;
        _xifexpression = _resultT_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<JvmTypeReference> resultJvmTypeReferences(final JudgmentDescription judgmentDescription) {
    List<JvmTypeReference> _xblockexpression = null;
    {
      List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      final List<OutputParameter> outputParams = _outputJudgmentParameters;
      List<JvmTypeReference> _xifexpression = null;
      int _size = outputParams.size();
      boolean _operator_equals = IntegerExtensions.operator_equals(_size, 0);
      if (_operator_equals) {
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(judgmentDescription, java.lang.Boolean.class);
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
  
  public ArrayList<JvmOperation> genEntryPointMethods(final JudgmentDescription judgmentDescription) {
    ArrayList<JvmOperation> _xblockexpression = null;
    {
      ArrayList<JvmOperation> _newArrayList = CollectionLiterals.<JvmOperation>newArrayList();
      final ArrayList<JvmOperation> entryPointMethods = _newArrayList;
      XsemanticsSystem _containingTypeSystem = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName = this._xsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string = _entryPointMethodName.toString();
      JvmTypeReference _resultType = this.resultType(judgmentDescription);
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
            CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _inputParameters);
          }
        };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(_containingTypeSystem, _string, _resultType, _function);
      CollectionExtensions.<JvmOperation>operator_add(entryPointMethods, _method);
      XsemanticsSystem _containingTypeSystem_1 = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName_1 = this._xsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string_1 = _entryPointMethodName_1.toString();
      JvmTypeReference _resultType_1 = this.resultType(judgmentDescription);
      final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            {
              EList<JvmFormalParameter> _parameters = it.getParameters();
              JvmFormalParameter _environmentParam = TempJvmModelInferrer.this.environmentParam(judgmentDescription);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
              EList<JvmFormalParameter> _parameters_1 = it.getParameters();
              List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters_1, _inputParameters);
            }
          }
        };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(_containingTypeSystem_1, _string_1, _resultType_1, _function_1);
      CollectionExtensions.<JvmOperation>operator_add(entryPointMethods, _method_1);
      XsemanticsSystem _containingTypeSystem_2 = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName_2 = this._xsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string_2 = _entryPointMethodName_2.toString();
      JvmTypeReference _resultType_2 = this.resultType(judgmentDescription);
      final Procedure1<JvmOperation> _function_2 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            {
              EList<JvmFormalParameter> _parameters = it.getParameters();
              JvmFormalParameter _environmentParam = TempJvmModelInferrer.this.environmentParam(judgmentDescription);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
              EList<JvmFormalParameter> _parameters_1 = it.getParameters();
              JvmFormalParameter _ruleApplicationTraceParam = TempJvmModelInferrer.this.ruleApplicationTraceParam(judgmentDescription);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters_1, _ruleApplicationTraceParam);
              EList<JvmFormalParameter> _parameters_2 = it.getParameters();
              List<JvmFormalParameter> _inputParameters = TempJvmModelInferrer.this.inputParameters(judgmentDescription);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
            }
          }
        };
      JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(_containingTypeSystem_2, _string_2, _resultType_2, _function_2);
      CollectionExtensions.<JvmOperation>operator_add(entryPointMethods, _method_2);
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
            String _inputParameterName = TempJvmModelInferrer.this._xsemanticsGeneratorExtensions.inputParameterName(it);
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
    CharSequence _environmentName = this._xsemanticsGeneratorExtensions.environmentName();
    String _string = _environmentName.toString();
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, it.xsemantics.runtime.RuleEnvironment.class);
    JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(e, _string, _newTypeRef);
    return _parameter;
  }
  
  public JvmFormalParameter ruleApplicationTraceParam(final JudgmentDescription e) {
    CharSequence _ruleApplicationTraceName = this._xsemanticsGeneratorExtensions.ruleApplicationTraceName();
    String _string = _ruleApplicationTraceName.toString();
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, it.xsemantics.runtime.RuleApplicationTrace.class);
    JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(e, _string, _newTypeRef);
    return _parameter;
  }
  
  public void infer(final EObject ts, final IAcceptor<JvmDeclaredType> acceptor, final boolean isPreIndexingPhase) {
    if (ts instanceof XsemanticsSystem) {
      _infer((XsemanticsSystem)ts, acceptor, isPreIndexingPhase);
    } else if (ts != null) {
      _infer(ts, acceptor, isPreIndexingPhase);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ts, acceptor, isPreIndexingPhase).toString());
    }
  }
}

package it.xsemantics.dsl.jvmmodel;

import com.google.inject.Inject;
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
import org.eclipse.xtext.EcoreUtil2;
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
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class XsemanticsJvmModelInferrer extends AbstractModelInferrer {
  /**
   * conveninence API to build and initialize JvmTypes and their members.
   */
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  /**
   * Is called for each instance of the first argument's type contained in a resource.
   * 
   * @param element - the model to create one or more JvmDeclaredTypes from.
   * @param acceptor - each created JvmDeclaredType without a container should be passed to the acceptor in order get attached to the
   *                   current resource.
   * @param isPreLinkingPhase - whether the method is called in a pre linking phase, i.e. when the global index isn't fully updated. You
   *        must not rely on linking using the index if iPrelinkingPhase is <code>true</code>
   */
  protected void _infer(final XsemanticsSystem ts, final IAcceptor<JvmDeclaredType> acceptor, final boolean isPreIndexingPhase) {
    String _javaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(ts);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          {
            String _documentation = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(ts);
            XsemanticsJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _newTypeRef = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(ts, it.xsemantics.runtime.XsemanticsRuntimeSystem.class);
            CollectionExtensions.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
            EList<JudgmentDescription> _judgmentDescriptions = ts.getJudgmentDescriptions();
            final Procedure1<JudgmentDescription> _function = new Procedure1<JudgmentDescription>() {
                public void apply(final JudgmentDescription j) {
                  EList<JvmMember> _members = it.getMembers();
                  ArrayList<JvmOperation> _genEntryPointMethods = XsemanticsJvmModelInferrer.this.genEntryPointMethods(j);
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
  
  public JvmTypeReference resultType(final JudgmentDescription e, final EObject context) {
    JvmTypeReference _xblockexpression = null;
    {
      List<JvmTypeReference> _resultJvmTypeReferences = this.resultJvmTypeReferences(e, context);
      final List<JvmTypeReference> resultTypeArguments = _resultJvmTypeReferences;
      JvmTypeReference resultT = null;
      JvmTypeReference _xifexpression = null;
      int _size = resultTypeArguments.size();
      boolean _operator_equals = IntegerExtensions.operator_equals(_size, 1);
      if (_operator_equals) {
        JvmTypeReference _get = resultTypeArguments.get(0);
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(context, it.xsemantics.runtime.Result.class, _get);
        JvmTypeReference _resultT = resultT = _newTypeRef;
        _xifexpression = _resultT;
      } else {
        JvmTypeReference _get_1 = resultTypeArguments.get(0);
        JvmTypeReference _get_2 = resultTypeArguments.get(1);
        JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(context, it.xsemantics.runtime.Result2.class, _get_1, _get_2);
        JvmTypeReference _resultT_1 = resultT = _newTypeRef_1;
        _xifexpression = _resultT_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<JvmTypeReference> resultJvmTypeReferences(final JudgmentDescription judgmentDescription, final EObject context) {
    List<JvmTypeReference> _xblockexpression = null;
    {
      List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(judgmentDescription);
      final List<OutputParameter> outputParams = _outputJudgmentParameters;
      List<JvmTypeReference> _xifexpression = null;
      int _size = outputParams.size();
      boolean _operator_equals = IntegerExtensions.operator_equals(_size, 0);
      if (_operator_equals) {
        JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(context, java.lang.Boolean.class);
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
      final XsemanticsSystem context = _containingTypeSystem;
      XsemanticsSystem _containingTypeSystem_1 = this._xsemanticsUtils.containingTypeSystem(judgmentDescription);
      CharSequence _entryPointMethodName = this._xsemanticsGeneratorExtensions.entryPointMethodName(judgmentDescription);
      String _string = _entryPointMethodName.toString();
      JvmTypeReference _resultType = this.resultType(judgmentDescription, context);
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            List<JvmFormalParameter> _inputParameters = XsemanticsJvmModelInferrer.this.inputParameters(judgmentDescription);
            CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _inputParameters);
          }
        };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(_containingTypeSystem_1, _string, _resultType, _function);
      CollectionExtensions.<JvmOperation>operator_add(entryPointMethods, _method);
      JudgmentDescription _cloneWithProxies = EcoreUtil2.<JudgmentDescription>cloneWithProxies(judgmentDescription);
      final JudgmentDescription j = _cloneWithProxies;
      XsemanticsSystem _containingTypeSystem_2 = this._xsemanticsUtils.containingTypeSystem(j);
      CharSequence _entryPointMethodName_1 = this._xsemanticsGeneratorExtensions.entryPointMethodName(j);
      String _string_1 = _entryPointMethodName_1.toString();
      JvmTypeReference _resultType_1 = this.resultType(j, context);
      final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            {
              EList<JvmFormalParameter> _parameters = it.getParameters();
              JvmFormalParameter _environmentParam = XsemanticsJvmModelInferrer.this.environmentParam(context);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
              EList<JvmFormalParameter> _parameters_1 = it.getParameters();
              List<JvmFormalParameter> _inputParameters = XsemanticsJvmModelInferrer.this.inputParameters(j);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters_1, _inputParameters);
            }
          }
        };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(_containingTypeSystem_2, _string_1, _resultType_1, _function_1);
      CollectionExtensions.<JvmOperation>operator_add(entryPointMethods, _method_1);
      JudgmentDescription _cloneWithProxies_1 = EcoreUtil2.<JudgmentDescription>cloneWithProxies(judgmentDescription);
      final JudgmentDescription j2 = _cloneWithProxies_1;
      XsemanticsSystem _containingTypeSystem_3 = this._xsemanticsUtils.containingTypeSystem(j2);
      CharSequence _entryPointMethodName_2 = this._xsemanticsGeneratorExtensions.entryPointMethodName(j2);
      String _string_2 = _entryPointMethodName_2.toString();
      JvmTypeReference _resultType_2 = this.resultType(j2, context);
      final Procedure1<JvmOperation> _function_2 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            {
              EList<JvmFormalParameter> _parameters = it.getParameters();
              JvmFormalParameter _environmentParam = XsemanticsJvmModelInferrer.this.environmentParam(context);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _environmentParam);
              EList<JvmFormalParameter> _parameters_1 = it.getParameters();
              JvmFormalParameter _ruleApplicationTraceParam = XsemanticsJvmModelInferrer.this.ruleApplicationTraceParam(context);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters_1, _ruleApplicationTraceParam);
              EList<JvmFormalParameter> _parameters_2 = it.getParameters();
              List<JvmFormalParameter> _inputParameters = XsemanticsJvmModelInferrer.this.inputParameters(j2);
              CollectionExtensions.<JvmFormalParameter>operator_add(_parameters_2, _inputParameters);
            }
          }
        };
      JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(_containingTypeSystem_3, _string_2, _resultType_2, _function_2);
      CollectionExtensions.<JvmOperation>operator_add(entryPointMethods, _method_2);
      _xblockexpression = (entryPointMethods);
    }
    return _xblockexpression;
  }
  
  public List<JvmFormalParameter> inputParameters(final JudgmentDescription judgmentDescription) {
    List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(judgmentDescription);
    final Function1<InputParameter,JvmFormalParameter> _function = new Function1<InputParameter,JvmFormalParameter>() {
        public JvmFormalParameter apply(final InputParameter it) {
          JvmFormalParameter _parameter = it.getParameter();
          JvmFormalParameter _parameter_1 = it.getParameter();
          String _name = _parameter_1.getName();
          JvmFormalParameter _parameter_2 = it.getParameter();
          JvmTypeReference _parameterType = _parameter_2.getParameterType();
          JvmFormalParameter _parameter_3 = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.toParameter(_parameter, _name, _parameterType);
          return _parameter_3;
        }
      };
    List<JvmFormalParameter> _map = ListExtensions.<InputParameter, JvmFormalParameter>map(_inputParams, _function);
    return _map;
  }
  
  public JvmFormalParameter environmentParam(final EObject e) {
    CharSequence _environmentName = this._xsemanticsGeneratorExtensions.environmentName();
    String _string = _environmentName.toString();
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(e, it.xsemantics.runtime.RuleEnvironment.class);
    JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(e, _string, _newTypeRef);
    return _parameter;
  }
  
  public JvmFormalParameter ruleApplicationTraceParam(final EObject e) {
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

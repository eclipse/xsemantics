package it.xsemantics.dsl.jvmmodel;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
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
          }
        }
      };
    JvmGenericType _class = this._jvmTypesBuilder.toClass(ts, _javaFullyQualifiedName, _function);
    acceptor.accept(_class);
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

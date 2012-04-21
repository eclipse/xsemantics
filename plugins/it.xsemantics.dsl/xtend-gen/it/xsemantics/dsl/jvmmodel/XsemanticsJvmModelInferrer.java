package it.xsemantics.dsl.jvmmodel;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
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
  protected void _infer(final XsemanticsSystem element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    String _javaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(element);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(element, _javaFullyQualifiedName);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          String _documentation = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(element);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(element, XsemanticsRuntimeSystem.class);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
          EList<JvmMember> _members = it.getMembers();
          final Procedure1<JvmConstructor> _function = new Procedure1<JvmConstructor>() {
              public void apply(final JvmConstructor it) {
              }
            };
          JvmConstructor _constructor = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.toConstructor(element, _function);
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
          final ArrayList<JvmField> issues = CollectionLiterals.<JvmField>newArrayList();
          EList<Rule> _rules = element.getRules();
          final Procedure1<Rule> _function_1 = new Procedure1<Rule>() {
              public void apply(final Rule rule) {
                String _ruleIssueString = XsemanticsJvmModelInferrer.this._xsemanticsGeneratorExtensions.ruleIssueString(rule);
                JvmTypeReference _newTypeRef = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(element, String.class);
                final Procedure1<JvmField> _function = new Procedure1<JvmField>() {
                    public void apply(final JvmField it) {
                      it.setVisibility(JvmVisibility.PUBLIC);
                      it.setStatic(true);
                      it.setFinal(true);
                    }
                  };
                final JvmField issue = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.toField(element, _ruleIssueString, _newTypeRef, _function);
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
                XsemanticsJvmModelInferrer.this._jvmTypesBuilder.setInitializer(issue, _function_1);
                issues.add(issue);
              }
            };
          IterableExtensions.<Rule>forEach(_rules, _function_1);
          EList<JvmMember> _members_1 = it.getMembers();
          XsemanticsJvmModelInferrer.this._jvmTypesBuilder.<JvmField>operator_add(_members_1, issues);
        }
      };
    _accept.initializeLater(_function);
  }
  
  public void issueStrings(final XsemanticsSystem element, final ITreeAppendable a) {
    EList<Rule> _rules = element.getRules();
    final Procedure1<Rule> _function = new Procedure1<Rule>() {
        public void apply(final Rule it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public final static ");
          ITreeAppendable _append = a.append(_builder);
          JvmTypeReference _newTypeRef = XsemanticsJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(element, String.class);
          JvmType _type = _newTypeRef.getType();
          ITreeAppendable _append_1 = _append.append(_type);
          ITreeAppendable _append_2 = _append_1.append(" ");
          String _ruleIssueString = XsemanticsJvmModelInferrer.this._xsemanticsGeneratorExtensions.ruleIssueString(it);
          ITreeAppendable _append_3 = _append_2.append(_ruleIssueString);
          ITreeAppendable _append_4 = _append_3.append(" ");
          String _javaFullyQualifiedName = XsemanticsJvmModelInferrer.this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(it);
          ITreeAppendable _append_5 = _append_4.append(_javaFullyQualifiedName);
          ITreeAppendable _append_6 = _append_5.append(";");
          _append_6.newLine();
        }
      };
    IterableExtensions.<Rule>forEach(_rules, _function);
  }
  
  public void infer(final EObject element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (element instanceof XsemanticsSystem) {
      _infer((XsemanticsSystem)element, acceptor, isPreIndexingPhase);
      return;
    } else if (element != null) {
      _infer(element, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, acceptor, isPreIndexingPhase).toString());
    }
  }
}

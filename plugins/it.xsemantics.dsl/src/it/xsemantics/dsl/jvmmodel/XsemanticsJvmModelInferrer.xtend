package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.util.XsemanticsUtils

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class XsemanticsJvmModelInferrer extends AbstractModelInferrer {

    /**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension JvmTypesBuilder
	
	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils

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
   	def dispatch void infer(XsemanticsSystem ts, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   		acceptor.accept(
			ts.toClass( ts.toJavaFullyQualifiedName )
		).initializeLater [
			documentation = ts.documentation
			
			superTypes += ts.newTypeRef(typeof(XsemanticsRuntimeSystem))
			
			//val procedure = element.newTypeRef(typeof(Procedure1), it.newTypeRef())
			members += ts.toConstructor() []
			
			val issues = <JvmField>newArrayList()
			ts.rules.forEach [
				issues += genIssueField()
			]
			members += issues
			
//			members += element.toConstructor() [
//				parameters += element.toParameter("initializer", procedure)
//				body = [it.append("initializer.apply(this);")]
//			]
			//members += element.addToStringMethod(it)
		]
   	}
   	
   	def genIssueField(Rule rule) {
   		val issueField = rule.containingTypeSystem.toField(
				rule.ruleIssueString,
				rule.newTypeRef(typeof(String))
			) [
				visibility = JvmVisibility::PUBLIC
				^static = true
				final = true
			]
		issueField.setInitializer [
			it.append('''"«rule.toJavaFullyQualifiedName»"''')
		]
		issueField
   	}
   	
   	def void issueStrings(XsemanticsSystem element, ITreeAppendable a) {
   		element.rules.forEach [
   			a.append('''public final static ''').
   			append(element.newTypeRef(typeof(String)).type).
   			append(" ").
   			append(ruleIssueString).
   			append(" ").
   			append(toJavaFullyQualifiedName()).
   			append(";").
   			newLine
   		]
   	}
}


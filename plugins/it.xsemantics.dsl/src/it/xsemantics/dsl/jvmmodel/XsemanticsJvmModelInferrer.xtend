package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

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
			

			val issues = <JvmField>newArrayList()
			ts.rules.forEach [
				issues += genIssueField()
			]
			members += issues
			
			val polymorphicDispatchers = <JvmField>newArrayList()
			ts.judgmentDescriptions.forEach [
				polymorphicDispatchers += genPolymorphicDispatcherField
			]
			members += polymorphicDispatchers
			
			//val procedure = element.newTypeRef(typeof(Procedure1), it.newTypeRef())
			members += ts.genConstructor
			
			members += ts.genInit
			
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
   	
   	def genConstructor(XsemanticsSystem ts) {
   		ts.toConstructor() [
			body = [it.append("init();")]
		]
   	}
   	
   	def genInit(XsemanticsSystem ts) {
   		ts.toMethod("init", null) [
   			body = [it.append("/* TODO */")]
   		]
   	}

	def genPolymorphicDispatcherField(JudgmentDescription e) {
		e.containingTypeSystem.toField(
			e.polymorphicDispatcherField.toString,
			e.polymorphicDispatcherType
		)
	}

	def polymorphicDispatcherType(JudgmentDescription e) {
		val resultTypeArguments = e.resultJvmTypeReferences()
		var JvmTypeReference resultT
		if (resultTypeArguments.size == 1)
			resultT = e.newTypeRef(typeof(Result), resultTypeArguments.get(0)) 
		else
			resultT = e.newTypeRef(typeof(Result2),
				resultTypeArguments.get(0), resultTypeArguments.get(1)
			)
		e.newTypeRef(typeof(PolymorphicDispatcher), resultT)
	}
	
	def resultJvmTypeReferences(JudgmentDescription judgmentDescription) {
		val outputParams = judgmentDescription.outputJudgmentParameters
		if (outputParams.size == 0) {
			<JvmTypeReference>newArrayList(judgmentDescription.newTypeRef(typeof(Boolean)))
		} else {
			outputParams.map [ it.jvmTypeReference ]
		}
	}
}


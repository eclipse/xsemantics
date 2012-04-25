package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class XsemanticsJvmModelInferrer extends AbstractModelInferrer {

    /**
     * conveninence API to build and initialize JvmTypes and their members.
     */
	@Inject extension JvmTypesBuilder
	
	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils

	/**
	 * Is called for each instance of the first argument's type contained in a resource.
	 * 
	 * @param element - the model to create one or more JvmDeclaredTypes from.
	 * @param acceptor - each created JvmDeclaredType without a container should be passed to the acceptor in order get attached to the
	 *                   current resource.
	 * @param isPreLinkingPhase - whether the method is called in a pre linking phase, i.e. when the global index isn't fully updated. You
	 *        must not rely on linking using the index if iPrelinkingPhase is <code>true</code>
	 */
   	def dispatch void infer(XsemanticsSystem ts, IAcceptor<JvmDeclaredType> acceptor, boolean isPreIndexingPhase) {
   		acceptor.accept(
			ts.toClass( ts.toJavaFullyQualifiedName ) [
				documentation = ts.documentation
				superTypes += ts.newTypeRef(typeof(XsemanticsRuntimeSystem))
				
				ts.judgmentDescriptions.forEach [
					j |
					members += j.genEntryPointMethods
				]
			]
		)
	}
	
	def resultType(JudgmentDescription e, EObject context) {
		val resultTypeArguments = e.resultJvmTypeReferences(context)
		var JvmTypeReference resultT
		if (resultTypeArguments.size == 1)
			resultT = context.newTypeRef(typeof(Result), resultTypeArguments.get(0)) 
		else
			resultT = context.newTypeRef(typeof(Result2),
				resultTypeArguments.get(0), resultTypeArguments.get(1)
			)
	}
	
	def resultJvmTypeReferences(JudgmentDescription judgmentDescription, EObject context) {
		val outputParams = judgmentDescription.outputJudgmentParameters
		if (outputParams.size == 0) {
			<JvmTypeReference>newArrayList(context.newTypeRef(typeof(Boolean)))
		} else {
			outputParams.map [ it.jvmTypeReference ]
		}
	}
	
   	def genEntryPointMethods(JudgmentDescription judgmentDescription) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		val context = judgmentDescription.containingTypeSystem
   		entryPointMethods += judgmentDescription.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType(context)
   		) [
   			for (p : judgmentDescription.inputParams) {
   				parameters += p.parameter.toParameter(
   					p.parameter.name, p.parameter.parameterType
   				)
   			}
   		]
   		
   		// since we create methods in overloading, in order to avoid
   		// wrong param scoping and renaming in the generated code
   		// the other methods are created on cloned judgment descriptions
   		
   		val j = judgmentDescription.cloneWithProxies
   		entryPointMethods += j.containingTypeSystem.toMethod(
   			j.entryPointMethodName.toString,
   			j.resultType(context)
   		) [
   			parameters += context.environmentParam
   			parameters += j.inputParameters
   		]
   		
   		val j2 = judgmentDescription.cloneWithProxies
   		entryPointMethods += j2.containingTypeSystem.toMethod(
   			j2.entryPointMethodName.toString,
   			j2.resultType(context)
   		) [
   			parameters += context.environmentParam
   			parameters += context.ruleApplicationTraceParam
   			parameters += j2.inputParameters
   		]
   		   		
   		entryPointMethods
   	}
   	
   	def inputParameters(JudgmentDescription judgmentDescription) {
		judgmentDescription.inputParams.map([
			it.parameter.toParameter(
				it.parameter.name,
				it.parameter.parameterType
			)
		])
	}
	
	def environmentParam(EObject e) {
		e.toParameter(
			environmentName.toString,
			e.newTypeRef(typeof(RuleEnvironment))
		)
	}
	
	def ruleApplicationTraceParam(EObject e) {
		e.toParameter(
			ruleApplicationTraceName.toString,
			e.newTypeRef(typeof(RuleApplicationTrace))
		)
	}
}

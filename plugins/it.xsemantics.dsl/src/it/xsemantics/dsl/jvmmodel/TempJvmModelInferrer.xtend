package it.xsemantics.dsl.jvmmodel

import com.google.inject.Inject
import it.xsemantics.dsl.generator.UniqueNames
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.runtime.Result
import it.xsemantics.runtime.Result2
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * temporary implementation for experiments     
 */
class TempJvmModelInferrer extends AbstractModelInferrer {

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
   	
	def resultType(JudgmentDescription e) {
		val resultTypeArguments = e.resultJvmTypeReferences()
		var JvmTypeReference resultT
		if (resultTypeArguments.size == 1)
			resultT = e.newTypeRef(typeof(Result), resultTypeArguments.get(0)) 
		else
			resultT = e.newTypeRef(typeof(Result2),
				resultTypeArguments.get(0), resultTypeArguments.get(1)
			)
	}
	
	def resultJvmTypeReferences(JudgmentDescription judgmentDescription) {
		val outputParams = judgmentDescription.outputJudgmentParameters
		if (outputParams.size == 0) {
			<JvmTypeReference>newArrayList(judgmentDescription.newTypeRef(typeof(Boolean)))
		} else {
			outputParams.map [ it.jvmTypeReference ]
		}
	}
	
   	def genEntryPointMethods(JudgmentDescription judgmentDescription) {
   		val entryPointMethods = <JvmOperation>newArrayList()
   		// main entry point method
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.inputParameters
   		]
   		
   		// entry point method with environment parameter
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.inputParameters
   		]
   		
   		// entry point method with environment parameter and rule application trace
   		entryPointMethods += judgmentDescription.containingTypeSystem.toMethod(
   			judgmentDescription.entryPointMethodName.toString,
   			judgmentDescription.resultType
   		) [
   			parameters += judgmentDescription.environmentParam
   			parameters += judgmentDescription.ruleApplicationTraceParam
   			parameters += judgmentDescription.inputParameters
   		]
   		
   		entryPointMethods
   	}
   	
   	def inputParameters(JudgmentDescription judgmentDescription) {
		val names = new UniqueNames()
		judgmentDescription.inputParams.map([
			it.toParameter(
				names.createName(it.inputParameterName),
				it.parameter.parameterType
			)
		])
	}
	
	def environmentParam(JudgmentDescription e) {
		e.toParameter(
			environmentName.toString,
			e.newTypeRef(typeof(RuleEnvironment))
		)
	}
	
	def ruleApplicationTraceParam(JudgmentDescription e) {
		e.toParameter(
			ruleApplicationTraceName.toString,
			e.newTypeRef(typeof(RuleApplicationTrace))
		)
	}
	
}


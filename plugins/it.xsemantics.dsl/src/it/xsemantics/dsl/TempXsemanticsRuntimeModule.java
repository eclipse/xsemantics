package it.xsemantics.dsl;

import it.xsemantics.dsl.scoping.TempXsemanticsScopeProvider;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;

@SuppressWarnings("restriction")
public class TempXsemanticsRuntimeModule extends XsemanticsRuntimeModule {

	@Override
	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return it.xsemantics.dsl.jvmmodel.TempJvmModelInferrer.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return TempXsemanticsScopeProvider.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return org.eclipse.xtext.xbase.compiler.JvmModelGenerator.class;
	}
	
	@Override
	// contributed by org.eclipse.xtext.generator.validation.JavaValidatorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends it.xsemantics.dsl.validation.XsemanticsJavaValidator> bindXsemanticsJavaValidator() {
		return it.xsemantics.dsl.validation.TempXsemanticsJavaValidator.class;
	}
}

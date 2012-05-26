package it.xsemantics.dsl;

import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;

@SuppressWarnings("restriction")
public class TempXsemanticsRuntimeModule extends XsemanticsRuntimeModule {

	@Override
	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return it.xsemantics.dsl.jvmmodel.TempJvmModelInferrer.class;
	}
}

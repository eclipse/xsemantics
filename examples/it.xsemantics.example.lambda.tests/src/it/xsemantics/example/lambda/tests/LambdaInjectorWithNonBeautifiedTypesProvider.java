package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.LambdaInjectorProvider;
import it.xsemantics.example.lambda.LambdaRuntimeModule;
import it.xsemantics.example.lambda.LambdaStandaloneSetup;
import it.xsemantics.example.lambda.xsemantics.LambdaStringRepresentation;
import it.xsemantics.runtime.StringRepresentation;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class LambdaInjectorWithNonBeautifiedTypesProvider extends
		LambdaInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new LambdaStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new LambdaRuntimeModule() {
					@Override
					public java.lang.Class<? extends StringRepresentation> bindStringProvider() {
						return LambdaStringRepresentation.class;
					};
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}

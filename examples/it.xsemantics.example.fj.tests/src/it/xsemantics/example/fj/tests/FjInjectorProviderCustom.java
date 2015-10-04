/**
 * 
 */
package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.example.fj.FJRuntimeModule;
import it.xsemantics.example.fj.FJStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author bettini
 * 
 */
public class FjInjectorProviderCustom extends FJInjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		return new FJStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new FJRuntimeModule() {
					@Override
					public java.lang.Class<? extends it.xsemantics.runtime.StringRepresentation> bindStringRepresentation() {
						return FjStringRepresentationForTests.class;
					};
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}

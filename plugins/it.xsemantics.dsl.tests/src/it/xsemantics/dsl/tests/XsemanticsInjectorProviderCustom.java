package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.XsemanticsRuntimeModule;
import it.xsemantics.dsl.XsemanticsStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class XsemanticsInjectorProviderCustom extends
		XsemanticsInjectorProvider {

	public static class XsemanticsStandaloneSetupForTests extends
			XsemanticsStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new XsemanticsRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return XsemanticsInjectorProviderCustom.class
							.getClassLoader();
				}
			});
		}
	}

	@Override
	protected Injector internalCreateInjector() {
		return new XsemanticsStandaloneSetupForTests()
				.createInjectorAndDoEMFRegistration();
	}
}

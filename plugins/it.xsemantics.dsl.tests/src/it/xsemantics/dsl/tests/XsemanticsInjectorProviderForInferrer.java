package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.TempXsemanticsRuntimeModule;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.XsemanticsStandaloneSetup;

import org.eclipse.xtext.junit4.GlobalRegistries;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class XsemanticsInjectorProviderForInferrer extends
		XsemanticsInjectorProvider {

	public static class XsemanticsStandaloneSetupForTests extends
			XsemanticsStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new TempXsemanticsRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return XsemanticsInjectorProviderForInferrer.class
							.getClassLoader();
				}
			});
		}
	}

	public Injector getInjector() {
		if (injector == null) {
			stateBeforeInjectorCreation = GlobalRegistries
					.makeCopyOfGlobalState();
			this.injector = new XsemanticsStandaloneSetupForTests()
					.createInjectorAndDoEMFRegistration();
			stateAfterInjectorCreation = GlobalRegistries
					.makeCopyOfGlobalState();
		}
		return injector;
	}
}

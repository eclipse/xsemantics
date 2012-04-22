package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.XsemanticsRuntimeModule;
import it.xsemantics.dsl.XsemanticsStandaloneSetup;

import org.eclipse.xtext.junit4.GlobalRegistries;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class XsemanticsInjectorProviderForInferrer extends
		XsemanticsInjectorProvider {

	public static class XsemanticsStandaloneSetupForTests extends
			XsemanticsStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new XsemanticsRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return XsemanticsInjectorProviderForInferrer.class
							.getClassLoader();
				}

				@Override
				public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
					return it.xsemantics.dsl.jvmmodel.TempJvmModelInferrer.class;
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

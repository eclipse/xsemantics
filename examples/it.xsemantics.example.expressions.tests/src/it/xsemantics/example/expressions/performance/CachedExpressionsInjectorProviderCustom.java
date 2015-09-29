package it.xsemantics.example.expressions.performance;

import com.google.inject.Guice;
import com.google.inject.Injector;

import it.xsemantics.example.expressions.ExpressionsRuntimeModule;
import it.xsemantics.example.expressions.ExpressionsStandaloneSetup;
import it.xsemantics.example.expressions.tests.ExtendedExpressionsInjectorProviderCustom;
import it.xsemantics.example.expressions.typing.CachedExpressionsSemantics;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;

public class CachedExpressionsInjectorProviderCustom extends
		ExtendedExpressionsInjectorProviderCustom {

	@Override
	protected Injector internalCreateInjector() {
		return new ExpressionsStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ExpressionsRuntimeModule() {
					@Override
					public Class<? extends ExpressionsSemantics> bindExpressionsSemantics() {
						return CachedExpressionsSemantics.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}

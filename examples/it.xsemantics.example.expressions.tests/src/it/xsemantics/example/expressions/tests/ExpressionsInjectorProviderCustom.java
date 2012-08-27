package it.xsemantics.example.expressions.tests;

import it.xsemantics.example.expressions.ExpressionsInjectorProvider;
import it.xsemantics.example.expressions.ExpressionsRuntimeModule;
import it.xsemantics.example.expressions.ExpressionsStandaloneSetup;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ExpressionsInjectorProviderCustom extends
		ExpressionsInjectorProvider {

	public static class ExpressionsSemanticsWrapper extends
			ExpressionsSemantics implements IExpressionsSemantics {

	}

	@Override
	protected Injector internalCreateInjector() {
		return new ExpressionsStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ExpressionsRuntimeModule() {
					@SuppressWarnings("unused")
					public Class<? extends IExpressionsSemantics> bindIExpressionsSemantics() {
						return ExpressionsSemanticsWrapper.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}

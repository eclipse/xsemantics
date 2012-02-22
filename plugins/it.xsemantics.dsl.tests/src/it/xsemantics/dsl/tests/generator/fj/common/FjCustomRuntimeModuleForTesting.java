package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.FJRuntimeModule;
import it.xsemantics.runtime.StringRepresentation;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;

import org.eclipse.xtext.scoping.IScopeProvider;

public class FjCustomRuntimeModuleForTesting extends FJRuntimeModule {
	private Class<? extends IFjTypeSystem> fjTypeSystemClass;

	public FjCustomRuntimeModuleForTesting(
			Class<? extends IFjTypeSystem> fjTypeSystemClass) {
		this.fjTypeSystemClass = fjTypeSystemClass;
	}

	@Override
	public java.lang.Class<? extends IScopeProvider> bindIScopeProvider() {
		return FjXsemanticsBasedScopeProvider.class;
	}

	public java.lang.Class<? extends IFjTypeSystem> bindIFjTypeSystem() {
		return fjTypeSystemClass;
	}

	public java.lang.Class<? extends StringRepresentation> bindStringRepresentation() {
		return FjTestsStringRepresentation.class;
	}

	public java.lang.Class<? extends XsemanticsBasedDeclarativeValidator> bindXsemanticsBasedDeclarativeValidator() {
		return XsemanticsBasedDeclarativeValidator.class;
	}
}
package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class FjFirstGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjStandaloneSetupFirst extends
			FjCustomStandaloneSetupForTesting {
		
		public static class FjFirstTypeSystemWrapper extends FjFirstTypeSystem
				implements IFjTypeSystem {

		}

		@Override
		protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
			return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {

				@Override
				public Class<? extends AbstractDeclarativeValidator> bindAbstractDeclarativeValidator() {
					return FjFirstTypeSystemValidator.class;
				}
				
			};
		}
		
		@Override
		protected Class<FjFirstTypeSystemWrapper> fjTypeSystemClass() {
			return FjFirstTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupFirst.class;
	}

}

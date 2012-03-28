package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

public class FjFirstGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjStandaloneSetupFirst extends
			FjCustomStandaloneSetupForTesting {
		
		public static class FjFirstTypeSystemWrapper extends FjFirstTypeSystem
				implements IFjTypeSystem {

		}
		
		public static class CustomFjTypeSystemValidator extends FjFirstTypeSystemValidator {
			@Override
			protected List<EPackage> getEPackages() {
			    List<EPackage> result = new ArrayList<EPackage>();
			    result.add(it.xsemantics.example.fj.fj.FjPackage.eINSTANCE);
				return result;
			}
		}

		@Override
		protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
			return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {

				@Override
				public Class<? extends XsemanticsBasedDeclarativeValidator> bindXsemanticsBasedDeclarativeValidator() {
					return CustomFjTypeSystemValidator.class;
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

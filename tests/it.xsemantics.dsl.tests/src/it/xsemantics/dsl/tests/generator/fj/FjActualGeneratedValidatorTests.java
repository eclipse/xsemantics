package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import it.xsemantics.example.fj.typing.validation.FjTypeSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.junit.Test;

public class FjActualGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjStandaloneSetupActual extends
			FjCustomStandaloneSetupForTesting {

		public static class CustomFjTypeSystemValidator extends
				FjTypeSystemValidator {
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
				public Class<? extends AbstractDeclarativeValidator> bindAbstractDeclarativeValidator() {
					return CustomFjTypeSystemValidator.class;
				}

				@SuppressWarnings("unused")
				public java.lang.Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
					return FjActualExpectedTraces.class;
				}

			};
		}

		@Override
		protected Class<FjActualTypeSystemWrapper> fjTypeSystemClass() {
			return FjActualTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupActual.class;
	}

	@Test
	public void testSubclassNotOverrideMethodChangingReturnType()
			throws Exception {
		assertAll(testFiles.testSubclassNotOverrideMethodChangingReturnType(),
				expectedTraces.validateSubclassNotOverrideMethodChangingReturnType());
	}
}

/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.dsl.tests.generator.fj;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xsemantics.example.fj.tests.FJInjectorProvider;
import org.eclipse.xsemantics.example.fj.typing.validation.FjSepTypeSystemValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

@InjectWith(FjSepGeneratedValidatorTests.FjSepGeneratedTypeSystemInjectorProvider.class)
@RunWith(XtextRunner.class)
public class FjSepGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjSepGeneratedTypeSystemInjectorProvider extends FJInjectorProvider {
		public static class CustomFjTypeSystemValidator extends
				FjSepTypeSystemValidator {
			@Override
			protected List<EPackage> getEPackages() {
				List<EPackage> result = new ArrayList<>();
				result.add(org.eclipse.xsemantics.example.fj.fj.FjPackage.eINSTANCE);
				return result;
			}
		}

		@Override
		protected Injector internalCreateInjector() {
			return new FjCustomStandaloneSetupForTesting() {
				@Override
				protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
					return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
						@Override
						public Class<? extends AbstractDeclarativeValidator> bindAbstractDeclarativeValidator() {
							return CustomFjTypeSystemValidator.class;
						}
						@SuppressWarnings("unused")
						public Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
							return FjSepExpectedTraces.class;
						}
					};
				}

				@Override
				protected Class<FjSepTypeSystemWrapper> fjTypeSystemClass() {
					return FjSepTypeSystemWrapper.class;
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}

	@Test
	public void testSubclassNotOverrideMethodChangingReturnType()
			throws Exception {
		assertAll(testFiles.testSubclassNotOverrideMethodChangingReturnType(),
				expectedTraces.validateSubclassNotOverrideMethodChangingReturnType());
	}
}

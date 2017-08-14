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

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xsemantics.example.fj.typing.validation.FjSepTypeSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.junit.Test;

public class FjSepGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjStandaloneSetupSep extends
			FjCustomStandaloneSetupForTesting {

		public static class CustomFjTypeSystemValidator extends
				FjSepTypeSystemValidator {
			@Override
			protected List<EPackage> getEPackages() {
				List<EPackage> result = new ArrayList<EPackage>();
				result.add(org.eclipse.xsemantics.example.fj.fj.FjPackage.eINSTANCE);
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
					return FjSepExpectedTraces.class;
				}

			};
		}

		@Override
		protected Class<FjSepTypeSystemWrapper> fjTypeSystemClass() {
			return FjSepTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupSep.class;
	}

	@Test
	public void testSubclassNotOverrideMethodChangingReturnType()
			throws Exception {
		assertAll(testFiles.testSubclassNotOverrideMethodChangingReturnType(),
				expectedTraces.validateSubclassNotOverrideMethodChangingReturnType());
	}
}

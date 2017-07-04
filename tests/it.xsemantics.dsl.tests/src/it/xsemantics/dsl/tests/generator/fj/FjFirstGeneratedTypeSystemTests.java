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

package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;

public class FjFirstGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	public static class FjStandaloneSetupFirst extends
			FjCustomStandaloneSetupForTesting {
		
		public static class FjFirstTypeSystemWrapper extends FjFirstTypeSystem
				implements IFjTypeSystem {

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

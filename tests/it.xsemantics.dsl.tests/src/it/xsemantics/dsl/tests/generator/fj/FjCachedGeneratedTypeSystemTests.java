package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.test.fj.caching.FjCachedTypeSystem;

public class FjCachedGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	public static class FjStandaloneSetupCached extends
			FjCustomStandaloneSetupForTesting {
		
		public static class FjCachedTypeSystemWrapper extends FjCachedTypeSystem
				implements IFjTypeSystem {

		}

		@Override
		protected Class<FjCachedTypeSystemWrapper> fjTypeSystemClass() {
			return FjCachedTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupCached.class;
	}

}

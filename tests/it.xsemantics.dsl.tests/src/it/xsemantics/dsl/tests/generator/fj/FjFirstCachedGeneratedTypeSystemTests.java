package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.test.fj.caching.FjFirstCachedTypeSystem;

public class FjFirstCachedGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	public static class FjStandaloneSetupCached extends
			FjCustomStandaloneSetupForTesting {
		
		public static class FjFirstCachedTypeSystemWrapper extends FjFirstCachedTypeSystem
				implements IFjTypeSystem {

		}

		@Override
		protected Class<FjFirstCachedTypeSystemWrapper> fjTypeSystemClass() {
			return FjFirstCachedTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupCached.class;
	}

}

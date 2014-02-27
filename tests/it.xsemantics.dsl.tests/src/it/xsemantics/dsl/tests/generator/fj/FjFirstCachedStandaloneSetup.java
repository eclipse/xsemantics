package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.test.fj.caching.FjFirstCachedTypeSystem;

public class FjFirstCachedStandaloneSetup extends FjCustomStandaloneSetupForTesting {
	
	@Override
	protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
		return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
			@SuppressWarnings("unused")
			public java.lang.Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
				return FjFirstCachedExpectedTraces.class;
			}
		};
	}

	public static class FjFirstCachedTypeSystemWrapper extends
			FjFirstCachedTypeSystem implements IFjTypeSystem {

	}

	@Override
	protected Class<FjFirstCachedStandaloneSetup.FjFirstCachedTypeSystemWrapper> fjTypeSystemClass() {
		return FjFirstCachedStandaloneSetup.FjFirstCachedTypeSystemWrapper.class;
	}
}
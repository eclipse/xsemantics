
package it.xsemantics.example.fj;

import it.xsemantics.example.fj.FJStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FJStandaloneSetup extends FJStandaloneSetupGenerated{

	public static void doSetup() {
		new FJStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


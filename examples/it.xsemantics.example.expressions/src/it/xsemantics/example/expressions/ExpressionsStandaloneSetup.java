
package it.xsemantics.example.expressions;

import it.xsemantics.example.expressions.ExpressionsStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExpressionsStandaloneSetup extends ExpressionsStandaloneSetupGenerated{

	public static void doSetup() {
		new ExpressionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


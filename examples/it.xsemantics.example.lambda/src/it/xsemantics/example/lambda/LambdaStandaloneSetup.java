
package it.xsemantics.example.lambda;

import it.xsemantics.example.lambda.LambdaStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LambdaStandaloneSetup extends LambdaStandaloneSetupGenerated{

	public static void doSetup() {
		new LambdaStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package it.xsemantics.dsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XsemanticsStandaloneSetup extends XsemanticsStandaloneSetupGenerated{

	public static void doSetup() {
		new XsemanticsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


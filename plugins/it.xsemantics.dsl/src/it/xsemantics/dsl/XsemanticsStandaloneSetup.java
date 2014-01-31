
package it.xsemantics.dsl;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XsemanticsStandaloneSetup extends XsemanticsStandaloneSetupGenerated{

	public static void doSetup() {
		new XsemanticsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey("http://xsemantics.sf.net/Xsemantics")) {
			EPackage.Registry.INSTANCE.put("http://xsemantics.sf.net/Xsemantics", it.xsemantics.dsl.xsemantics.XsemanticsPackage.eINSTANCE);
		}
		super.register(injector);
	}
}


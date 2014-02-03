package it.xsemantics.dsl;

import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class XsemanticsStandaloneSetup extends
		XsemanticsStandaloneSetupGenerated {

	public static void doSetup() {
		new XsemanticsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(XsemanticsPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(XsemanticsPackage.eNS_URI,
					XsemanticsPackage.eINSTANCE);
		}
		super.register(injector);
	}
}

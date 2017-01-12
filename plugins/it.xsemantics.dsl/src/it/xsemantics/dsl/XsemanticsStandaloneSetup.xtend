package it.xsemantics.dsl

import it.xsemantics.dsl.xsemantics.XsemanticsPackage
import org.eclipse.emf.ecore.EPackage
import com.google.inject.Injector

/** 
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
class XsemanticsStandaloneSetup extends XsemanticsStandaloneSetupGenerated {
	def static void doSetup() {
		new XsemanticsStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	override void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(XsemanticsPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(XsemanticsPackage.eNS_URI, XsemanticsPackage.eINSTANCE)
		}
		super.register(injector)
	}
}

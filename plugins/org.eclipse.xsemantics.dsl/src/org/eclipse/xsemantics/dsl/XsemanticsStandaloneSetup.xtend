/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.dsl

import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsPackage
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

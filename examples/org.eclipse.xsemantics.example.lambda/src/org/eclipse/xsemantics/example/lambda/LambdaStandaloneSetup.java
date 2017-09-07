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


package org.eclipse.xsemantics.example.lambda;

import org.eclipse.xsemantics.example.lambda.LambdaStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LambdaStandaloneSetup extends LambdaStandaloneSetupGenerated{

	public static void doSetup() {
		new LambdaStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


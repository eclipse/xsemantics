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

/**
 * 
 */
package org.eclipse.xsemantics.example.lambda.ui.util;

import org.eclipse.xsemantics.example.lambda.ui.internal.LambdaActivator;

import com.google.inject.Injector;

/**
 * @author bettini
 * 
 */
public class LambdaUiUtil {

	public static Injector getInjector() {
		return LambdaActivator.getInstance().getInjector(
				"org.eclipse.xsemantics.example.lambda.Lambda");
	}
}

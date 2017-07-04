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
package it.xsemantics.dsl.tests.classes;

import com.google.inject.Provider;

import it.xsemantics.runtime.XsemanticsCacheDefaultImpl;

/**
 * Just for calling protected methods.
 * 
 * @author Lorenzo Bettini
 *
 */
public class TestableCache extends XsemanticsCacheDefaultImpl {

	@Override
	public <T> T internalGet(String methodName, Provider<T> provider,
			Object... elements) {
		return super.internalGet(methodName, provider, elements);
	}
}

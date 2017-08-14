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

package org.eclipse.xsemantics.dsl.util

import com.google.inject.Provider
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.xbase.lib.Pair

/**
 * A customization of the default Xtext caching.
 * 
 * @author Lorenzo Bettini
 */
@Singleton
class XsemanticsDslCache extends OnChangeEvictingCache {
	
	def <T> T get(Pair<String,EObject> key, Provider<T> provider) {
		get(key, key.value.eResource, provider)
	}

	def <T> T get2(Pair<String,Pair<? extends EObject,? extends Object>> key, Provider<T> provider) {
		get(key, key.value.key.eResource, provider)
	}

}
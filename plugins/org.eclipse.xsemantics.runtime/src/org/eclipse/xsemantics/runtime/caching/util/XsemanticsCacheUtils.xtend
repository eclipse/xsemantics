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

package org.eclipse.xsemantics.runtime.caching.util

import org.eclipse.emf.ecore.EObject

/**
 * Utility functions for caching.
 * 
 * @author Lorenzo Bettini
 * 
 * @since 1.8
 */
class XsemanticsCacheUtils {
	
	def getResource(Object...elements) {
		elements.filter(EObject).head?.eResource
	}

	def getKeys(Object...elements) {
		elements.reduce[p1, p2| p1 -> p2]
	}
}
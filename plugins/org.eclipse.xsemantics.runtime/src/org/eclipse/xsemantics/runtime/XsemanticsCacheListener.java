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
package org.eclipse.xsemantics.runtime;

/**
 * Utility class to listen to cache events (especially for testing)
 * 
 * @author Lorenzo Bettini
 * @since 1.6
 */
public interface XsemanticsCacheListener {
	
	public void cacheMissed(XsemanticsCachedData<?> data);
	
	public void cacheHit(XsemanticsCachedData<?> data);
	
	public void reset();
}

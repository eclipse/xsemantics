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

package it.xsemantics.runtime.caching

import it.xsemantics.runtime.XsemanticsCacheListener
import java.util.ArrayList

/**
 * A utility base class for listening to XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
abstract class XsemanticsCacheLoggerListener implements XsemanticsCacheListener {

	val hits = new ArrayList<String>
	
	val missed = new ArrayList<String>
	
	override void reset() {
		hits.clear
		missed.clear
	}

	def getHits() {
		return hits
	}

	def getMissed() {
		return missed
	}
}

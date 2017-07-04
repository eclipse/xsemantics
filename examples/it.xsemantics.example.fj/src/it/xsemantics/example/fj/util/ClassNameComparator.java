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
package it.xsemantics.example.fj.util;

import java.util.Comparator;

import it.xsemantics.example.fj.fj.Class;

/**
 * Compares two classes using their names
 * 
 * @author bettini
 * 
 */
public class ClassNameComparator implements
		Comparator<it.xsemantics.example.fj.fj.Class> {

	public int compare(Class arg0, Class arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}

}

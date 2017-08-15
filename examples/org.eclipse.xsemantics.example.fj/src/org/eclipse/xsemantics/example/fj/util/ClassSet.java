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
package org.eclipse.xsemantics.example.fj.util;

import java.util.TreeSet;

import org.eclipse.xsemantics.example.fj.fj.Class;

/**
 * A set of classes (contains only one instance of a class with
 * a specific name).
 * 
 * @author bettini
 *
 */
public class ClassSet extends TreeSet<Class> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClassSet() {
		super(new ClassNameComparator());
	}
}

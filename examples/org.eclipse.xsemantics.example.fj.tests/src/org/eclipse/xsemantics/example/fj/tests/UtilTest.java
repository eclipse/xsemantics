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
package org.eclipse.xsemantics.example.fj.tests;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.FjFactory;
import org.eclipse.xsemantics.example.fj.util.ClassNameComparator;
import org.eclipse.xsemantics.example.fj.util.ClassSet;

/**
 * @author bettini
 * 
 *         Tests for utility functions
 */
public class UtilTest extends TestWithLoader {
	public UtilTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testClassComparator() {
		ClassNameComparator comparator = new ClassNameComparator();

		Class c1 = FjFactory.eINSTANCE.createClass();
		c1.setName("c1");
		Class c1bis = FjFactory.eINSTANCE.createClass();
		c1bis.setName("c1");

		assertEquals(0, comparator.compare(c1, c1bis));

		Class c2 = FjFactory.eINSTANCE.createClass();
		c2.setName("c2");

		assertTrue(comparator.compare(c1, c2) < 0);
	}

	public void testClassTreeSet() {
		ClassSet classSet = new ClassSet();

		Class c1 = FjFactory.eINSTANCE.createClass();
		c1.setName("c1");
		Class c1bis = FjFactory.eINSTANCE.createClass();
		c1bis.setName("c1");
		Class c2 = FjFactory.eINSTANCE.createClass();
		c2.setName("c2");

		classSet.add(c1);

		assertTrue(classSet.contains(c1bis));
		assertFalse(classSet.contains(c2));

		// if we add c1bis there should still be one class
		classSet.add(c1bis);

		assertEquals(1, classSet.size());
	}

}

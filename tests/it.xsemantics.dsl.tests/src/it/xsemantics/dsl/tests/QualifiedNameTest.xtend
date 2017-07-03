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

package it.xsemantics.dsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class QualifiedNameTest extends XsemanticsBaseTest {

	@Inject extension IQualifiedNameProvider
	
	@Test
	def void testParsingOfName() {
		val rule = parse(testFiles.testSimpleRule).getRules.get(0)
		Assert::assertEquals("it.xsemantics.test.TypeSystem.EClassEObject",
			rule.fullyQualifiedName.toString
		)
	}
	
}
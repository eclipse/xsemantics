/** 
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Lorenzo Bettini - Initial contribution and API
 */
/** 
 */
package org.eclipse.xsemantics.example.lambda.tests

import java.util.List
import java.util.Set
import org.eclipse.xsemantics.example.lambda.lambda.Program
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaTypeVariableFinder
import org.junit.Test

import static org.junit.Assert.*

/** 
 * @author bettini
 */
class TypeVariableTest extends LambdaAbstractBaseTest {
	package LambdaTypeVariableFinder typeVariableFinder = new LambdaTypeVariableFinder()

	@Test def void testNoTypeVariables() throws Exception {
		var String programString = "lambda x : int . x x"
		var Program program = programString.parse
		var List<TypeVariable> typeVariables = typeVariableFinder.findTypeVariables(program.getTerm())
		assertEquals(0, typeVariables.size())
	}

	@Test def void testTypeVariables() throws Exception {
		var String programString = "lambda x : X1 . lambda y . lambda z : a . y"
		var Program program = programString.parse
		var List<TypeVariable> typeVariables = typeVariableFinder.findTypeVariables(program.getTerm())
		assertEquals(2, typeVariables.size())
		assertEquals("X1", typeVariables.get(0).getTypevarName())
		assertEquals("a", typeVariables.get(1).getTypevarName())
	}

	@Test def void testTypeVariableNames() throws Exception {
		var String programString = "lambda x : X1 . lambda y : a. lambda z : a . y"
		var Program program = programString.parse
		var Set<String> typeVariableNames = typeVariableFinder.getTypeVariableNames(program.getTerm())
		assertEquals(2, typeVariableNames.size())
		assertTrue(typeVariableNames.contains("X1"))
		assertTrue(typeVariableNames.contains("a"))
	}
}

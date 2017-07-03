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

package it.xsemantics.example.fj.tests

import com.google.inject.Inject
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.Method
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.StringRepresentation
import it.xsemantics.runtime.TraceUtils
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Before
import org.junit.BeforeClass
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.EcoreUtil2.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjBaseTests {

	@Inject extension ParseHelper<Program>
	
	@Inject extension ValidationTestHelper
	
	@Inject protected TraceUtils traceUtils
	
	@Inject protected StringRepresentation stringRep
	
	protected RuleApplicationTrace trace
	
	@BeforeClass
	def static void setNewLine() {
		System::setProperty("line.separator", "\n")
	}
	
	@Before
	def void setUp() {
		trace = new RuleApplicationTrace()
	}
	
	def parseAndAssertNoError(CharSequence prog) {
		prog.parse => [
			it.assertNoErrors
		]
	}
	
	def methodByName(Program p, String methodName) {
		p.getAllContentsOfType(typeof(Method)).findFirst [
			name == methodName
		]
	}

}
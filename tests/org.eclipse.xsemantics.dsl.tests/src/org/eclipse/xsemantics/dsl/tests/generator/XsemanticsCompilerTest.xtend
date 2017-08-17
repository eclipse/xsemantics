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

package org.eclipse.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xsemantics.runtime.Result
import org.eclipse.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xsemantics.runtime.TraceUtils
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * These tests also run the generated (and on the fly compiled) Java code
 * 
 * @author Lorenzo Bettini
 */
@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCompilerTest extends XsemanticsBaseTest {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder 
	
	@Inject extension CompilationTestHelper
	
	@Inject extension ReflectExtensions
	
	@Inject extension TraceUtils

	@Inject
	var Injector injector
	
	@Test
	def testRuleInvocation() {
'''
import java.util.List

system my.test.ruleinvokations.System

judgments {
	type |- Object o : output Object
}

rule Type G |- List<String> list : Object res
from {
	res = list.head
}
'''.invokeTypeAndExpect(
'''Type: [] |- [first, second] : first''',
newArrayList("first", "second")
)
	}

	@Test
	def testRuleInvocationInsideLambda_Issue_36() {
		// https://github.com/LorenzoBettini/xsemantics/issues/36
		// the generated code used to fail to compile into Java
		// because RuleFailedException was not caught
		// now RuleFailedException extends RuntimeException
'''
import java.util.List

system my.test.ruleinvokations.System

judgments {
	type |- Object o : output Object
}

// the result is simply the input list
rule TypeList G |- List<String> list : list
from {
	list.forEach[
		element |
		// but first invoke type on every element
		G |- element : var Object r
	]
}

// the result is simply the input
axiom TypeString G |- String s : s
'''.invokeTypeAndExpect(
'''
TypeList: [] |- [first, second] : [first, second]
 TypeString: [] |- first : first
 TypeString: [] |- second : second
''',
newArrayList("first", "second")
)
	}

	@Test
	def testRuleInvocationInsideLambdaWithFailure_Issue_36() {
		// https://github.com/LorenzoBettini/xsemantics/issues/36
		// the generated code used to fail to compile into Java
		// because RuleFailedException was not caught
		// now RuleFailedException extends RuntimeException
'''
import java.util.List

system my.test.ruleinvokations.System

judgments {
	type |- Object o
}

rule TypeList G |- List<Object> list
from {
	list.forEach[
		element |
		// but first invoke type on every element
		G |- element 
	]
}

// the result is simply the input
axiom TypeString G |- String s 

// no rule defined for input Integer
'''.invokeTypeAndExpectFailure(
'''
failed: TypeList: [] |- [first, 0]
 cannot find a rule for |- 0
''',
newArrayList("first", 0)
)
	}

	@Test
	def testUseOfPreviousFailure() {
'''
import java.util.List

system my.test.ruleinvokations.System

judgments {
	type |- Object o : output Object
}

rule Type G |- List<String> list : Object res
from {
	{
		list.size > 3
	}
	or
	{
		fail
			error "there was a failure caused by: " +
				previousFailure.message
	}
}
'''.invokeTypeAndExpectFailure(
'''failed: Type: [] |- [first, second] : Object
 there was a failure caused by: failed: list.size > 3''',
newArrayList("first", "second")
)
	}

	@Test
	def testUseOfErrorInformationDataFromJudgment() {
'''
import java.util.List

system my.test.ruleinvokations.System

judgments {
	type |- Object o : output Object
		error "type has failed"
		data #["data: ", o]
}

rule TypeString G |- String s : Object res
from {
	s.isEmpty()
}

rule Type G |- List<String> list : Object res
from {
	{
		G |- list.head : res
	}
	or
	{
		fail
			error "data from failure: " +
				previousFailure.getErrorInformations.head.getData
	}
}
'''.invokeTypeAndExpectFailure(
'''failed: type has failed
 data from failure: [data: , first]''',
newArrayList("first", "second")
)
	}

	@Test
	def testUseOfErrorInformationDataFromFail() {
'''
import java.util.List
import org.eclipse.xsemantics.runtime.TraceUtils

system my.test.ruleinvokations.System

inject extension TraceUtils traceUtils

judgments {
	type |- Object o : output Object
}

rule TypeString G |- String s : Object res
from {
	fail
		error "type has failed"
		data #["data: ", s]
}

rule Type G |- List<String> list : Object res
from {
	{
		G |- list.head : res
	}
	or
	{
		// the failure we're interested in is the last one
		// we retrieve that using TraceUtils injected as extension
		fail
			error "data from failure: " +
				previousFailure.failureAsList.last.errorInformations.head.^data
	}
}
'''.invokeTypeAndExpectFailure(
'''failed: Type: [] |- [first, second] : Object
 data from failure: [data: , first]''',
newArrayList("first", "second")
)
	}

	@Test
	def testUseOfErrorInformationDataFromRule() {
'''
import java.util.List
import org.eclipse.xsemantics.runtime.TraceUtils

system my.test.ruleinvokations.System

inject extension TraceUtils traceUtils

judgments {
	type |- Object o : output Object
}

rule TypeString G |- String s : Object res
	error "type has failed"
		data #["data: ", s]
from {
	fail
}

rule Type G |- List<String> list : Object res
from {
	{
		G |- list.head : res
	}
	or
	{
		// the failure we're interested in is the last one
		// we retrieve that using TraceUtils injected as extension
		fail
			error "data from failure: " +
				previousFailure.failureAsList.last.errorInformations.head.^data
	}
}
'''.invokeTypeAndExpectFailure(
'''failed: Type: [] |- [first, second] : Object
 data from failure: [data: , first]''',
newArrayList("first", "second")
)
	}

	def private invokeTypeAndExpect(CharSequence input, CharSequence expectedTrace, Object args) {
		val system = input.instantiateSystem
		val trace = new RuleApplicationTrace
		system.invoke("type", null, trace, args)
		expectedTrace.toString.trim.assertEqualsStrings(trace.traceAsString)
	}

	def private invokeTypeAndExpectFailure(CharSequence input, CharSequence expectedTrace, Object args) {
		val system = input.instantiateSystem
		val trace = new RuleApplicationTrace
		val result = system.invoke("type", null, trace, args) as Result<Object>
		expectedTrace.toString.trim.assertEqualsStrings(result.ruleFailedException.failureTraceAsString)
	}

	def private instantiateSystem(CharSequence input) {
		val instantiated = Wrapper.forType(XsemanticsRuntimeSystem)
		input.compile[
			assertNoValidationErrors
			// don't assume that the compiled system is the first one
			val systemClass = getCompiledClass("my.test.ruleinvokations.System")
			val obj = systemClass.newInstance
			injector.injectMembers(obj)
			obj.invoke("init")
			instantiated.set(obj as XsemanticsRuntimeSystem)
		]
		return instantiated.get
	}
}

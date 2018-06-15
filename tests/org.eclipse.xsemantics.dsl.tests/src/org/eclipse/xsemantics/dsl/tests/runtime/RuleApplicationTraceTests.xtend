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
package org.eclipse.xsemantics.dsl.tests.runtime;

import org.eclipse.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xsemantics.runtime.TraceUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.spi.LoggingEvent
import org.apache.log4j.varia.NullAppender
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * @author Lorenzo Bettini
 * 
 */
class RuleApplicationTraceTests extends XsemanticsRuntimeAbstractTests {
	
	static final Logger LOGGER = Logger.getLogger(RuleApplicationTrace);
	
	extension TraceUtils = new TraceUtils
	
	var LogListener logListener
	
	static class LogListener extends NullAppender {
		
		val public events = <LoggingEvent>newArrayList()
		
		override doAppend(LoggingEvent event) {
			if (event.getLevel == Level.INFO) {
				events += event
			}
		}

		def containsMessage(String messagePart) {
			val eventsToString = events.map[message.toString].join(",")
			assertTrue("No messagePart found in " + eventsToString,
				eventsToString.contains(messagePart)
			)
		}
	}
	
	static class TestRuleApplicationTraceSubclass extends RuleApplicationTrace {
		
	}

	/**
	 * throws an InstantionException after the first instance is created: this
	 * is used to test snapshot: in the presence of exceptions snapshot simply returns
	 * the same trace
	 */
	static class TestRuleApplicationTraceWithInstantiationException extends RuleApplicationTrace {
		static var first = false
		new () {
			if (first) {
				throw new InstantiationException
			} else {
				first = true
			}
		}
	}

	/**
	 * throws an IllegalAccessException after the first instance is created: this
	 * is used to test snapshot: in the presence of exceptions snapshot simply returns
	 * the same trace
	 */
	static class TestRuleApplicationTraceWithIllegalAccessException extends RuleApplicationTrace {
		static var first = false
		new () {
			if (first) {
				throw new IllegalAccessException
			} else {
				first = true
			}
		}
	}

	@Before
	def void createAppender() {
		LOGGER.removeAllAppenders
		// avoid print errors on the console
		LOGGER.additivity = false
		logListener = new LogListener => [
			LOGGER.addAppender(it)
		]
	}

	@After
	def void removeAppender() {
		LOGGER.removeAppender(logListener)
		// reset print errors on the console
		LOGGER.additivity = true
	}

	@Test
	def void testAddAsSubtraceNull() {
		val t1 = new RuleApplicationTrace();
		t1.addAsSubtrace(null as RuleApplicationTrace);
		Assert.assertTrue(t1.isEmpty());
		t1.addObjectAsSubtrace(null as Object);
		Assert.assertTrue(t1.isEmpty());
	}

	@Test
	def void testAddNull() {
		val t1 = new RuleApplicationTrace();
		t1.addToTrace(null);
		Assert.assertTrue(t1.isEmpty());
	}

	@Test
	def void testAddObjectAsSubtraceNull() {
		val t1 = new RuleApplicationTrace();
		t1.addToTrace("first");
		t1.addObjectAsSubtrace("nested");
		'''
		first
		 nested'''.assertEqualsStrings(t1.traceAsString);
	}

	@Test
	def void testSnapshot() {
		val t1 = new RuleApplicationTrace();
		Assert.assertTrue(t1.snapshot().isEmpty());
		
		val s1 = "first";
		t1.addToTrace(s1);
		val t2 = t1.snapshot();
		assertEquals("first", t2.traceAsString);
		// modify the string in the first trace
		t1.getTrace().set(0, "modified");
		assertEquals("first", t2.traceAsString);
		
		val subTrace = new RuleApplicationTrace
		subTrace.addToTrace("second")
		t1.addAsSubtrace(subTrace)
'''modified
 second'''.assertEqualsStrings(t1.traceAsString);
 		assertEquals("first", t2.traceAsString);
 		
 		val t3 = t1.snapshot
'''modified
 second'''.assertEqualsStrings(t3.traceAsString);
 
 		subTrace.getTrace().set(0, "modified2");
'''modified
 modified2'''.assertEqualsStrings(t1.traceAsString);
'''modified
 second'''.assertEqualsStrings(t3.traceAsString);
	}

	@Test
	def void testSnapshotWithSubclass() {
		val t1 = new TestRuleApplicationTraceSubclass
		assertEquals(TestRuleApplicationTraceSubclass, t1.snapshot.class)
	}

	@Test
	def void testSnapshotWithInstantionExceptionReturnsThis() {
		TestRuleApplicationTraceWithInstantiationException.first = false;
		val t1 = new TestRuleApplicationTraceWithInstantiationException
		assertSame(t1, t1.snapshot)
		logListener.containsMessage("deep cloning of trace disabled")
	}

	@Test
	def void testSnapshotWithIllegalAccessExceptionReturnsThis() {
		TestRuleApplicationTraceWithIllegalAccessException.first = false;
		val t1 = new TestRuleApplicationTraceWithIllegalAccessException
		assertSame(t1, t1.snapshot)
		logListener.containsMessage("deep cloning of trace disabled")
	}
}

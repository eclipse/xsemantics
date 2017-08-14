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
package org.eclipse.xsemantics.dsl.tests.typesystems;

import org.eclipse.xsemantics.dsl.tests.classes.BaseClass1;
import org.eclipse.xsemantics.dsl.tests.classes.BaseClass2;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedAlternativeClass1;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedClass1;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedClass2;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedDerivedClass1;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.Result2;
import org.eclipse.xsemantics.runtime.Result3;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;

import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author bettini
 * 
 */
public class TestTypeSystemWithPolymorphicDispatcher extends
		XsemanticsRuntimeSystem {

	protected PolymorphicDispatcher<Result<Object>> nonExistentMethodDispatcher;

	protected PolymorphicDispatcher<Result2<Object, Object>> nonExistentMethodDispatcher2;

	protected PolymorphicDispatcher<Result3<Object, Object, Object>> nonExistentMethodDispatcher3;

	protected PolymorphicDispatcher<Result2<String, Integer>> stringIntegerMethodDispatcher;

	// we will have overloaded methods with BaseClass1, BaseClass2,
	// DerivedClass1, DerivedClass2
	protected PolymorphicDispatcher<Result2<String, String>> base1base2MethodDispatcher;

	protected PolymorphicDispatcher<Result2<BaseClass1, BaseClass2>> testAssignableResultDispatcher;

	protected PolymorphicDispatcher<BaseClass1> nonExistentAuxiliaryDispatcher;

	public TestTypeSystemWithPolymorphicDispatcher() {
		init();
	}

	public void init() {
		nonExistentMethodDispatcher = buildPolymorphicDispatcher1(
				"nonExistentMethod", 2 + INDEX_OF_RULE_PARAMETERS, "|-", ":");
		nonExistentMethodDispatcher2 = buildPolymorphicDispatcher2(
				"nonExistentMethod", 2 + INDEX_OF_RULE_PARAMETERS, "|-", ":");
		nonExistentMethodDispatcher3 = buildPolymorphicDispatcher3(
				"nonExistentMethod", 2 + INDEX_OF_RULE_PARAMETERS, "|-", ":");
		stringIntegerMethodDispatcher = buildPolymorphicDispatcher2(
				"stringIntegerMethodImpl", 2 + INDEX_OF_RULE_PARAMETERS, "|-",
				":");
		base1base2MethodDispatcher = buildPolymorphicDispatcher2(
				"base1base2Impl", 2 + INDEX_OF_RULE_PARAMETERS, "|-", ":");
		testAssignableResultDispatcher = buildPolymorphicDispatcher2(
				"testAssignableResultImpl", 2 + INDEX_OF_RULE_PARAMETERS, "|-",
				":");
		nonExistentAuxiliaryDispatcher = buildPolymorphicDispatcher(
				"testAuxiliaryImpl", 2 + INDEX_OF_AUX_PARAMETERS);
	}

	/**
	 * Simulates additional arguments (RuleEnvironment and RuleApplicationTrace)
	 */
	protected Object dummy = new Object();

	public void callNonExistentMethod(String foo, Integer bar) {
		nonExistentMethodDispatcher.invoke(dummy, dummy, foo, bar);
	}

	public void callNonExistentMethod2(String foo, Integer bar) {
		nonExistentMethodDispatcher2.invoke(dummy, dummy, foo, bar);
	}

	public void callNonExistentMethod3(String foo, Integer bar) {
		nonExistentMethodDispatcher3.invoke(dummy, dummy, foo, bar);
	}

	public void callNonExistentAuxiliary(String foo, Integer bar) {
		nonExistentAuxiliaryDispatcher.invoke(dummy, foo, bar);
	}

	public Result2<String, Integer> stringIntegerMethod(String foo, Integer bar) {
		return stringIntegerMethodDispatcher.invoke(dummy, dummy, foo, bar);
	}

	protected Result2<String, Integer> stringIntegerMethodImpl(Object dummy1,
			Object dummy2, String foo, Integer bar) {
		return new Result2<String, Integer>(foo, bar);
	}

	public Result2<String, String> base1base2(BaseClass1 left, BaseClass2 right) {
		return base1base2MethodDispatcher.invoke(dummy, dummy, left, right);
	}

	protected Result2<String, String> base1base2Impl(Object dummy1,
			Object dummy2, BaseClass1 left, BaseClass2 right) {
		return new Result2<String, String>("BaseClass1", "BaseClass2");
	}

	protected Result2<String, String> base1base2Impl(Object dummy1,
			Object dummy2, DerivedClass1 left, DerivedClass2 right) {
		return new Result2<String, String>("DerivedClass1", "DerivedClass2");
	}

	protected Result2<String, String> base1base2Impl(Object dummy1,
			Object dummy2, DerivedDerivedClass1 left, DerivedClass2 right) {
		return new Result2<String, String>("DerivedDerivedClass1",
				"DerivedClass2");
	}

	public Result2<BaseClass1, BaseClass2> testAssignableResult(
			BaseClass1 left, BaseClass2 right) throws RuleFailedException {
		checkNotNull(left);
		checkNotNull(right);
		Result2<BaseClass1, BaseClass2> result = testAssignableResultDispatcher
				.invoke(dummy, dummy, left, right);
		checkAssignableTo(result.getFirst(), left);
		checkAssignableTo(result.getSecond(), right);
		return result;
	}

	private void checkAssignableTo(Object result, Object destination)
			throws RuleFailedException {
		checkAssignableTo(result, destination.getClass());
	}

	public Result2<BaseClass1, BaseClass2> testAssignableResultImpl(
			Object dummy1, Object dummy2, BaseClass1 left, BaseClass2 right) {
		return new Result2<BaseClass1, BaseClass2>(
				new DerivedAlternativeClass1(), right);
	}

	@Override
	public String trimIfNotNull(String message) {
		// to make it available for testing
		return super.trimIfNotNull(message);
	}

	@Override
	public <T> Result<T> resultForFailure(Exception e) {
		// to make it available for testing
		return super.resultForFailure(e);
	}

	@Override
	public <F, S> Result2<F, S> resultForFailure2(Exception e) {
		// to make it available for testing
		return super.resultForFailure2(e);
	}

	@Override
	public <F, S, T> Result3<F, S, T> resultForFailure3(Exception e) {
		// to make it available for testing
		return super.resultForFailure3(e);
	}
}

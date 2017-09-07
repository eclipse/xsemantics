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

package org.eclipse.xsemantics.dsl.tests.generator.fj;

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.ClassType;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xsemantics.example.fj.fj.Type;
import org.eclipse.xsemantics.example.fj.fj.TypedElement;
import org.eclipse.xsemantics.example.fj.typing.FjSepTypeSystem;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

public class FjSepTypeSystemWrapper implements IFjTypeSystem {

	@Inject
	FjSepTypeSystem ts;

	public List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(
			final org.eclipse.xsemantics.example.fj.fj.Class _Class)
			throws RuleFailedException {
		return null;
	}

	public List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(
			RuleApplicationTrace _trace_,
			org.eclipse.xsemantics.example.fj.fj.Class _Class)
			throws RuleFailedException {
		return null;
	}

	public Result<List<Field>> fields(org.eclipse.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	public Result<List<Field>> fields(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			org.eclipse.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	public Result<List<Method>> methods(org.eclipse.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	public Result<Type> typedecl(TypedElement _TypedElement) {
		return null;
	}

	public Result<Type> typedecl(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, TypedElement _TypedElement) {
		return null;
	}

	public Result<Boolean> subclass(Class _Class, Class _Class_1) {
		return null;
	}

	public Result<Boolean> subclass(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Class _Class, Class _Class_1) {
		return null;
	}

	public Result<Type> type(Expression _Expression) {
		return ts.type(_Expression);
	}

	public Result<Type> type(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Expression _Expression) {
		return ts.type(_environment_, _trace_, _Expression);
	}

	public Result<ClassType> classtype(Expression _Expression) {
		return ts.classtype(_Expression);
	}

	public Result<ClassType> classtype(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Expression _Expression) {
		return ts.classtype(_environment_, _trace_, _Expression);
	}

	public Result<Boolean> subtype(Type _Type, Type _Type_1) {
		return ts.subtype(_Type, _Type_1);
	}

	public Result<Boolean> subtype(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Type _Type, Type _Type_1) {
		return ts.subtype(_environment_, _trace_, _Type, _Type_1);
	}

	public Boolean subtypeSucceeded(Type _Type, Type _Type_1) {
		return ts.subtypeSucceeded(_Type, _Type_1);
	}

	public Boolean subtypeSucceeded(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Type _Type, Type _Type_1) {
		return ts.subtypeSucceeded(_environment_, _trace_, _Type, _Type_1);
	}

	public Result<Boolean> equalstype(Type _Type, Type _Type_1) {
		return ts.equalstype(_Type, _Type_1);
	}

	public Result<Boolean> equalstype(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Type _Type, Type _Type_1) {
		return ts.equalstype(_environment_, _trace_, _Type, _Type_1);
	}

	public Result<Boolean> subtypesequence(Expression owner,
			List<Expression> _List, List<? extends TypedElement> _List_1) {
		return ts.subtypesequence(owner, _List, _List_1);
	}

	public Result<Boolean> subtypesequence(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Expression owner,
			List<Expression> _List, List<? extends TypedElement> _List_1) {
		return ts
				.subtypesequence(_environment_, _trace_, owner, _List, _List_1);
	}

	public RuleEnvironment environmentEntry(Object key, Object value) {
		return ts.environmentEntry(key, value);
	}

	public Result<Boolean> checkMain(Program program) {
		return ts.checkMain(program);
	}

	public Result<Boolean> checkMethodBody(Method method) {
		return ts.checkMethodBody(method);
	}

	public Result<Boolean> checkField(Field field) {
		return ts.checkField(field);
	}

	public Result<Boolean> checkMethodOverride(Method method) {
		return ts.checkMethodOverride(method);
	}

	public Result<Boolean> checkClassHierachyNotCyclic(Class cl) {
		return ts.checkClassHierachyNotCyclic(cl);
	}

	public Result<Boolean> check(EObject _EObject) {
		return ts.check(_EObject);
	}

	public Result<Boolean> check(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, EObject _EObject) {
		return ts.check(_environment_, _trace_, _EObject);
	}

}
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

package org.eclipse.xsemantics.dsl.tests.generator.fj.common;

import org.eclipse.xsemantics.example.fj.fj.ClassType;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xsemantics.example.fj.fj.Type;
import org.eclipse.xsemantics.example.fj.fj.TypedElement;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * This is just a common interface to be used for testing different
 * type systems for FJ.
 * 
 * @author bettini
 *
 */
public interface IFjTypeSystem {

	public abstract Result<Type> type(final Expression _Expression);

	public abstract Result<Type> type(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Expression _Expression);

	public abstract Result<ClassType> classtype(final Expression _Expression);

	public abstract Result<ClassType> classtype(
			final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Expression _Expression);

	public abstract Result<Type> typedecl(final TypedElement _TypedElement);

	public abstract Result<Type> typedecl(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final TypedElement _TypedElement);

	public abstract Result<Boolean> subtype(final Type _Type, final Type _Type_1);

	public abstract Result<Boolean> subtype(
			final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Type _Type,
			final Type _Type_1);

	public abstract Boolean subtypeSucceeded(final Type _Type, final Type _Type_1);

	public abstract Boolean subtypeSucceeded(
			final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Type _Type,
			final Type _Type_1);

	public abstract Result<Boolean> equalstype(final Type _Type, final Type _Type_1);
	
	public abstract Result<Boolean> equalstype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type _Type, final Type _Type_1);
	
	public abstract Result<Boolean> subtypesequence(final Expression owner,
			final List<Expression> _List,
			final List<? extends TypedElement> _List_1);

	public abstract Result<Boolean> subtypesequence(
			final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Expression owner,
			final List<Expression> _List,
			final List<? extends TypedElement> _List_1);

	public abstract Result<Boolean> subclass(
			final org.eclipse.xsemantics.example.fj.fj.Class _Class,
			final org.eclipse.xsemantics.example.fj.fj.Class _Class_1);

	public abstract Result<Boolean> subclass(
			final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_,
			final org.eclipse.xsemantics.example.fj.fj.Class _Class,
			final org.eclipse.xsemantics.example.fj.fj.Class _Class_1);

	public abstract List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(
			final org.eclipse.xsemantics.example.fj.fj.Class _Class) throws RuleFailedException;

	public abstract List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(
			final RuleApplicationTrace _trace_,
			final org.eclipse.xsemantics.example.fj.fj.Class _Class) throws RuleFailedException;

	public abstract Result<List<Field>> fields(
			final org.eclipse.xsemantics.example.fj.fj.Class _Class);

	public abstract Result<List<Field>> fields(
			final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_,
			final org.eclipse.xsemantics.example.fj.fj.Class _Class);

	public abstract Result<List<Method>> methods(
			final org.eclipse.xsemantics.example.fj.fj.Class _Class);

	public abstract Result<Boolean> check(final EObject _EObject);

	public abstract Result<Boolean> check(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final EObject _EObject);

	public abstract RuleEnvironment environmentEntry(Object key,
			Object value);
	
	
	public Result<Boolean> checkMain(final Program program);
	
	public Result<Boolean> checkMethodBody(final Method method);
	
	public Result<Boolean> checkField(final Field field);
	
	public Result<Boolean> checkMethodOverride(final Method method);
	
	public Result<Boolean> checkClassHierachyNotCyclic(final org.eclipse.xsemantics.example.fj.fj.Class cl);
}
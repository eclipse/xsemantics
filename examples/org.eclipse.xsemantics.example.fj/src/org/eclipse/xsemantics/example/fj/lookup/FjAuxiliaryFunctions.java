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
package org.eclipse.xsemantics.example.fj.lookup;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Member;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.util.ClassSet;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

/**
 * @author Lorenzo Bettini
 * 
 *         Auxiliary functions for looking up into classes (e.g., all the fields
 *         of a class hierarchy)
 */
public class FjAuxiliaryFunctions {

	/**
	 * Collects all the fields of a class (including the inherited ones, which
	 * will appear first in the list).
	 * 
	 * @param cl
	 * @return the fields of a class (including the inherited ones)
	 */
	public List<Field> getFields(Class cl) {
		if (cl == null)
			return Collections.emptyList();
		
		List<Field> fields = new LinkedList<Field>(selectFields(cl));
		List<Class> superClasses = getSuperclasses(cl);
		
		for (Class class1 : superClasses) {
			fields.addAll(0, selectFields(class1));
		}
		
		return fields;
	}
	
	public List<Field> selectFields(Class cl) {
		return EcoreUtil2.typeSelect(
				cl.getMembers(), Field.class);
	}

	/**
	 * Collects all the methods of a class (including the inherited ones). In
	 * case of method overriding, makes sure to get the most redefined version.
	 * 
	 * @param cl
	 * @return the methods of a class (including the inherited ones)
	 */
	public List<Method> getMethods(Class cl) {
		if (cl == null)
			return Collections.emptyList();
		
		HashMap<String, Method> methodMap = new HashMap<String, Method>();
		List<Method> methods = selectMethods(cl);

		for (Method method : methods) {
			methodMap.put(method.getName(), method);
		}

		List<Class> superClasses = getSuperclasses(cl);
		for (Class class1 : superClasses) {
			List<Method> currentClassMethods = selectMethods(class1);
			for (Method method : currentClassMethods) {
				// add it only if not already present
				if (!methodMap.containsKey(method.getName()))
					methodMap.put(method.getName(), method);
			}
		}
		
		return new LinkedList<Method>(methodMap.values());
	}
	
	public List<Method> selectMethods(Class cl) {
		return EcoreUtil2.typeSelect(
				cl.getMembers(), Method.class);
	}

	/**
	 * Computes the superclasses of a given class (also avoids duplicates, in
	 * case of cyclic hierarchy). The implicit class Object is added
	 * automatically. The superclasses respect the hierarchy order, starting
	 * from the direct superclasses up to Object.
	 * 
	 * When iterating over a class hierarchy, you should never iterate directly
	 * over the superclass of a given class since a (malformed) class hierarchy
	 * may contain a cycle and you'd end up looping. Thus, never do:
	 * 
	 * <pre>
	 * Class current = cl;
	 * while (current != null) {
	 * 		...
	 * 		current = current.getExtends();
	 * }
	 * </pre>
	 * 
	 * Instead the classes returned by this method should be used to iterate
	 * over a class hierarchy.
	 * 
	 * @param cl
	 * @return the superclasses of a given class (without duplicates)
	 */
	public List<Class> getSuperclasses(Class cl) {
		List<Class> orderedSuperClasses = new LinkedList<Class>();
		// only used to avoid loops.
		ClassSet superClasses = new ClassSet();

		Class current = cl.getSuperclass();
		while (current != null) {
			// avoid endless loops in case of cycles
			if (superClasses.contains(current))
				break;
			superClasses.add(current);
			orderedSuperClasses.add(current);
			current = current.getSuperclass();
		}

		return orderedSuperClasses;
	}

	public List<Member> getMembers(Class cl) {
		List<Member> allMembers = new LinkedList<Member>();
		allMembers.addAll(getFields(cl));
		allMembers.addAll(getMethods(cl));
		return allMembers;
	}
}

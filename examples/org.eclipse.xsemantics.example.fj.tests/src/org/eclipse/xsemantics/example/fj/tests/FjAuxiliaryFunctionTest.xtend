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
package org.eclipse.xsemantics.example.fj.tests

import com.google.inject.Inject
import java.util.List
import org.eclipse.xsemantics.example.fj.fj.Class
import org.eclipse.xsemantics.example.fj.fj.Field
import org.eclipse.xsemantics.example.fj.fj.Method
import org.eclipse.xsemantics.example.fj.fj.Program
import org.eclipse.xsemantics.example.fj.lookup.FjAuxiliaryFunctions
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.junit.Test

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjAuxiliaryFunctionTest extends FjAbstractBaseTest {
	@Inject FjAuxiliaryFunctions fixture

	@Test
	def void testOneClass() {
		var Program program = '''
			class A {
				A a;
				A m() { return this; }
			}
		'''.parseAndAssertNoError
		assertTrue(program !== null)
		var Class class1 = program.getClasses().get(0)
		var List<Field> fields = fixture.getFields(class1)
		assertEquals(1, fields.size())
		assertEquals("a", fields.get(0).getName())
	}

	@Test
	def void testTwoClasses() {
		var Program program = '''
			class A {
				A a;
				A m() { return this; }
			}
			
			class B extends A {
			
			}
		'''.parseAndAssertNoError
		assertTrue(program !== null)
		var Class class1 = program.getClasses().get(1)
		assertEquals("B", class1.getName())
		var List<Field> fields = fixture.getFields(class1)
		assertEquals(1, fields.size())
		assertEquals("a", fields.get(0).getName())
	}

	@Test
	def void testFieldsAdditions() {
		var Program program = '''
			// each subclass adds fields
			
			class A {
				A a;
			}
			
			class B extends A {
				Object b;
			}
			
			class C extends B {
				Object c;
			}
		'''.parse
		assertTrue(program !== null)
		var Class class1 = program.getClasses().get(2)
		assertEquals("C", class1.getName())
		var List<Field> fields = fixture.getFields(class1)
		assertEquals(3, fields.size())
		// inherited fields come first
		assertEquals("a", fields.get(0).getName())
		assertEquals("b", fields.get(1).getName())
		assertEquals("c", fields.get(2).getName())
	}

	@Test
	def void testGetMethods() {
		var Program program = '''
			class A {
				A a;
				A m() { return this; }
			}
			
			class B extends A {
			
			}
		'''.parseAndAssertNoError
		assertTrue(program !== null)
		var Class class1 = program.getClasses().get(1)
		assertEquals("B", class1.getName())
		var List<Method> methods = fixture.getMethods(class1)
		assertEquals(1, methods.size())
		assertEquals("m", methods.get(0).getName())
	}

	@Test
	def void testMethodsOverridden() {
		var Program program = '''
			// each subclass overrides a method
			
			class A {
				Object a;
				A m() { return new A(new Object()); }
				A n() { return new A(new Object()); }
			}
			
			class B extends A {
				Object b;
				A m() { return new B(new Object(), new Object()); }
			}
			
			class C extends B {
				Object c;
				A n() { return new C(new Object(), new Object(), new Object()); }
			}
		'''.parse
		assertTrue(program !== null)
		var Class class1 = program.getClasses().get(2)
		assertEquals("C", class1.getName())
		var List<Method> methods = fixture.getMethods(class1)
		assertEquals(2, methods.size())
		var Method m
		m = methodByName(methods, "m")
		// take the overridden version in B
		assertSame(program.getClasses().get(1), m.eContainer())
		m = methodByName(methods, "n")
		// take the overridden version in C
		assertSame(program.getClasses().get(2), m.eContainer())
	}

	@Test
	def void testSuperclasses() {
		var Program program = '''
			// each subclass overrides a method
			
			class c1 {
			}
			
			class c2 extends c1 {
			}
			
			class c3 extends c2 {
			}
		'''.parseAndAssertNoError
		// make sure to put everything in a resource
		var Class c1 = program.classes.get(0)
		var Class c2 = program.classes.get(1)
		var Class c3 = program.classes.get(2)
		var List<Class> superClasses = fixture.getSuperclasses(c1)
		assertEquals(0, superClasses.size())
		superClasses = fixture.getSuperclasses(c3)
		assertEquals(2, superClasses.size())
		assertTrue(superClasses.contains(c1))
		assertTrue(superClasses.contains(c2))
	}

	def private Method methodByName(List<Method> methods, String name) {
		return IterableExtensions::findFirst(methods,
			([Method p|return p.getName().equals(name)] as Functions.Function1<Method, Boolean>))
	}
}

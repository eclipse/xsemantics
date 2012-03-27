/**
 * 
 */
package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.lookup.AuxiliaryFunctions;
import it.xsemantics.example.fj.util.ClassFactory;
import it.xsemantics.example.fj.util.ClassSet;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author bettini
 *
 * Tests for auxiliary functions
 */
public class AuxiliaryFunctionTest extends TestWithLoader {
	AuxiliaryFunctions fixture;
	
	public AuxiliaryFunctionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		fixture = new AuxiliaryFunctions();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test for file one_class.fj
	 */
	public void testOneClass() {
		Program program = getProgramFromResource("one_class.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(0);
		List<Field> fields = fixture.getFields(class1);
		assertEquals(1, fields.size());
		assertEquals("a", fields.get(0).getName());
	}
	
	/**
	 * Test for file two_classes.fj
	 */
	public void testTwoClasses() {
		Program program = getProgramFromResource("two_classes.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(1);
		assertEquals("B", class1.getName());
		List<Field> fields = fixture.getFields(class1);
		assertEquals(1, fields.size());
		assertEquals("a", fields.get(0).getName());
	}

	/**
	 * Test for file classes_fields.fj
	 */
	public void testFieldsAdditions() {
		Program program = getProgramFromResource("classes_fields.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(2);
		assertEquals("C", class1.getName());
		List<Field> fields = fixture.getFields(class1);
		assertEquals(3, fields.size());
		assertEquals("c", fields.get(0).getName());
		assertEquals("b", fields.get(1).getName());
		assertEquals("a", fields.get(2).getName());
	}

	/**
	 * Test for file classes_fields2.fj.
	 * Fields are collected with inherited fields first.
	 */
	public void testOrderedFieldsAdditions() {
		Program program = getProgramFromResource("classes_fields2.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(2);
		assertEquals("C", class1.getName());
		List<Field> fields = fixture.getOrderedFields(class1);
		assertEquals(6, fields.size());
		assertEquals("b", fields.get(0).getName());
		assertEquals("a", fields.get(1).getName());
		assertEquals("ba", fields.get(2).getName());
		assertEquals("bb", fields.get(3).getName());
		assertEquals("cb", fields.get(4).getName());
		assertEquals("ca", fields.get(5).getName());
	}

	public void testGetField() {
		Program program = getProgramFromResource("classes_fields.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(2);
		assertEquals("C", class1.getName());
		Field field = fixture.getField(class1, "c");
		assertTrue(field != null);
		assertEquals("Object", getClassType(field.getType()).getClassref().getName());
		field = fixture.getField(class1, "a");
		assertTrue(field != null);
		assertEquals("A", getClassType(field.getType()).getClassref().getName());
		field = fixture.getField(class1, "foobar");
		assertTrue(field == null);
	}

	protected ClassType getClassType(Type type) {
		return AuxiliaryFunctions.getClassType(type);
	}
	
	/**
	 * Test for file two_classes.fj and getMethods
	 */
	public void testGetMethods() {
		Program program = getProgramFromResource("two_classes.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(1);
		assertEquals("B", class1.getName());
		List<Method> methods = fixture.getMethods(class1);
		assertEquals(1, methods.size());
		assertEquals("m", methods.get(0).getName());
	}

	/**
	 * Test for file classes_methods.fj
	 */
	public void testMethodsAdditions() {
		Program program = getProgramFromResource("classes_methods.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(2);
		assertEquals("C", class1.getName());
		List<Method> methods = fixture.getMethods(class1);
		assertEquals(3, methods.size());
		assertEquals("n", methods.get(0).getName());
		assertEquals("o", methods.get(1).getName());
		assertEquals("m", methods.get(2).getName());
	}

	public void testGetMethod() {
		Program program = getProgramFromResource("classes_methods.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(2);
		assertEquals("C", class1.getName());
		Method method = fixture.getMethod(class1, "o");
		assertTrue(method != null);
		assertEquals("C", getClassType(method.getType()).getClassref().getName());
		method = fixture.getMethod(class1, "m");
		assertTrue(method != null);
		assertEquals("A", getClassType(method.getType()).getClassref().getName());
		method = fixture.getMethod(class1, "foobar");
		assertTrue(method == null);
	}

	public void testGetMethodOverridden() {
		Program program = getProgramFromResource("classes_methods_overridden.fj");
		assertTrue(program != null);
		Class class1 = program.getClasses().get(2);
		assertEquals("C", class1.getName());
		Method method = fixture.getMethod(class1, "m");
		assertTrue(method != null);
		assertEquals("B", ((New)(method.getBody().getExpression())).getType().getClassref().getName());
		method = fixture.getMethod(class1, "n");
		assertTrue(method != null);
		assertEquals("C", ((New)(method.getBody().getExpression())).getType().getClassref().getName());
		method = fixture.getMethod(class1, "foobar");
		assertTrue(method == null);
	}

	public void testSuperclasses() {
		// make sure to put everything in a resource
		Resource resource = createResource();
		
		Class c1 = ClassFactory.createClass("c1");
		resource.getContents().add(c1);
		Class c2 = ClassFactory.createClass("c2", c1);
		resource.getContents().add(c2);
		Class c3 = ClassFactory.createClass("c3", c2);
		resource.getContents().add(c3);
		
		ClassSet superClasses = fixture.getSuperclasses(c1);
		// Object is implicit
		assertEquals(0, superClasses.size());
		
		superClasses = fixture.getSuperclasses(c3);
		assertEquals(2, superClasses.size());
		assertTrue(superClasses.contains(c1));
		assertTrue(superClasses.contains(c2));
	}
	
	public void testOrderedSuperclasses() {
		// make sure to put everything in a resource
		Resource resource = createResource();
		
		Class c1 = ClassFactory.createClass("c1");
		resource.getContents().add(c1);
		Class c2 = ClassFactory.createClass("c2", c1);
		resource.getContents().add(c2);
		Class c3 = ClassFactory.createClass("c3", c2);
		resource.getContents().add(c3);
		
		List<Class> superClasses = fixture.getOrderedSuperclasses(c1);
		// Object is implicit
		assertEquals(0, superClasses.size());
		
		superClasses = fixture.getOrderedSuperclasses(c3);
		assertEquals(2, superClasses.size());
		assertEquals("c2", superClasses.get(0).getName());
		assertEquals("c1", superClasses.get(1).getName());
	}
}

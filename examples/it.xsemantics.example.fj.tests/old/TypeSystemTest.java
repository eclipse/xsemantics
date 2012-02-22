/**
 * 
 */
package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.fj.BoolConstant;
import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.IntConstant;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.fj.StringConstant;
import it.xsemantics.example.fj.lookup.AuxiliaryFunctions;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.example.fj.typing.FJTypeSystem;
import it.xsemantics.example.fj.typing.TypeResult;
import it.xsemantics.example.fj.util.ContainingClassFinder;
import it.xsemantics.example.fj.util.FjTypeUtils;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * @author bettini
 * 
 *         Tests for type system
 */
public class TypeSystemTest extends TestWithLoader {
	FJTypeSystem fixture;

	public TypeSystemTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		fixture = getTypeSystem();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test the type for new instance
	 */
	public void testNew() {
		Class c = FjFactory.eINSTANCE.createClass();
		c.setName("A");
		New n = FjFactory.eINSTANCE.createNew();
		n.setType(FjTypeUtils.createClassType(c));

		TypeResult typeResult = fixture.getType(n);
		assertEquals("A", FjTypeUtils.typeToString(typeResult.getType()));
	}

	/**
	 * Test the typability of the expression
	 * 
	 * <pre>
	 * new A(new F()).f
	 * </pre>
	 * 
	 * where
	 * 
	 * <pre>
	 * class F {}
	 * 
	 * class A {
	 * 	F f;
	 * }
	 * </pre>
	 */
	public void testFieldSelection() throws IOException {
		Program program = getProgramFromString("class F {} class A { F f;} new A(new F()).f");
		Selection selection = (Selection)program.getMain();
		
		TypeResult typeResult = fixture.getType(selection);
		System.out.println("type: " + typeResult);
		assertTrue(typeResult.getType() != null);
		assertEquals("F", FjTypeUtils.typeToString(typeResult.getType()));
	}

	/**
	 * Test the typability of the expression
	 * 
	 * <pre>
	 * this.f
	 * </pre>
	 * 
	 * where
	 * 
	 * <pre>
	 * class A {
	 * 	F f;
	 * }
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testFieldSelectionOnThis() throws IOException {
		Program program = getProgramFromString("class F {} class A { F f; F m() { return this.f; }}");

		Expression exp = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0)
				.getBody().getExpression();

		TypeResult typeResult = fixture.getTypeWithBindingOfThis(exp);
		System.out.println("type: " + typeResult);
		assertTrue(typeResult.getType() != null);
		assertEquals("F", FjTypeUtils.typeToString(typeResult.getType()));
	}

	/**
	 * Test the typability of the expression
	 * 
	 * <pre>
	 * this.f.g
	 * </pre>
	 * 
	 * where
	 * 
	 * <pre>
	 * class A {
	 * 	F f;
	 * }
	 * 
	 * class G {}
	 * 
	 * class F {
	 *  G g
	 * }
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testFieldSelectionOnField() throws IOException {
		Program program = getProgramFromString("class F { G g; } class A { F f; G m() { return this.f.g; }} class G {}");

		Expression exp = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0)
				.getBody().getExpression();

		TypeResult typeResult = fixture.getTypeWithBindingOfThis(exp);
		System.out.println("type: " + typeResult);
		assertTrue(typeResult.getType() != null);
		assertEquals("G", FjTypeUtils.typeToString(typeResult.getType()));
	}

	/**
	 * Tests finding the class of this
	 * 
	 * @throws IOException
	 */
	public void testFindContainingClass() throws IOException {
		Program program = getProgramFromString("class A { A f; A m() { return this; }}");
		Expression thisV = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getBody().getExpression();
		Class containingClass = new ContainingClassFinder()
				.getContainingClass(thisV);
		System.out.println("containing class: " + containingClass.getName());
		assertEquals("A", containingClass.getName());
	}

	/**
	 * Tests finding the class of this
	 * 
	 * @throws IOException
	 */
	public void testFindContainingClass2() throws IOException {
		Program program = getProgramFromString("class A { A f; A m() { return new A(this); }}");
		New newA = (New) FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getBody().getExpression();
		Expression thisV = newA.getArgs().get(0);
		Class containingClass = new ContainingClassFinder()
				.getContainingClass(thisV);
		System.out.println("containing class: " + containingClass.getName());
		assertEquals("A", containingClass.getName());
	}

	/**
	 * Cannot find the class of this in the main
	 * 
	 * @throws IOException
	 */
	public void testFindContainingClassFail() throws IOException {
		Program program = getProgramFromString("this");
		Expression thisV = program.getMain();
		Class containingClass = new ContainingClassFinder()
				.getContainingClass(thisV);
		assertTrue(containingClass == null);
	}

	/**
	 * Test the type for new instance
	 */
	public void testCannotType() {
		New n = FjFactory.eINSTANCE.createNew();
		n.setType(FjTypeUtils.createClassType(null));

		TypeResult typeResult = fixture.getType(n);
		assertEquals(null, typeResult.getDiagnostic());
		assertEquals(null, typeResult.getClassref());
	}

	/**
	 * Test the typability of the expression
	 * 
	 * <pre>
	 * this.n()
	 * </pre>
	 * 
	 * where
	 * 
	 * <pre>
	 * class A {
	 * 	F m() {
	 * 		return this.n();
	 * 	}
	 * 
	 * 	F m() {
	 * 		return new F();
	 * 	}
	 * }
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testMethodSelectionOnThis() throws IOException {
		Program program = getProgramFromString("class F {} class A { F f; F m() { return this.n(); } F n() { return new F(); }}");

		Expression exp = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0)
				.getBody().getExpression();

		TypeResult typeResult = fixture.getTypeWithBindingOfThis(exp);
		System.out.println("type: " + typeResult);
		assertTrue(typeResult.getType() != null);
		assertEquals("F", FjTypeUtils.typeToString(typeResult.getType()));
	}

	/**
	 * Test the untypability of field selection on a basic type
	 * 
	 * @throws IOException
	 */
	public void testFieldSelectionOnBasicTypes() throws IOException {
		EList<Diagnostic> errors = getErrorProgramFromString("class A { int f; int g; int m() { return this.f.g; }}");

		System.out.println("errors: " + errors);
		assertEquals(1, errors.size());
		System.out.println("error: " + errors.get(0).getMessage());
		assertEquals("Couldn't resolve reference to Field 'g'.", errors.get(0)
				.getMessage());
	}

	/**
	 * Test the untypability of method selection on a basic type
	 * 
	 * @throws IOException
	 */
	public void testMethodSelectionOnBasicTypes() throws IOException {
		EList<Diagnostic> errors = getErrorProgramFromString("class A { int f; int m() { return this.f.m(); }}");

		System.out.println("errors: " + errors);
		assertEquals(1, errors.size());
		System.out.println("error: " + errors.get(0).getMessage());
		assertEquals("Couldn't resolve reference to Method 'm'.", errors.get(0)
				.getMessage());
	}

	public void testField() throws IOException {
		Program program = getProgramFromString("class A { Object f;}");
		Field field = FjAuxiliaryFunctions.selectFields(program.getClasses().get(0)).get(0);
		TypeResult typeResult = fixture.getType(field);
		assertTrue(typeResult.getClassref() != null);
		assertEquals("Object", typeResult.getClassref().getName());
	}

	public void testParameter() throws IOException {
		Program program = getProgramFromString("class A { A m(A a, Object o) {return a;} }");
		Parameter parameter = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getParams().get(0);
		TypeResult typeResult = fixture.getType(parameter);
		assertTrue(typeResult.getClassref() != null);
		assertEquals("A", typeResult.getClassref().getName());
		parameter = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0).getParams()
				.get(1);
		typeResult = fixture.getType(parameter);
		assertTrue(typeResult.getClassref() != null);
		assertEquals("Object", typeResult.getClassref().getName());
	}

	public void testVariable() throws IOException {
		Program program = getProgramFromString("class A { A m(A a, Object o) {return a;} }");
		Expression variable = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getBody().getExpression();
		TypeResult typeResult = fixture.getType(variable);
		assertTrue(typeResult.getClassref() != null);
		assertEquals("A", typeResult.getClassref().getName());
	}
	
	public void testConstant() throws IOException {
		StringConstant stringConstant = FjFactory.eINSTANCE.createStringConstant();
		stringConstant.setConstant("foobar");
		TypeResult typeResult = fixture.getType(stringConstant);
		assertTrue(typeResult.getBasicType() != null);
		assertEquals("String", AuxiliaryFunctions.getBasicType(typeResult.getType()).getBasic());
		
		IntConstant intConstant = FjFactory.eINSTANCE.createIntConstant();
		intConstant.setConstant(10);
		typeResult = fixture.getType(intConstant);
		assertTrue(typeResult.getBasicType() != null);
		assertEquals("int", AuxiliaryFunctions.getBasicType(typeResult.getType()).getBasic());
		
		BoolConstant boolConstant = FjFactory.eINSTANCE.createBoolConstant();
		boolConstant.setConstant("true");
		typeResult = fixture.getType(boolConstant);
		assertTrue(typeResult.getBasicType() != null);
		assertEquals("boolean", AuxiliaryFunctions.getBasicType(typeResult.getType()).getBasic());
		
		Resource resource = loadFromString
			("class A { int m() { return 10; } boolean n() {return false;} String p() { return \"foo\";}}");
		EList<Diagnostic> errors = resource.getErrors();
		assertTrue(errors.size() == 0);
	}

}

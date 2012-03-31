/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProgramTest.java,v 1.1 2009-11-02 11:25:13 bettini Exp $
 */
package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.lookup.AuxiliaryFunctions;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.example.fj.util.ClassFactory;
import it.xsemantics.example.fj.util.FragmentPrinter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Program</b></em>'. <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class ProgramTest extends TestWithLoader {

	/**
	 * The fixture for this Program test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Program fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProgramTest.class);
	}

	/**
	 * Constructs a new Program test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProgramTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Program test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Program fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Program test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Program getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setFixture(FjFactory.eINSTANCE.createProgram());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * An empty program must not have Object either
	 */
	public void testEmptyProgram() {
		assertEquals(0, fixture.getClasses().size());
	}

	/**
	 * An empty resource must not have Object either
	 */
	public void testEmptyResource() {
		Resource resource = createResource();

		assertEquals(0, resource.getContents().size());
	}

	/**
	 * Test that object is not automatically added to the resource when using a
	 * model directly
	 */
	public void testResourceWithOneClass() {
		Resource resource = createResource();

		resource.getContents().add(fixture);
		assertEquals(1, sizeOfIterable(resource.getAllContents()));

		Class cl = ClassFactory.createClass("A");
		fixture.getClasses().add(cl);
		assertEquals(1, fixture.getClasses().size());
	}

	/**
	 * In a program, class Object is always implicitly added
	 * 
	 * @throws IOException
	 */
	public void testSimpleProgram() throws IOException {
		Resource resource = loadFromString("new Object()");
		fixture = (Program) resource.getContents().get(0);
		New n = (New) fixture.getMain();
		assertEquals("Object", n.getType().getClassref().getName());
	}

	/**
	 * Saves the resource corresponding to a program and makes sure that the
	 * result is just the same as the original program source.
	 * 
	 * @throws IOException
	 */
	public void testSaveResource() throws IOException {
		String program = "new Object()";
		Resource resource = loadFromString(program);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, null);
		// the saved program must not contain the implicit class object
		assertEquals(program, outputStream.toString());
	}

	/**
	 * Saves the resource corresponding to a program and makes sure that the
	 * result is just the same as the original program source.
	 * 
	 * @throws IOException
	 */
	public void testSaveResource2() throws IOException {
		String program = "class A extends Object {}";
		Resource resource = loadFromString(program);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (XtextSerializationException e) {
			e.printStackTrace();
			throw e;
		}
		// the saved program must not contain the implicit class object
		assertEquals(program, outputStream.toString());
	}

	/**
	 * Saves the resource corresponding to a program and makes sure that the
	 * result is just the same as the original program source.
	 * 
	 * @throws IOException
	 */
	public void testSaveResourceWithInheritance() throws IOException {
		String program = "class A {} class B extends A {} class C extends B{}";
		Resource resource = loadFromString(program);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, null);
		fixture = (Program) resource.getContents().get(0);
		Class C = fixture.getClasses().get(2);
		assertEquals("C", C.getName());
		assertEquals("B", C.getSuperclass().getName());
		// the saved program must not contain the implicit class object
		assertEquals(program, outputStream.toString());
	}

	/**
	 * Print the fragments of all elements of a program, and checks
	 * that reference to types have exactly the same fragment of the types
	 * themselves (thus we can uniquely refer to a class in a resource
	 * using its fragment).
	 * 
	 * @throws IOException
	 */
	public void testFragments() throws IOException {
		Program program = getProgramFromString("class A { B b; A c; C m(Object a) { return new C(); } } class B {} class C {}");
		FragmentPrinter fragmentPrinter = new FragmentPrinter();
		//fragmentPrinter.printFragment(program.eResource());
		String fragmentToStringA = fragmentPrinter.fragmentToString(program.getClasses()
				.get(0));
		String fragmentToStringB = fragmentPrinter.fragmentToString(program.getClasses()
				.get(1));
		String fragmentToStringC = fragmentPrinter.fragmentToString(program.getClasses()
				.get(2));
		String fragmentToString_btype = fragmentPrinter
				.fragmentToString(AuxiliaryFunctions.getClassType(
						FjAuxiliaryFunctions.selectFields(program.getClasses().get(0)).get(0)
								.getType()).getClassref());
		String fragmentToString_ctype = fragmentPrinter
				.fragmentToString(AuxiliaryFunctions.getClassType(
						FjAuxiliaryFunctions.selectFields(program.getClasses().get(0)).get(1)
								.getType()).getClassref());
		String fragmentToString_mrettype = fragmentPrinter
				.fragmentToString(AuxiliaryFunctions.getClassType(
						FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
								.getType()).getClassref());
		
		assertEquals(fragmentToStringB, fragmentToString_btype);
		assertEquals(fragmentToStringA, fragmentToString_ctype);
		assertEquals(fragmentToStringC, fragmentToString_mrettype);
	}
} // ProgramTest

package it.xsemantics.example.lambda.tests;

import org.junit.Before;
import org.junit.Test;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.BasicType;
import it.xsemantics.example.lambda.lambda.LambdaFactory;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.xsemantics.LambdaTypeBeautifier;

import junit.framework.TestCase;

import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.*;

public class LambdaTypeBeautifierTests extends TestCase {
	LambdaTypeBeautifier lambdaTypeBeautifier;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		lambdaTypeBeautifier = new LambdaTypeBeautifier();
	}

	@Test
	public void testGetBeautifiedStringIntType() {
		BasicType type = LambdaFactory.eINSTANCE.createIntType();

		String s;

		s = lambdaTypeBeautifier.getBeautifiedString(type);
		assertEquals("int", s);
	}
	
	@Test
	public void testGetBeautifiedStringStringType() {
		BasicType type = LambdaFactory.eINSTANCE.createStringType();

		String s;

		s = lambdaTypeBeautifier.getBeautifiedString(type);
		assertEquals("string", s);
	}

	@Test
	public void testGetBeautifiedStringTypeVariable() {
		TypeVariable typeVariable1 = createTypeVariable("X1");
		TypeVariable typeVariable2 = createTypeVariable("X2");

		String s;

		s = lambdaTypeBeautifier.getBeautifiedString(typeVariable1);
		assertEquals("a", s);
		s = lambdaTypeBeautifier.getBeautifiedString(typeVariable2);
		assertEquals("b", s);
		s = lambdaTypeBeautifier.getBeautifiedString(typeVariable1);
		assertEquals("a", s);
	}

	@Test
	public void testGetBeautifiedStringArrowType() {
		ArrowType arrowType = createArrowType(
				createTypeVariable("X1"),
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X1")));
		String s;
		s = lambdaTypeBeautifier.getBeautifiedString(arrowType);
		assertEquals("a -> b -> a", s);
	}

	@Test
	public void testGetBeautifiedStringArrowType2() {
		ArrowType arrowType = createArrowType(
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X1")), createTypeVariable("X2"));
		String s;
		s = lambdaTypeBeautifier.getBeautifiedString(arrowType);
		assertEquals("(a -> b) -> a", s);
	}

	@Test
	public void testGetBeautifiedStringArrowType3() {
		ArrowType arrowType = createArrowType(
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X1")),
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X3")));
		String s;
		s = lambdaTypeBeautifier.getBeautifiedString(arrowType);
		assertEquals("(a -> b) -> a -> c", s);
	}

	@Test
	public void testBeautifyIntType() {
		BasicType type = LambdaFactory.eINSTANCE.createIntType();

		lambdaTypeBeautifier.beautifyTypeVariables(type);
	}

	@Test
	public void testBeautifyTypeVariable() {
		TypeVariable type = createTypeVariable("X1");

		lambdaTypeBeautifier.beautifyTypeVariables(type);
		assertEquals("a", type.getTypevarName());
	}

	@Test
	public void testBeautifyArrowType() {
		ArrowType arrowType = createArrowType(createTypeVariable("X2"),
				createTypeVariable("X1"));
		lambdaTypeBeautifier.beautifyTypeVariables(arrowType);
		assertEquals("a", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("b", getTypeVariable(arrowType.getRight())
				.getTypevarName());
	}

	@Test
	public void testBeautifyArrowTypeAlreadyBeautified() {
		ArrowType arrowType = createArrowType(createTypeVariable("b"),
				createTypeVariable("a"));
		lambdaTypeBeautifier.beautifyTypeVariables(arrowType);
		assertEquals("b", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("a", getTypeVariable(arrowType.getRight())
				.getTypevarName());
	}

	@Test
	public void testBeautifyArrowTypeWithExistingTypeVariables() {
		ArrowType arrowType = createArrowType(createTypeVariable("a"),
				createTypeVariable("X1"));
		lambdaTypeBeautifier.beautifyTypeVariables(arrowType);
		assertEquals("a", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("b", getTypeVariable(arrowType.getRight())
				.getTypevarName());
	}

	private TypeVariable createTypeVariable(String name) {
		TypeVariable typeVariable = LambdaFactory.eINSTANCE
				.createTypeVariable();
		typeVariable.setTypevarName(name);
		return typeVariable;
	}

	private ArrowType createArrowType(Type left, Type right) {
		ArrowType arrowType = LambdaFactory.eINSTANCE.createArrowType();
		arrowType.setLeft(left);
		arrowType.setRight(right);
		return arrowType;
	}
}

/**
 * 
 */
package it.xsemantics.example.lambda.xsemantics;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.LambdaFactory;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;

/**
 * @author bettini
 * 
 */
public class LambdaUtils {

	protected static int counter = 0;

	public static void resetCounter() {
		counter = 0;
	}

	public static TypeVariable createTypeVariable(String name) {
		TypeVariable typeVariable = LambdaFactory.eINSTANCE
				.createTypeVariable();
		typeVariable.setTypevarName(name);
		return typeVariable;
	}

	public static TypeVariable createFreshTypeVariable() {
		return createTypeVariable("X" + ++counter);
	}

	public static ArrowType createFreshArrowType() {
		return createArrowType(createFreshTypeVariable(),
				createFreshTypeVariable());
	}

	public static ArrowType createArrowType(Type left, Type right) {
		ArrowType arrowType = LambdaFactory.eINSTANCE.createArrowType();
		arrowType.setLeft(left);
		arrowType.setRight(right);
		return arrowType;
	}

	public static StringType createStringType() {
		return LambdaFactory.eINSTANCE.createStringType();
	}

	public static IntType createIntType() {
		return LambdaFactory.eINSTANCE.createIntType();
	}
}

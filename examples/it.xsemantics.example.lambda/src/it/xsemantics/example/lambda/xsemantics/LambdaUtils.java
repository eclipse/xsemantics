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

	protected int counter = 0;

	public void resetCounter() {
		counter = 0;
	}

	public TypeVariable createTypeVariable(String name) {
		TypeVariable typeVariable = LambdaFactory.eINSTANCE
				.createTypeVariable();
		typeVariable.setTypevarName(name);
		return typeVariable;
	}

	public TypeVariable createFreshTypeVariable() {
		return createTypeVariable("X" + ++counter);
	}

	public ArrowType createFreshArrowType() {
		return createArrowType(createFreshTypeVariable(),
				createFreshTypeVariable());
	}

	public ArrowType createArrowType(Type left, Type right) {
		ArrowType arrowType = LambdaFactory.eINSTANCE.createArrowType();
		arrowType.setLeft(left);
		arrowType.setRight(right);
		return arrowType;
	}

	public StringType createStringType() {
		return LambdaFactory.eINSTANCE.createStringType();
	}

	public IntType createIntType() {
		return LambdaFactory.eINSTANCE.createIntType();
	}
}

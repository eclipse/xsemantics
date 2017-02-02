/**
 * 
 */
package it.xsemantics.example.lambda.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.xsemantics.LambdaUtils;
import it.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaUtilsTests {

	@Inject StringRepresentation stringRep;
	
	@Inject LambdaUtils lambdaUtils;
	
	@Before
	public void setUp() {
		lambdaUtils.resetCounter();
	}
	
	@Test
	public void testFreshVars() {
		assertTypeVarName("X1", lambdaUtils.createFreshTypeVariable());
		assertTypeVarName("X2", lambdaUtils.createFreshTypeVariable());
	}
	
	@Test
	public void testFreshVarsAfterReset() {
		assertTypeVarName("X1", lambdaUtils.createFreshTypeVariable());
		lambdaUtils.resetCounter();
		assertTypeVarName("X1", lambdaUtils.createFreshTypeVariable());
	}
	
	@Test
	public void testFreshArrowType() {
		assertArrowType("(X1 -> X2)", lambdaUtils.createFreshArrowType());
	}
	
	protected void assertTypeVarName(String expected, TypeVariable typeVariable) {
		Assert.assertEquals(expected, typeVariable.getTypevarName());
	}
	
	protected void assertArrowType(String expected, ArrowType arrowType) {
		Assert.assertEquals(expected, stringRep.string(arrowType));
	}
}

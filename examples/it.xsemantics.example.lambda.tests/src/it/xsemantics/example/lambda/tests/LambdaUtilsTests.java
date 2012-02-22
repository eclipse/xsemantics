/**
 * 
 */
package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.xsemantics.LambdaUtils;
import it.xsemantics.runtime.StringRepresentation;
import junit.framework.Assert;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author bettini
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaUtilsTests {

	@Inject StringRepresentation stringRep;
	
	@Before
	public void setUp() {
		LambdaUtils.resetCounter();
	}
	
	@Test
	public void testFreshVars() {
		assertTypeVarName("X1", LambdaUtils.createFreshTypeVariable());
		assertTypeVarName("X2", LambdaUtils.createFreshTypeVariable());
	}
	
	@Test
	public void testFreshVarsAfterReset() {
		assertTypeVarName("X1", LambdaUtils.createFreshTypeVariable());
		LambdaUtils.resetCounter();
		assertTypeVarName("X1", LambdaUtils.createFreshTypeVariable());
	}
	
	@Test
	public void testFreshArrowType() {
		assertArrowType("(X1 -> X2)", LambdaUtils.createFreshArrowType());
	}
	
	protected void assertTypeVarName(String expected, TypeVariable typeVariable) {
		Assert.assertEquals(expected, typeVariable.getTypevarName());
	}
	
	protected void assertArrowType(String expected, ArrowType arrowType) {
		Assert.assertEquals(expected, stringRep.string(arrowType));
	}
}

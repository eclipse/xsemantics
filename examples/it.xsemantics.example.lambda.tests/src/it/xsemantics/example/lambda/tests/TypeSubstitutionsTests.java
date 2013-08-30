/**
 * 
 */
package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bettini
 *
 */
public class TypeSubstitutionsTests extends LambdaBaseTest {

	TypeSubstitutions substitutions;
	
	@Before
	public void setUp() {
		lambdaUtils.resetCounter();
		substitutions = new TypeSubstitutions();
	}
	
	@Test
	public void testWithMappedVar() {
		TypeVariable typeVariable = lambdaUtils.createFreshTypeVariable();
		addSubst(typeVariable, lambdaUtils.createFreshTypeVariable());
		Type mapped = mapped(typeVariable);
		Assert.assertTrue(mapped != null);
		assertTypeVariable(mapped, "X2");
	}
	
	@Test
	public void testReset() {
		TypeVariable typeVariable = lambdaUtils.createFreshTypeVariable();
		addSubst(typeVariable, lambdaUtils.createFreshTypeVariable());
		substitutions.reset();
		Type mapped = mapped(typeVariable);
		Assert.assertTrue(mapped == null);
	}
	
	protected void addSubst(TypeVariable typeVariable, Type type) {
		substitutions.add(typeVariable.getTypevarName(), type);
	}
	
	protected Type mapped(TypeVariable typeVariable) {
		return substitutions.mapped(typeVariable.getTypevarName());
	}
}

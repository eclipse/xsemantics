/**
 * 
 */
package it.xsemantics.dsl.typing;

import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Singleton;

/**
 * @author bettini
 * 
 */
@SuppressWarnings("restriction")
@Singleton
public class XsemanticsXbaseTypeProvider extends XbaseTypeProvider {

	@Override
	protected JvmTypeReference type(XExpression expression,
			JvmTypeReference rawExpectation, boolean rawType) {

		if (expression instanceof RuleInvocation
				|| expression instanceof OrExpression
				|| expression instanceof Fail) {
			return getTypeReferences().createAnyTypeReference(expression);
		} else if (expression instanceof EnvironmentAccess) {
			return ((EnvironmentAccess) expression).getType();
		} else if (expression instanceof RuleInvocationExpression) {
			RuleInvocationExpression ruleInvocationExpression = (RuleInvocationExpression) expression;
			return super.type(ruleInvocationExpression.getExpression(),
					rawExpectation, rawType);
		} else if (expression instanceof XVariableDeclaration) {
			// xbase type provider does not seem to return the type for var decl
			XVariableDeclaration varDecl = (XVariableDeclaration) expression;
			return varDecl.getType();
		}

		return super.type(expression, rawExpectation, rawType);
	}

}

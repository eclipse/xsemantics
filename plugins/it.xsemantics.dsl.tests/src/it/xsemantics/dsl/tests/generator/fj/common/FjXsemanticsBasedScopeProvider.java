/**
 * 
 */
package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.example.fj.util.FjTypeUtils;
import it.xsemantics.runtime.RuleEnvironment;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.inject.Inject;

/**
 * @author bettini
 * 
 */
public class FjXsemanticsBasedScopeProvider extends
		AbstractDeclarativeScopeProvider {

	@Inject
	IFjTypeSystem typeSystem;

	public IScope scope_Member(Selection sel, EReference ref) {
		return Scopes.scopeFor(FjAuxiliaryFunctions
				.getMembers(getExpressionClass(sel.getReceiver())));
	}

	protected Class getExpressionClass(Expression receiver) {
		ClassType classType = typeSystem.classtype(
				environmentForExpression(receiver), null, receiver).getValue();
		return (classType != null ? classType.getClassref() : null);
	}

	private RuleEnvironment environmentForExpression(Expression expression) {
		Class containingClass = EcoreUtil2.getContainerOfType(expression,
				Class.class);
		if (containingClass != null) {
			ClassType thisType = FjTypeUtils.createClassType(containingClass);
			return new RuleEnvironment(typeSystem.environmentEntry("this",
					thisType));
		}
		return null;
	}
}

package it.xsemantics.dsl.validation;

import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.RuleInvocation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

public class XsemanticsXExpressionHelper extends XExpressionHelper {

	@Inject
	protected XsemanticsTypeSystem typeSystem;

	@Override
	public boolean hasSideEffects(XExpression expr) {
		if (typeSystem.isBooleanPremise(expr)) {
			// in this case we consider it valid
			// since it will be generated to a correct Java statement
			return true;
		}
		if (isXsemanticsXExpression(expr)) {
			// in this case we consider it valid
			// since it will be generated to a correct Java statement
			return true;
		}
		return super.hasSideEffects(expr);
	}

	public boolean isXsemanticsXExpression(EObject eObject) {
		return eObject instanceof RuleInvocation
				|| eObject instanceof OrExpression 
				|| eObject instanceof Fail
				|| eObject instanceof ErrorSpecification;
	}
}

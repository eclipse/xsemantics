package it.xsemantics.dsl.util;

import it.xsemantics.dsl.typing.XsemanticsTypingSystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class XsemanticsXExpressionHelper extends XExpressionHelper {

	@Inject
	protected XsemanticsTypingSystem typingSystem;
	
	@Override
	public boolean isJavaStatementExpression(XExpression expr) {
		if (typingSystem.isBooleanPremise(expr)) {
			// in this case we consider it valid
			// since it will be generated correctly
			return true;
		}
		return super.isJavaStatementExpression(expr);
	}
}

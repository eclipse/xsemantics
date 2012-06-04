package it.xsemantics.dsl.validation;

import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("restriction")
public class TempXsemanticsJavaValidator extends XsemanticsJavaValidator {

	@Override
	public void checkImplicitReturn(XExpression expr) {
		// we will deal with this during generation
		return;
	}
}

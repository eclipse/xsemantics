package it.xsemantics.test.particular.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.particular.ecore.TypeSystem;

public class TypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
	@Inject
	protected TypeSystem xsemanticsSystem;

}

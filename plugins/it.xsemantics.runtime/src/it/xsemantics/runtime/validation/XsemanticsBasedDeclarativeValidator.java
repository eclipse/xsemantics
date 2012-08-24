/**
 * 
 */
package it.xsemantics.runtime.validation;

import it.xsemantics.runtime.ResultWithFailure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsBasedDeclarativeValidator extends
		AbstractDeclarativeValidator {

	@Inject
	protected XsemanticsValidatorErrorGenerator errorGenerator;

	protected void generateErrors(ResultWithFailure resultWithFailure,
			EObject originalSource) {
		errorGenerator.generateErrors(this,
				resultWithFailure.getRuleFailedException(), originalSource);
	}
}

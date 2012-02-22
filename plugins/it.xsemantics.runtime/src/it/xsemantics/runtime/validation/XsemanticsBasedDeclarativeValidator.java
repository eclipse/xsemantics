/**
 * 
 */
package it.xsemantics.runtime.validation;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.ResultWithFailure;
import it.xsemantics.runtime.RuleFailedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

import com.google.inject.Inject;

/**
 * @author bettini
 * 
 */
public class XsemanticsBasedDeclarativeValidator extends
		AbstractDeclarativeValidator {

	@Inject
	XsemanticsValidatorFilter filter;

	protected void generateErrors(ResultWithFailure resultWithFailure,
			EObject originalSource) {
		generateErrors(resultWithFailure.getRuleFailedException(),
				originalSource);
	}

	protected void generateErrors(RuleFailedException ruleFailedException,
			EObject originalSource) {
		if (ruleFailedException == null)
			return;
		Iterable<RuleFailedException> allFailures = filter
				.filterRuleFailedExceptions(ruleFailedException);
		// the last information about a model element with error
		ErrorInformation lastErrorInformationWithSource = null;
		// we will use it to print error messages which do not have
		// an associated model element
		for (RuleFailedException ruleFailedException2 : allFailures) {
			lastErrorInformationWithSource = generateErrors(
					ruleFailedException2.getMessage(),
					ruleFailedException2.getIssue(),
					filter.filterErrorInformation(ruleFailedException2),
					lastErrorInformationWithSource, originalSource);
		}
	}

	protected ErrorInformation generateErrors(String errorMessage,
			String issue, Iterable<ErrorInformation> filteredErrorInformation,
			ErrorInformation lastErrorInformationWithSource,
			EObject originalSource) {
		if (filteredErrorInformation.iterator().hasNext()) {
			for (ErrorInformation errorInformation : filteredErrorInformation) {
				error(errorMessage, errorInformation.getSource(),
						errorInformation.getFeature(), issue);
				lastErrorInformationWithSource = errorInformation;
			}
		} else {
			if (lastErrorInformationWithSource != null)
				error(errorMessage, lastErrorInformationWithSource.getSource(),
						lastErrorInformationWithSource.getFeature(), issue);
			else
				error(errorMessage, originalSource, null, issue);
		}
		return lastErrorInformationWithSource;
	}
}

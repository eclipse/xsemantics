package it.xsemantics.example.fj.validation;

import it.xsemantics.example.fj.typing.validation.FjTypeSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class FJJavaValidator extends FjTypeSystemValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(it.xsemantics.example.fj.fj.FjPackage.eINSTANCE);
		return result;
	}
}

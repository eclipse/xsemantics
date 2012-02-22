package it.xsemantics.example.lambda.validation;

import it.xsemantics.example.lambda.xsemantics.validation.LambdaXsemanticsSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

public class LambdaJavaValidator extends LambdaXsemanticsSystemValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(it.xsemantics.example.lambda.lambda.LambdaPackage.eINSTANCE);
		return result;
	}
}

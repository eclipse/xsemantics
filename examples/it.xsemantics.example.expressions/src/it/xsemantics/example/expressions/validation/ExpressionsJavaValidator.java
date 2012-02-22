package it.xsemantics.example.expressions.validation;

import it.xsemantics.example.expressions.typing.validation.ExpressionTypeSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

public class ExpressionsJavaValidator extends ExpressionTypeSystemValidator {

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(it.xsemantics.example.expressions.expressions.ExpressionsPackage.eINSTANCE);
		return result;
	}

}

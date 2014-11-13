package it.xsemantics.dsl.resource;

import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini
 *
 */
public class XsemanticsResourceDescriptionStrategy extends
		XbaseResourceDescriptionStrategy {

	@Inject
	private XsemanticsGeneratorExtensions generatorExtensions;

	@Override
	protected boolean isResolvedAndExternal(EObject from, EObject to) {
		if (to instanceof XVariableDeclaration
				&& generatorExtensions.previousFailureVarName().equals(
						((XVariableDeclaration) to).getName())) {
			return false;
		}

		return super.isResolvedAndExternal(from, to);
	}
}

/**
 * 
 */
package it.xsemantics.runtime;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author bettini
 * 
 */
public class ErrorInformation {

	EObject source;

	EStructuralFeature feature;

	public ErrorInformation(EObject source, EStructuralFeature feature) {
		super();
		this.source = source;
		this.feature = feature;
	}

	public ErrorInformation(EObject source) {
		super();
		this.source = source;
	}

	public EObject getSource() {
		return source;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

}

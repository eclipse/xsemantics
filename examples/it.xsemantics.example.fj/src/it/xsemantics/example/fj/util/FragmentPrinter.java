/**
 * 
 */
package it.xsemantics.example.fj.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Prints the URI fragments associated to objects in the model
 * 
 * @author bettini
 * 
 */
public class FragmentPrinter {

	public String fragmentToString(EObject eObject) {
		Resource resource = eObject.eResource();
		return resource.getURIFragment(eObject);
	}
	
}

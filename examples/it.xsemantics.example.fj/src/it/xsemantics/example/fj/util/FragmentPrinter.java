/**
 * 
 */
package it.xsemantics.example.fj.util;

import org.eclipse.emf.common.util.TreeIterator;
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
	
	public void printFragment(EObject eObject) {
		System.out.println(eObject + " = " + fragmentToString(eObject));
	}
	
	public void printFragment(Resource resource) {
		TreeIterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext())
			printFragment(contents.next());
	}
}

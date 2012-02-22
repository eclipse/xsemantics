/**
 * 
 */
package it.xsemantics.example.fj.util;

import java.util.Comparator;

import it.xsemantics.example.fj.fj.Class;

/**
 * Compares two classes using their names
 * 
 * @author bettini
 * 
 */
public class ClassNameComparator implements
		Comparator<it.xsemantics.example.fj.fj.Class> {

	public int compare(Class arg0, Class arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}

}

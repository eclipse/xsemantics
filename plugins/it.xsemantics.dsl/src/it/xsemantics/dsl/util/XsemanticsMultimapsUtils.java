/**
 * 
 */
package it.xsemantics.dsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.collect.Multimap;

/**
 * @author Lorenzo Bettini
 *
 */
public class XsemanticsMultimapsUtils {
	public static Multimap<String, EObject> duplicatesMultimap() {
		return Multimaps2.<String, EObject>newLinkedHashListMultimap();
	}
}

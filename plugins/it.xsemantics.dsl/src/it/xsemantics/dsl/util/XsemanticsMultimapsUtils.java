/**
 * 
 */
package it.xsemantics.dsl.util;

import it.xsemantics.dsl.typing.TupleType;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.collect.Multimap;

/**
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsMultimapsUtils {
	public static Multimap<String, EObject> duplicatesByNameMultimap() {
		return Multimaps2.<String, EObject> newLinkedHashListMultimap();
	}

	public static Multimap<TupleType, EObject> duplicatesByTypeMultimap() {
		return Multimaps2.<TupleType, EObject> newLinkedHashListMultimap();
	}
}

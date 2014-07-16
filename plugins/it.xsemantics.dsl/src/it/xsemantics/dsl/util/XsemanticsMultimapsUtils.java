/**
 * 
 */
package it.xsemantics.dsl.util;

import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.collect.Multimap;

/**
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsMultimapsUtils {
	
	private XsemanticsMultimapsUtils() {
		
	}
	
	public static <T, K> Multimap<K, T> duplicatesMultimap() {
		return Multimaps2.<K, T> newLinkedHashListMultimap();
	}
}

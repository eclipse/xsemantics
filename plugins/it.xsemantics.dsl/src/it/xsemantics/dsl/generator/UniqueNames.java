/**
 * 
 */
package it.xsemantics.dsl.generator;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

/**
 * @author bettini
 * 
 */
public class UniqueNames {

	private Set<String> names = newHashSet();

	public String createName(String proposedName) {
		if (names.contains(proposedName)) {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				String newProposal = proposedName + "_" + i;
				if (!names.contains(newProposal)) {
					names.add(newProposal);
					return newProposal;
				}
			}
		} else {
			names.add(proposedName);
		}

		return proposedName;
	}
}

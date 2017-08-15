/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

/**
 * 
 */
package org.eclipse.xsemantics.dsl.generator;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

/**
 * @author bettini
 * 
 */
public class UniqueNames {

	private Set<String> names = newHashSet();

	protected int max = Integer.MAX_VALUE;

	public String createName(String proposedName) {
		if (names.contains(proposedName)) {
			for (int i = 1; i < max; i++) {
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

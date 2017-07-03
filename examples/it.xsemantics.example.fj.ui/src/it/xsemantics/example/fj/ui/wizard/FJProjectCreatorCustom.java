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
package it.xsemantics.example.fj.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Lorenzo Bettini
 * 
 */
public class FJProjectCreatorCustom extends FJProjectCreator {

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT);
	}

	@Override
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList(DSL_GENERATOR_PROJECT_NAME);
	}
}

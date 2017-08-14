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
package org.eclipse.xsemantics.example.fj.ui;

import org.eclipse.xsemantics.example.fj.ui.internal.FJActivator;

import com.google.inject.Module;

/**
 * Activates FJ editors with different type system implementations.
 * 
 * @author Lorenzo Bettini
 *
 */
public class FJActivatorCustom extends FJActivator {

	public static final String ORG_ECLIPSE_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM = "org.eclipse.xsemantics.example.fj.FJ.Sep";
	
	@Override
	protected Module getRuntimeModule(String grammar) {
		if (ORG_ECLIPSE_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM.equals(grammar)) {
			return new org.eclipse.xsemantics.example.fj.FJSepTypeSystemRuntimeModule();
		}
		
		return super.getRuntimeModule(grammar);
	}

	@Override
	protected Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM.equals(grammar)) {
			return new org.eclipse.xsemantics.example.fj.ui.FJUiModule(this);
		}
		
		return super.getUiModule(grammar);
	}
}

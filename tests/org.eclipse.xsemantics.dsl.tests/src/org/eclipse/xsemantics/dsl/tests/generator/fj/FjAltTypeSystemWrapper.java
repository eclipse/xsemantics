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

package org.eclipse.xsemantics.dsl.tests.generator.fj;

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.test.fj.alt.FjAltTypeSystem;

import java.util.List;

public class FjAltTypeSystemWrapper extends FjAltTypeSystem
		implements IFjTypeSystem {

	
	public List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(
			final org.eclipse.xsemantics.example.fj.fj.Class _Class) throws RuleFailedException {
		return null;
	}
	
	public List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(
			RuleApplicationTrace _trace_,
			org.eclipse.xsemantics.example.fj.fj.Class _Class) throws RuleFailedException {
		return null;
	}

	
	public Result<List<Field>> fields(
			org.eclipse.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Field>> fields(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			org.eclipse.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Method>> methods(
			org.eclipse.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

}
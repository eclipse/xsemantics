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

package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.fj.alt.FjAltTypeSystem;

import java.util.List;

public class FjAltTypeSystemWrapper extends FjAltTypeSystem
		implements IFjTypeSystem {

	
	public List<it.xsemantics.example.fj.fj.Class> superclasses(
			final it.xsemantics.example.fj.fj.Class _Class) throws RuleFailedException {
		return null;
	}
	
	public List<it.xsemantics.example.fj.fj.Class> superclasses(
			RuleApplicationTrace _trace_,
			it.xsemantics.example.fj.fj.Class _Class) throws RuleFailedException {
		return null;
	}

	
	public Result<List<Field>> fields(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Field>> fields(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Method>> methods(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

}
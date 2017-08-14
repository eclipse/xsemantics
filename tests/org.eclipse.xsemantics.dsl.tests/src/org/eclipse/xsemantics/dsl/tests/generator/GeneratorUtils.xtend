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

package org.eclipse.xsemantics.dsl.tests.generator

import java.util.List
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.diagnostics.Severity
import com.google.common.collect.Lists

class GeneratorUtils {
	
	def static onlyErrors(List<Issue> issues) {
		Lists::newArrayList(
			issues.filter[ severity == Severity::ERROR ]
		)
	}
	
	def static hasErrors(List<Issue> issues) {
		!(onlyErrors(issues).empty)
	}
}
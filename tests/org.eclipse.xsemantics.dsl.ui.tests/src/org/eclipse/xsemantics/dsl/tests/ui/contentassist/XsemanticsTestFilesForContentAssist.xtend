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

package org.eclipse.xsemantics.dsl.tests.ui.contentassist

class XsemanticsTestFilesForContentAssist {
	
	def inputForJudgmentSymbols() {
'''
system my.test.ts.TypeSystem

judgments {
	type '''.toString
	}
	
	def inputForRelationSymbols() {
'''
system my.test.ts.TypeSystem

judgments {
	type |- Object o '''.toString
	}

	def inputForInjections() {
'''
system my.test.ts.TypeSystem

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass
import java.util.List

inject List<EClass> mylist

judgments {
	type |- EObject o : output EClass
}

'''.toString
	}

	def inputForRuleInvocation() {
'''
system my.test.ts.TypeSystem

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass
import java.util.List

judgments {
	type |- EObject o : output EClass : output EClass
}

'''.toString
	}
}
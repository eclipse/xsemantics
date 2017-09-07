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

package org.eclipse.xsemantics.dsl.tests.input

import org.eclipse.xsemantics.dsl.tests.input.XsemanticsTestFiles

class FjTypeSystemFiles extends XsemanticsTestFiles {
	
	def fjTypeSystem() '''
	system org.eclipse.xsemantics.test.Fj
	'''
	
	def fjTypeSystemWithImports() '''
	«fjTypeSystem»
	
	import org.eclipse.xsemantics.example.fj.fj.*
	'''
	
	def fjJudgmentDescriptions() '''
	«fjTypeSystem»
	
	import org.eclipse.xsemantics.example.fj.fj.Expression
	import org.eclipse.xsemantics.example.fj.fj.Type
	import org.eclipse.xsemantics.example.fj.fj.New
	import org.eclipse.xsemantics.example.fj.fj.BasicType
	
	judgments {
		type |- Expression expression : output Type
		subtype |- Type left <: Type right
	}
	'''
	
	def fjExpressionTypeRules() '''
	«fjJudgmentDescriptions»
	
	axiom TNew
		G |- New newExp : newExp.type
	
	rule BasicSubtyping
		derives G |- BasicType left <: BasicType right
	from {
		left.basic.equals(right.basic)
	}
	'''
	
}
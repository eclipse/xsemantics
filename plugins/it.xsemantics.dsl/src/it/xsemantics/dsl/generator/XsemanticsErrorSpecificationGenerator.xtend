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

package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class XsemanticsErrorSpecificationGenerator {
	
	@Inject XsemanticsXbaseCompiler xbaseCompiler
	
	def compileErrorOfErrorSpecification(ErrorSpecification errorSpecification, ITreeAppendable appendable) {
		xbaseCompiler.compileErrorOfErrorSpecification(errorSpecification, appendable)
	}
	
	def compileSourceOfErrorSpecification(ErrorSpecification errorSpecification, ITreeAppendable appendable) {
		xbaseCompiler.compileSourceOfErrorSpecification(errorSpecification, appendable)
	}
	
	def compileFeatureOfErrorSpecification(ErrorSpecification errorSpecification, ITreeAppendable appendable) {
		xbaseCompiler.compileFeatureOfErrorSpecification(errorSpecification, appendable)
	}
}
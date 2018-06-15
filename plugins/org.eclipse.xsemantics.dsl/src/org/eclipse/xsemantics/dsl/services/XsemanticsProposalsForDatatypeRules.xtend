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

package org.eclipse.xsemantics.dsl.services

import com.google.inject.Inject
import org.eclipse.xtext.Keyword

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Lorenzo Bettini
 * 
 */
class XsemanticsProposalsForDatatypeRules {

	@Inject XsemanticsGrammarAccess grammarAccess

	def judgmentSymbols() {
		grammarAccess.judgmentSymbolRule.alternatives.getAllContentsOfType(typeof(Keyword)).map[it.value]
	}

	def relationSymbols() {
		grammarAccess.relationSymbolRule.alternatives.getAllContentsOfType(typeof(Keyword)).map[it.value]
	}
}

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

package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.services.XsemanticsProposalsForDatatypeRules
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsProposalsForDatatypeRulesTest extends XsemanticsBaseTest {
	
	@Inject XsemanticsProposalsForDatatypeRules proposalProvider
	
	@Test
	def void testProposalsForJudgmentSymbol() {
		assertEqualsStrings("[||-, |-, ||~, |~, ||=, |=, ||>, |>]",
			proposalProvider.judgmentSymbols
		)
	}
	
	@Test
	def void testProposalsForRelationSymbol() {
		assertEqualsStrings("[<!, !>, <<!, !>>, <~!, !~>, :, <:, :>, <<, >>, ~~, <|, |>, <-, -->, <~, ~>, \\/, /\\]",
			proposalProvider.relationSymbols
		)
	}
}
package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.services.XsemanticsProposalsForDatatypeRules
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
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
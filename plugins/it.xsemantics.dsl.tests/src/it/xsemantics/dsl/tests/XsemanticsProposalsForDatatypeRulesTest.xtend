package it.xsemantics.dsl.tests

import org.eclipse.xtext.junit4.InjectWith
import it.xsemantics.dsl.XsemanticsInjectorProvider
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import com.google.inject.Inject
import it.xsemantics.dsl.services.XsemanticsProposalsForDatatypeRules
import org.junit.Test

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
		assertEqualsStrings("[<!, !>, <<!, !>>, <~!, !~>, :, <:, :>, <<, >>, ~~, <|, |>, <-, -->, <~, ~>]",
			proposalProvider.relationSymbols
		)
	}
}
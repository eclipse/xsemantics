package it.xsemantics.dsl.services

import com.google.inject.Inject
import org.eclipse.xtext.Keyword

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author bettini
 *
 */
public class XsemanticsProposalsForDatatypeRules {

	@Inject XsemanticsGrammarAccess grammarAccess
	
	def judgmentSymbols() {
		grammarAccess.judgmentSymbolRule.
			alternatives.getAllContentsOfType(typeof(Keyword)).map [ it.value ]
	}
	
	def relationSymbols() {
		grammarAccess.relationSymbolRule.
			alternatives.getAllContentsOfType(typeof(Keyword)).map [ it.value ]
	}
}

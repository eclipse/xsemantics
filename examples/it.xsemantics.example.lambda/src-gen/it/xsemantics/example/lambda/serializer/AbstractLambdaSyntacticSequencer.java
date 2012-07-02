package it.xsemantics.example.lambda.serializer;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.services.LambdaGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractLambdaSyntacticSequencer extends AbstractSyntacticSequencer {

	protected LambdaGrammarAccess grammarAccess;
	protected AbstractElementAlias match_TerminalTerm_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_TerminalTerm_LeftParenthesisKeyword_0_0_p;
	protected AbstractElementAlias match_TerminalType_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_TerminalType_LeftParenthesisKeyword_0_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (LambdaGrammarAccess) access;
		match_TerminalTerm_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getTerminalTermAccess().getLeftParenthesisKeyword_0_0());
		match_TerminalTerm_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getTerminalTermAccess().getLeftParenthesisKeyword_0_0());
		match_TerminalType_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getTerminalTypeAccess().getLeftParenthesisKeyword_0_0());
		match_TerminalType_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getTerminalTypeAccess().getLeftParenthesisKeyword_0_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_TerminalTerm_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_TerminalTerm_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TerminalTerm_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_TerminalTerm_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TerminalType_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_TerminalType_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TerminalType_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_TerminalType_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_TerminalTerm_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_TerminalTerm_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_TerminalType_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_TerminalType_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

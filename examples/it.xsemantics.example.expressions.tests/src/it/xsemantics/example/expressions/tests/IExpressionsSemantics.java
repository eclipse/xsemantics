package it.xsemantics.example.expressions.tests;

import it.xsemantics.example.expressions.expressions.Expression;
import it.xsemantics.example.expressions.expressions.Type;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;

/**
 * Used only for testing the different Expressions type systems
 * 
 * @author Lorenzo Bettini
 * 
 */
public interface IExpressionsSemantics {

	Result<Type> type(final Expression expression);

	Result<Type> type(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Expression expression);

	Result<Object> interpret(final Expression expression);

	Result<Object> interpret(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Expression expression);

}
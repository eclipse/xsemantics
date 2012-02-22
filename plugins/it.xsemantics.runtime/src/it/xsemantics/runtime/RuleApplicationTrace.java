/**
 * 
 */
package it.xsemantics.runtime;

import java.util.LinkedList;
import java.util.List;

/**
 * Keeps a trace of rule applied (and also failures)
 * 
 * @author Lorenzo Bettini
 * 
 */
public class RuleApplicationTrace {

	protected List<Object> trace = new LinkedList<Object>();

	public RuleApplicationTrace() {

	}

	public void addToTrace(Object traceElement) {
		trace.add(traceElement);
	}

	public void addAsSubtrace(RuleApplicationTrace subTrace) {
		trace.add(subTrace);
	}

	public List<Object> getTrace() {
		return trace;
	}
}

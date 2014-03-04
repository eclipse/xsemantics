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
		if (traceElement != null)
			trace.add(traceElement);
	}

	public void addAsSubtrace(RuleApplicationTrace subTrace) {
		if (subTrace != null)
			trace.add(subTrace);
	}

	public List<Object> getTrace() {
		return trace;
	}

	/**
	 * @since 1.5
	 */
	public boolean isEmpty() {
		return trace.isEmpty();
	}
}

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

	/**
	 * @since 1.5
	 */
	public void addObjectAsSubtrace(Object traceElement) {
		if (traceElement != null) {
			RuleApplicationTrace subTrace = new RuleApplicationTrace();
			subTrace.addToTrace(traceElement);
			trace.add(subTrace);
		}	
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

	/**
	 * Returns a "snapshot" of the current trace (i.e., it clones possible
	 * subtraces); this is useful for storing snapshots in cached computations.
	 * @since 1.5
	 */
	public RuleApplicationTrace snapshot() {
		return clone();
	}
	
	/**
	 * @since 1.5
	 */
	@Override
	protected RuleApplicationTrace clone() {
		RuleApplicationTrace cloned = new RuleApplicationTrace();
		cloned.trace = new LinkedList<Object>();
		for (Object orig : trace) {
			if (orig instanceof RuleApplicationTrace)
				cloned.trace.add(((RuleApplicationTrace)orig).clone());
			else
				cloned.trace.add(orig);
		}
		return cloned;
	}
}

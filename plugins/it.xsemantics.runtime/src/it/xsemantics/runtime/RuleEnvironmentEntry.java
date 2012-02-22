package it.xsemantics.runtime;

/**
 * This will be used to store the runtime representation of a TypingStatement
 * into an environment
 * 
 * @author Lorenzo Bettini
 * 
 */
public class RuleEnvironmentEntry {
	Object left;

	Object right;

	public RuleEnvironmentEntry(Object left, Object right) {
		super();
		this.left = left;
		this.right = right;
	}

	public Object getLeft() {
		return left;
	}

	public Object getRight() {
		return right;
	}

}

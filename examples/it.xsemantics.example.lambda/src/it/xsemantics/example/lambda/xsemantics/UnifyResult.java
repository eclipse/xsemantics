package it.xsemantics.example.lambda.xsemantics;

import it.xsemantics.example.lambda.lambda.Type;

/**
 * @author Lorenzo Bettini
 */
public class UnifyResult {
	private final Type first;

	private final Type second;

	public UnifyResult(final Type firstElement, final Type secondElement) {
		this.first = firstElement;
		this.second = secondElement;
	}

	public Type getFirst() {
		return first;
	}

	public Type getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "UnifyResult(" + first + ", " + second + ")";
	}
}

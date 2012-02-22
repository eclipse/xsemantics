/**
 * 
 */
package it.xsemantics.runtime;

/**
 * @author Lorenzo Bettini
 * 
 */
public class LeftRightPair<LeftT, RightT> {
	protected LeftT left = null;

	protected RightT right = null;

	public LeftRightPair() {

	}

	public LeftRightPair(LeftT left, RightT right) {
		super();
		this.left = left;
		this.right = right;
	}

	public LeftT getLeft() {
		return left;
	}

	public void setLeft(LeftT left) {
		this.left = left;
	}

	public RightT getRight() {
		return right;
	}

	public void setRight(RightT right) {
		this.right = right;
	}

}

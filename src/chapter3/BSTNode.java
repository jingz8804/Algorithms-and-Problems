package chapter3;

/**
 * This class represents the node in a binary search tree.
 * Assume that the key of the node only contains integers.
 * @author Jing
 *
 */
public class BSTNode {
	private int key;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(int key, BSTNode left, BSTNode right){
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public String toString(){
		return "" + key;
	}
}

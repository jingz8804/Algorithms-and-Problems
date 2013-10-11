package chapter3;

public class BSTTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTNode root = new BSTNode(9, null, null);
		BSTree tree = new BSTree(root);
		tree.insert(3);
		tree.insert(15);
		tree.insert(1);
		tree.insert(6);
		tree.insert(12);
		tree.insert(14);
		
		System.out.println(tree.traverse());
		tree.delete(15);
		System.out.println(tree.traverse());
		tree.delete(9);
		System.out.println(tree.traverse());
		tree.insert(18);
		System.out.println(tree.traverse());
	}

}

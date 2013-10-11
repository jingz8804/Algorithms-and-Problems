package chapter3;

import java.util.ArrayList;

public class BSTree {
	private BSTNode root;
	private int size;
	
	public BSTree(BSTNode root){
		this.root = root;
		size = 1;
	}

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void insert(int key){
		/*
		 * if the node already exists in the tree, we do not insert it.
		 */
		BSTNode currentNode = root;
		BSTNode parent = null;
		while (currentNode != null){
			if (currentNode.getKey() == key){
				System.out.println("This value already exists in the tree!");
				return;
			}
			parent = currentNode;
			if (key < currentNode.getKey()){
				currentNode = currentNode.getLeft();
			}else{
				currentNode = currentNode.getRight();
			}
		}
		// once we reached the bottom of the tree, we insert the new node.
		// to do that we need to know the leaf node which is stored in the BSTNode parent
		// by comparing with its value, we know which side to insert the new node.
		if (key < parent.getKey()){
			parent.setLeft(new BSTNode(key, null, null));
		}else{
			parent.setRight(new BSTNode(key, null, null));
		}
		size++;
	}
	
	public BSTNode search(int key){
		return searchByRecursion(root, key);
//		return searchByIteration(key);
	}
	
	public void delete(int key){
		// to delete a node, we need to know if it is even in the tree.
		BSTNode currentNode = root;
		BSTNode parent = null;
		while (currentNode != null && currentNode.getKey() != key){
			parent = currentNode;
			if (key < currentNode.getKey()){
				currentNode = currentNode.getLeft();
			}else{
				currentNode = currentNode.getRight();
			}
		}
		if (currentNode == null){
			System.out.println("No such key is found in the tree");
			return;
		}
		if (currentNode.getLeft() == null && currentNode.getRight() == null){
			//Leaf Node
			if (currentNode.getKey() > parent.getKey()){
				parent.setRight(null);
			}else{
				parent.setLeft(null);
			}
		}else if (currentNode.getLeft() == null){
			if (currentNode.getKey() > parent.getKey()){
				parent.setRight(currentNode.getRight());
			}else{
				parent.setLeft(currentNode.getRight());
			}
		}else if(currentNode.getRight() == null){
			if (currentNode.getKey() > parent.getKey()){
				parent.setRight(currentNode.getLeft());
			}else{
				parent.setLeft(currentNode.getLeft());
			}
		}else{
			// this is case where this node has two children
			BSTNode node = currentNode.getLeft();
			BSTNode parentTemp = currentNode;
			while (node.getRight() != null){
				parentTemp = node;
				node = node.getRight();
			}
			// switch the value with the target node we are deleting.
			currentNode.setKey(node.getKey());
			// remove this node but don't forget about its left tree
			parentTemp.setRight(node.getLeft());
		}
	}
	
	private BSTNode searchByRecursion(BSTNode currentNode, int key){
		if (currentNode == null) return null;
		if (currentNode.getKey() == key) return currentNode;
		if (key < currentNode.getKey()) {
			return searchByRecursion(currentNode.getLeft(), key);
		}else{
			return searchByRecursion(currentNode.getRight(), key);
		}
	}
	
	private BSTNode searchByIteration(int key){
		BSTNode currentNode = root;
		while (currentNode != null){
			if (currentNode.getKey() == key) return currentNode;
			if (key < currentNode.getKey()){
				currentNode = currentNode.getLeft();
			}else{
				currentNode = currentNode.getRight();
			}
		}
		return null;
	}
	
	public String traverse(){
		ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
		nodes.add(root);
		String tree = "";
		BSTNode temp;
		while (nodes.size() > 0){
			tree += nodes.get(0) + " ";
			temp = nodes.remove(0);
			if (temp.getLeft() != null){
				nodes.add(temp.getLeft());
			}
			if (temp.getRight() != null){
				nodes.add(temp.getRight());
			}
		}
		return tree;
	}
}

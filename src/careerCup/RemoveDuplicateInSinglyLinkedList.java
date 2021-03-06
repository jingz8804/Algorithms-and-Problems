package careerCup;

import java.util.HashMap;

public class RemoveDuplicateInSinglyLinkedList {
	public static RemoveDuplicateInSinglyLinkedList tmp = new RemoveDuplicateInSinglyLinkedList();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = new LinkedListNode();
		head.setData(10);
		head.appendToTail(11);
		head.appendToTail(15);
		head.appendToTail(10);
		head.appendToTail(12);
		head.appendToTail(10);
		traverse(head);
		removeDuplicates1(head);
		traverse(head);
		System.out.println(findKthToLastElement(head, 3));
		System.out.println(findKthToLastElement2(head, 3));
		NodeWrapper n = findKthToLastElement3(head, 3);
		if (n.node != null){
			System.out.println(n.node);
		}else{
			System.err.println("K is larger than the length of the list");
		}
		
	}
	
	public static void traverse(LinkedListNode head){
		if (head == null) return;
		StringBuffer buffer = new StringBuffer();
		while(head != null){
			buffer.append(head.getData() + "->");
			// remember to move
			head = head.getNext();
		}
		buffer.append("null");
		System.out.println(buffer.toString());
	}
	
	public static void removeDuplicates1(LinkedListNode head){
		LinkedListNode front = null;
		LinkedListNode current = head;
		HashMap<Integer, Boolean> counts = new HashMap<Integer, Boolean>();
		while (current != null){ // be sure to check the ending condition
			if(!counts.containsKey(current.getData())){
				counts.put(current.getData(), true);
				front = current;
			}else{
				front.setNext(current.getNext());
			}
			current = current.getNext();
		}
	}
	
	public static void removeDuplicates2(LinkedListNode head){
		LinkedListNode current = head;
		while (current.getNext() != null){
			LinkedListNode front = current;
			LinkedListNode target = front.getNext();
			while (target != null){
				if(target.getData() != current.getData()){
					front = front.getNext();
				}else{
					front.setNext(target.getNext());
				}
				// remember to move
				target = target.getNext();
			}
			// remember to move
			current = current.getNext();
		}
	}
	
	public static LinkedListNode findKthToLastElement(LinkedListNode head, int k){
		// check for special cases
		if(head == null || k < 0) return null;
		// we would like to know how many elements are in the list
		int numOfElem = 0;
		LinkedListNode current = head;
		while (current != null){
			numOfElem++;
			current = current.getNext();
		}
		// if k is greater than the number of elements, then return null
		if(k >= numOfElem) return null;
		// find the kth element to the last equals to find the (numOfElem - k - 1)th element from
		// the head
		int moves = numOfElem - k - 1;
		int count = 0;
		while(count < moves){
			head = head.getNext();
			// remember to move
			count++;
		}
		return head;
	}
	
	public static LinkedListNode findKthToLastElement2(LinkedListNode head, int k){
		if(head == null || k < 0) return null;
		// if a node抯 next is null, then it is the last node in the list
		// kth to last node means if we make k moves from the current node
		// we will get the last node
		LinkedListNode current = head;
		while(current != null){
			// check if we make k moves here to get the last node
			LinkedListNode runner = current;
			for (int i = 0; i < k; i++){
				if (runner.getNext() == null){
					// reach the last node before the k moves complete
					// 0, 1, 2, �, k - 1 moves must not fail
					return null;
				}else{
					runner = runner.getNext();
				}
			}
			// if we can successfully make k moves, check if the node
			// at this position is the last node.
			if(runner.getNext() == null) return current;
			current = current.getNext();
		}
		return null;
	}
	
	public static NodeWrapper findKthToLastElement3(LinkedListNode head, int k){
		if (head.getNext() == null){
			return tmp.new NodeWrapper(null, 0);
		}
		
		NodeWrapper node = findKthToLastElement3(head.getNext(), k);
		if (node.value + 1 == k){
			return tmp.new NodeWrapper(head, k);
		}
		
		if (node.value == k){
			return node;
		}
		
		return tmp.new NodeWrapper(null, node.value + 1);
	}
	
	private class NodeWrapper{
		public LinkedListNode node;
		public int value;
		
		public NodeWrapper(LinkedListNode node, int value){
			this.node = node;
			this.value = value;
		}
	}
	
	public static NodeWrapper getKthToLast6(NodeWrapper head, int k) {
		if (head.node == null) {
			return tmp.new NodeWrapper(null, 0);
		}

		NodeWrapper nodeWrapper = getKthToLast6(tmp.new NodeWrapper(
				head.node.getNext(), head.value), k);
		nodeWrapper.value += 1;

		if (nodeWrapper.value == k) {
			return head;
		}
		// return chap2_2.new NodeWrapper(null, nodeWrapper.value);
		return nodeWrapper;
	}

}

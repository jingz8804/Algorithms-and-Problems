package careerCup;

public class DeleteAMiddleNode {

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
		LinkedListNode middle = head.getNext().getNext();
		deleteAMiddleNode(middle);
		traverse(head);
	}
	
	public static void deleteAMiddleNode(LinkedListNode target){
		LinkedListNode front = target;
		LinkedListNode current = target.getNext();
		while (current.getNext() != null){
			front.setData(current.getData());
			front = front.getNext();
			current = current.getNext();
		}
		// the last node 
		front.setData(current.getData());
		front.setNext(null);
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


}

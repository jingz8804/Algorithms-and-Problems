package careerCup;

public class LinkedListPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = new LinkedListNode();
		head.setData(10);
		head.appendToTail(11);
		head.appendToTail(15);
		head.appendToTail(8);
		head.appendToTail(18);
		traverse(head);
		head = partition(head, 12);
		traverse(head);
		head = partition(head, 20);
		traverse(head);
		head = partition(head, 4);
		traverse(head);
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
	
	public static LinkedListNode partition(LinkedListNode head, int x){
		if (head == null) return null;
		boolean hasMetLarger = false;
		LinkedListNode front = null;
		LinkedListNode current = head;
		while(current != null){
			if(!hasMetLarger){
				if (current.getData() >= x){
					hasMetLarger = true;
				}
				front = current;
			}else{
				if (current.getData() < x){
					front.setNext(current.getNext());
					current.setNext(head);
					head = current;
					current = front;
				}else{
					front = current;
				}
			}
			current = current.getNext();
		}
		return head;
	}
}

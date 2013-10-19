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
	
	/*
	 * Just write down an example: say x is 6.
	 * .....5, 14, ..., 7....
	 * before 14 all numbers are less than 6; 
	 * numbers between 14 and 7 (excluding 7) are all larger than 6;
	 * so 14, the first number larger than 6 is like a cut point.
	 * once we meet it, we have to watch out for number less than 
	 * 6 after 14. If we find one, we need to move it to the left side 
	 * by left side I mean you can just put it at the head.
	 */
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

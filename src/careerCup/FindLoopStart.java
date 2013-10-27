package careerCup;

public class FindLoopStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode n1 = new LinkedListNode();
		n1.setData(1);
		LinkedListNode n2 = new LinkedListNode();
		n2.setData(2);
		LinkedListNode n3 = new LinkedListNode();
		n3.setData(3);
		LinkedListNode n4 = new LinkedListNode();
		n4.setData(4);
		LinkedListNode n5 = new LinkedListNode();
		n5.setData(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n4);

		System.out.println(findLoopBeginning(n1));
	}

	public static LinkedListNode findLoopBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		LinkedListNode third = head;

		while (true) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (fast == slow)
				break;
		}

		while (true) {
			if (third == slow)
				break;
			third = third.getNext();
			slow = slow.getNext();
		}
		return third;
	}

}

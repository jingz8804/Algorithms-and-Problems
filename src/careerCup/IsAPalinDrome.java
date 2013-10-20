package careerCup;

public class IsAPalinDrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = new LinkedListNode();
		head.setData(1);
		head.appendToTail(2);
		head.appendToTail(5);
		head.appendToTail(6);
//		head.appendToTail(6);
//		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(1);
		traverse(head);
		System.out.println(isAPalindrome(head));

	}
	
	/* simple for doubly linked list but so easy for singly linked list
	 * palindrome here means that if we scan the linked list from either directions, we will get the
	 * same result, for example 1 -> 2 -> 5 -> 6 -> 5 ->2 -> 1 or a -> b -> b -> a
	 * so basically we have to compare the scanning results from both direction.
	 * well, from left to right is easy since we have the head node but the opposite way? not so easy.
	 * There is no link backwards. But could we make a linked list backwards from what we have?
	 * That means can we reverse the current linked list? If we can do that we can scan it easily and
	 * obtain the backwards result of the original list. 
	 * If we are allowed to change the original list, we can reverse it in place. Otherwise we will need
	 * O(n) space to store a new linked list where n is the length of the original list.
	 * let¡¯s go with the case that we can use additional space first. 
	 * */

	public static boolean isAPalindrome(LinkedListNode head){
		if (head  == null) return false;
		LinkedListNode reversedHead = null;
		LinkedListNode current = head;
		while (current  != null){
			// construct a new node for the reversed linked list
			LinkedListNode node = new LinkedListNode();
			node.setData(current.getData());
			node.setNext(null);
			
			if (reversedHead == null){
				reversedHead = node;
			}else{
				node.setNext(reversedHead);
				reversedHead = node;
			}
			// always remember to move
			current = current .getNext();
		}
		while (reversedHead != null){
			if (!(reversedHead.getData() == head.getData())) return false;
			reversedHead = reversedHead.getNext();
			head = head.getNext();
		}
		return true;
	}
	
	/* let¡¯s try reverse the list in place but we have to get the data in the ¡°right¡± order and save it somewhere first*/
	public static boolean isAPalindrome2(LinkedListNode head){
		StringBuffer buffer1 = new StringBuffer();
		LinkedListNode current = head;
		while (current != null){
			buffer1.append(current.getData());
			// always remember to move
			current = current.getNext();
		}

		StringBuffer buffer2 = new StringBuffer();
		LinkedListNode reversedHead = null;
		while (head != null){
			LinkedListNode tmp = head.getNext();
			head.setNext(reversedHead);
			reversedHead = head;
			head = tmp;
		}
		while (reversedHead != null){
			buffer2.append(reversedHead.getData());
			reversedHead = reversedHead.getNext();
		}
		if(buffer1.toString().equals(buffer2.toString())){
			return true;
		}
		return false;
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

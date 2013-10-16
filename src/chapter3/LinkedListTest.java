package chapter3;

public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(6, null);
		MyLinkedList<Integer> list = new MyLinkedList<Integer>(node);
		System.out.println(list.traverse());
		list.add(9);
		list.add(10);
		list.add(6);
		list.add(11);
		System.out.println(list.traverse());
		list.delete(6);
		list.delete(6);
		list.delete(0);
		System.out.println(list.traverse());
		list.insertBefore(20, 9);
		System.out.println(list.traverse());
		list.insertBefore(8, 11);
		System.out.println(list.traverse());
		list.insertBefore(8, 14);
		System.out.println(list.traverse());
		System.out.println(list.search(11));
		System.out.println(list.search(19));
	}

}

package chapter3;

public class MyLinkedList<T> {
	private LinkedListNode<T> head;
	private int size;

	public MyLinkedList(LinkedListNode<T> head){
		this.head = head;
		size = 1;
	}

	public LinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(LinkedListNode<T> head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public LinkedListNode<T> search(T element){
		return null;
	}
	
	public boolean insertBefore(T element){
		return false;
	}
	
	public boolean insertAfter(T element){
		return false;
	}
	
	public LinkedListNode<T> remove(T element){
		return null;
	}
	
	public boolean add(T element){
		if (size == 0){
			head = new LinkedListNode<T>(element, null);
			size++;
			return true;
		}else{
			
		}
		return false;
	}
}

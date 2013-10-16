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
		if (size == 0){
			return null;
		}
		LinkedListNode<T> current = head;
		while (current != null){
			if (current.getElement().equals(element)){
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	
	public boolean insertBefore(T element, T before){
		if (size == 0){
			return false;
		}
		if (head.getElement().equals(before)){
			// insert before the head element
			LinkedListNode<T> tmp = new LinkedListNode<T>(element, null);
			tmp.setNext(head);
			head = tmp;
			return true;
		}
		LinkedListNode<T> front = head;
		LinkedListNode<T> current = head.getNext();
		while (current != null && !current.getElement().equals(before)){
			front = front.getNext();
			current = current.getNext();
		}
		if (current == null) return false;
		LinkedListNode<T> tmp = new LinkedListNode<T>(element, null);
		tmp.setNext(current);
		front.setNext(tmp);
		size++;
		return true;
	}
	
	public boolean delete(T element){
		if (size == 0) return false;
		if (head.getElement().equals(element)){
			head = head.getNext();
			size--;
			return true;
		}
		LinkedListNode<T> front = head;
		LinkedListNode<T> current = head.getNext();
		while (current != null && !current.getElement().equals(element)){
			front = front.getNext();
			current = current.getNext();
		}
		if (current == null) return false;
		front.setNext(current.getNext());
		return false;
	}
	
	public void add(T element){
		if (size == 0){
			head = new LinkedListNode<T>(element, null);
		}else{
			LinkedListNode<T> tmp = new LinkedListNode<T>(element, null);
			tmp.setNext(head);
			head = tmp;
		}
		size++;
	}
	
	public String traverse(){
		if (size == 0) return null;
		StringBuffer buffer = new StringBuffer();
		LinkedListNode<T> current = head;
		while(current != null){
			buffer.append(current.getElement().toString());
			if(current.getNext() != null) buffer.append("->");
			current = current.getNext();
		}
		buffer.append("->null");
		return buffer.toString();
	}
}

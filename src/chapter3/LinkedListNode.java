package chapter3;

public class LinkedListNode<T> {
	private T element;
	private LinkedListNode<T> next;
	
	public LinkedListNode(T element, LinkedListNode<T> next){
		this.element = element;
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	public String toString(){
		return element.toString();
	}
	
}

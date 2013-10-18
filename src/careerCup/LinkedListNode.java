package careerCup;

public class LinkedListNode {
	private int data;
	private LinkedListNode next = null;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	public void appendToTail(int data){
		LinkedListNode current = this;
		
		LinkedListNode end = new LinkedListNode();
		end.setData(data);
		end.setNext(null);
		
		while (current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(end);
	}
	
	public String toString(){
		return data+"";
	}
}

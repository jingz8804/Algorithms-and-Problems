package careerCup;

public class SortAStack {
	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		s = sortAscending(s);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	public static Stack sortAscending(Stack s) throws Exception {
		Stack tmp = new Stack();
		while (s.top != null) {
			int data = s.pop();
			while (tmp.top != null) {
				int data2 = tmp.top.data;
				if (data <= data2) {
					tmp.push(data);
					break;
				} else {
					// pop from tmp and push it back to s
					data2 = tmp.pop();
					s.push(data2);
				}
			}
			if (tmp.top == null) {
				tmp.push(data);
			}
		}
		return tmp;
	}
}

class Stack {
	StackNode top = null;
	int numOfElem = 0;

	public void push(int data) {
		StackNode node = new StackNode(data);
		node.previous = top;
		top = node;
		numOfElem++;
	}

	public int pop() throws Exception {
		if (top == null)
			throw new Exception("the stack is empty!");
		int data = top.data;
		top = top.previous;
		numOfElem--;
		return data;
	}
}

class StackNode {
	int data;
	StackNode previous;

	public StackNode(int data) {
		this.data = data;
		previous = null;
	}
}

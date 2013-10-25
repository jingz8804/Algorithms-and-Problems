package careerCup;

public class MyQueue<T>{
	public Stack<T> s1;
	public Stack<T> s2;
	
	public MyQueue(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void inQueue(T data){
		// add the data to s1
		s1.push(data);
	}

	public T deQueue() throws Exception{
		// if s2 is not empty, just pop
		// otherwise, pop all from s1 and push them to s2 first
		if (s2.top == null){
			while(s1.top != null){
				T data = s1.pop();
				s2.push(data);
			}
		}
		T tmp;
		try{
			tmp = s2.pop();
		}catch(Exception e){
			throw new Exception("The Queue is Empty");
		}
		return tmp;
	}

	private class Stack<T>{
		public StackNode<T> top;
	
		public Stack(){
			top = null;
		}
	
		public void push(T data){
			StackNode<T> node = new StackNode<T>(data);
			node.previous = top;
			top = node;
		}

		public T pop() throws Exception{
			if (top == null) throw new Exception("The Stack is Empty!");
			StackNode<T> tmp = top;
			top = top.previous;
			return tmp.data;
		}
	}

	private class StackNode<T>{
		public T data;
		public StackNode<T> previous;
	
		public StackNode(T data){
			this.data = data;
			previous = null;
		}
	}
}


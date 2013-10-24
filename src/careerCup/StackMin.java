package careerCup;

public class StackMin {
	private StackNode top;
	private StackNode minTop;	
	private int currentMinVal;
		
	public StackMin(){
		top = null;
		minTop = null;
		currentMinVal= 0;
	}

	public int peek() throws Exception{
		if(top == null) throw new Exception("The stack is Empty!");
		return top.data;
	}

	public int min()  throws Exception{
		if (minTop == null) throw new Exception("The stack is Empty!");
		return minTop.data;
	}

	public void push(int val){
		if (top == null){
			currentMinVal = val;
			top = new StackNode();
			top.data = val;
			top.next = null;
			minTop = new StackNode();
			minTop.data = val;
			minTop.next = null;
		}else{
			StackNode tmp = new StackNode();
			tmp.data = val;
			tmp.next = top;
			top = tmp;
			
			if(currentMinVal > val){
				currentMinVal = val;
			}

			StackNode tmp2 = new StackNode();
			tmp2.data = currentMinVal;
			tmp2.next = minTop;
			minTop = tmp2;
		}
	}

	public int pop() throws Exception{
		if (top == null) throw new Exception("The stack is empty!");
		int val = top.data;
		top = top.next;
		minTop = minTop.next;
		return val;
	}

	private class StackNode{
		public int data;
		public StackNode next;
	}
	
	public String traverse(){
		if(top == null){
			return null;
		}
		StackNode node = top;
		StringBuffer buffer = new StringBuffer();
		while (node != null){
			buffer.append(node.data);
			buffer.append("->");
			node = node.next;
		}
		buffer.append("null");
		return buffer.toString();
	}

}

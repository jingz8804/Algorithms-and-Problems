package careerCup;
/*
 * Three stacks in one array with flexible space allocation.
 * But we have to use extra space to save reference and a list
 */
public class ThreeStacksInArray2{
	public int stackSizeTotal = 9;
	public StackNode[] stacks = new StackNode[stackSizeTotal];
	public int[] stackTops = {-1, -1, -1};
	public FreeCell cell = null;

	public ThreeStacksInArray2(){
		for(int i = 0; i < stackSizeTotal; i++){
			if(cell == null){
				cell = new FreeCell();
				cell.ind = i;
			}else{
				FreeCell c = new FreeCell();
				c.ind = i;
				c.next = cell;
				cell = c;
			}
		}
	}

	public void push(int data, int stackNum) throws Exception{
		if(stackNum > 2) throw new Exception("No such stack exists! Stack index can only be 0, 1 and 2");
		if(cell == null) throw new Exception("The stacks are all full!");
		int index = getCell().ind;

		StackNode n = new StackNode();
		n.data = data;
		n.indexInArray = index;

		if(stackTops[stackNum] != -1){
			n.previousTop = stacks[stackTops[stackNum]];
		}
		stackTops[stackNum] = index;
		stacks[index] = n;
	}

	public int pop(int stackNum) throws Exception{
		if(stackNum > 2) throw new Exception("No such stack exists! Stack index can only be 0, 1 and 2");
		if(stackTops[stackNum] == -1) throw new Exception("The stack is Empty!");

		int currentTop = stackTops[stackNum];
		StackNode n = stacks[currentTop];

		// find the previous top and set the top of the stack in consideration to it
		StackNode previous = n.previousTop;
		if(previous == null)
			stackTops[stackNum] = -1;
		else
			stackTops[stackNum] = previous.indexInArray;	
		// add a free cell to the free cell list
		FreeCell newCell = new FreeCell();
		newCell.ind = currentTop;
		newCell.next = cell;
		cell = newCell;
		// return the data in n
		return n.data;
	}

	private FreeCell getCell(){
		FreeCell tmp = cell;
		cell = cell.next;
		return tmp;
	}

	private class StackNode{
		public int indexInArray;
		public int data;
		public StackNode previousTop = null;
	}

	private class FreeCell{
		public int ind;
		public FreeCell next = null;
	}
}

package careerCup;

/*
 * Suppose the size of each stack is fixed. So we divide the array into three parts
 */
public class ThreeStacksInArray1 {
	int stackSize = 3;
	int[] stacks = new int[stackSize * 3];
	int[] stackTops = new int[3];

	public ThreeStacksInArray1(){
		for (int i = 0; i < 3; i++){
			stackTops[i] = i * stackSize - 1;
		}
	}
	
	public void push(int data, int stackNum) throws Exception{
		if(stackNum > 2) throw new Exception("No such stack exists! Stack index can only be 0, 1 and 2");
		if(stackTops[stackNum] == (stackNum + 1 ) * stackSize - 1){
			throw new Exception("Stack " + stackNum + " is full!");
		}

		int currentTopInd = stackTops[stackNum];
		stacks[currentTopInd + 1] = data;
		stackTops[stackNum]++;
	}

	public int pop(int stackNum) throws Exception{
		if(stackNum > 2) throw new Exception("No such stack exists! Stack index can only be 0, 1 and 2");
		if(stackTops[stackNum] == stackNum * stackSize - 1){
			throw new Exception("Stack " + stackNum + " is empty!");
		}

		int currentTopInd = stackTops[stackNum];
		int data = stacks[currentTopInd];
		stackTops[stackNum]--;
		return data;
	}

	public int peek(int stackNum) throws Exception{
		if(stackNum > 2) throw new Exception("No such stack exists! Stack index can only be 0, 1 and 2");
		if(stackTops[stackNum] == stackNum * stackSize - 1){
			throw new Exception("Stack " + stackNum + " is empty!");
		}
		int currentTopInd = stackTops[stackNum];
		int data = stacks[currentTopInd];
		return data;
	}
	
}



package careerCup;

public class ThreeStacksInArrayTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ThreeStacksInArray1 stack1 = new ThreeStacksInArray1();
		stack1.push(1, 0);
		stack1.push(2, 0);
		stack1.push(3, 0);
		stack1.push(1, 2);
		System.out.println(stack1.pop(2));
//		stack1.peek(1);
//		stack1.push(4, 0);
		
		ThreeStacksInArray2 stack2 = new ThreeStacksInArray2();
		stack2.push(1, 0);
		stack2.push(2, 0);
		stack2.push(3, 0);
		stack2.push(1, 2);
		System.out.println(stack2.pop(2));
		System.out.println(stack2.pop(0));
		System.out.println(stack2.pop(0));
		System.out.println(stack2.pop(0));
		stack2.push(1, 0);
		stack2.push(2, 0);
		stack2.push(3, 0);
		stack2.push(1, 0);
		stack2.push(2, 0);
		stack2.push(3, 0);
		stack2.push(1, 0);
		stack2.push(2, 0);
		stack2.push(3, 0);
		stack2.push(1, 0);
	}

}

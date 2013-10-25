package careerCup;

public class MyQueueTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.inQueue(1);
		queue.inQueue(2);
		queue.inQueue(3);
		queue.inQueue(4);
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

}

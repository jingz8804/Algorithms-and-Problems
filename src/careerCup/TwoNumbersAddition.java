package careerCup;

public class TwoNumbersAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode number1 = new LinkedListNode();
		number1.setData(7);
		number1.appendToTail(1);
		number1.appendToTail(6);
		LinkedListNode number2 = new LinkedListNode();
		number2.setData(5);
		number2.appendToTail(9);
		number2.appendToTail(2);
		LinkedListNode sum = NumbersAddition(number1, number2);
		traverse(sum);
		
		LinkedListNode number3 = new LinkedListNode();
		number3.setData(5);
		number3.appendToTail(9);
		number3.appendToTail(3);
		LinkedListNode sum2 = NumbersAddition(number1, number3);
		traverse(sum2);
		
		LinkedListNode number4 = new LinkedListNode();
		number4.setData(5);
		number4.appendToTail(9);
		LinkedListNode sum3 = NumbersAddition(number1, number4);
		traverse(sum3);
		
	}
	
	public static void traverse(LinkedListNode head){
		if (head == null) return;
		StringBuffer buffer = new StringBuffer();
		while(head != null){
			buffer.append(head.getData() + "->");
			// remember to move
			head = head.getNext();
		}
		buffer.append("null");
		System.out.println(buffer.toString());
	}

	public static LinkedListNode NumbersAddition(LinkedListNode n1, LinkedListNode n2){
		// number 1 and number 2 may not have the same number of digits.
		if (n1 == null || n2 == null) return null;
		LinkedListNode sumHead = null;
		LinkedListNode sumTail = null;
		int advance = 0;
		while (n1 != null || n2 != null){
			int digitSum = 0;
			if(n1 != null && n2 != null)
				digitSum = n1.getData() + n2.getData() + advance;
			else if(n1 == null)
				digitSum = n2.getData() + advance;
			else
				digitSum = n1.getData() + advance;
			if (digitSum >= 10){
				advance = 1;
				digitSum = digitSum % 10;
			}else{
				advance = 0;
			}
			LinkedListNode dSum = new LinkedListNode();
			dSum.setData(digitSum);
			if (sumHead == null) sumHead = dSum;
			if (sumTail == null) {
				sumTail = dSum;
			}else{
				sumTail.setNext(dSum);
				sumTail = dSum;
			}
			// move n1 and n2 under certain conditions!
			if(n1 != null)
				n1 = n1.getNext();
			if (n2 != null)
				n2 = n2.getNext();
		}
		if(advance == 1){
			LinkedListNode last = new LinkedListNode();
			last.setData(advance);
			sumTail.setNext(last);
			sumTail = last;
		}
		return sumHead;
	}

}

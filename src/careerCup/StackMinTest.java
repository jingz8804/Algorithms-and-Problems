package careerCup;

public class StackMinTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackMin st = new StackMin();
		st.push(5);
		st.push(6);
		st.push(4);
		st.push(7);
		st.push(3);
		System.out.println(st.traverse());
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
	}

}

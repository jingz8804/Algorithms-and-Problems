package careerCup;

public class IsRotation {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "cdba";
		System.out.println("is str2 a rotation of str1? " + isRotation(str1, str2));
		String str3 = "cdab";
		System.out.println("is str3 a rotation of str1? " + isRotation(str1, str3));
		int a = 11;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(~a));
	}
	
	private static boolean isRotation(String str1, String str2){
		String combined = str1 + str1;
		if (combined.indexOf(str2) > 0) return true;
		return false;
	}
}

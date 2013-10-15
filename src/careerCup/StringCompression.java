package careerCup;

public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "aaaaaaaaaabbbbbbd";
		System.out.println(compress(test1));
		String test2 = "abd";
		System.out.println(compress(test2));
		String test3 = "adddd";
		System.out.println(compress(test3));
		String test4 = "";
		System.out.println(compress(test4));
		String test5 = null;
		System.out.println(compress(test5));

	}
	
	private static String compress(String str){
		if (str == null) return null;
		if (str.equals("")) return str;

		char[] charArr = str.toCharArray();
		StringBuffer strs = new StringBuffer(charArr.length * 2);

		// we need to one index for charArr: 
		// keep track of the current character
		// see if it is the same as the previous one
		// also keep track of the frequency of the current character

		int i = 0; // index for charArr
		char currentNode;
		int count = 0;

		for (; i < charArr.length; i++){
			currentNode = charArr[i];
			if (i == 0) {
				count++;
				strs.append(Character.toString(currentNode));
			}else{
				if (charArr[i-1] == currentNode){
					count++;
				}else{
					strs.append(Integer.toString(count));
					strs.append(Character.toString(currentNode));
					count = 1;
				}
			}
		}
		// not finished, the count of the last character in consideration should be added as well
		strs.append(Integer.toString(count));

		String compressed = strs.toString();
		if (compressed.length() >= str.length()){
			return str;
		}else{
			return compressed;
		}
	}

}

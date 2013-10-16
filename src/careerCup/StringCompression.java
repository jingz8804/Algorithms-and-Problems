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
	
	private static int getCompressedSize(String str){
		int strLength = str.length();
		int compressedLen = 0;
		
		char currentNode;
		int count = 0;
		for (int i = 0; i < strLength; i++){
			currentNode = str.charAt(i);
			if (i == 0){
				count++;
			}else{
				if (currentNode == str.charAt(i-1)){
					count++;
				}else{
					compressedLen += 1 + String.valueOf(count).length();
					count = 1;
				}
			}
		}
		compressedLen += 1 + String.valueOf(count).length();
		return compressedLen;
	}
	
	private static String compress(String str){
		if (str == null) return null;
		if (str.equals("")) return str;
		if (getCompressedSize(str) >= str.length()) return str;

		StringBuffer strs = new StringBuffer();

		// we need to one index for charArr: 
		// keep track of the current character
		// see if it is the same as the previous one
		// also keep track of the frequency of the current character

		int i = 0; // index for charArr
		char currentNode;
		int count = 0;

		for (; i < str.length(); i++){
			currentNode = str.charAt(i);
			if (i == 0) {
				count++;
				strs.append(Character.toString(currentNode));
			}else{
				if (str.charAt(i-1) == currentNode){
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
		return strs.toString();
	}

}

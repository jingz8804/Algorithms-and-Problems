package careerCup;

public class IfCharsUnique {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String test1 = "asfsd";
		System.out.println(isUnique3(test1));
		String test2 = "agfsd";
		System.out.println(isUnique3(test2));
		String test3 = "";
		System.out.println(isUnique3(test3));
	}
	
	/**
	 * check if characters are all unique using an boolean array
	 * @param str the string to be checked
	 * @return whether all characters are unique
	 * @throws Exception 
	 */
	private static boolean isUnique1(String str) throws Exception{
		if(str == null) throw new Exception("The string cannot be null!");
		boolean[] occurrence = new boolean[256];
		char[] chars = str.toCharArray();
		for(char c: chars){
			if(!occurrence[c]){
				occurrence[c] = true;
			}else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * check if characters are all unique without using array or hashtable
	 * @param str
	 * @return whether all characters are unique
	 * @throws Exception
	 */
	private static boolean isUnique2(String str) throws Exception{
		if(str == null) throw new Exception("The string cannot be null!");
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length - 1; i++){
			for (int j = i + 1; j < chars.length; j++){
				if (chars[i] == chars[j]){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * check if characters are all unique without using additional data structure 
	 * in O(n) time (characters range from 'a' to 'z')
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private static boolean isUnique3(String str) throws Exception{
		if(str == null) throw new Exception("The string cannot be null!");
		int stats = 0; //starts with a cleaning record.
		char[] chars = str.toCharArray();
		for (char c: chars){
			int temp = 1 << (c - 'a');
			if((stats & temp) > 0){
				// if we have seen this character before.
				return false;
			}else{
				// otherwise, keep it on record.
				stats = stats | temp;
			}
		}
		return true;
	}

}

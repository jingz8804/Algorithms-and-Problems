package careerCup;

public class RemoveDuplicateChars {

	public static void main(String[] args) {
		String test1 = "abcbd";
		System.out.println(removeDuplicateChars2(test1));
		String test2 = "aaaa";
		System.out.println(removeDuplicateChars2(test2));
		String test3 = "abv";
		System.out.println(removeDuplicateChars2(test3));
		String test4 = null;
		System.out.println(removeDuplicateChars2(test4));
	}
	
	private static String removeDuplicateChars(String str){
		if (str == null) return null;
		char[] chars = str.toCharArray();
		if (chars.length < 2) return new String(chars);
		
		int tail = 1;
		int current = 1;
		while(current < chars.length){
			int i;
			for (i = 0; i < tail; i++){
				if(chars[i] == chars[current]) {
					break;
				}
			}
			if (i == tail){
				chars[tail] = chars[current];
				tail++;
			}
			current++;
		}
		return new String(chars, 0, tail);
		
	}
	
	private static String removeDuplicateChars2(String str){
		if (str == null) return null;
		if (str.length() < 2) return str;
		char[] chars = str.toCharArray();
		boolean[] stats = new boolean[256];
		int tail = 0;
		int current = 0;
		while (current < chars.length){
			if(!stats[chars[current]]){
				stats[chars[current]] = true;
				chars[tail] = chars[current];
				tail++;
			}
			current++;
		}
		return new String(chars, 0, tail);
	}

}

package careerCup;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Determine if one string is a permutation of another string.
 * 
 * Q: What is the unknown? What is the goal?
 * A: To find out if one string is a permutation of another.
 * Q: What are the data?
 * A: Two strings. For example, "abcd" and "bcad".
 * Q: What are the conditions? What are the restrictions?
 * A: Not really. I guess we can use whatever we want initially and improve later.
 * Q: Now let's make sure we understand the question. What is a permutation in this problem?
 * A: Eh I think a permutation here means that we re-arrange the characters in one string. 
 * The new string is a permutation as a result.
 * Q: So what is the relationship between a string and its permutation?
 * A: I would say they have the same characters. Also each character has the same frequency but
 * the order of the characters may be different.
 * Q: Good. We mentioned "frequency" here. Have you seen some problems require frequency?
 * A: Yes I have.
 * Q: What method did you try?
 * A: I tried two data structures: an array and a HashTable to keep track of the frequency.
 * Q: Can we use it here? If yes, how can we use it?
 * A: I think we can. I can use either an array or a hashtable, scan through one string first 
 * and get the frequency of each character. Then scan through the second string 
 * and decrease the frequency of each character. In the end, if all that left in the array
 * or the hashtable are zeros, then one string is a permutation of another. Otherwise, it is not.
 * Q: Good.
 */
public class IfPermutation {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str1 = "abcd";
		String str2 = "badc";
		String str3 = "bbds";
		String str4 = "cda";
		String str5 = null;
		
		System.out.println(isPermutation2(str1, str2));
		System.out.println(isPermutation2(str1, str3));
		System.out.println(isPermutation2(str1, str4));
		System.out.println(isPermutation2(str1, str5));
	}
	
	private static boolean isPermutation(String str1, String str2) throws Exception{
		if (str1 == null || str2 == null){
			throw new Exception("The input cannot be null!");
		}
		if (str1.length() != str2.length()){
			return false;
		}
		int[] counts = new int[256];
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		for (int i = 0; i < charArr1.length; i++){
			char c1 = charArr1[i];
			char c2 = charArr2[i];
			counts[c1]++;
			counts[c2]--;
		}
		for (int j = 0; j < counts.length; j++){
			if (counts[j]!=0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isPermutation2(String str1, String str2) throws Exception{
		if (str1 == null || str2 == null){
			new Exception("Input cannot be null!");
		}
		
		if (str1.length() != str2.length()) return false;
		
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		
		// the object wrapper for char is Character
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		for (int i = 0; i < charArr1.length; i++){
			if (counts.containsKey(charArr1[i])){
				counts.put(charArr1[i], counts.get(charArr1[i])+1);
			}else{
				counts.put(charArr1[i], 1);
			}
			
			if (counts.containsKey(charArr2[i])){
				counts.put(charArr2[i], counts.get(charArr2[i])-1);
			}else{
				counts.put(charArr2[i], -1);
			}
		}
		
		for (int j = 0; j < charArr2.length; j++){
			if (counts.get(charArr2[j]) != 0) return false;
		}
		return true;
	}

}

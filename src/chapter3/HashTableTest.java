package chapter3;

public class HashTableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// The hashCode for primitive type int is the integer itself
		// since my hashtable has 32 initial space, we can test collision case using 11 and 43 as the key.
		MyHashTable test = new MyHashTable();
		test.put(11, 90);
		System.out.println(test.get(11));
		System.out.println(test.get(12));
		test.put(11, 80);
		System.out.println(test.get(11));
		test.put(43, 85);
		System.out.println(test.get(43));
		test.remove(11);
		System.out.println(test.get(11));
		System.out.println(test.get(43));
	}

}

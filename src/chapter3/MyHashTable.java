package chapter3;
/*
 * Important Notes about Hashing:
 * element's location is determined by a hashing function (the key is the parameter).
 * elements are stored in an array.
 * use chaining to resolve collision.
 * load factor: be sure to resize the table once the load is met and rehash the elements in the former table.
 */
public class MyHashTable{
	private double loadFactor = 0.75;
	private HashNode[] table;
	private int elemCount;
	
	public MyHashTable(){
		table = new HashNode[32];
		elemCount = 0;
	}
	
	public int getTableSize(){
		return table.length;
	}
	
	// it is recommended that every object implements its own hashCode function
	// this hash method here assume that key has its customized hashCode function
	private int hash(Object key){
		int hashCode = key.hashCode() % table.length;
		return hashCode;
	}
	
	// we implement a very simple hash function here.
	private int hash2(Object key){
		String keyStr = key.toString();
		int sum = 0; // or we could start from key.hashCode() 
		for (int i = 0; i < keyStr.length(); i++){
			sum += keyStr.charAt(i);
		}
		return sum % table.length;
		
	}
	
	public boolean containsKey(Object key){
		int index = hash(key);
		HashNode head = table[index];
		if (head == null) return false;
		while(head!=null){
			if(head.getKey().equals(key)) return true;
			head = head.getNext();
		}
		return false;
	}
	
	public Object get(Object key){
		if(!containsKey(key)) return null;
		int index = hash(key);
		HashNode head = table[index];
		while(head != null){
			if (head.getKey().equals(key)){
				return head.getValue();
			}
			head = head.getNext();
		}
		return null;
	}
	
	public void put(Object key, Object value){
		int index = hash(key);
		if(containsKey(key)){
			HashNode head = table[index];
			while(head != null){
				if (head.getKey().equals(key)){
					head.setValue(value);
					return;
				}
				head = head.getNext();
			}
		}else{
			if(elemCount > table.length * loadFactor) {
				resize();
				index = hash(key);
			}
			HashNode node = new HashNode(key, value);
			table[index] = node;
			elemCount++;
		}
	}
	
	/*
	 * Be sure to rehash the elements in the former table!
	 */
	private void resize(){
		int newSize = table.length * 2;
		HashNode[] newTable = new HashNode[newSize];
		for (int i = 0; i < table.length; i++){
			HashNode node = table[i];
			if(node != null){
				Object key = node.getKey();
				int newIndex = hash(key.hashCode()) % newSize;
				newTable[newIndex] = node;
			}
		}
		table = newTable;
	}
	
	public void remove(Object key){
		if(containsKey(key)){
			int index = hash(key);
			HashNode front = table[index];
			HashNode current = front.getNext();
			
			if(front.getKey().equals(key)){
				front.setNext(null);
				table[index] = current;
				if(table[index] == null) elemCount--;
				return;
			}
			
			while(current != null){
				if(current.getKey().equals(key)){
					front.setNext(current.getNext());
					break;
				}
				front = current;
				current = current.getNext();
			}
			if(table[index] == null) elemCount--;
			return;
			
		}
	}
	
	private class HashNode{
		private Object key;
		private Object value;
		private HashNode next;
		
		public HashNode(Object key, Object value){
			this.key = key;
			this.value = value;
			next = null;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public HashNode getNext() {
			return next;
		}

		public void setNext(HashNode next) {
			this.next = next;
		}
	}
}
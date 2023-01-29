// Time Complexity : O(1)
// Space Complexity : depends on the input 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
/* implementing with chaining technique:
 * primary bucket will be arrays and second bucket will be linked list
 * we initially create a an array of size 10000 with and initially linked list when ever it is required
 * we calculate first hash function with index % array length and second hash with index/array length
*/
class MyHashMap {

	class Node {
		int key;
		int val;
		Node next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + ", next=" + next + "]";
		}

	}

	Node[] storage;

	public MyHashMap() {
		this.storage = new Node[10000];
	}

	private int hash(int key) {
		return key % 10000;
	}

	private Node find(Node node, int key) {
		Node prev = null;
		Node curr = node;
		while (curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	public void put(int key, int value) {
		int hash = hash(key);
		if (storage[hash] == null) {
			storage[hash] = new Node(-1, -1);
			Node node = storage[hash];
			node.next = new Node(key, value);
			return;
		}
		Node prev = find(storage[hash], key);
		if (prev.next == null) {
			prev.next = new Node(key, value);
		} else {
			prev.next.val = value;
		}
	}

	public int get(int key) {
		int hash = hash(key);
		if (storage[hash] == null)
			return -1;
		Node prev = find(storage[hash], key);

		if (prev.next == null) {
			return -1;
		} else {
			return prev.next.val;
		}
	}

	public void remove(int key) {
		int hash = hash(key);
		if (storage[hash] == null)
			return;
		Node prev = find(storage[hash], key);
		if (prev.next == null)
			return;
		prev.next = prev.next.next;
	}

	@Override
	public String toString() {
		return "MyHashMap [storage[1]=" + storage[1] + "]" + "   ->[storage[2]=" + storage[2] + "]";
	}

	public static void main(String args[]) {
		MyHashMap obj = new MyHashMap();
		System.out.println("empty " + obj);
		obj.put(1, 300);
		System.out.println("add key 1 " + obj);
		obj.put(10001, 400);
		System.out.println("add key 10001 " + obj);
		System.out.println("get key 1, value: " + obj.get(1));
		obj.remove(1);
		System.out.println("remove key 1 " + obj);
		obj.put(10001, 999);
		System.out.println("update key 10001 " + obj);
		obj.put(2, 100);
		System.out.println("add key 2 " + obj);

	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
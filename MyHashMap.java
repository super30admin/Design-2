//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
class MyHashMap {
	private Node[] storage;

	class Node {
		int key;
		int value;
		Node next;

		public Node(int k, int v) {
			this.key = k;
			this.value = v;
		}
	}

	public MyHashMap() {
		storage = new Node[10000];
	}

	public void put(int key, int value) {
		int index = hash1(key);
		if (storage[index] == null) {
			storage[index] = new Node(-1, -1);
		}
		Node previous = getPrevious(storage[index], key);
		if (previous.next == null) {
			previous.next = new Node(key, value);
		} else
			previous.next.value = value;
	}

	public int get(int key) {
		int index = hash1(key);
		if (storage[index] == null)
			return -1;
		Node previous = getPrevious(storage[index], key);
		if (previous.next == null)
			return -1;
		return previous.next.value;
	}

	public void remove(int key) {
		int index = hash1(key);
		if (storage[index] == null)
			return;
		Node previous = getPrevious(storage[index], key);
		if (previous.next == null)
			return;
		Node temp = previous.next;
		previous.next = previous.next.next;
		temp.next = null;
	}

	private int hash1(int key) {
		return key % 10000;
	}

	private Node getPrevious(Node head, int key) {
		Node previous = null;
		Node current = head;
		while (current != null && current.key != key) {
			previous = current;
			current = current.next;
		}
		return previous;
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
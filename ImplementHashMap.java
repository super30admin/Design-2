// Time Complexity : O(1) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
	class Node {
		int key;
		int val;
		Node next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private Node[] storage;
	private int length = 1000;

	private int hashCal(int key) {
		return key % length;
	}

	public MyHashMap() {
		this.storage = new Node[length];
	}

	private Node search(Node node, int key) {
		Node prev = null;
		while (node != null && node.key != key) {
			prev = node;
			node = node.next;
		}
		return prev;
	}

	public void put(int key, int value) {
		int block = hashCal(key);
		if (storage[block] == null) {
			storage[block] = new Node(-1, -1);
		}
		Node prev = search(storage[block], key);
		if (prev.next == null) {
			prev.next = new Node(key, value);
		} else {
			prev.next.val = value;
		}

	}

	public int get(int key) {
		int block = hashCal(key);
		if (storage[block] == null)
			return -1;
		Node prev = search(storage[block], key);

		if (prev.next == null) {
			return -1;
		} else {
			return prev.next.val;
		}
	}

	public void remove(int key) {
		int block = hashCal(key);
		if (storage[block] == null)
			return;
		Node prev = search(storage[block], key);
		if (prev.next == null)
			return;
		Node temp = prev.next;
		prev.next = prev.next.next;
		temp.next = null;
	}
}

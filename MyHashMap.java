/* Time Complexity : 
 * each of  put , get , remove - O(1)*/
/* Space Complexity : 
 * each of  put , get , remove - O(1)*/
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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

	//hash function to create primary array of buckets
	private int hash(int key) {
		return key % 10000;
	}

	public MyHashMap() {
		this.storage = new Node[10000];
	}

	//search function to get the prev node
	private Node search(Node head, int key) {
		Node prev = null;
		Node curr = head;
		while (curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	public void put(int key, int value) {
		int index = hash(key);
		if (storage[index] == null) {
			//Creating a dummy node at the beginning of a linked list
			storage[index] = new Node(-1, -1);
		}
		Node prev = search(storage[index], key);
		//create new node with key,val
		if (prev.next == null) {
			prev.next = new Node(key, value);
		} else {//update existing node
			prev.next.val = value;
		}

	}

	public int get(int key) {
		int index = hash(key);
		// key is not present
		if (storage[index] == null)
			return -1;
		Node prev = search(storage[index], key);
		if (prev.next == null) {
			return -1;
		} else {
			return prev.next.val;
		}
	}

	public void remove(int key) {
		int index = hash(key);
		// key is not present
		if (storage[index] == null)
			return;
		Node prev = search(storage[index], key);
		if (prev.next == null) {
			return;
		} else {
			//remove the connection of the node
			Node tempNode = prev.next;
			prev.next = prev.next.next;
			tempNode.next = null;
		}
	}
}

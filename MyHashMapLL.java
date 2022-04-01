package design2;
// time complexity: get: O(1), put: O(1), remove: O(1), find: O(n)
// space complexity: O(n)

public class MyHashMapLL {
	class Node{
		int key, value;
		Node next;
		public Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	int buckets;
	Node[] nodes;
	
	public MyHashMapLL(){
		buckets = 10000;
		nodes = new Node[buckets];
	}
	
	private Node find(Node head, int key) {
		Node prev = head;
		Node curr = head.next;
		while(curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}
	
	private int getHash(int key) {
		return key % buckets;
	}
	
	public int get(int key) {
		int index = getHash(key);
		if(nodes[index] == null) {
			return -1;
		}
		Node prev = find(nodes[index], key);
		if(prev.next == null) {
			return -1;
		}
		return prev.next.value;
	}
	
	public void put(int key, int value) {
		int index = getHash(key);
		if(nodes[index] == null) {
			nodes[index] = new Node(-1, -1);
		}
		Node prev = find(nodes[index], key);
		if(prev.next == null) {
			prev.next = new Node(key, value);
		}
		prev.next.value = value;
	}
	
	public void remove(int key) {
		int index = getHash(key);
		if(nodes[index] == null) {
			return;
		}
		Node prev = find(nodes[index], key);
		if(prev.next == null) {
			return;
		}
		prev.next = prev.next.next;
	}
}

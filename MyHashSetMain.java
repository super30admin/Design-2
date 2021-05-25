
class MyHashSet {

	private final int bucketSize = 1999;
	private Node[] dataArr;

	class Node {
		private int key;

		private Node nextNode;

		private Node(int key) {
			this.key = key;
			this.nextNode = null;
		}
	}

    /** Initialize your data structure here. */
    public MyHashSet() {
    	dataArr = new Node[bucketSize];
    }
    
    public void add(int key) {
    	Node firstNode = dataArr[key % bucketSize];

		// if bucket is empty create new node in the bucket
		if (firstNode == null) {
			dataArr[key % bucketSize] = new Node(key);
		} else {
			// traverse all the nodes in bucket. If key found replace value
			Node previousNode = null;
			while (firstNode != null) {
				if (firstNode.key == key) {
					return;
				}
				previousNode = firstNode;
				firstNode = firstNode.nextNode;
			}

			// if key not found create a new node and add it to bucket last node
			Node newNode = new Node(key);
			previousNode.nextNode = newNode;

		}
    }
    
    public void remove(int key) {
    	Node firstNode = dataArr[key % bucketSize];
		if (firstNode != null) {

			if (firstNode.key == key) {
				dataArr[key % bucketSize] = firstNode.nextNode;
				return;
			}

			Node previousNode = null;
			while (firstNode != null) {
				if (firstNode.key == key) {
					previousNode.nextNode = firstNode.nextNode;
					return;
				}
				previousNode = firstNode;
				firstNode = firstNode.nextNode;
			}
		}
   
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	Node firstNode = dataArr[key % bucketSize];
		if (firstNode != null) {
			while (firstNode != null) {
				if (firstNode.key == key) {
					return true;
				}
				firstNode = firstNode.nextNode;
			}
		}
		return false;
    }
}
    
public class MyHashSetMain {
	public static void main(String[] args) {
		MyHashSet set= new MyHashSet();
		
		set.add(10);
		set.add(20);
		System.out.println(set.contains(10));
		set.remove(10);
		System.out.println(set.contains(10));
		System.out.println(set.contains(20));
		System.out.println(set.contains(25));
	}
}

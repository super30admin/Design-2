// Time Complexity : O(1) for put(), get() and remove() operations.
// Space Complexity : O(n) where n is the number of key-value pairs stored in the hashmap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Design HashMap
 * Approach: Using Arrays, LinkedList and Hashing - We use the hash function to locate the
 * index of the bucket. We then use a find() function to retrieve the data for the key using the index from hashing.
 * We use the ref to the prev node so that it works for all three cases: put, get and remove 
 *
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
    }

    // We define the bucket size to be 10^4 considering the constraints.
    private static final int BUCKET_SIZE = 10000;
    // We use an array of linked list nodes for storing the key values.
    private Node[] storage;
    
    public MyHashMap() {
        this.storage = new Node[BUCKET_SIZE];
    }

    // returns the bucket index after hashing 
    private int hashFunction(int key) {
        return key % BUCKET_SIZE;
    }

    // finds the key within the provided linked list by iterating through all elements
    private Node find(Node head, int key) {
        // returns previous node to current node if we find the current key in the linked list
        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    // puts the key-value pair in the map if not present and overwrites the value if key is already present
    public void put(int key, int value) {
        int idx = hashFunction(key);

        // check if a linked list is present, if not initialize a linked list with a dummy node
        if (storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }

        Node prev = find(storage[idx], key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    // gets the value for a key
    public int get(int key) {
        int idx = hashFunction(key);

        // check if a linked list is present, if not return -1 as the key does not exist
        if (storage[idx] == null) return -1;

        Node prev = find(storage[idx], key);

        if (prev.next == null) return -1;

        return prev.next.val;
    }
    
    // removes the linked list node corresponding to the specific input key
    public void remove(int key) {
        int idx = hashFunction(key);

        // check if a linked list is present, if not return as there is nothing to remove
        if (storage[idx] == null) return;

        Node prev = find(storage[idx], key);

        if (prev.next == null) return;

        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
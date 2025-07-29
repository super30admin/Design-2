// Approach:
// We use an array of linked lists (buckets) and hash the key to find its index in the array.
// Each bucket is a linked list where we check if a key exists, and if not, we add it to the end.
// Dummy head nodes are used in each bucket to simplify deletion logic.


// Time Complexity : O(1) average for put, get, remove; 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    Node[] storage;
    int bucketSize;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        // Initialize a fixed-size array for storing key-value linked lists
        this.bucketSize = 1000;
        this.storage = new Node[bucketSize];
    }

    public int hashfxn(int key) {
        // Simple hash function to find index in storage array
        return key % bucketSize;
    }

    public Node getPrev(Node head, int key) {
        // Traverse linked list to find the node just before the target key
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hashfxn(key);

        // If bucket is empty, initialize with dummy head and insert node
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1); // dummy head
            storage[index].next = new Node(key, value);
        } else {
            // Find previous node before key (if exists)
            Node prev = getPrev(storage[index], key);
            if (prev.next == null) {
                // Key not found, add new node
                prev.next = new Node(key, value);
            } else {
                // Key found, update value
                prev.next.value = value;
            }
        }
    }

    public int get(int key) {
        int index = hashfxn(key);

        // If bucket is empty, return -1
        if (storage[index] == null) return -1;

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) {
            return -1; // Key not found
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = hashfxn(key);

        // If bucket is empty, nothing to remove
        if (storage[index] == null) return;

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) {
            return; // Key not found
        } else {
            // Unlink the node to remove it
            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
        }
    }
}

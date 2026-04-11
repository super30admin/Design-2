// Time Complexity : O(1) for put, get, and remove; O(n) in worst case due to collisions
// Space Complexity : O(n + k), where n is the number of key-value pairs and k is the number of buckets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Handling collisions cleanly and simplifying insert, update, and delete operations using a dummy head node was the key part.


// Approach:
// Use an array of buckets, where each bucket stores a linked list to handle collisions by separate chaining.
// A dummy head node is used in every non-empty bucket so that insertion, search, and deletion become easier without special handling for the first real node.
// To find a key, return the previous node so that put can update/insert and remove can delete in O(1) once the position is located.

class MyHashMap {
    private int buckets;
    private Node[] storage;

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    // Compute bucket index for a given key
    private int hash(int key) {
        return key % buckets;
    }

    // Return the previous node of the target key in the linked list
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

        // Initialize bucket with dummy node if it does not exist
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }

        Node prev = search(storage[index], key);

        // If key does not exist, insert new node
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            // If key exists, update its value
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);

        // If bucket is empty, key does not exist
        if (storage[index] == null) return -1;

        Node prev = search(storage[index], key);

        // If target node not found, return -1
        if (prev.next == null) return -1;

        return prev.next.val;
    }
    
    public void remove(int key) {
        int index = hash(key);

        // If bucket is empty, nothing to remove
        if (storage[index] == null) return;

        Node prev = search(storage[index], key);

        // If key does not exist, nothing to remove
        if (prev.next == null) return;

        // Remove the node by bypassing it
        Node curr = prev.next;
        prev.next = prev.next.next;
        curr.next = null;
    }
}
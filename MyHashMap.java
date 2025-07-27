// I used an array of linked lists (chaining) to handle collisions in a fixed-size custom HashMap.
// Each bucket stores a dummy head node to simplify insertions and deletions.
// getPrev is used to find the previous node for a given key, which helps cleanly handle put, get, and remove logic.

// Time Complexity : O(1) average for put, get, and remove; worst-case O(N) if all keys collide in one bucket.
// Space Complexity : O(K) where K is the number of unique keys inserted.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, handling edge cases like inserting at the head or removing the first element, which was solved using a dummy head node.


class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets = 1000; // Fixed number of buckets
        this.storage = new Node[buckets]; // Array of linked lists
    }

    // Hash function to determine bucket index
    private int getHash(int key) {
        return key % buckets;
    }

    // Helper function to get previous node before the target key
    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);

        // If no list exists at this bucket, initialize with dummy node
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1); // dummy head
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);

        // If key not found, insert new node
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            // Key found → update the value
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);

        // Bucket doesn't exist
        if (storage[index] == null) {
            return -1;
        }

        Node prev = getPrev(storage[index], key);

        // Key not found
        if (prev.next == null) {
            return -1;
        }

        return prev.next.value; // Return the value for key
    }

    public void remove(int key) {
        int index = getHash(key);

        // If bucket is empty, nothing to remove
        if (storage[index] == null) return;

        Node prev = getPrev(storage[index], key);

        // If key doesn't exist, nothing to do
        if (prev.next == null) return;

        // Remove the node by skipping it
        prev.next = prev.next.next;
    }
}

// Time Complexity :  Time Complexity : O(l) for put, get, and remove operations, where l is the length of the linked list
// Space Complexity : O(n), where n is the number of key-value pairs stored
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Minor confusion with initializing dummy node


// Your code here along with comments explaining your approach
// Approach:
// Used an array of 10000 buckets, each storing a linked list of key-value nodes.
// Computed the bucket index using key % buckets and use a dummy head node for easier list operations.
// Use a helper function `find()` to locate the previous node for efficient put, get, and remove actions.

class MyHashMap {

    class Node{
        int key,value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Returns the previous node of the target key (or last node if key not found)
    Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    int buckets;
    Node[] storage;

    // Hash function to get bucket index
    int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }

    public MyHashMap() {
        this.buckets = 10000; // More buckets reduce collisions and shorten linked list traversal time
        storage = new Node[this.buckets];
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        // Initialize dummy head if bucket is empty
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1,-1);
        }
        // Used find to get previous node of key (or end of list)
        Node prev = find(storage[bucket], key);

        // If key doesn't exist, insert new node at the end
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        // Return value if key exists
        if(prev.next != null) {
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        // Skip the node to remove it
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
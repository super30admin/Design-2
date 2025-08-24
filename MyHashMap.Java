// ## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(1) on average, (worst case O(n) if all keys collide in the same bucket)
// Space Complexity : O(n) for storing all key-value pairs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Linear chaining hash map implementation
class MyHashMap {
    private Node[] storage; // Array of buckets (each bucket is a linked list of Nodes)
    private int buckets;     // Total number of buckets
    
    public MyHashMap() {
        this.buckets = 10000;    // Fixed number of buckets (to reduce collisions)
        this.storage = new Node[buckets]; // Initialize storage with null values
    }

    // Node class for chaining in each bucket
    class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }    
}
    
    // Insert or update a key-value pair
    public void put(int key, int value) {
        // Find the bucket index using hash function
        int bucket = hash(key);
        // Use a dummy head (-1, -1) so we don’t need special handling 
        // for insert/remove at the start of the list
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        // Check if key already exists in the list
        Node prev = iterateList(storage[bucket], key);
        // Either we get the key or we don't
        if (prev.next == null) {
            // Key not found → add new node at end
            prev.next = new Node(key, value);
        } else {
            // Key found → update value
            // Hash Map works by replacing value in case key already exists.
            prev.next.val = value;
        }
    }
    
    // Helper: traverse the linked list until key is found or end of list
    private Node iterateList(Node head, int key) {
        Node prev = head;
        Node curr = prev.next;
         // Move forward until curr is null or key is found
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        // Retrurn prev since both put and remove, we want to manipulate prev.next
        return prev;
    }

    // Get the value for a key
    public int get(int key) {
        int bucket = hash(key);
        if (storage[bucket] == null) {
            return -1; // No bucket → key not found
        }
        Node prev = iterateList(storage[bucket], key);
        if (prev.next == null) {
            return -1; // Key not found in chain
        } else {
            return prev.next.val; // Key found, return value
        }
    }
    
    // Remove a key from the map
    public void remove(int key) {
        int bucket = hash(key); 
        if (storage[bucket] == null) return; // Nothing to remove
        Node prev = iterateList(storage[bucket], key);
        if (prev.next == null) {
            // Key not found
            return;
        } else {
            // Skip the node to remove it from chain
            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null; // Help GC by clearing pointer
        }
    }
    
    // Modulo-based hash function
    private int hash(int key) {
        return key % buckets;
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

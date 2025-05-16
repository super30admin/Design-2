/*
 * Implements a basic HashMap using separate chaining with linked lists.
 * 1. buckets: array of linked lists to handle collisions.
 * 2. hash(key): computes index using a custom hash function and PRIME bucket size.

 * - put(key, value): hashes the key, searches the corresponding bucket; if key exists, updates the value; otherwise, adds a new node.
 * - get(key): searches the hashed bucket for the key and returns its value; returns -1 if not found.
 * - remove(key): searches the hashed bucket and removes the node if the key matches.
 */
// Time Complexity : O(1) average, O(n) worst-case (if all keys hash to the same bucket) for all functions
// Space Complexity : O(n), where n is the number of keys stored.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No (Explored multiple ways)

class MyHashMap {
    
    int PRIME = 997; // Prime number used for bucket size to reduce collisions
    List<Node>[] buckets; // Array of buckets (each bucket is a linked list of nodes)

    // Hash function to compute index for a key
    int hash(int key) {
        return (31 * key + 17) % PRIME;
    }

    // Constructor initializes the buckets array
    public MyHashMap() {
        buckets = new List[PRIME];
    }

    public void put(int key, int value) {
        int hsh = hash(key); // Compute bucket index
        Node node = new Node(key, value); // Create new node with key and value

        // If bucket is empty, initialize it
        if(buckets[hsh] == null)
            buckets[hsh] = new LinkedList<Node>();

        // Search for existing key and update value if found
        for(int i = 0; i < buckets[hsh].size(); i++){
            if(key == buckets[hsh].get(i).key){
                buckets[hsh].set(i, node); // Update existing key
                return;
            }
        }
        // If key not found, add new node to bucket
        buckets[hsh].add(node);
    }

    public int get(int key) {
        int hsh = hash(key); // Compute bucket index

        if(buckets[hsh] == null)
            return -1; // Key not found

        // Search for the key in the bucket
        for(int i = 0; i < buckets[hsh].size(); i++){
            if(key == buckets[hsh].get(i).key)
                return buckets[hsh].get(i).value; // Return corresponding value
        }
        return -1; // Key not found
    }
    
    public void remove(int key) {
        int hsh = hash(key); // Compute bucket index
        if(buckets[hsh] == null)
            return; // Nothing to remove
        // Search and remove node with matching key
        for(int i = 0; i < buckets[hsh].size(); i++){
            if(key == buckets[hsh].get(i).key){
                buckets[hsh].remove(i);
                break;
            }
        }
    }
}

class Node {
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

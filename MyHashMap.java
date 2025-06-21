// Time Complexity :O(L)->L-size of likedlist
// Space Complexity :O(n)
/*
 * Approach: HashMap implementation using an array of linked lists (separate
 * chaining).
 * /The array `storage` has `buckets` number of slots, each representing a
 * bucket to handle collisions.Each bucket is a linked list that starts with a
 * dummy node for simpler insertion and deletion.The key is mapped to a bucket
 * using `key % buckets`. We use a helper `find` method to locate the node
 * before the target key in the list.This ensures that put, get, and remove
 * operations can efficiently handle collisions at each bucket by traversing the
 * linked list.
 */
class MyHashMap {

    // Node class representing key-value pairs in the linked list
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // find method to find the previous node of the key in the list
    // If key is not found, prev.next will be null
    public Node find(Node dummy, int key) {
        Node prev = dummy;// storing dummy node in prev
        Node curr = prev.next;
        while (curr != null && curr.key != key)// traverse while current not equals to null and key in current is not
                                               // the key we required.
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    int buckets; // Number of primary buckets
    Node[] storage;// Array of linked list heads (dummy nodes)

    public MyHashMap() {
        this.buckets = 10000;// size of buckets , took 10^4 instead of 10^3 to reduce time complexity.
        this.storage = new Node[this.buckets];
    }

    // Hash function to compute bucket index
    public int getBucket(int key) {
        return key % this.buckets;
    }

    // Insert or update the key-value pair
    public void put(int key, int value) {
        int bucket = getBucket(key);// calling hash function and getting bucket(Index)
        // Initialize dummy node if this bucket is empty
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);// If bucket at the respective index/key is not null, then find the prev
        if (prev.next == null) {
            prev.next = new Node(key, value);// If previous.next(current) node is null, then insert new node.
        } else {
            prev.next.value = value;// If previous.next(current) node is not null, then update the value of the
                                    // respective key.
        }
    }

    // Retrieve the value associated with the key
    public int get(int key) {
        int bucket = getBucket(key);// calling hash function
        if (storage[bucket] == null) {
            return -1;// No entry at this bucket
        }
        Node prev = find(storage[bucket], key);// getting previous node
        if (prev.next != null) {
            return prev.next.value;// if previous node is not equals to null then returning the value at
                                   // current(prev.next) as it is the key that we are searching for.
        }
        return -1; // Key not found

    }

    // Remove the key-value pair if it exists
    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return;// Nothing to remove
        }
        Node prev = find(storage[bucket], key);
        if (prev.next != null) {
            prev.next = prev.next.next; // Unlink the node to remove it
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
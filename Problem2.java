// Time Complexity : 
// put() = O(1) average, O(n) worst
// get() = O(1) average, O(n) worst
// remove() = O(1) average, O(n) worst
//
// Space Complexity : O(N) where N = number of inserted key-value pairs
//
// Did this code successfully run on Leetcode : Yes
//
// Any problem you faced while coding this : 
// Understanding how to implement separate chaining using linked lists
// and handling collisions correctly. Also ensuring find() returns
// the previous node to simplify insert/update/remove operations.

// Your code here along with comments explaining your approach

class MyHashMap {

    // Node structure for each key-value pair
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Bucket size (large enough to minimize collisions)
    private final int SIZE = 10000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int hash(int key) {
        return key % SIZE;
    }

    // Helper function: returns previous node of the target key
    private Node find(Node head, int key) {
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

        // If bucket empty, create a dummy node
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);
        }

        Node prev = find(buckets[index], key);

        // If the key does NOT exist, add new node
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            // If key exists → update value
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);

        if (buckets[index] == null) return -1;

        Node prev = find(buckets[index], key);

        if (prev.next == null) return -1;

        return prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);

        if (buckets[index] == null) return;

        Node prev = find(buckets[index], key);

        // If key exists, delete it
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

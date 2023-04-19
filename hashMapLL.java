// Time Complexity : O(K) where K is the size of the linked list bucket
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * The hashing function used is a modulus operator (single hash function).
 * In case of collision, we use the method of a linear chain (based on linked
 * list to store the keys with same hash)
 */

class MyHashMap {

    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private Node find(Node node, int key) {
        Node prev = node;
        Node cur = node.next;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int b = getBucket(key);
        if (storage[b] == null) { // bucket is empty, initialize dummy variable
            storage[b] = new Node(-1, -1);
        }

        Node prev = find(storage[b], key);
        if (prev.next == null) { // bucket doesn't have key
            prev.next = new Node(key, value);
            return;
        }
        prev.next.value = value;
    }
    
    public int get(int key) {
        int b = getBucket(key);
        if (storage[b] == null) { // bucket is empty
            return -1;
        }
        Node prev = find(storage[b], key);
        if (prev.next == null) { // reached end of bucket's LL
            return -1;
        }
        return prev.next.value; // value found
    }
    
    public void remove(int key) {
        int b = getBucket(key);
        if (storage[b] == null) { // bucket is empty
            return;
        }
        Node prev = find(storage[b], key);
        if (prev.next == null) { // reached end of bucket's LL
            return;
        }
        prev.next = prev.next.next; // delete the Node that contains the value
    }
}

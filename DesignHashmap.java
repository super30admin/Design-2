// Problem : Design HashMap
// Time Complexity: O(1) for put, get, and remove operations (amortized, assuming good hash distribution)
// Space Complexity: O(n) for the linked list in each bucket
// Did this run on leetcode : Yes
// Approach: Use an array of linked lists to handle collisions. Each index in the array represents a bucket, and each bucket contains a linked list of nodes. Each node contains a key-value pair. The hash function is used to determine the index for each key. The linked list is used to handle collisions by chaining.

public class DesignHashmap {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public DesignHashmap() { // Corrected constructor name
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    private int getHash(int key) {
        return key % buckets; // Simplified hash function
    }

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
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1); // Dummy node to simplify logic
        }

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if (storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if (storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
}

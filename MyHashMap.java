/**
 * HashMap which uses double hashing. This uses array. Time Complexity for put, get and remove is o(1).
 */
public class MyHashMap {

    private int buckets;
    private int bucketItems;

    private Node[][] storage;

    public static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new Node[buckets][];
    }

    void put(int key, int value) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1] == null) {
            if (hash1 == 0) storage[hash1] = new Node[bucketItems + 1];
            else storage[hash1] = new Node[bucketItems];
        }
        storage[hash1][hash2] = new Node(value);
    }

    int get(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1] == null) return -1;
        if (storage[hash1][hash2] == null) return -1;
        return storage[hash1][hash2].val;
    }

    void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1] == null) return;
        storage[hash1][hash2] = null;
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

}

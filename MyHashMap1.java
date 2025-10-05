import java.util.Iterator;
import java.util.LinkedList;

/**
 * HashMap which uses double hashing and uses linkedlist. Linked List is used if in certain use cases there is no contiguous memory for array.
 * Time Complexity for put, get and remove is o(n).
 */
public class MyHashMap1 {

    private int buckets;
    private int bucketItems;

    private LinkedList<Node>[] storage;

    public static class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap1() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new LinkedList[buckets];
    }

    void put(int key, int value) {
        int hash1 = hash1(key);
        if (storage[hash1] == null) {
            storage[hash1] = new LinkedList();
            storage[hash1].addLast(new Node(key, value));
        } else {
            Node found = getSearchNode(hash1, key);
            if (found == null) {
                storage[hash1].addLast(new Node(key, value));
            } else found.val = value;
        }
    }

    int get(int key) {
        int hash1 = hash1(key);
        if (storage[hash1] == null) return -1;
        Node found = getSearchNode(hash1, key);
        if (found == null) return -1;
        else return found.val;
    }

    void remove(int key) {
        int hash1 = hash1(key);
        if (storage[hash1] == null) return;
        Iterator<Node> iterator = storage[hash1].iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.key == key) iterator.remove();
        }
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private Node getSearchNode(int hash1, int key) {
        Iterator<Node> iterator = storage[hash1].iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.key == key) return next;
        }
        return null;
    }
}

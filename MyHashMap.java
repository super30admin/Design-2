// Time Complexity:
//    put(key, value): O(1) average case, O(n) worst case in case of collisions
//    get(key): O(1) average case, O(n) worst case
//    remove(key): O(1) average case, O(n) worst case
//
// Space Complexity: O(N + K)
//    - N: number of buckets
//    - K: number of keys inserted
//
// Did this code successfully run on Leetcode: Yes
//
// Any problem you faced while coding this:
//    - Handling collisions (resolved using chaining with linked list)
//    - Making sure sentinel dummy nodes are used properly for easier deletes

public class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node[] storage;
    private final int buckets;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private int getHash(int key) {
        return key % buckets;
    }

    private Node findPrev(Node head, int key) {
        Node prev = null, curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1); // Dummy head
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = findPrev(storage[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value; // Update value if key exists
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if (storage[index] == null) return -1;

        Node prev = findPrev(storage[index], key);
        return (prev.next == null) ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if (storage[index] == null) return;

        Node prev = findPrev(storage[index], key);
        if (prev.next == null) return;

        Node toRemove = prev.next;
        prev.next = toRemove.next;
        toRemove.next = null;
    }

    // Main method to test all edge cases
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Test get on empty map
        System.out.println("Get key 1 (expect -1): " + map.get(1)); // -1

        // Insert a key
        map.put(1, 10);
        System.out.println("Get key 1 after insert (expect 10): " + map.get(1)); // 10

        // Update same key
        map.put(1, 20);
        System.out.println("Get key 1 after update (expect 20): " + map.get(1)); // 20

        // Insert multiple keys with same hash
        map.put(10001, 99); // 1 and 10001 have same hash (1 % 10000)
        System.out.println("Get key 10001 (expect 99): " + map.get(10001)); // 99
        System.out.println("Get key 1 (still expect 20): " + map.get(1)); // 20

        // Remove key
        map.remove(1);
        System.out.println("Get key 1 after remove (expect -1): " + map.get(1)); // -1

        // Remove key that doesn't exist
        map.remove(999);
        System.out.println("Remove non-existing key 999 (expect no crash)");

        // Remove key that collided
        map.remove(10001);
        System.out.println("Get key 10001 after remove (expect -1): " + map.get(10001)); // -1

        // Insert again after removal
        map.put(2, 200);
        System.out.println("Get key 2 (expect 200): " + map.get(2)); // 200

        // Chained collision test with multiple items
        map.put(10002, 300); // Same index as 2
        map.put(20002, 400);
        System.out.println("Get key 10002 (expect 300): " + map.get(10002));
        System.out.println("Get key 20002 (expect 400): " + map.get(20002));

        // Remove middle node in chain
        map.remove(10002);
        System.out.println("Get key 10002 after remove (expect -1): " + map.get(10002));
        System.out.println("Get key 20002 after removing 10002 (expect 400): " + map.get(20002));
    }
}
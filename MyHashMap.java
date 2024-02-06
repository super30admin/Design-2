
class MyHashMap {

    // Represents a node in a linked list, used for chaining in case of hash
    // collisions.
    class Node {

        int key;
        int value;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    // Used to calculate the index for the key in the array.
    private int hash(int key) {
        return key % 10000;
    }

    // used to find the previous node of a given key in the linked list within a
    // specific bucket.
    private Node search(Node head, int key) {
        Node prev = null;
        Node cur = head;

        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }

        return prev;
    }

    public void put(int key, int value) {

        int idx = hash(key);
        if (storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }

        Node prev = search(storage[idx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {

        int idx = hash(key);
        if (storage[idx] == null) {
            return -1;
        }
        Node prev = search(storage[idx], key);
        if (prev.next == null) {
            return -1;
        }

        return prev.next.value;
    }

    public void remove(int key) {
        int idx = hash(key);
        if (storage[idx] == null) {
            return;
        }

        Node prev = search(storage[idx], key);
        if (prev.next == null) {
            return;
        } else {
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
        }
    }
}

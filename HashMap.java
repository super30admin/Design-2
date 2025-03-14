/**
 * Approach:
 * Using an array of linked lists of size 10,000 to store key-value pairs.
 * The hash function (key % capacity) distributes values into buckets.
 * Finding the previous node in all operations to make insertion and deletion easier.
 */

class MyHashMap {
    Node[] storage;
    int capacity;

    class Node {
        int key;
        int value;
        Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        capacity = 10000;
        storage = new Node[capacity];
    }

    private int getHash(int key) {
        return key % capacity;

    }

    private Node getPrev(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }

    public void put(int key, int value) {
        int index = getHash(key);
        Node head = storage[index];
        if (head == null) {
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }
        Node prev = getPrev(head, key);
        if (prev.next == null) { // create new node
            prev.next = new Node(key, value);
        } else { // update existing node
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        Node head = storage[index];
        if (head == null) {
            return -1;
        }
        Node prev = getPrev(head, key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;

    }

    public void remove(int key) {
        int index = getHash(key);
        Node head = storage[index];
        if (head == null) {
            return;
        }
        Node prev = getPrev(head, key);
        if (prev.next != null) {
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
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

/**
 * Time Complexity: O(1) for all the operations due to hashing and linked list
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode : Yes
 */


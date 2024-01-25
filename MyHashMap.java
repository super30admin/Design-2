/* 
Time Complexity : amortized O(1) for all fns
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Using linear chaining for the collisions;
Choosing an appropriate array size which makes traversing the linked list cheaper
*/

class Node {
    int value;
    int key;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[10000];
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            // start a linked list here with a dummy node
            Node head = new Node(-1, -1);
            Node newNode = new Node(key, value);
            head.next = newNode;
            buckets[index] = head;
            return;
        }
        // linked list already exists there
        Node prev = search(buckets[index], key);

        if (prev.next == null) {
            Node newNode = new Node(key, value);
            prev.next = newNode;
        } else {
            // item already exists
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null)
            return -1;

        Node prev = search(buckets[index], key);
        if (prev.next == null)
            return -1;

        return prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        // nothing to remove
        if (buckets[index] == null)
            return;
        Node prev = search(buckets[index], key);
        // nothing to remove
        if (prev.next == null)
            return;

        Node current = prev.next;
        prev.next = current.next;
        current.next = null;

    }

    public int hash(int key) {
        return key % 10000;
    }

    // returns the prev pointer right before the actual key
    // if not found, returns the last element
    public Node search(Node head, int key) {
        Node prev = null;
        while (head != null) {
            if (head.key == key) {
                break;
            }
            prev = head;
            head = head.next;
        }
        return prev;
    }
}
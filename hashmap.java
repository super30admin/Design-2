// Time Complexity : push - O(1), pop - O(1), peek - O(1), empty - O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :LinkedList traversal is a bit hard to wrap my head around

/*
 * Approach
 * I used linear chaining to create the hashmap, where the main array is of length 1000
 * 
 */

class MyHashMap {
    Node[] storage;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int hash(int key) {
        return key % 1000;
    }

    public MyHashMap() {
        this.storage = new Node[1000];

    }

    private Node find(Node head, int key) {
        Node prev = head;
        Node cur = head.next;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int indx = hash(key);
        if (storage[indx] == null) {
            storage[indx] = new Node(-1, -1);
        }
        Node prev = find(storage[indx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);

        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int indx = hash(key);
        if (storage[indx] == null)
            return -1;
        Node prev = find(storage[indx], key);
        if (prev.next == null)
            return -1;
        return prev.next.value;

    }

    public void remove(int key) {
        int indx = hash(key);
        if (storage[indx] == null)
            return;
        Node prev = find(storage[indx], key);
        if (prev.next == null)
            return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}
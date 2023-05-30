// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage;

    public HashMap() {
        this.storage = new Node[10000];
    }

    public int hashIdx(int key) {
        return key % 10000;
    }

    public void put(int key, int value) { // O(1)
        int hashOne = hashIdx(key);
        if (storage[hashOne] == null) {
            storage[hashOne] = new Node(-1, -1);
        }
        Node prev = find(storage[hashOne], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    private Node find(Node head, int key) { // O(1)
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public int get(int key) { // O(1)
        int hashOne = hashIdx(key);
        if (storage[hashOne] == null) {
            return -1;
        }
        Node prev = find(storage[hashOne], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }

    public void remove(int key) { // O(1)
        int hashOne = hashIdx(key);
        if (storage[hashOne] == null) {
            return;
        }
        Node prev = find(storage[hashOne], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put(1, 1);
        map.put(2, 2);
        map.get(1);
        map.get(3);
        map.put(2, 1);
        map.get(2);
        map.remove(2);
        map.get(2);
    }
}
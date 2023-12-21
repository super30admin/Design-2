// Time Complexity : O(1) for push, O(n) for functions using find
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// hash map (key, value) created by doing linear chaining

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node [] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private int hashFunction (int key) {
        return key % storage.length;
    }

    private Node find(Node node, int key) {
        Node curr = node;
        Node prev = null;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = hashFunction(key);
        if (storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }
        Node prev = find(storage[idx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = hashFunction(key);
        if (storage[idx] == null) return -1;
        Node prev = find(storage[idx], key);
        if (prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hashFunction(key);
        if (storage[idx] == null) return;
        Node prev = find(storage[idx], key);
        if (prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

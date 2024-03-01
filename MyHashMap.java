// Time Complexity : O(1) 
// Space Complexity : The space complexity is O(n + m) where n is the number of unique keys inserted and m is the number of slots in the hashmap (in this case, 10000)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : None 
/*Implemented a hashmap using separate chaining with an array of linked lists, where each list handles collisions.
Each node in the linked list stores a key-value pair, and hash function modulo operation distributes keys evenly across 10000 buckets.
For put, get, and remove operations, search for the key in the appropriate linked list within constant time on average, ensuring O(1) time complexity for each operation in the best case.
 */

public class MyHashMap {
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

    private int hash(int key) {
        return key % 10000;
    }

    private Node search(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
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
            prev.next.value = value; // Corrected this line
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if (storage[idx] == null)
            return -1;
        Node prev = search(storage[idx], key);
        if (prev.next == null)
            return -1;
        return prev.next.value; // Corrected this line
    }

    public void remove(int key) {
        int idx = hash(key);
        if (storage[idx] == null)
            return;
        Node prev = search(storage[idx], key);
        if (prev.next == null)
            return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
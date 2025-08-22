// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
// forgot to do the null check for previous.next in get function


// Your code here along with comments explaining your approach
// Created an array nodes to save the data to relevant buckets using % hash function
// Used linkedlist to save the nodes. Could have used arrays instead but it has trade offs
// 1 - arrays defining constant space for each bucket even if the data is filled or not
// 2 - linkedlist takes O(n) time to traverse through the data to find the match
class MyHashMap {
    private int bucketSize;
    private Node[] storage;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        bucketSize = 10000;
        storage = new Node[bucketSize];
    }

    // amortized O(1) since we have to traverse through the linkedlist for adding the data
    public void put(int key, int value) {
        int hash = hash(key);
        // empty bucket. will create a dummy and the new node and return
        if (storage[hash] == null) {
            Node dummy = new Node(-1, -1);
            storage[hash] = dummy;
            storage[hash].next = new Node(key, value);
        } else {
            // if key is not present or present

            Node previous = previous(storage[hash], key);
            // if key not present, add it to the last
            if (previous.next == null) {
                previous.next = new Node(key, value);
            }
            // if key is present, update the new value
            else {
                previous.next.value = value;
            }
        }
    }

    // amortized O(1) since we have to traverse through the linkedlist for get the key
    public int get(int key) {
        int hash = hash(key);
        if (storage[hash] == null)
            return -1;

        Node previous = previous(storage[hash], key);
        //  if next is null, then we didn't find a match
        if (previous.next == null)
            return -1;
        else
            return previous.next.value;
    }

    // amortized O(1) since we have to traverse through the linkedlist for remove the key
    public void remove(int key) {
        // nothing to remove
        // remove if exists
        int hash = hash(key);
        // nothing to remove
        if (storage[hash] == null)
            return;

        Node previous = previous(storage[hash], key);
        // if next is null, then it means previous function returned dummy node, hence nothing to return
        if (previous.next != null) {
            Node current = previous.next;
            previous.next = current.next;
            current.next = null;
        }
    }

    private Node previous(Node head, int key) {
        Node prev = head;
        Node current = prev.next;

        // if current is null, then we reached the end without finding the key
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        return prev;
    }

    private int hash(int key) {
        return key % bucketSize;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
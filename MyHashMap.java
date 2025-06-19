// Time Complexity: put(), get(), remove() all have amortised O(1) complexity. Based on the given constraints and the selected hash function a bucket should linked list with maximum of 101 elements including the dummy node.
// Space Complexity: Space complexity would be O(buckets * n) where n is the number of elements that can be added to the linked list.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Implemented HashMap using linear chaining technique.
class MyHashMap {
    private Node[] storage;
    private int buckets;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int idx = hashFunction(key);

        if (storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }

        Node prev = findPrevNode(storage[idx], key);
        if (prev.next == null) {
            // insert new node value
            prev.next = new Node(key, value);
        } else {
            // update existing node value
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int idx = hashFunction(key);

        if (storage[idx] == null) {
            return -1;
        }

        Node prev = findPrevNode(storage[idx], key);
        if (prev.next == null) {
            return -1;
        }

        return prev.next.value;
    }
    
    public void remove(int key) {
        int idx = hashFunction(key);
        if (storage[idx] == null) {
            return;
        }

        Node prev = findPrevNode(storage[idx], key);
        if (prev.next == null) {
            return;
        }

        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }

    private int hashFunction(int key) {
        return key % buckets;
    }

    private Node findPrevNode(Node head, int key) {
        Node prev = head;
        Node currentNode = head.next;

        while (currentNode != null && currentNode.key != key) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        return prev;
    }

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
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
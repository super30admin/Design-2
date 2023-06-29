// Time Complexity : Time complexity of all the functions would be O(1) as the worst case could be O(100) which can be considered as constant time
// Space Complexity : Space complexity would be O(1) as for worst case the auxillary space required would be O(1,000,000) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced issue due to logical flaw in the code. I was not taking dummy head which was causing problem

// Your code here along with comments explaining your approach
// # Design-2

// Explain your approach in **three sentences only** at top of your code
// Using linear chaining method where data structure is array of linked list. Size of the array would be 10,000 so that the maximum size
// of linked list for worst case would be 100. Initializing linked list when first element for that bucker arrives. Searching through the linked list
// by iterating through the elements

class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    Node[] storage;

    public MyHashMap() {
        storage = new Node[10000];
    }

    private int hash(int h) {
        return h % 10000;
    }

    public Node getElement(Node n, int key) {
        Node curr = n;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hashKey = hash(key);
        if (storage[hashKey] == null) {
            storage[hashKey] = new Node(-1, -1);

        }

        Node prev = getElement(storage[hashKey], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int hashKey = hash(key);
        if (this.storage[hashKey] == null) {
            return -1;

        } else {
            Node prev = getElement(this.storage[hashKey], key);
            if (prev.next == null)
                return -1;
            else
                return prev.next.value;
        }
    }

    public void remove(int key) {
        int hashKey = hash(key);
        if (this.storage[hashKey] == null) {
            return;

        } else {
            Node prev = getElement(storage[hashKey], key);
            if (prev.next == null)
                return;
            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
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

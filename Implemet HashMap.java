// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashMap {

    class Node {
        int key, val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int key) { // Dummy node constructor
            this.key = key;
        }
    }

    private Node[] storage;
    private int bucket;

    public MyHashMap() {
        this.bucket = 10000;
        this.storage = new Node[bucket];
    }

    private int hash(int key) {
        return key % bucket;
    }

    private Node helper(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (storage[idx] == null) {
            storage[idx] = new Node(-1); // dummy head
        }
        Node prev = helper(storage[idx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value); // insert new
        } else {
            prev.next.val = value; // update
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if (storage[idx] == null) return -1;
        Node prev = helper(storage[idx], key);
        if (prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int idx = hash(key);
        if (storage[idx] == null) return;
        Node prev = helper(storage[idx], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
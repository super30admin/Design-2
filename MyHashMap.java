class MyHashMap {

    // Time Complexity : 
    // search = O(1)
    // get = O(1)
    // put = O(1)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    /*
        Using Node array as the data structure to store key value pair and next Node pointer.
        To search a node exists, we travel upto the node which matches value and keep track of the prev node
        and return the prev node. The reason to return prev node is to make sure that when 
        deleting a node we have access to the prev node as we cannot back track. We call search to 
        get the previous of the node we want to add, delete, or get. For delete, we just need to set prev 
        element to point to next of the next element (which we want to delete). To add or update, we just 
        add new node to next of the prev node if null or update value of the next node. 
     */

    class Node {
        int key, val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
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
        Node cur = head;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hashKey = hash(key);
        if (storage[hashKey] == null) {
            storage[hashKey] = new Node(-1, -1);
        }
        Node prev = search(storage[hashKey], key);
        if (prev.next != null) {
            prev.next.val = value;
        } else {
            prev.next = new Node(key, value);
       }
    }
    
    public int get(int key) {
        int hashKey = hash(key);
        if (storage[hashKey] == null) {
            return -1;
        }
        Node prev = search(storage[hashKey], key);
        if (prev.next != null) {
            return prev.next.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        if (storage[hashKey] == null) {
            return;
        }
        Node prev = search(storage[hashKey], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
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
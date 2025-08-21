// Time Complexity :Amortized-O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Used linear chaining with linked list to handle collision
Created a helper method - getPrev to get the previous node in the linked list using which update, get and remove operations
are simplified
Used two pointers prevous and current to make the removed node orphan.
Created a dummy node during the initial node insertion
*/

class MyHashMap {
    int buckets;
    Node[] storage;

    class Node {
        int key, val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];   
    }

    //To calculate hash value
    private int getHashKey(int key) {
        return key % buckets;
    }

    private Node getPrev(Node head, int key) {
        Node prev = head;
        Node curr = prev.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        //get the hash value
        int buckets = getHashKey(key);
        if (storage[buckets] == null) {
            // no llist present create a dummy node and new node with the key and value
            storage[buckets] = new Node(-1, -1);
            storage[buckets].next = new Node(key, value);
        }
        // when llist is already present
        //get the prev node
        Node prev = getPrev(storage[buckets], key);
        if (prev.next == null) {
            // no key is present so insert a fresh node
            prev.next = new Node(key, value);
        } else {
            // key is present so update the value
            prev.next.val = value;
        }   
    }
    
    public int get(int key) {
        //Get the hash value
        int buckets = getHashKey(key);
        if (storage[buckets] == null) return -1; // no key present in the index
        //primary array is not null so traverse through llist
        Node prev = getPrev(storage[buckets], key);
        if (prev.next == null) {
            // no key is found 
            return -1;
        } else {
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int buckets = getHashKey(key);
        if (storage[buckets] == null) return; //no item available to remove in primary array
        //primary array is not null so traverse through llist
        Node prev = getPrev(storage[buckets], key);
        if (prev.next == null) {
            return; //no key present to remove 
        } else {
            // we have found key to remove
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

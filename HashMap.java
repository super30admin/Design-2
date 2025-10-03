// Time Complexity : amortized O(1).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : We used linear chaining technique here to implement hashset where in we have array of nodes
// as storage buckets. As it's linear chaining we used one hash function used for the array reference and then iterate through the linkedList
// for the operations.

// Your code here along with comments explaining your approach

class MyHashMap {
    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.storage = new Node[1000];
        this.buckets = 1000;
    }

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int getHash(int key){
        return key%buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return;
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }


}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
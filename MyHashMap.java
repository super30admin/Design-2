// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced some problem to implement the dummy node concept.

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int buckets;
    private Node[] storage;

    private int hash(int key){
        return key % buckets;
    }


    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    private Node helper(Node head, int key){
        Node prev = head;
        Node curr = prev.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = helper(storage[bucket], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return -1;
        Node prev = helper(storage[bucket], key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return;
        Node prev = helper(storage[bucket], key);
        if(prev.next == null){
            return;
        }else{
            Node curr = prev.next;
            prev.next = prev.next.next;
            curr.next = null;
        }
    }
}
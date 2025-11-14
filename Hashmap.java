// Time Complexity : O(1)-avg , O(n)-worst case
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Initialized a node structure and to avoid collisions i initialized a linked list as a sub array to each index and Uses a dummy head node and a custom getPrev method to simplify operations.
// for put i checked if that element is present or not and replaced the value
//for remove and get, i checked whether that element is there or not if not there i return -1 or none
class MyHashMap {
    Node[] storage;
    int buckets;
    
    class Node {
        int key;
        int val;
        Node next;
    public Node (int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }
    public int getHash(int key){
        return key % 1000;
    }
    private Node getPrev(Node head, int key){
        Node curr = head;
        Node prev = null;
        while (curr!= null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash_1 = getHash(key);
        if (storage[hash_1] == null){
            storage[hash_1] = new Node(-1,-1);
            storage[hash_1].next = new Node(key, value);
            return;
        }
        Node prev = getPrev(storage[hash_1],key);
        if (prev.next == null){
            prev.next = new Node(key,value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int hash_1 = getHash(key);
        if(storage[hash_1] == null){
            return -1;
        }
        Node prev = getPrev(storage[hash_1],key);
        if (prev.next == null){
            return -1;
        }else{
            return prev.next.val;
        }
        
    }
    
    public void remove(int key) {
        int hash_1 = getHash(key);
        if(storage[hash_1] == null){
            return;
        }
        Node prev = getPrev(storage[hash_1],key);
        if (prev.next == null){
            return;
        }else{
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
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
// Time Complexity : Put: O(n), get: O(n), remove: O(n);
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using linear chaining method
// Create Node class with key, value and next member
// Initialize array of Node with 10000 size
// In case of put, find the hash code, if that array location is empty initialize with dummy node else find the key in list. If key is present, update its value else create a new node and point next of prev to new node.
// Same logic applies for remove and get.

class MyHashMap {
    private class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node storage[];
    private int bucketSize = 10000;

    public MyHashMap() {
        storage = new Node[bucketSize];
    }
    
    private int getHashCode(int key){
        return key % 10000;
    }

    private Node findPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash = this.getHashCode(key);
        if(storage[hash] == null)
            storage[hash] = new Node(-1,-1);
        
        Node prev = this.findPrev(storage[hash], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }
    
    public int get(int key) {
        int hash = this.getHashCode(key);
        if(storage[hash] == null)
           return -1;
    
        Node prev = this.findPrev(storage[hash], key);
        if(prev.next == null)
            return -1;
        else
            return prev.next.value;
    }
    
    public void remove(int key) {
        int hash = this.getHashCode(key);
        if(storage[hash] == null)   return;
        
        Node prev = this.findPrev(storage[hash], key);
        if(prev.next != null)
            prev.next = prev.next.next;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
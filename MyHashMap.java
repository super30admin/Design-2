// Time Complexity : O(n) for put, get and remove
// Space Complexity : O(n) for linkedlist
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Node {
    int key;
    int val;
    Node next;
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {
    Node[] storage;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int bucket = getBuckets(key);
        
        if(storage[bucket] == null){
            // Linked list is not been initialised yet for this key
            // Create a dummy node
            storage[bucket] = new Node(-1, -1);
        }
           
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            // New Node
            prev.next = new Node(key, value);
        }else{
            // Update existing node
            prev.next.val = value;
        }         
    }
    
    public int get(int key) {
        int bucket = getBuckets(key);
        
        if(storage[bucket] == null){
            // Element not found
            return -1;
        }
        
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            // We couldn't find the key mapping
            return -1;
        }
        
        return prev.next.val;
    }
    
    public void remove(int key) {
        int bucket = getBuckets(key);
        
        if(storage[bucket] == null){
            // Element not found
            return;
        }
        
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            // We couldn't find the key mapping
            return;
        }else{
            Node current = prev.next;
            prev.next = current.next;
            current.next = null;            
        }
    }
    
    private Node find(Node head, int key){
        Node prev = null;
        Node current = head;
        
        while(current != null && current.key != key){
            prev = current;
            current = current.next;
        }
        return prev;
    }
    
    private int getBuckets(int key){
        return key % buckets;
    }
}
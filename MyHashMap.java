// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Created an array of capacity 10000 and added the elements as part of linked list
//in  case of collision - we can use double hashing, linear probing or linear chaining
//used linear chaining in the below example
class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    Node[] storage;
    int buckets;

    public MyHashMap(){
        this.buckets = 10000;
        this.storage =  new Node[buckets] ; 
    }

    private int hash(int key) {
        return key% buckets;
    }

    private Node find (Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key)  {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int val) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1) ;
        }
        Node prev = find(storage[bucket], key);
        //case 1 node does not exist
        if(prev.next == null){
            prev.next = new Node(key, val);
        }else {
            prev.next.value = val;
        }
        
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            return -1;
        } else {
            return prev.next.value;
        }
        
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            return ;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null)
            return;
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
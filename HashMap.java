// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// I had a lot of syntactical errors to deal with.public class HashMap {
// Some errors because of logic.
//  Debugged and resolved it.


// Your code here along with comments explaining your approach
class MyHashMap {

    Node[] storage;
    int buckets;

    class Node{
        int key; int value; Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int getHash(int key){
        return key % buckets;
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key!= key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int Index = getHash(key);
        if(storage[Index] == null){
            storage[Index] = new Node(-1,-1);
            storage[Index].next = new Node(key,value);
            return;
        }
        Node prev = getPrev(storage[Index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int Index = getHash(key);
        if(storage[Index] == null) return -1;
        Node prev = getPrev(storage[Index],key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int Index = getHash(key);
        if(storage[Index] == null) return;
        Node prev = getPrev(storage[Index],key);
        if(prev.next == null) return;
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
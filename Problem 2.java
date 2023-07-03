// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Designing a Hash map using array of nodes of 10000 buckets and linked list based on the hash function on the vaule e%10000

class MyHashMap {

     class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    Node[] storage;
    int buckets = 10000;

    public MyHashMap() {
        this.storage = new Node[buckets];
    }
    
    public int hashIdx(int key){
        return key%buckets;
    }

    public Node findIndex(Node head, int key){
        Node previous = null;
        Node current = head;
        while(current != null && current.key != key){
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public void put(int key, int value) {
        int bucket=hashIdx(key);
        if(storage[bucket] == null) storage[bucket]= new Node(-1,-1);
        Node previous = findIndex(storage[bucket],key);
        if(previous.next == null) {
            previous.next = new Node(key,value);
        }else{
            previous.next.val = value;
        }
    }
    
    public int get(int key) {
      int bucket=hashIdx(key);
      if(storage[bucket] == null) return -1;
         Node previous = findIndex(storage[bucket],key);
        Node current = previous.next;
        if(current == null) { 
            return -1;
        }
        return current.val;
    }
    
    public void remove(int key) {
      int bucket=hashIdx(key);
      if(storage[bucket] == null) return;
       Node previous = findIndex(storage[bucket],key);
        Node current = previous.next;
        if(current == null) return;
        previous.next = current.next;
    }
}

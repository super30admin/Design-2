// Time Complexity : O(n/k) per operation on average, where n = total keys, k = number of buckets
// Space Complexity : O(n + k), n for storing key-value nodes, k for bucket array
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use an array of linked lists/buckets to store key-value pairs and handle collisions through chaining.
// For each operation, hash the key to find the correct bucket and traverse the list to find or modify the node.
// Dummy head nodes simplify edge case handling for insertions and deletions.


class MyHashMap {
    Node[] storage;
    int buckets;

    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public MyHashMap() {
        this.buckets=10000;
        this.storage=new Node[buckets];
    }

    private int getHash(int key){
        return key%buckets;
    }

    private Node getPrev(Node head,int key){
        Node prev=null;
        Node curr=head;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int i=getHash(key);
        if(storage[i]==null){
            storage[i]=new Node(-1,-1);
            storage[i].next=new Node(key,value);
            return;
        }
        Node prev=getPrev(storage[i],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int i=getHash(key);
        if(storage[i]==null){
            return -1;
        }
        Node prev=getPrev(storage[i],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int i=getHash(key);
        if(storage[i]==null){
            return;
        }
        Node prev=getPrev(storage[i],key);
        if(prev.next==null){
            return;
        }
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// Time Complexity : O(1) for put, O(1) for get and remove
// Space Complexity : O(n) for storing elements in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we use array of objects and use linear probing to handle collisions
// we use a dummy node to handle the case when the first node is deleted
// we use a helper function to get the previous node of the node with the given key
// so that we can update the value or remove the node easily



class MyHashMap {
    Node[] storage;
    int buckets;
    class Node{   //structure of each node in the linked list
        int key,value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public MyHashMap() {
        this.buckets=10000;
        this.storage=new Node[buckets]; 
    }

    int generatehashfunc(int key){
        return key%buckets;
    }

    Node getPrev(int key,Node head){
        Node prev=null,curr=head;
        while(curr!=null&&curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index=generatehashfunc(key);
        if(storage[index]==null){
            storage[index]=new Node(-1,-1);   
            storage[index].next=new Node(key,value);
            return;
        }
        Node prev=getPrev(key,storage[index]);
        if(prev.next==null)   //no entry with the given key is present
            prev.next=new Node(key,value);
        else
            prev.next.value=value;  // entry with the given key is present so update its value
    }
    
    public int get(int key) {
        int index=generatehashfunc(key);
        if(storage[index]==null){
            return -1;
        }
        Node prev=getPrev(key,storage[index]);
        if(prev.next==null)   //no entry with the given key is present 
            return -1;
        else
            return prev.next.value;
    }
    
    public void remove(int key) {
        int index=generatehashfunc(key);
        if(storage[index]==null){
            return;
        }
        Node prev=getPrev(key,storage[index]);
        if(prev.next==null)   //no entry with the given key is present
            return;
        else
            prev.next=prev.next.next;
    }
}


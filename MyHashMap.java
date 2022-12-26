// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: We follow a linear chaining approach, where we have a bucket of nodes, each node will have a linked list.
// To place the element in the bucket, we need to calculate hasIndex which is key%bucket
// To find a node, we already have the key and the head of the node
// We traverse the particular node of the linkedlist and traverse the linkedlist until we find the key
// Get and remove function will be similar, in get we return the value of the node and in remove,
// we remove the node after locating it and set its prev.next to prev.next.next

class MyHashMap {
    
    //for LinkedList
    class Node{
        int key;int val;
        Node next;
        private Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    
    private Node[] storage;
    private int buckets;
    
    public MyHashMap() {
        
        this.buckets=10000;
        this.storage=new Node[this.buckets];
    }
    
    //calculate hash index
    private int hashIdx(int key){
        return key%buckets;
    }
    
    //find function
    public Node find(Node head,int key){
        Node curr=head;
        Node prev=null; //initially
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        // 2 scenarios that break the while loop
        // 1 we dont find the node at all and current reached null
        // 2 when we reach at a curr node and prev node is 1 step back
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket=hashIdx(key);
        if(storage[bucket]==null){
            storage[bucket]=new Node(-1,-1);
        }
        // if the key already exists
        Node prev=find(storage[bucket],key);
        if(prev.next==null){ 
            // we didnt find current element
            prev.next=new Node(key,value); // add the node
        } else { //current node is there
            prev.next.val=value ; //update the current value, curr is prev.next
        }
    }
    
    public int get(int key) {
        int bucket=hashIdx(key);
        if(storage[bucket]==null) return -1;
        Node prev=find(storage[bucket],key);
        if(prev.next==null) return -1; //if current is not present
        return prev.next.val; // return curr value if current is present
    }
    
    public void remove(int key) {
        int bucket=hashIdx(key);
        if(storage[bucket]==null) return;
        Node prev=find(storage[bucket],key);
        if(prev.next==null) return;
        prev.next=prev.next.next; // set current to the next node
    }
}

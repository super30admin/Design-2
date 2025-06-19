// Time Complexity :O(L) 
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO
class MyHashMap {
    class Node{
        int key,value;
        Node next;
    
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }                         //linkedlist created to handle colloisions and create a find function to save time from going traverse to each node and created a dummy if node finds in first node only
    }
    Node find(Node dummy,int key){
        Node prev=dummy;
        Node curr=dummy.next;

        while(curr !=null && curr.key!=key){
          prev=curr;
        curr=curr.next;  //inside linkedlist if we found matching key or null return prev pair 
        }
       return prev; 
    }
    int buckets;
    Node[] storage;
    int getBucket(int key){
        return key % this.buckets;
    }
    public MyHashMap() {


        this.buckets=1000;
        storage=new Node[this.buckets];
        
    }
    
    public void put(int key, int value) {
        int bucket=getBucket(key);
        if(storage[bucket]==null){
        storage[bucket]=new Node(-1,-1);//if null dummy node will be created
        }
        Node prev=find(storage[bucket],key);
        if(prev.next==null){  // if next node of prev is null new node will be created or else will update prev next value that is current
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value= value;

        }
        
    }
    
    public int get(int key) {
        int bucket=getBucket(key);
        if(storage[bucket]==null){
            return -1;
        }
     Node prev=find(storage[bucket],key);
     if(prev.next != null){
        return prev.next.value;
     }
     return -1;
        
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        if(storage[bucket]==null){ //
            return;
        }
    
    Node prev=find(storage[bucket],key);
    if(prev.next!=null){ // if it is not equal to null then the prev next pair wil be removed so prev next will become next of its next
        prev.next=prev.next.next;
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
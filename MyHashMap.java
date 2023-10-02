// Time Complexity :
//          1. Put Operation: Amortized O(1)
//          2. Remove Operation:  Amortized O(1)
//          3. Get Operation: Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Pointer operations while remove()

// Your code here along with comments explaining your approach
class MyHashMap {

    Node[] buckets;
    public MyHashMap() {
        buckets = new Node[10000];
    }
    private int hash1(int key){
        return key % 10000;
    }
    private Node search(Node node, int key){
        Node prev = null;
        Node curr = node;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index = hash1(key);
        
        if(buckets[index]==null){
            buckets[index] = new Node(-1,-1);
        }
        //Node node = new Node(key,alue);
        Node prev = search(buckets[index], key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
       
    }
    
    public int get(int key) {
        int index  = hash1(key);
        if(buckets[index]==null)
            return -1;
        Node prev = search(buckets[index],key);
       // System.out.println("prev "+prev.next.value);
        if(prev.next==null)
            return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = hash1(key);
        if(buckets[index]==null)
            return;
        Node prev = search(buckets[index],key);
        if(prev.next==null){
            return;
        }
        Node temp = prev.next;
        prev.next=prev.next.next;
        temp.next=null;
    }
}

class Node{
    int key;
    int value;
    Node next;

    public Node(int key,int value){
        this.key=key;
        this.value=value;
        next = null;
    }
}


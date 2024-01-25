// https://leetcode.com/problems/design-hashmap/

// Time Complexity :
/*
 *  get, remove, and put all perform Node manipulation operations which take constant time.
 *  All of these has one call in common to searchNode() which searches a linked list of constant size
 *  Max number of elements in this linked list is UPPER LIMIT OF RANGE/NO OF BUCKETS(= 1000000/10000)=100 which is a constant
 *  So all these operations take constant time
 */

// Space Complexity :
/*
 * Constant space is utilized. Only space to store all the key-valu pairs is used,
 * and a certain number of temp varaibles(to iterate over node etc) are created
 */

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nod


// Your code here along with comments explaining your approach

// Hashmap with linear chaining
class Problem2 {

    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    private int buckets;
    private Node[] storage;


    public MyHashMap() {
        // Number of buckets can be changed 
        buckets=10000;
        storage=new Node[buckets];
    }

    private Node searchBucket(Node head, int key){
        Node prev=null;
        Node curr=head;

        // Iterate over ll until Node with given key found, and till there are nodes
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    private int getHash(int key){
        return key%this.buckets;
    }
    
    public void put(int key, int value) {
        // Find the hash for given key
        int index=this.getHash(key);

        if(storage[index]==null){
            // Create a dummy node at that index
            storage[index]=new Node(-1, -1);
        }

        // Get the prev pointer or tail of ll if key doesn't exist'
        Node prev=this.searchBucket(storage[index], key);

        // If key doesn't exist, attach a new node
        if(prev.next==null) prev.next=new Node(key, value);
        prev.next.val=value;
    }
    
    public int get(int key) {
        int index=getHash(key);

        // If bucket doesn't exist, then key doesn't exist
        if(storage[index]==null)    return -1;

        // Get the prev pointer or tail of ll if key doesn't exist'
        Node prev=searchBucket(storage[index], key);

        // Key not found
        if(prev.next==null) return -1;

        // Key found
        return prev.next.val;
    }
    
    public void remove(int key) {
        int index=getHash(key);

        // If bucket doesn't exist, then key doesn't exist
        if(storage[index]==null)    return;

        // Get the prev pointer or tail of ll if key doesn't exist'
        Node prev=searchBucket(storage[index], key);

        // Key not found
        if(prev.next==null) return;

        // Key found, remove it from ll
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
    }
}


// Time Complexity : O(1) , since searching will be for at max 100 iterations considered as constant time
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced issues with references in remove and search functions.


// Your code here along with comments explaining your approach

class MyHashMap {

    class Node{
        int val;
        int key;
        Node next;

        public Node(int key, int val){
            this.val = val;
            this.key = key;
            this.next = null;
        }
    }

    private Node[] storage;
    private int mod;

    public MyHashMap() {
        storage = new Node[10000];
        this.mod = 10000; //keeping it 10000 arrays values and 100 linkedlist values for 10^6 input    
    }

    //to provide index in the array where key will be present
    private int hash(int key){
        return key%mod;
    }

    // wrote a modular search funtion to cater to put,get and remove function of hashmap
    private Node search(Node head, int key){
        Node prev = head;
        Node curr = prev.next;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null){
            storage[idx] = new Node(-1,-1); // keeping a dummy node with -1 (which is out of limit)
        }

        Node prev = search(storage[idx], key);
        if(prev.next == null) // we are at the tail because we could not find the key
        {
            prev.next = new Node(key,value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = hash(key);

        if(storage[idx] == null) // there is no pointer to the linkedlist, hence key is not present
            return -1;
        
        Node prev = search(storage[idx],key);
        //System.out.println(prev.val);
        if(prev.next == null) // we are at the tail because we could not find the key
        {
            return -1;
        }
        else{
            return prev.next.val; // prev.next is curr where key is present
        }

    }
    
    public void remove(int key) {
        int idx = hash(key);

        if(storage[idx] == null) // there is no pointer to the linkedlist, hence key is not present
            return;
        
        Node prev = search(storage[idx],key);
        if(prev.next == null) // we are at the tail because we could not find the key
        {
            return;
        }
        else{
            Node temp = prev.next; // prev.next is curr which needs to be removed
            prev.next = temp.next;
            temp.next = null;
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

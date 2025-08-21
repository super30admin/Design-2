// Implementing HashMap using linear chaining
// Time Complexity : Amortized O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {

    // create a node class for linear chaining
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    // TC: O(1)
    private int myHashFunction(int key){
        return key % buckets;
    }
     // TC: Amortized O(1)
     // helper for all three operations to get prev node by iterating throught the list
    private Node getPrev(int key, Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next; 
        }
        return prev;
    }
    // TC: Amortized O(1)
    public void put(int key, int value) {
        int index = myHashFunction(key);

        //if no list create, create a node with dummy node and then node with actual value
        // dummy node to handle prev edge condition
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
            storage[index].next = new Node(key, value);
        }
        // check if the key exists, if it does update the value else add new node
        Node prev = getPrev(key, storage[index]);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }
    // TC: Amortized O(1)
    public int get(int key) {
        int index = myHashFunction(key);
        // check and return the value if exists, else return -1
        if(storage[index] == null)
            return -1;
        Node prev = getPrev(key, storage[index]);
        if(prev.next == null)
            return -1;
        return prev.next.value;
    }
    // TC: Amortized O(1)
    public void remove(int key) {
        int index = myHashFunction(key);

        //check if the key exists, if it does, point prev pointer to prev's next's next node
        if(storage[index] == null)
            return;
        Node prev = getPrev(key, storage[index]);
        if(prev.next == null)
            return;

        // free up the node to be picked by garbage collector and clean code
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


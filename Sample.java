// Time Complexity : Average Case: O(1) — assuming uniform distribution and good hash function. Worst Case: O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : For understaning the linear chaing.


// Your code here along with comments explaining your approach
// Represents a single entry in the HashMap. Each node stores a key, value, and a pointer to the next node.
class MyHashMap {

    Node[] storage;
    int buckets;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key =key;
            this.value =value;
        }
    }

    public MyHashMap() {
        this.buckets =1000;        //array size
        this.storage = new Node[buckets];  //array of nodes size
    }
    
    //Maps a key to a specific bucket index between 0 and 999.
    private int getHash(int key){
        return key % buckets;      //for finding the index actually
    }


//Purpose: Finds the node before the node containing the target key. & If key not found, returns the last node in the chain.

//Why?: Makes it easier to update or delete the key later.
// If prev.next == null, key is not present.
// If prev.next.key == key, key is present.
    private Node getPrev(Node head, int key){
        Node prev =null;
        Node curr = head;
        while(curr !=null && curr.key!= key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

//Calculate bucket index using hash.
//If the bucket is empty, create a dummy node and add the new node.
//Use getPrev() to find the previous node.
//If the key already exists → update the value.
//Else → add a new node at the end.

    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1); //creates a dummy node 
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);   //head =storage[index]
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;  //updating the value of current node
        }
    }
    

//Hash the key to find the bucket.
//If no bucket exists → return -1.
//Use getPrev() to check if key exists.
// If not → return -1. Else → return value
    public int get(int key) {
        int index = getHash(key);
        if(storage[index]==null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    

//Get bucket index.
//If no list → nothing to remove.
//Find prev node using getPrev().
//If prev.next is null → key not found.
//Else → remove the node by changing the next pointer.
    public void remove(int key) {
        int index = getHash(key);

        if(storage[index] == null) return;
        Node prev= getPrev(storage[index], key);

        if(prev.next==null) return;
        Node curr= prev.next;
        prev.next=curr.next;
        curr.next=null;
    }
}


// The overall time complexity is: O(1) amortized time per operation   Worst-case time for one pop() or peek(): O(n)

//  Space Complexity: O(n) where n is the total number of elements in the queue. Each element is stored in either inSt or outSt, but never in both at the same time.

class MyQueue {

    Stack<Integer> inSt;   // Stack to add (push) new elements
    Stack<Integer> outSt;  // Stack to remove (pop) elements in correct order

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }

    // Add element to the end of the queue
    public void push(int x) {
        inSt.push(x);  // Just push into the input stack
    }

    // Remove the element from the front of the queue
    public int pop() {
        if (empty()) return -1;  // If both stacks are empty, return -1
        peek();                  // Make sure outSt has the correct order
        return outSt.pop();      // Pop from outSt
    }

    // Get the front element of the queue
    public int peek() {
        // If outSt is empty, move all elements from inSt to outSt
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty()) {
                outSt.push(inSt.pop());  // Reverse the order
            }
        }
        return outSt.peek();  // Return the front element
    }

    // Check if the queue is empty
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }
}
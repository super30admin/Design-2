// Time Complexity : push - O(1), peek and pop - O(1)
// Space Complexity : O(n) because we use two stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

class MyQueue {
    Stack<Integer> in;               // using two stacks S1 = in and S2 = out
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();            // initializing both stacks
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);                   // for pushing element we use in stack which makes time complexity as O(1)
    }
    
    public int pop() {                   // Amortized O(1)
        peek();                          // since peek and pop are executinf same line of code so call peek in pop
        return out.pop();
    }
    
    public int peek() {                    
        if (out.isEmpty()) {                     // check if the out stack is empty
            while (!in.isEmpty()) {              // check if the in stack is not empty
                out.push(in.pop());              // pop the elements from in stack and push it in out stack
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();      // checking both the stack if empty and return true with time complexity as O(1)
    }
}


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(1) for all operation put, get, remove
// Space Complexity : O(n) because space used by storage array will be constant i.e. 10000 but space used by the nodes will be proportional to n.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {

    class Node {                                         // node in the linked list
        int key;
        int value;
        Node next;
        public Node (int key, int value) {                 // constructor assigned
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;                                         // array of nodes
    int buckets;

    private int getBucket(int key) {                         // using the hash function with inbuilt java method hashCode
        return Integer.hashCode(key) % buckets;
    }

    private Node find(Node node, int key) {                 // creating a find method to set dummy and the next element
        Node prev = node;
        Node curr = node.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public MyHashMap() {
        buckets = 10000;                                         // initializing buckets
        storage = new Node[buckets];
    }
    
    public void put(int key, int value) {                            // used to insert a key-value pair into the hashmap
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);                      // assigning a dummy variable or a placeholder
        }
        Node prev = find(storage[bucket], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {                                      // used to retrieve the value corresponding to a given key
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return -1;                                             // linked list for that index is empty
        }
        Node prev = find(storage[bucket], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {                               // used to remove a key-value pair from the hashmap
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return;                                            // linked list for that index is empty
        }
        Node prev = find (storage[bucket], key);              // finds the previous node for the key
        if (prev.next == null) {
            return;                                            // the next node is null
        }
        prev.next = prev.next.next;                            // updates the next pointer
    }
}
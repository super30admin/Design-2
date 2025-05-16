// Time Complexity : O(1) for put, get, remove
// Space Complexity : O(n) for n elements in the hash map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : YEs it took me almost 1.30 hr to understand chaining and how to implement it.

// Explain your approach in **three sentences only** at top of your code
// I have used chaining to implement the hash map. I have used an array of linked list nodes to store the key-value pairs.
// The hash function is the modulo of the key and the size of the array.
// The put, get, and remove operations are all O(1) in time complexity.

// Your code here along with comments explaining your approach
// Node class that holds key-value pair
class EntryNode {
    int key;
    int value;
    EntryNode next;

    public EntryNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// Hash map class
public class MyHashMap {
    EntryNode[] buckets;
    int size = 1000;

    public MyHashMap() {
        buckets = new EntryNode[size];
    }

    public int myhashfunction(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = myhashfunction(key);
        EntryNode current = buckets[index];

        // Check if key already exists → update
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new node at head
        EntryNode newNode = new EntryNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = myhashfunction(key);
        EntryNode current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1; // Not found
    }

    public void remove(int key) {
        int index = myhashfunction(key);
        EntryNode current = buckets[index];
        EntryNode prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }}

    // 232. Implement Queue using Stacks
    // Time Complexity : O(1) for push, pop, peek, empty
    // Space Complexity : O(n) for n elements in the queue
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    // Explain your approach in **three sentences only** at top of your code
    // I have used two stacks to implement the queue. I have used an input stack and
    // an output stack.
    // The push operation is O(1) in time complexity.
    // The pop, peek, and empty operations are O(1) in time complexity.

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /// class MyQueue {

    Stack<Integer> inputstack;
    Stack<Integer> outputstack;

public MyQueue() {
        inputstack = new Stack <>();
        outputstack = new Stack <>();
    }

    public void push(int x) {
        inputstack.push(x);
    }

    public void transfer() {
        if (outputstack.isEmpty()) {
            while (!inputstack.isEmpty()) {
                outputstack.push(inputstack.pop());
            }

        }
    }

    public int pop() {
        transfer();
        return outputstack.pop();
    }

    public int peek() {
        transfer();
        return outputstack.peek();
    }

    public boolean empty() {
        return inputstack.isEmpty() && outputstack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
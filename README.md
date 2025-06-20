# Design-2

Explain your approach in **three sentences only** at top of your code
// Time Complexity : AmortizedF for pop O(1), push(),peek(),empty() = O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

Approach:
We use two stacks, in and out, to simulate queue behavior.
All push operations go to in, and pop/peek operations come from out.
If out is empty when pop/peek is called, we transfer all elements from in to out, reversing the order to maintain FIFO.

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return this.out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return this.out.peek();  
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

## Problem 2:

// Time Complexity : O(N) 
// Space Complexity: O(K + N)
// K = number of buckets , N = number of stored key-value pairs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


Approach:
We use a fixed-size array of linked lists (separate chaining) to handle collisions.
Each index in the array represents a bucket, and we use a dummy head node to simplify insertion and deletion operations.
The find() helper returns the node before the target key, which helps us locate, update, or delete nodes efficiently.

Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashMap {
    class Node {
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
        this.storage = new Node[this.buckets];
    }

    int getBucket(int key){
        return (key % this.buckets);
    }

    private Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;

        while (curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if (storage[bucket] == null){
            storage[bucket] = new Node(-1, -1); // dummy node
        }

        Node prev = find(storage[bucket], key);
        if (prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) return -1;

        Node prev = find(storage[bucket], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) return;

        Node prev = find(storage[bucket], key);
        if (prev.next != null){
            prev.next = prev.next.next;
        }
    }
}



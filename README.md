# Design-2

Explain your approach in **three sentences only** at top of your code.

## Problem 1: Implement Queue using Stacks (https://leetcode.com/problems/implement-queue-using-stacks/)

### Approach:
We use two stacks, `inSt` and `outSt`, to simulate the behavior of a queue. Elements are pushed into `inSt`, and when a pop or peek operation is requested, elements are transferred from `inSt` to `outSt` to maintain the FIFO order. This ensures that the amortized time complexity for each operation is efficient.

```java
class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>(); // inStack
        this.outSt = new Stack<>(); // outStack
    }
    
    public void push(int x) {
        inSt.push(x); // when push operation occurs, push into inStack
    }
    
    public int pop() {
        if(empty()) return -1;
        if(outSt.isEmpty()) { // check whether outStack is already empty
            while(!inSt.isEmpty()) { // if inStack is not empty
                outSt.push(inSt.pop()); // pop from inStack and push into outStack
            } // first pop() gives O(n) complexity, rest O(1)
        }
        return outSt.pop(); 
    }
    
    public int peek() {
        if(outSt.isEmpty()) {
            while(!inSt.isEmpty()) {
                outSt.push(inSt.pop()); // same as pop operation
            }
        }
        return outSt.peek(); 
    }
    
    public boolean empty() { // check whether stack is empty or not
        return inSt.isEmpty() && outSt.isEmpty(); // check if both stacks are empty
    }
}
```

---

## Problem 2: Design HashMap (https://leetcode.com/problems/design-hashmap/)

### Approach:
We use an array of linked lists to handle collisions via chaining. Each bucket in the array stores a linked list of nodes, where each node contains a key-value pair. Hashing is used to determine the index for a given key, and operations like `put`, `get`, and `remove` are performed by traversing the linked list at the corresponding bucket.

```java
class MyHashMap {

    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    private int getHash(int key) {
        return (2 * key) % buckets;
    }

    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null) {
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}
```

---

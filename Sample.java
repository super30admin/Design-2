// Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I understood the problem and implemented the solution but faced issues on how to use java syntax according to problem and the in built libraries.

// Your code here along with comments explaining your approach
//The main idea is to use one stack (inStack) for enqueue operations and another stack (outStack) for dequeue operations. When we need to dequeue an element, we check if outStack is empty. If it is, we pop all elements from inStack and push them onto outStack, effectively reversing the order of the elements. This way, the front of the queue will be on top of outStack
import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    private void move() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public int pop() {
        move();
        return outStack.pop();
    }

    public int peek() {
        move();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

//Problem 2:Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(1) for put, get, and remove operations.
// Space Complexity : O(n) in the worst case if all keys hash to the same bucket, but on average it will be O(1) if the hash function distributes keys equally.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I understood the problem and implemented the solution but faced issues on how to write the code in java according to problem requirements.

// Your code here along with comments explaining your approach
//used an array of buckets, and each bucket stores a linked list of (key, value) pairs. The hash function key % SIZE decides which bucket a key belongs to, and if multiple keys land in the same bucket, we keep them in that list. For put, get, and remove, we only scan one bucket.
import java.util.LinkedList;

class MyHashMap {
    private static final int SIZE = 1009;
    private LinkedList<int[]>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        for (int[] pair : buckets[idx]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        buckets[idx].add(new int[]{key, value});
    }

    public int get(int key) {
        int idx = hash(key);
        for (int[] pair : buckets[idx]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        for (int i = 0; i < buckets[idx].size(); i++) {
            if (buckets[idx].get(i)[0] == key) {
                buckets[idx].remove(i);
                return;
            }
        }
    }
}
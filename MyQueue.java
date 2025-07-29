// Approach:
// We use two stacks — one for inserting (inSt) and one for removing/peeking (outSt) elements.
// When outSt is empty, we move all elements from inSt to outSt, reversing the order to simulate a queue.
// This way, we maintain FIFO (First-In-First-Out) behavior using two LIFO (stack) structures.


// Time Complexity : O(1) amortized for push, pop, peek; worst-case O(n) when transferring
// Space Complexity : O(n), where n is the number of elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        // inSt stores new elements
        // outSt is used to pop/peek in correct queue order
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }

    public void push(int x) {
        // Always push new elements into input stack
        inSt.push(x);
    }

    public int pop() {
        // Transfer if outSt is empty, then pop the front of queue
        peek();
        return outSt.pop();
    }

    public int peek() {
        // Transfer all elements from inSt to outSt only when outSt is empty
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }

    public boolean empty() {
        // Queue is empty only when both stacks are empty
        return inSt.isEmpty() && outSt.isEmpty();
    }
}

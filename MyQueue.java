// Time Complexity : Amortized O(1) - for all operations.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.Stack;

class MyQueue {

    // Primary stack for enqueue (push) operations
    Stack<Integer> pStack;

    // Secondary stack for dequeue (pop and peek) operations
    Stack<Integer> sStack;

    public MyQueue() {
        pStack = new Stack<>();
        sStack = new Stack<>();
    }

    // Enqueue operation - push element onto the primary stack
    public void push(int x) {
        pStack.push(x);
    }

    // Dequeue operation - pop element from the front of the queue
    public int pop() {
        peek();
        return sStack.pop();
    }

    // Peek operation - view the front element of the queue without removing it
    public int peek() {

        // If the dequeue stack is not empty, peek at its top element
        if (!sStack.empty()) {
            return sStack.peek();
        }

        // Else, Transfer elements from the enqueue stack to the dequeue stack
        while (!pStack.empty()) {
            sStack.push(pStack.pop());
        }

        return sStack.peek();
    }

    // Check if the queue is empty
    public boolean empty() {
        return pStack.empty() && sStack.empty();
    }
}

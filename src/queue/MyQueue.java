package queue;

import java.util.Stack;

// Implementing queue using 2 stacks. One stack to keep track of incoming elements and other to keep track of outgoing elements.
// Time Complexity : O(1) for push operation and for pop and peek operations - Amortized - O(1) Worst Case - O(n)
// Space Complexity : O(n) where n is the number of elements in the queue.

public class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack();
        this.outStack = new Stack();
    }

    // Push element x to the inStack.
    public void push(int x) {
        inStack.push(x);

    }

    // While popping or peeking, if outStack is empty, we need to transfer all elements from inStack to outStack.
    // This is done to maintain the FIFO order of the queue.
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (outStack.isEmpty() && !inStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.peek());
                inStack.pop();
            }
        }
        return outStack.pop();
    }


    // While popping or peeking, if outStack is empty, we need to transfer all elements from inStack to outStack.
    // This is done to maintain the FIFO order of the queue.
    public int peek() {
        if (empty()) {
            return -1;
        }
        if (outStack.isEmpty() && !inStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.peek());
                inStack.pop();
            }
        }
        return outStack.peek();
    }

    // If both stacks are empty, then the queue is empty.
    public boolean empty() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            return true;
        }
        return false;
    }
}

// I used two stacks to simulate a queue using the amortized approach.
// Elements are pushed to stack1, and only when needed, transferred to stack2 for FIFO access.
// This ensures that push is always O(1), and pop/peek are O(1) amortized by reversing elements only once.

// Time Complexity : O(1) amortized for push, pop, peek. Worst case O(n) only when transferring from stack1 to stack2.
// Space Complexity : O(n) for storing n elements across two stacks.
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // Initialize two stacks
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    // Push to the back of the queue
    public void push(int x) {
        stack1.push(x); // Always push to stack1
    }

    // Return the front of the queue
    public int peek() {
        if (empty()) return -1;

        // Transfer elements to stack2 only if it's empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Reversing stack1 to simulate queue order
            }
        }
        return stack2.peek();
    }

    // Removes the element from front of queue
    public int pop() {
        if (empty()) return -1;
        peek(); // Ensure front is ready in stack2
        return stack2.pop();
    }

    // Check if queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

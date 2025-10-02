// Time Complexity : O(1) for push(), 
//                   Amortized O(1) for pop() and O(n) in worst case, 
//                   Amortized O(1) for peek() and O(n) in worst case, 
//                   O(1) for empty()

// Space Complexity : O(n) as we need auxiliary space to save elements.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Implement Queue using Stacks
 * Approach: Two stacks
 * We use an instack for pushing elements to the queue and an outstack 
 * for popping elements off the queue as the elements in instack require re-arranging to respect the queue ordering.
 * We do the same while peeking elements. We transfer the elements between the stacks as and when required.
 *
*/

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    // Pushes element to the back of the queue
    public void push(int x) {
        inStack.push(x);
    }
    
    // Pops element from the front of the queue and returns it. We need to move all elements from instack to outstack if
    // outstack is empty in order to maintain the elements in right order of first-in-first-out.
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }
    
    // Returns the element at the front of the queue
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    // Checks whether the queue is empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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
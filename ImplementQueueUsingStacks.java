// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I use two stacks: mainStack for inputs and outStack for outputs. New elements are always pushed onto mainStack. For pop or peek operations, I only shift elements from mainStack to outStack if outStack is currently empty. This reversal correctly orders the elements for FIFO (First-In-First-Out) access and ensures an amortized O(1) time complexity, as each element is moved between stacks only once.

import java.util.Stack;

class ImplementQueueUsingStacks {

    private Stack<Integer> mainStack;
    private Stack<Integer> outStack;

    public ImplementQueueUsingStacks() {
        mainStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
    }
    
    public int pop() {
        shiftStacks();
        if (outStack.isEmpty()) return -1; // Or throw error
        return outStack.pop();
    }
    
    public int peek() {
        shiftStacks();
        if (outStack.isEmpty()) return -1;
        return outStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                outStack.push(mainStack.pop());
            }
        }
    }
}
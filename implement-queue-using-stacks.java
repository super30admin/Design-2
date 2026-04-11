// Time Complexity : Amortized O(1) for pop, O(1) for push and peek
// Space Complexity : O(n) for storing elements in two stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach:
// Use two stacks: 'in' for incoming elements and 'out' for outgoing elements.
// For pop/peek, if 'out' is empty, transfer all elements from 'in' to 'out' to reverse order (FIFO behavior).
// Each element is moved at most once from 'in' to 'out', which ensures amortized O(1) time complexity.

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        // Always push into 'in' stack
        in.push(x);
    }
    
    public int pop() {
        // Ensure 'out' has elements in correct order
        peek();
        return out.pop();
    }
    
    public int peek() {
        // If 'out' is empty, transfer all elements from 'in' to 'out'
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
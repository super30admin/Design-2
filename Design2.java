// Time Complexity :
// push()    -> O(1)
// pop()     -> O(1)
// top()     -> O(1)
// getMin()  -> O(1)

// Space Complexity : O(n) 
//  - For storing n elements in `stack` and up to n elements in `minStack` in worst case

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
// No major issues. The key trick is to push a value to `minStack` 
// only when it's smaller than or equal to the current minimum.

// Your code here along with comments explaining your approach:

class MinStack {
    private Stack<Integer> stack;      // Primary stack to store all elements
    private Stack<Integer> minStack;   // Secondary stack to store minimum values

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or val is <= current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // If the top of both stacks is the same, pop from both
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek(); // Return top of primary stack
    }

    public int getMin() {
        return minStack.peek(); // Return top of minStack (the current minimum)
    }
}

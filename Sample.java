// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.Stack;

// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> inStack, outStack;

    public MyQueue() {
        this.inStack = new Stack();
        this.outStack = new Stack();
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * TC: O(1) - amortized, O(n) when outstack is empty
     * SC: O(1) - amortized, O(n) when outstack is empty
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.isEmpty() ? -1 : outStack.pop();
    }

    /**
     * TC: O(1) - amortized, O(n) when outstack is empty
     * SC: O(1) - amortized, O(n) when outstack is empty
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
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
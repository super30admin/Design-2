// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// To implement Queue using two stacks I need to make sure two thiings.
//a. insertion at end and deletion from beginning. FIFO
// Whenever we have to pop an element, traverse the stack and put it in other stack and then pop. 
// Push in one stack, pop from other stack if the stack is not empty.

class MyQueue {
    java.util.Stack<Integer> inStack;
    java.util.Stack<Integer> outStack;

    public MyQueue() {
       inStack = new java.util.Stack<>(); 
       outStack = new java.util.Stack<>(); 
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()) {
          while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }  
        }
        return outStack.peek();
    }
    
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
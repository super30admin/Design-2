// Time Complexity : O(1) for push, peek, empty and O(n) for pop (amortized O(1))
// Space Complexity : // O(n) for storing elements in stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// In my approach, I have used two stacks - I add everything to stack1.
// When I need to pop or peek, I transfer elements from stack1 to stack2 if stack2 is empty.
// Since stack1 is last in first out, it will put everything in reverse way, the top of stack2 will always be the front of the queue.

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int front = 0;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // O(1)
    public void push(int x) {
        if(stack1.isEmpty()) front = x;
        stack1.push(x);
    }
    
    // O(n) - O(1) amortized
    public int pop() {
        if(stack2.isEmpty()) while(!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.pop();
    }
    
    // O(1)
    public int peek() {
        if(!stack2.isEmpty()) return stack2.peek();
        return front;
    }
    
    // O(1)
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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

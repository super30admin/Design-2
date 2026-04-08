
// Time Complexity : All Functions - O(1) for push, amotized O(1) for pop and peek
// Space Complexity : O(n) where n is the number of elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach : Queue is usually FIFO, But stack is LIFO
// We are given 2 stacks, we have 2 menthods, 
// We will push element in stack in and when we get pop or peek we will move it to stack out and pop or peek from stack out, if stack out is empty then we will move all element from stack in to stack out and then pop or peek from stack out. This way we can maintain the order of queue using 2 stacks.
// Other wise we will push element in stack in and when next element comes we will push the element from in to out and insert the new element in stack in
// push back the element from stack out to stack in, this way we can maintain the order of queue using 2 stacks. But this approach will have O(n) time complexity for push operation, so we will go with the first approach which has O(1) time complexity for push operation and amotized O(1) time complexity for pop and peek operation.
// We will go with the first approach which has O(1) time complexity for push operation and amotized O(1) time complexity for pop and peek operation.

import java.util.Stack;

class MyQueue {
Stack<Integer> inStack;
Stack<Integer> outStack;
    public MyQueue() {

        this.inStack=new Stack<>();
        this.outStack=new Stack<>();
        
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty())
       {
        while(!inStack.isEmpty())
        {
            outStack.push(inStack.pop());
        }
       }
       return outStack.pop();
    }
    
    public int peek() {
       if(outStack.isEmpty())
       {
        while(!inStack.isEmpty())
        {
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

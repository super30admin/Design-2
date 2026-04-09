// Time Complexity : O(1) for push, O(n) for pop and peek in worst case when outStack is empty, O(1) for pop and peek in average case when outStack is not empty
// Space Complexity : O(n) where n is the number of elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// this approach uses two stacks to implement a queue. 
// The inStack is used to store the elements when they are pushed into the queue, 
// and the outStack is used to store the elements when they are popped from the queue. 
// When we need to pop or peek an element, we check if the outStack is empty. 
// If it is empty, we transfer all elements from the inStack to the outStack, 
// which reverses the order of the elements and allows us to access the front of the queue. 
// If the outStack is not empty, we can directly pop or peek from it. 
// This way, we maintain the FIFO order of the queue using two LIFO stacks.

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        peek();
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
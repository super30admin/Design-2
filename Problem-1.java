// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {
    // Implementing a queue using 2 stacks
    private Stack<Integer> inStack; // top of inStack is the back of the queue
    private Stack<Integer> outStack; // top of outStack is the front of the queue

    public MyQueue() {
        this.inStack = new Stack<>();    
        this.outStack = new Stack<>();    
    }
    
    // To insert element to the back of the queue
    public void push(int x) {
        inStack.push(x);
    }
    
    // To remove element from the front of the queue
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    // To get the element from the front of the queue
    public int peek() {
        // Check if the outStack is empty, if it is push all elements from inStack to outStack
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        // If both stacks are empty the queue is empty
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("Removed element " + queue.pop());
        System.out.println("Front element: " + queue.peek());
        queue.push(3);
        queue.push(4);
        System.out.println("Removed element " + queue.pop());
    }
}

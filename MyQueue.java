// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// I have used two stack to mimic a queue.
// As soon as a pop() or peek() operation is encountered I check if the outStack if it is empty I pop all elements from inStack into the outStack and then peek() or pop() the top of outStack I
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return outStack.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
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

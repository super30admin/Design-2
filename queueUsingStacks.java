// Time Complexity : O(n) since we'll copy the entire array's worth of data once
// Space Complexity : O(2n) for 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {

    //Create 2 queues one in normal order other in reverse
    Stack<Integer> normalStack;
    Stack<Integer> reverseStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        normalStack = new Stack<Integer>();
        reverseStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        normalStack.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //reverse the stack first and then pop the top element of the reversed stack
        copyStackToReverse();
        return reverseStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //Reverses the stack and then show the top element
        copyStackToReverse();
        return reverseStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //If only bot the queues are empty only then return true else elements are still there
        if(normalStack.isEmpty() && reverseStack.isEmpty())
            return true;
        return false;
    }
    
    public void copyStackToReverse() {
        //Put the elements only if its empty, if it's not empty then wait till all the pop operations happen and it becomes empty, then we can again put from the 'normal stack'
        if(reverseStack.isEmpty()) {       
            while(!normalStack.isEmpty()) {
                reverseStack.push(normalStack.pop());
            }
        }
    }
}

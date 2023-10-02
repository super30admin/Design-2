/* Time Complexity : 
 * each of push, pop, peek, empty - O(1)*/
/* Space Complexity : 
 * each of push, pop, peek, empty - O(1)*/
// Did this code successfully run on Leetcode : - Yes
// Any problem you faced while coding this :

import java.util.Stack;

class MyQueue {

    private Stack<Integer> inStack;//Insert new val
    private Stack<Integer> outStack;//Used for Pop and peek - To implement FIFO

    public MyQueue() {
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    public int peek() {
    	//If outStack is empty, populate it using inStack and then peek in outStack
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {// both stacks should be empty for this to return true
        return (outStack.isEmpty() && inStack.isEmpty());
    }
}

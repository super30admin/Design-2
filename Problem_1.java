/* 

Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/) 

Time Complexity : O(N), where N is the number of elements in the "in" stack for pop() and peek() for worst case. For push() its O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Lets take 2 stacks "in" and "out". Push operation happens into "in". When there is a pop() or peek(), we check if
"out" is empty, and if it is empty then we pop() all elements from "in" into "out". and then pop() or peek() from "out". If the 
"out" is not empty then we directly can pop() or peek() making our TC O(1). Hence, average TC for pop and peek comes to O(1).
 
 */

import java.util.Stack;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();        
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
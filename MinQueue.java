/*
* Approach:
*  1. use two stacks instack and outstack
* 
*  2. perform push on instack and pop on outstack
* 
*  3. while popping, check if outstack is empty, 
*        if empty, 
*           transfer all elements from instack to outstack till instack is empty.
*
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : YES
    Collection of Stack syntax: 
        Collections can be applied on Objects but not on primitive data types.
    
* 
* Time Complexity:
    push - O(1)
    pop - O(1) amortized
    peek - O(1) amortized
    empty - O(1)
* 
* Space Complexity: O(2N) ==> O(N) using two stacks
* 
*/

import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack, outStack;

    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();

        return outStack.pop();
    }

    public int peek() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
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
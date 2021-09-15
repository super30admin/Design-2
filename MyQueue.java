/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
Memory Usage: 37 MB, less than 56.64% of Java online submissions for Implement Queue using Stacks.
*/

import java.util.Stack;

class MyQueue {
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    int peek;

    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(st1.isEmpty())
            peek = x;
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st2.push(x);
        while(!st2.isEmpty())
            st1.push(st2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int pop = st1.pop();
        if(!st1.isEmpty())
            peek = st1.peek();
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty();
    }
}
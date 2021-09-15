// Time Complexity : push-O(1), pop-O(n), peek-O(n) ,empty-O(1)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :none

import java.util.Stack;
public class MyQueue {
    Stack<Integer> st1,st2;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1=new Stack<Integer>();
        st2=new Stack<Integer>();
    }
    
    //pushing element to the stack without using the second stack at this point
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //popping from stack1 and pushing to stack2 element wise
        while(!st1.isEmpty()){
        st2.push(st1.pop());
        }
        int temp=st2.pop();
        //pushing again to the main stack 
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return temp;
    }
    
    /** Get the front element. */
    public int peek() {
        //popping from stack1 and pushing to stack2 element wise
        while(!st1.isEmpty()){
        st2.push(st1.pop());
        }
        int temp=st2.peek();
        //pushing again to the main stack 
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return temp;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty();
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
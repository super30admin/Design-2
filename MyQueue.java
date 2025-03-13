// Time Complexity : O(1) for push(), O(1) amortized for pop() and peek().
// Space Complexity : O(N) for storing elements in two stacks.  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : Initially, I pushed elements back to stack1 after transferring, causing O(N) time for pop() and peek() every time.


// Approach : 
// Used two stacks to implement a queue, where push() adds to stack1.  
// pop() and peek() transfer elements to stack2 only when needed for FIFO order.  
// empty() checks if both stacks are empty to determine if the queue is empty.

import java.util.*;

public class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() 
    {
        if(st1.size()==0 && st2.size()==0)
        {
            return -1;
        }
        if(st2.isEmpty())
        {
            while(!st1.isEmpty())
            {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    public int peek() 
    {
        if(st1.size()==0 && st2.size()==0)
        {
            return -1;
        }
        if(st2.isEmpty())
        {
            while(!st1.isEmpty())
            {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    
    public boolean empty() {
        if(st1.size()==0 && st2.size()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
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
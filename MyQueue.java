// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

import java.util.Stack;

class MyQueue {
    Stack stack, stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
        stack2 = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty())
            
        {
            int stackSize = stack.size();
            //transfer data into another stack
            for(int i=0;i<stackSize;i++)
                {
                    stack2.push(stack.pop());
                }
            //pop the topmost value for queue
            int popedValue = (int)stack2.pop();
            int stackSize2 = stack2.size();
            //transfer data back to the main stack
            for(int i=0;i<stackSize2;i++)
                {
                    stack.push(stack2.pop());
                }

            return popedValue;
        }
        else
        {
            return -1;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty())
        {
            int stackSize = stack.size();
        for(int i=0;i<stackSize;i++)
        {
            stack2.push(stack.pop());
        }
        int peekValue = (int) stack2.peek();

            int stackSize2 = stack2.size();
        for(int i=0;i<stackSize2;i++)
        {
            stack.push(stack2.pop());
        }

            return peekValue;
        }

        else
        {
            return -1;
        }

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if( stack.empty())
        {
            return true;
        }
        else
        {
            return false;
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

public static void main(String[] args) {
  MyQueue obj = new MyQueue();
  obj.push(1);
  obj.push(2);
  int param_3 = obj.peek();
  int param_2 = obj.pop();
  
  boolean param_4 = obj.empty();
    
  System.out.println(param_2 + " " +param_3 + " " + param_4);
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
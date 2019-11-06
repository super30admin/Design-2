// Time Complexity :1
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//this is new commeng-------------------

// Your code here along with comments explaining your approach

class MyQueue {
	//creating two sttacks to keep track of minimum w.r.t the respective element
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	//simply push the element in s1
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty())
        {	//if s1 is not empty,push all the elements of s1 in s2
            while(!s1.isEmpty())
            {s2.push(s1.pop());}
        }
        //return and pop the top of the s2 stack
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         if(s2.isEmpty())
        {	//if s1 is not empty,push all the elements of s1 in s2
            while(!s1.isEmpty())
            {s2.push(s1.pop());}
        }
        //return top of the s2 stack
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	//if both the stacks are empty return true
        return (s1.isEmpty() && s2.isEmpty());
        
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
// Time Complexity : O(1) for push, peek and empty. In worst Case O(N) for pop
// Space Complexity : O(N) where N = size of stack.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/525825319/  
// Any problem you faced while coding this : None. 


class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> s1, s2;
    private int front;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = -1;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // if this is first element it becomes front of queue
        if(s1.isEmpty())
        {
            front = x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // if s2 is empty then we need to copy elements of s1 in reverse order (to make front as top)
        if(s2.isEmpty())
        {
            while(s1.isEmpty() == false)
            {
                s2.push(s1.pop());
            }
        }
        // top of s2 will be front of queue
        int ans = s2.pop();
        
        // New front should point to second top element
        if(s2.isEmpty() == false)
            front = s2.peek();
        
        return ans;
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();   
    }
}

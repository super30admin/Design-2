// Time Complexity : 
// For Push Operation -> Time Complecity is O(1) and Space Complexity is O(1)
// For POP Operation -> Time Complecity is O(1) (Amortized) and Space Complexity is O(n)
// For Peek Operation -> Time Complecity is O(1) (Amortized) and Space Complexity is O(n) 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Error for peek I did not check if both the Stacks are empty. 


// Your code here along with comments explaining your approach

import java.util.*;
class MyQueue {
    private final Stack<Integer> s1;
    private final Stack<Integer> s2;
    public MyQueue() {
       s1=new Stack<>();
       s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x); //O(1)
    }
    
    public int pop() {
      peek();
      return s2.pop(); 
    }
    
    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop()); //O(n)
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
       return s1.empty() && s2.empty();
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
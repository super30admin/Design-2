// Time Complexity : push, isempty - O(1), pop,peek - O(n), 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> queue1;
    Stack<Integer> queue2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        queue1 = new Stack<>();
        queue2 = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        while(!queue1.isEmpty()){
            queue2.push(queue1.pop());
        }
        int val = -1;
        
        if(!queue2.isEmpty())
            val =  queue2.pop();
        
        while(!queue2.isEmpty()){
            queue1.push(queue2.pop());
        }
        return val;
      }
    
    /** Get the front element. */
    public int peek() { 
        
        Object temp = (Stack)queue1.clone();
        
        while(!queue1.isEmpty()){
            queue2.push(queue1.pop());
        }
        int val = -1;
        
        queue1 = (Stack)temp;
        
        if(!queue2.isEmpty())
            val =  queue2.peek();
        
        queue2=new Stack();
        return val;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
      while(!queue1.isEmpty()){
            queue2.push(queue1.pop());
        }
       return queue2.isEmpty();
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

//fron 1 2 3rear
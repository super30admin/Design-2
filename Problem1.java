// Time Complexity : O(1) average time complexity
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>(); 
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);       
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            int size = in.size();
            for(int i=0;i < size;i++){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         if(out.isEmpty()){
            int size = in.size();
            for(int i=0;i < size ;i++){
                out.push(in.pop());
            }
        }
        return out.peek();    
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty())
            return true;
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

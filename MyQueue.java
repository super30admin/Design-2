// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class MyQueue {
    
    Stack<Integer> in ; //in stack for adding values
    Stack<Integer> out; // Out stack to keep the values
    int val;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x); //Push all the new elements to the in stack only 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop()); //Pop all the elements from in Stack to out stack and then we will have queue FIFO order in out stack 
            }
           
        }
         val =  out.peek();
            out.pop();
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop()); //Same as push
            }
    }    
        val =  out.peek();
        return val;
}
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
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
// Time Complexity : O(1) for all push, pop, peek, empty methods
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understood from class, but a little unsure about the space complexity

class MyQueue {
    
    private Stack<Integer> out;
    private Stack<Integer> in;

    /** Initialize your data structure here. */
    public MyQueue() {
        out = new Stack<>();
        in = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
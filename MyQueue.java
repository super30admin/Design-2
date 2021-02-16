class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> st1, st2;
    private int front;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        front = -1;
    }
    
    /** Push element x to the back of queue. */
    // Time Complexity: O(1)
    // Space Complexity: O(n)
    public void push(int x) {
        if(st1.isEmpty())
            front = x;
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int pop() {
        while(st1.size() > 1)
            st2.push(st1.pop());
        int result = st1.pop();
        
        front = st2.isEmpty() ? -1 : st2.peek();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    // Time Complexity: O(1)
    // Space Complexity: O(1)
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
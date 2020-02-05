class MyQueue {

    Stack<Integer> stack1, stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	// Push all elements in stack1 to stack2
        while(!stack1.isEmpty()) 
            stack2.push(stack1.pop());
        stack1.push(x);
        // Then, push back from stack2 to stack1
        while(!stack2.isEmpty()) 
            stack1.push(stack2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	// pop element
        return stack1.isEmpty()?-1:stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	// peek element
        return stack1.isEmpty()?-1:stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	// Check if stack is empty
        if(stack1.isEmpty())
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
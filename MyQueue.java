class MyQueue {
    
	private Stack<Integer> firstStack = new Stack<Integer>();
	private Stack<Integer> secondStack = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
        firstStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!firstStack.isEmpty()) {
    	    secondStack.push(firstStack.pop());
    	}
    	return secondStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while(!firstStack.isEmpty()) {
			secondStack.push(firstStack.pop());
		}
		return secondStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(firstStack.isEmpty() && secondStack.isEmpty()) {
    		return true;
    	}
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
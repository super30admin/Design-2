class MyQueue {

    /** Initialize your data structure here. */
    
    //Initialized Two Stack approach, temp is used to maintain top element for the queue
    Stack<Integer> stack;
    Stack<Integer> temp;
    
    // Integer front is used to keep track of current top element as per queue
    Integer front;
    public MyQueue() {
        stack = new Stack<Integer>();
        temp = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        //update front is stack is empty
        if(stack.empty()){
            front = x;
        }
        
        //transferring all elements of stack to temp to so that last element can be pushed to stack first
        while(!stack.empty()){
            temp.push(stack.pop());
        }
        
        //pushing last element to stack first
        stack.push(x);
        
        //updating stack back from the temp
        while(!temp.empty()){
            stack.push(temp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        //popped interger will be the current top element as per queue
        Integer popped = stack.pop();
        
        //If stack is not empty, then second element in queue becomes the top
        if(!stack.empty()){
            front = stack.peek();
        }
        return popped;
    }
    
    /** Get the front element. */
    public int peek() {
        
        //returning front, as it will be always top
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
       return stack.isEmpty();
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
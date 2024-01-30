class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();    
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        if (popStack.size() == 0) {
             while(pushStack.size() > 0) {
                int val = pushStack.pop();
                popStack.push(val);
             }
        }
        return(popStack.pop());
            
    }
    
    public int peek() {
        if (popStack.size() == 0) {
            while(pushStack.size() > 0) {
                int val = pushStack.pop();
                popStack.push(val);
            }
            return popStack.peek();
        } else {
            return popStack.peek();
        }    
    }
    
    public boolean empty() {
        if ((popStack.size() == 0) && (pushStack.size() == 0)) {
            return true;
        } else {
            return false;
        }        
        
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
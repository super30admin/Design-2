class MyQueue {
    Stack <Integer> inStack;
    Stack <Integer> outStack;
    public MyQueue() {
       this.inStack = new Stack<>();
       this.outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    public int peek() {
        if(!outStack.isEmpty())
            return outStack.peek();
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty())
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
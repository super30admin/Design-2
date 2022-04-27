class MyQueue {
    
    private Stack<Integer> first;
    private Stack<Integer> second;
    private int front;
    public MyQueue() {
        this.first = new Stack();
        this.second = new Stack();
    }
    
    public void push(int x) {
    if(first.isEmpty())
        front = x;    
    first.push(x);
    }
    
    public int pop() {
    if(second.isEmpty()){
        while(!first.isEmpty()){
            second.push(first.pop());
        }
    }
       return second.pop();
    }
    
    public int peek() {
       if(!second.isEmpty())
            return second.peek();
        
        return front;
    }
    
    public boolean empty() {
        return first.isEmpty() && second.isEmpty() ;
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

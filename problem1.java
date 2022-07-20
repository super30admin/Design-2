class MyQueue {
    
    private Stack<Integer> in;
    private Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(!out.empty())
            return out.pop();
        else if(!in.empty()){
            helper();
            return out.pop();
        }
        return -1;
    }
    
    public int peek() {
        if(!out.empty())
            return out.peek();
        else if(!in.empty()){
            helper();
            return out.peek();
        }
        return -1;
    }
    
    public void helper(){
        while(!in.empty()){
            int popped = in.pop();
            out.push(popped);
        }
    }
    
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

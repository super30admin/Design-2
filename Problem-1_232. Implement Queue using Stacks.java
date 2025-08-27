// used two stacks to make it look like one is entrance and other is exit.
// for pop(), pop it from out stack, if out stack is empty then push all from in stack to out stack  and then pop.




class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<Integer>();
        this.out = new Stack<Integer>();
    }
    
    public void push(int x) {    // O(1)
        in.push(x);
    }
    
    public int pop() {      \\ O(1)
            peek();
            return  out.pop(); 
    }
    
    public int peek() {        \\  O(1)
        if(!empty()){
            if(!out.isEmpty()){
                return out.peek();
            }
            while(!in.isEmpty()){
                out.push(in.pop());
            }    
        }
        return out.peek();
    }
    
    public boolean empty() {        // O(1)
        if(out.isEmpty() && in.isEmpty()){
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

import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<Integer>();
        this.out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int popped = in.pop();
                out.push(popped);
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()){
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
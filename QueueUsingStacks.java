class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        peek();
       return out.pop();
    }
    
    int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();        
    }
    
    boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
// We maintain 2 stacks. In stack and out stack. So that we can mimic a queue. We push any new element to the first stack. When we want to pop or peek any element, we basically have to check if the out stack is empty. If it is, we should copy all values from in to out so that we can pop in FIFO order. It is kind of reversing the order

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    
    // O(1)
    public void push(int x) {
        in.push(x);
    }
    
    // O(1) avg case, O(n) worst case
    public int pop() {
        if (out.isEmpty()) {
            copyFromInStackToOut();
        }
        return out.pop();
    }
    
    // O(1) avg case, O(n) worst case
    public int peek() {
        if (out.isEmpty()) {
            copyFromInStackToOut();
        }
        return out.peek();
    }
    
    // O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void copyFromInStackToOut() {
        while (!in.isEmpty()) {
            out.push(in.pop());
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
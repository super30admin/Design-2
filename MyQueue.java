class MyQueue {
    Stack<Integer> in;//stack1 for normal push
    Stack<Integer> out;//stack2 for pushing values from stack1 which results to queue DS

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
        
    }
    
    public int peek() {
        if(out.isEmpty()){//move values from stack1 to stack 2 when stack2 is empty
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();//check stack1 first for the best case
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


//Time Complexity: O(1)
//Space Complexity: O(N)

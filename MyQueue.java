class MyQueue {
    // Queue - FIFO , push = o(1) , pop = o(1) , peek = o(1) , empty = o(1)
    // Take 2 stack , push in 1st stack , for pop or peek transfer all to second stack & remove top or return top
    // for each pop or peek refeer to 2nd stack , if empty then do same remove from stack 1 & move to stack 2

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if( st2.isEmpty() ){
            while( !st1.isEmpty() ){
                st2.push( st1.pop() );
            }
        }
        return st2.pop();
    }

    public int peek() {
        if( st2.isEmpty() ){
            while( !st1.isEmpty() ){
                st2.push( st1.pop() );
            }
        }
        return st2.peek();
    }

    public boolean empty() {
        if( st1.isEmpty() && st2.isEmpty() ){
            return true;
        }
        else{
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
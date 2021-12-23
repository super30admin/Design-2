class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int x) {
        s1.push(x);

    }

    public int pop() {

        if(!s2.isEmpty()){
            return s2.pop();
        }

        reverseStack(s1,s2);
        return s2.pop();
    }

    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }

        reverseStack(s1,s2);
        return s2.peek();
    }

    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) return true;
        return false;
    }

    public void reverseStack(Stack s1, Stack s2){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
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
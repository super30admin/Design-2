class MyStack {
    Deque deque ;
    /** Initialize your data structure here. */
    public MyStack() {
        deque = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int num = (int) deque.removeLast();
        return num;
    }

    /** Get the top element. */
    public int top() {
        return (int)deque.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(deque.isEmpty()) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
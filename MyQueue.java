class MyQueue {
    // use two stacks one dedicated for push and other for pop

    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.isEmpty() ? -1 : popStack.pop();

    }

    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.isEmpty() ? -1 : popStack.peek();
    }

    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
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
class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> popStack;

    public MyQueue() {
        this.stack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (!popStack.isEmpty())
            return popStack.pop();
        while (!stack.isEmpty()) {
            popStack.push(stack.pop());
        }
        return popStack.pop();
    }

    public int peek() {
        if (!popStack.isEmpty())
            return popStack.peek();
        while (!stack.isEmpty()) {
            popStack.push(stack.pop());
        }
        return popStack.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && popStack.isEmpty();
    }
}

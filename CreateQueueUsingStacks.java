public class CreateQueueUsingStacks {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CreateQueueUsingStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int val) {
       this.inStack.push(val);
    }

    public int pop() {
       if(empty()) return -1;
        peek();
       return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        outStack.peek();
    }
    public boolean empty() {
       return inStack.isEmpty() && outStack.isEmpty();
    }
}

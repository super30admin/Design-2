import java.util.Stack;
/*
I use two stacks: an input stack for push operations and an output stack for pop/peek operations.
When output is empty, and we need to pop/peek, I move all elements from input to output which reverses the order and simulates FIFO.
Each element moves from input to output at most once, so operations are amortized O(1).
*/
class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue(){
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();

    }

    public int peek() {
        if(outStack.isEmpty())
        {
            while (!inStack.isEmpty())
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

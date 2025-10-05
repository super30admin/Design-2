import java.util.Stack;

/**
 * The strategy here is to using one inStack and outStack.
 * Push the data in to the inStack if outStack is empty. Time Complexity is o(1) for all operations amortized.
 */

public class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    void push(int x) {
        inStack.push(x);
    }

    int pop() {
        peek();
        return outStack.pop();
    }

    int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

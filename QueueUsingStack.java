import java.util.Stack;

/**
 * Approach:
 * Push everything to inStack
 * Pop / peek everything from outStack.
 * When outStack is empty, transfer all contents of inStack to outStack.
 *
 * TC: O(1) Averaged
 * SC: O(n) All elements are stored across two stacks
 *
 */
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;


    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            // Transfer everything from inStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            // Transfer everything from inStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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

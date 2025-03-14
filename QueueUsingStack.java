import java.util.Stack;

/**
 * Approach:
 * Use two stacks: `inStack` (for push operations) and `outStack` (for pop and peek operations).
 * When `pop()` or `peek()` is called:
 * - If `outStack` is empty, transfer all elements from `inStack` to `outStack` to maintain FIFO order.
 * - Otherwise, simply pop/peek from `outStack`.
 * This ensures an amortized time complexity of O(1) per operation, since each element is moved at most once.
 */

public class QueueUsingStack {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStack() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.isEmpty() ? -1 : outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());

            }
        }
        return outStack.isEmpty() ? -1 : outStack.peek();
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

/**
 * Amortized Time Complexity: O(1)
 * Space Complexity: O(N)
 */

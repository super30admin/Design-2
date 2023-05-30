// Time Complexity :  Push: O(1); Pop and Peek: O(N) for transferring elements from inStack to outStack (at most once) + O(1) for subsequent pop() or peek() operations; Empty : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class QueueUsingStack {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public QueueUsingStack() {
        this.inStack = new Stack();
        this.outStack = new Stack();
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
        return outStack.pop();

    }

    public int peek() { //
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() { // O(1)
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack obj = new QueueUsingStack();
        obj.push(1);
        obj.push(2);

        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());

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

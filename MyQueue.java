// Time Complexity : O(1) - both pop() and peek()
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }     return outStack.peek();

    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
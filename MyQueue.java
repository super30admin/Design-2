// Time Complexity : O(1)  // amortized
// Space Complexity : O(n) // For Second Stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Using Two stack to simulate queue inStack -> outStack
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
        moveElements();
        return outStack.pop();
    }

    public int peek() {
        moveElements();
        return outStack.peek();
    }

    /*
        Util function to move all the elements from inStack to outStack
     */
    private void moveElements() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty()) ? true : false;
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
// Time Complexity: O(1)
// Space Complexity: O(n)

// Approach: using 2 stacks one for storing values as we get in a stack
// The other used to transfer all values from input stack to output stack to reverse the order which will be used to pop() elements, so elements are popped like a queue. 
// Whenever outstack becomes empty, transfer new values from instack again.


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
        if (empty()) return -1;
        if (outStack.isEmpty()) {
            peek();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if (outStack.isEmpty()) {
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

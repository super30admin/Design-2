// Time Complexity: push() and empty() have O(1) complexity. pop() and peek() have amortised O(1) complexity.
// Space Complexity: O(n) where n is the total number of elements stored in the queue.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


import java.util.Stack;

// Implemented Queue using two stacks. Stack follows Last in First out (LIFO) whereas Queue follows First in First out (FIFO).
// First stack stores all the input elements that are pushed until the pop() or peek() method is invoked that require the ordering to be updated.
// Existing elements are copied over to the other stack and returned from there until it becomes empty while first stack stores any new values added.
class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> queueStack;
    private int count;

    public MyQueue() {
        inputStack = new Stack<>();
        queueStack = new Stack<>();
        count = 0;
    }
    
    public void push(int x) {
        inputStack.push(x);
        count++;
    }
    
    public int pop() {
        if (queueStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                queueStack.push(inputStack.pop());
            }
        }
        count--;
        return queueStack.pop();
    }
    
    public int peek() {
        if (queueStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                queueStack.push(inputStack.pop());
            }
        }
        return queueStack.peek();
    }
    
    public boolean empty() {
        return count == 0;
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
// Problem: Implement Queue using Stack
// Time Complexity: O(1) for push and O(n) for pop and peek in the worst case
// Space Complexity: O(n) for both stacks
// Approach: Use two stacks to implement a queue. The first stack is used for enqueue operations, and the second stack is used for dequeue operations. When dequeuing, if the second stack is empty, pop all elements from the first stack and push them onto the second stack. This reverses the order of elements, allowing for FIFO behavior.

import java.util.Stack;


public class QueueUsingStack {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public QueueUsingStack() {
        this.inSt = new Stack<>(); // inStack
        this.outSt = new Stack<>(); // outStack
    }
    
    public void push(int x) {
        inSt.push(x); // Push into inStack
    }
    
    public int pop() {
        if (empty()) return -1; // Return -1 if the queue is empty
        if (outSt.isEmpty()) { // Check whether outStack is empty
            while (!inSt.isEmpty()) { // Transfer elements from inStack to outStack
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop(); 
    }
    
    public int peek() {
        if (empty()) return -1; // Return -1 if the queue is empty
        if (outSt.isEmpty()) { // Check whether outStack is empty
            while (!inSt.isEmpty()) { // Transfer elements from inStack to outStack
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek(); 
    }
    
    public boolean empty() { // Check whether the queue is empty
        return inSt.isEmpty() && outSt.isEmpty(); 
    }
}

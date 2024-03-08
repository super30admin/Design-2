// Time Complexity :
//   - push(): O(1)
//   - pop(): Amortized O(1), Worst-case O(n) where n is the number of elements in the queue. This is because in the worst case, when the 'out' stack is empty, we need to transfer all elements from 'in' to 'out', which takes O(n) time.
//   - peek(): Amortized O(1), Worst-case O(n) where n is the number of elements in the queue. Similar to pop(), in the worst case, all elements need to be transferred from 'in' to 'out'.
//   - empty(): O(1)
// Space Complexity : O(n) where n is the number of elements in the queue. This is because we are using additional space for two stacks, 'in' and 'out', each of which can potentially hold all elements of the queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class ImplementQueueUsingStacks {
    private Stack<Integer> in; // Stack for input elements
    private Stack<Integer> out; // Stack for output elements

    public ImplementQueueUsingStacks() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    // Function to push an element into the queue
    public void push(int x) {
        in.push(x); // Push the element onto the input stack
    }
    
    // Function to remove and return the element at the front of the queue
    public int pop() {
        peek(); // Make sure out stack is up-to-date
        return out.pop(); // Pop and return the top element from the out stack
    }
    
    // Function to return the element at the front of the queue without removing it
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop()); // Transfer elements from input stack to output stack
            }
        }
        return out.peek(); // Return the top element from the out stack
    }
    
    // Function to check if the queue is empty
    public boolean empty() {
        return in.isEmpty() && out.isEmpty(); // Return true if both stacks are empty
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
// Time Complexity :
// push()     - O(1)
// pop()      - Amortized O(1), Worst-case O(n) when out stack is empty and all elements are transferred
// peek()     - Amortized O(1), Worst-case O(n) for the same reason as pop()
// empty()    - O(1)

// Space Complexity : O(n), where n is the total number of elements stored in both stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// Used two stacks: 'in' for pushing new elements and 'out' for popping/peeking in queue order.
// On pop or peek, if 'out' is empty, transfer all elements from 'in' to 'out' to reverse the order.
// This ensures front of the queue is always on top of 'out', simulating FIFO behavior using LIFO stacks.


class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        this.in.push(x); // Push element to the end of the queue
    }

    // Pop from output stack (after transferring if needed)
    public int pop() {
        peek(); // Ensures correct order by transferring from 'in' to 'out' if needed
        return out.pop();
    }

    // Return front element; transfer only if 'out' is empty
    public int peek() {
        if (this.out.isEmpty()) {
            while (!this.in.isEmpty()){
                this.out.push(in.pop());
            }
        }
        return out.peek();
    }

    // Queue is empty only if both stacks are empty
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
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
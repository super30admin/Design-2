// Time Complexity : 
//     push(x): O(1)
//     pop(): Amortized O(1)
//     peek(): Amortized O(1)
//     empty(): O(1)
//
// Space Complexity : O(n) — where n is the number of elements in the queue
//
// Did this code successfully run on Leetcode : Yes
//
// Any problem you faced while coding this : No
//   - Just needed to handle moving elements from one stack to another 
//     to reverse the order and simulate queue behavior using stacks.

import java.util.Stack;

class MyQueue {

    Stack<Integer> st;     // Input stack
    Stack<Integer> outSt;  // Output stack

    public MyQueue() {
        this.st = new Stack();
        this.outSt = new Stack();
    }

    // Push to the input stack (O(1))
    public void push(int x) {
        st.push(x);
    }

    // Pop from the output stack; if empty, dump all from input to output (Amortized O(1))
    public int pop() {
        if (empty()) {
            return -1;
        }
        peek(); // Ensure elements are moved to output stack
        return outSt.pop();
    }

    // Peek front element using output stack (Amortized O(1))
    public int peek() {
        if (outSt.isEmpty()) {
            while (!st.isEmpty()) {
                outSt.push(st.pop()); // Reverse the order
            }
        }
        return outSt.peek();
    }

    // Check if both stacks are empty
    public boolean empty() {
        return st.isEmpty() && outSt.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println("Is queue empty? " + queue.empty()); // true

        System.out.println("Pushing 1");
        queue.push(1);
        System.out.println("Pushing 2");
        queue.push(2);

        System.out.println("Peek: " + queue.peek()); // 1

        System.out.println("Popping: " + queue.pop()); // 1

        System.out.println("Peek: " + queue.peek()); // 2

        System.out.println("Is queue empty? " + queue.empty()); // false

        System.out.println("Popping: " + queue.pop()); // 2

        System.out.println("Is queue empty? " + queue.empty()); // true

        System.out.println("Trying to pop from empty queue: " + queue.pop()); // -1

        System.out.println("Trying to peek from empty queue:");
        try {
            System.out.println("Peek: " + queue.peek()); // should not throw error but logically invalid
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Mixed operations
        queue.push(10);
        queue.push(20);
        System.out.println("Peek: " + queue.peek()); // 10
        queue.push(30);
        System.out.println("Popping: " + queue.pop()); // 10
        System.out.println("Peek: " + queue.peek()); // 20
    }
}
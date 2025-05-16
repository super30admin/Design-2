/*
 * Implements a queue using two stacks (FIFO using LIFO).
 * 1. input: holds newly pushed elements.
 * 2. output: holds reversed elements for dequeueing.

 * - push(x): always push to input stack.
 * - pop(): if output is empty, transfer all input to output (reversing order), then pop from output.     
 * - peek(): same as pop, but returns top of output without removing it.
 * - empty(): returns true if both stacks are empty.
 */

// Time Complexity : O(1) - Amortized Time, O(n) - Worst Case Time	
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    //Stack for inputting elements
    private Stack<Integer> input;
    //Stack for popping elements from
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        //Pushing into input Queue
        input.push(x);
    }

    public int pop() {
        //Peeking it so that it gets element from input Stack to output Stack if it is empty
        peek();
        return output.pop();
    }

    public int peek() {
        //checking if output stack is empty so get elements from input stack
        if (output.isEmpty()) {
            //looping for all elements in Input Stack
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        //just using the inbuilt stack functions to check if both are empty
        return input.isEmpty() && output.isEmpty();
    }
}

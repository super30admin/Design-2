/* 
Time Complexity : O(1) for push; peek,pop: amortized O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
Two stacks (in and out). Push only in instack; whenever you have to
pop or peek; move all elements to out and pop/peek there. This ensures that
the first element added is on top of the outstack.
*/

import java.util.Stack;

class QueueUsingStack {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public QueueUsingStack() {
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            moveElementsToOutStack();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            moveElementsToOutStack();
        }
        return outStack.peek();
    }

    public void moveElementsToOutStack() {
        while (!inStack.isEmpty()) {
            int poppedNum = inStack.pop();
            outStack.push(poppedNum);
        }
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
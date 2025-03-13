// Time Complexity:
// push(): O(1)
// pop(): Average - O(1) but worst case O(N)
// peek(): Average - O(1) but worst case O(N)
// empty(): O(1)

// Space Complexity : N + N = 2 -> O(2N) -> O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Basically using two stacks would be optimal
// We would be pushing items in Instack until a pop operation happens for first time
// When pop operation happens: we would pop all the items from inStack to outStack
// Then every consecutive pop would be O(1)
// Peek operation would be same as pop

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void PushinStackToOutStack() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        PushinStackToOutStack();
        return outStack.pop();
    }

    public int peek() {
        PushinStackToOutStack();
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

}

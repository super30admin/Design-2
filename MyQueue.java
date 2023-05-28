// Time Complexity : Pop, Peek, Empty O(1) | Push O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MyQueue {
    public Stack<Integer> stackOne;
    public Stack<Integer> stackTwo;

    public MyQueue() {
        this.stackOne = new Stack<>();
        this.stackTwo = new Stack<>();
    }

    public void push(int x) {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        stackOne.push(x);
        while (!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }
    }

    public int pop() {
        if (!stackOne.isEmpty()) {
            return stackOne.pop();
        }
        return -1;
    }

    public int peek() {
        if (!stackOne.isEmpty()) {
            return stackOne.peek();
        }
        return -1;
    }

    public boolean empty() {
        return stackOne.isEmpty();
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
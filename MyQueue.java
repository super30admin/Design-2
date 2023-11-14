// Time Complexity : push():O(1), pop():O(n), peek():O(n), empty():O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
* We have 2 stacks here. We will always push a new element on the stack 1. When there is a pop operation, initially we will push
* all elements from stack 1 to stack 2 and pop the top most element from stack 2. Later, we will perform this transfer only when
* the stack 2 is empty. peek will also work in the same manner. Queue can be called empty when both the stacks are empty.
*/

import java.util.Stack;

class MyQueue {

    Stack<Integer> primary;
    Stack<Integer> secondary;

    public MyQueue() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }

    public void push(int x) {
        primary.push(x);
    }

    public int pop() {

        if(empty()) return -1;

        transfer();

        return secondary.pop();
    }

    public int peek() {

        if(empty()) return -1;

        transfer();

        return secondary.peek();
    }

    public boolean empty() {
        return primary.isEmpty() && secondary.isEmpty();
    }

    private void transfer() {

        if(secondary.isEmpty())
            while(!primary.isEmpty())
                secondary.push(primary.pop());
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
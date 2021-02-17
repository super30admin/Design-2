// Time Complexity :
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> helper;
    /** Initialize your data structure here. */
    //Constuctor
    public MyQueue() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    /** Push element x to the back of queue. */
    //Time Complexity: O(1)
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    //Time Complexity: O(n)
    public int pop() {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int val = helper.pop();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return val;
    }

    /** Get the front element. */
    //Time Complexity: O(n)
    public int peek() {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int top = helper.peek();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return top;
    }

    /** Returns whether the queue is empty. */
    //Time Complexity: O(1)
    public boolean empty() {
        return stack.isEmpty() && helper.isEmpty();
    }
}

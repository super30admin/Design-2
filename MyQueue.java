// Time Complexity: O(n).
// Space Complexity: O(n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> reverse;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        reverse = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(reverse.isEmpty()) {
            reverse.push(x);
        } else {
            while(!reverse.isEmpty()) {
                stack.push(reverse.pop());
            }
            reverse.push(x);
            while(!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return reverse.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return reverse.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return reverse.isEmpty();
    }
}
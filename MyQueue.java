// Time Complexity : Worst Case: O(n), Best Case: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class MyQueue {

    /** Initialize your data structure here. */

    Stack<Integer> from;
    Stack<Integer> to;
    private int first;

    public MyQueue() {
        from = new Stack<>();
        to = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(from.empty())
        {
            first = x;
        }
        from.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(to.isEmpty())
        {
            while(!from.isEmpty())
            {
                to.push(s1.pop());
            }
        }
        return to.pop();
    }

    /** Get the front element. */
    public int peek() {

        if(!to.isEmpty())
        {
            return to.peek();
        }
        return first;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return from.isEmpty() && to.isEmpty();
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

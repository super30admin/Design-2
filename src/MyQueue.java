// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        this.in.push(x);

    }

    public int pop() {
        peek();
        return this.out.pop();
    }

    public int peek() {
        if(this.out.empty()) {
            while (!this.in.empty()) {
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }

    public boolean empty() {
        return this.in.empty() && this.out.empty();
    }
}

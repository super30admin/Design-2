// Time Complexity :
//push() - O(1)
//pop() - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {

    private Stack<Integer> pushSt;
    private Stack<Integer> popSt;

    public MyQueue() {
        this.pushSt = new Stack<>();
        this.popSt = new Stack<>();
    }

    public void push(int x) {
        this.pushSt.push(x);
    }

    public int pop() {
        fillPopStack();
        return this.popSt.pop();
    }

    private void fillPopStack() {
        if(this.popSt.isEmpty()) {
            while(!this.pushSt.isEmpty()) {
                this.popSt.push(this.pushSt.pop());
            }
        }
    }

    public int peek() {
        fillPopStack();
        return this.popSt.peek();
    }

    public boolean empty() {
        return this.pushSt.isEmpty() && this.popSt.isEmpty();
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
// Time Complexity : push: O(1); pop: O(1)=average, O(N)= worst
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// push all the elements until push is happening.
// when pop is happening, if the out stack is empty, we need to pop in stack and push it to out stack

import java.util.Stack;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    //O(1)
    public void push(int x) {
        in.push(x);
    }
    // amortized O(1)
    public int pop() {
        peek();
        return out.pop();
    }
    // amortized O(1)
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        } 
        return out.peek();
    }
    // O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
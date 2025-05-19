// Time Complexity : O(1) push, Amortized O(1) pop & peek
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int temp = in.pop();
                out.push(temp);
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}


// Time Complexity : O(n) for worst case, but in average case it will be O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.Stack;


class MyQueue {
    //using two stacks to implement queue
 Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        //initializing the stacks
        in = new Stack<>();
        out =new Stack<>();
    }
    
    public void push(int x) {
        in.push(x); //push into the in stack
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        //if out Stack is empty then we have to push the elements from the in Stack.
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
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
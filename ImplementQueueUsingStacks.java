
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.Stack;
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty())
        {
            while(!inStack.isEmpty())
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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
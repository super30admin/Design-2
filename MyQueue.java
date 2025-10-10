// Time Complexity : O(1) Amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Stack;

class MyQueue {
    Stack<Integer> outStack;
    Stack<Integer> inStack;
    public MyQueue() {
        //Initialize InStack and OutStack
        outStack = new Stack<>();
        inStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        //if both stacks empty, return -1.
        if(outStack.empty()){
            if(inStack.empty()) return -1;
            //if outStack is empty, fill it. As stack-pop operation will be used to pop the outStack.
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        //if both stacks empty, return -1.
        if(outStack.empty()){
            if(inStack.empty()) return -1;
            //Similar logic as Pop
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        //If only both stacks are empty, return true.
        return inStack.empty() && outStack.empty();
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
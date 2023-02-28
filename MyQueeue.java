// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 Made use of two stacks. When one stack gets popped its details are stored in the second stack. 
 This allows all the contents to be stored in reverse order. 
 Empty checks if both the stacks are empty or not. 
 */
import java.util.Stack;
class MyQueue {
private Stack<Integer> inStack;
private Stack<Integer> outStack;
    MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    void push(int x) {
        inStack.push(x);
    }
    
    int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty())
        return true;
        else 
        return false;
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
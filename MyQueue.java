/*
 * Time Complexity : push - O(1), pop - amortized O(1), peek - amortized O(1)
 * Space Complexity :  O(n)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - We consider 2 stacks, where stack1 is our input stack and stack2 is our output stack. On every element push we push it in the input stack.
 * On pop, we check if the output stack is not empty. If not empty then we simple just pop from the output stack, else we transfer elements from input stack by popping and push them into output stack
 * thereby reversing the order of insertion and maintaining FIFO. Same logic as pop is followed for peek.
 */

//https://leetcode.com/problems/implement-queue-using-stacks/submissions/886218167/
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
    
    public int peek() {
        if(!stack2.empty()){
            return stack2.peek();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
    
    public boolean empty() {
        return stack1.empty()&&stack2.empty();
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
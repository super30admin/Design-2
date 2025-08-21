// Did this code successfully run on Leetcode : Yes
// SC: O(2 * n)
// TC: Amortized O(1) for all operations
// Solving using two stacks to implement a FIFO DS using LIFO DS
// push - always add to the input stack
// pop - if the output stack is empty move all the elements from input stack to output stack and pop one element, if the output stack is not empty pop the element out of out directly
// peek - similar to pop but dont remove the element
// empty - if both input and output stack are empty return true else return false
import java.util.*;

class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {   
        input.push(x);
    }
    
    public int pop() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty()) return true;
        return false;
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
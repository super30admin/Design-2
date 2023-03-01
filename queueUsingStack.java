// Time Complexity : O(1) (for push,) O(1) Amortized for pop
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :
import java.util.*;
class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;
    private int peeker;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        if(input.isEmpty()){
            peeker = x;
        }
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
            return peeker;
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
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


// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
import java.util.*;

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
         if (output.empty()) {
            while (!input.empty()) {
              output.push(input.peek());
              input.pop();
          }
        }
        int num = output.peek();
        output.pop();
        return num;
    }
    
    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }
}





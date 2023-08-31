// Time Complexity : O(n) [push- O(1) and pop - O(n)]
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/implement-queue-using-stacks/submissions/1036454229/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
 * Queue using Stacks: this implementation must follow FIFO
 * Use 2 stacks : inStack and outStack
 * Whenever you push, push the elements into inStack
 * Whenever you pop, traverse all the elements from inStack to outStack and pop the peek element, checking the Stack is not empty
 */
import java.util.*;
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
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
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
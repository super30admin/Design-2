import java.util.Stack;

// Time Complexity : Amortized O(1), worst case where we get push and pop operation alternatively thene we will have O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * We figured out that if we decide on pushing in one stack and 
 * for popping, push all the element in stack2, pop and then again push to stack1 costs pop to be O(n).
 * 
 * similarly if we decide on pushing all the element in stack1 then pop from stack2, it costs us to have O(n) for push
 * 
 * So we go with the approach where we only push in stack 2 if its empty, and call pop and peek from stack2.
 * 
 * so we have amortized O(1) time complexity.
 */
public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();  
    }
    
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
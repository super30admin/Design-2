import java.util.Stack;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/**
 * Using two stacks to implement a queue. 
 * Stack1 is used to push the elements. Stack2 is used when pop or peek 
 * are called.
 * for Push: check if the stack2 is not empty, that means there are some
 * elements that are pushed earlier into the stack1. So, move them back to
 * Stack1 and then push the new element.
 * for Pop: check if the stack2 is empty. If so, then stack1's 1st element
 * would be popped. So, move all elements of stack1 to stack2. Thus, the order 
 * will be reversed now. So, pop the stack2's top element.
 * for Peek: check if stack1 is not empty. if So, move those elements to stack2.
 * Thus, stack2's top element becomes peek.
 * for isEmpty: if both stacks are empty, then the queue is empty.
 *
 */
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
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
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

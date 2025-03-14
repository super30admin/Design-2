// Time Complexity : O(1) for push, O(n) for pop and peek in worst case and O(1) in average case
// Space Complexity : O(n) where n is number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*

 We take 2 stacks, 1 for push and another for pop and peek
 Push will happen on stack 1
 Since stack is LIFO and Queue is FIFO order, when we pop, we need the element at the bottom of the stack
 Hence we take second stack, where if a call comes in pop or peek, we transfer all elements to second stack
 Hence, the element on top of stack will be the correct element. We only transfer elements if stack2 is empty
 as transferring elements for every pop call is unnecessary because that does not change the outcome.
 */
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();


    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {

                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {

                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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
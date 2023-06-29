
// Time Complexity : Worst case time complexity is O(n) for push operation, O(1) for pop, peek and isEmpty operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



import java.util.*;

class MyQueue {

    // Here, stack2 would act as a facilitator stack

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /*

        For push method, the operations to be performed are:
        1) stack1 -> stack2
        2) x -> stack1
        3) stack2 -> stack1


    */

    public void push(int x) {

        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }

    // We always pop from stack1

    public int pop() {

        if(stack1.isEmpty())
        {
            return -1;
        }

        return stack1.pop();
    }

    // We always peek from stack1
    public int peek() {
        return stack1.peek();
    }

    // We always check whether stack1 is empty or not
    public boolean empty() {
        return stack1.isEmpty();
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
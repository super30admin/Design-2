import java.util.Stack;

// Time Complexity : pop() & peek() - O(n). push() & empty() - O(1).
// Space Complexity : no extra space used other than two stacks. O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    //Time complexity: O(1)
    //Space complexity: O(1)
    public void push(int x) {
        stack1.push(x);
    }
    
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int ans = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return ans;
    }
    
    //Time complexity : O(n)
    //Space complexity: O(1)
    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int ans = stack2.peek();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return ans;
    }
    
    //Time complexity: O(1)
    //Space complexity: O(1)
    public boolean empty() {
        return stack1.isEmpty();
    }
}
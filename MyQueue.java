// Time Complexity : O(1)
// Space Complexity : O(1), O(n) -> only once when we pop elements from stack 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {

    // create 2 stacks -> 1 stack for inserting all the new elements to the end, 2nd
    // stack to remove the 1st element.
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // initialise in the cosntructor
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // push all the elements to stack 1
    public void push(int x) {
        stack1.push(x);
    }

    // check if there stack2 is empty or not, if empty then, insert all the elements
    // from stack 1 to stack 2. and then pop the top element from stack 2.
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // check if there stack2 is empty or not, if empty then, insert all the elements
    // from stack 1 to stack 2. and then peek the top element from stack 2.
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // check if both the stack is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
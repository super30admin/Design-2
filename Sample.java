/**
 * Implementing Queue using 2 stack.
 * When pushing value
 *      a) If stack is empty push the value to the stack.
 *      b) If Stack is not empty
 *          i) Pop all the values to temp stack
 *          ii) Push the current value
 *          iii) Push all the values from temp stack back to the stack.
 * Push Time Complexity : O(n)
 * Pop Time Complexity : O(1)
 */

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    public MyQueue() {
    }

    // Time Complexity : O(n)
    public void push(int x) {
        if(stack.isEmpty()) stack.push(x);
        else {
            while (!stack.isEmpty()){
                tempStack.push(stack.pop());
            }
            stack.push(x);
            while (!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
        }
    }

    // Time Complexity : O(1)
    public int pop() {
        return stack.pop();
    }

    // Time Complexity : O(1)
    public int peek() {
        // Placeholder return value
        return stack.peek();
    }

    public boolean empty() {
        // Placeholder return value
        return stack.isEmpty();
    }
}
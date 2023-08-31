// Time Complexity : O(N)[WORST CASE] - O(1) for pushing the element in stack but O(N) for transferring the element
// between stacks pushStack and popStack for pop and peek operation
// Space Complexity : O(N) - 2 stacks required pushStack and popStack in this example
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * OUTPUT:
 * 1
 * 1
 * 1
 * false
 * 2
 * 3
 * 4
 * 5
 * true
 */

// Your code here along with comments explaining your approach


import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    //constructor
    public ImplementQueueUsingStack() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    //push
    public void push(int val) {
        pushStack.push(val);
    }

    //pop
    public int pop() {
        peek();
        return popStack.pop();
    }

    //peek
    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    //Check if Queue is Empty()
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }


    public static void main(String[] args) {
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.peek();
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}

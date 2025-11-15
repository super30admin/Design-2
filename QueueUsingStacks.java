// ## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : Avg ~ O(1) Worst ~ O(100) since the problem mentions atmost 100 calls will be made
// Space Complexity : O(2n) ~ O(n) for 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Took two stacks similar to what was explained in the class.
 * When pop and peek operation is triggered and outStack is Empty, start transferring elements from inStack
 * Always return pop and peek from outStack and push in inStack 
 */

import java.util.*;

public class QueueUsingStacks {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        transferElementsFromStack();
        return outStack.pop();
    }
    
    public int peek() {
        transferElementsFromStack();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void transferElementsFromStack() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks myQueue = new QueueUsingStacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());// return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
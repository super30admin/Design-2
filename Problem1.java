// Time Complexity : Push, peek, empty -> O(1), pop -> O(1) ammortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to go through solutions to understand the approach


// Your code here along with comments explaining your approach


import java.util.*;

class MyQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> auxStack;
    private int front;

    public MyQueue() {
        mainStack = new Stack<Integer>();
        auxStack = new Stack<Integer>();
    }

    public void push(int x) {
        if( mainStack.isEmpty() ) {
            front = x;
        }
        mainStack.push(x);
    }

    public int pop() {
        if( auxStack.isEmpty() ) {
            while( !mainStack.isEmpty() ) {
                auxStack.push(mainStack.pop());
            }
        }
        return auxStack.pop();
    }

    public int peek() {
        if( auxStack.isEmpty() ) {
            return front;
        } else {
            return auxStack.peek();
        }
    }

    public boolean empty() {
        return mainStack.isEmpty() && auxStack.isEmpty();
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
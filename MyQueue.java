package com.company;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack = new Stack<>();
    public MyQueue() {
        int pointer = 0;
        int pointerIndex = -1;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    public int reverse(int x){
        Stack<Integer> temp = new Stack<>();
        if(x == 0){
            while(stack.empty() == false){
                temp.push(stack.pop());
            }
            int topValue = temp.peek();
            while(temp.empty() == false){
                stack.push(temp.pop());
            }
            return topValue;
        }

        if(x == -1){
            while(stack.empty() == false){
                temp.push(stack.pop());
            }
            int topValue = temp.pop();
            while(temp.empty() == false){
                stack.push(temp.pop());
            }
            return topValue;
        }
        return -1;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return reverse(-1);
    }

    /** Get the front element. */
    public int peek() {
        return reverse(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.empty()){
            return true;
        }
        return false;
    }
}

/*
    Time Complexity = Push and Empty methods are O(1) while Pop and Peek methods are O(N) worst case (avg O(1))
    Space Complexity = O(N) as size of Stack is unknown
    Did this code successfully run on Leetcode : yes
 */


package com.madhurima;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }

        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.empty());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}

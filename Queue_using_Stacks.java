// Time Complexity : O(1) for push(), pop(), peek() and empty(). It could be O(n) in worst case for pop(), peek().
// Space Complexity : O(n) for no of elements stored in queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// I used two stacks to create a queue: one called inStack for adding (push) and another called outStack for removing or peeking.
// When we want to pop or peek, and outStack is empty, we move all elements from inStack into outStack.
// This reverses the order so that the first element added ends up on top and can be popped like in a real queue.
// We only move elements from inStack to outStack when outStack is empty, which makes most operations fast.
// This is a classic way to build a queue using two stacks.


import java.util.*;

class Queue_using_Stacks{
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public Queue_using_Stacks(){
        inStack = new Stack<>();
        outStack = new Stack<>();

    }

    public void push(int x){
        this.inStack.push(x);

    }

    public int pop(){
        peek();
        return this.outStack.pop();

    }

    public int peek(){
        if(this.outStack.isEmpty()){
            while(!this.inStack.isEmpty()){
                this.outStack.push(this.inStack.pop());
            }
        }

        return this.outStack.peek();

    }

    public boolean empty(){
        return this.inStack.isEmpty() && this.outStack.isEmpty();

    }

    public static void main(String[]args){
        Queue_using_Stacks q = new Queue_using_Stacks();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());  
        System.out.println(q.peek()); 
        System.out.println(q.pop());  
        System.out.println(q.empty()); 
        System.out.println(q.pop());  
        System.out.println(q.empty()); 


    }


}
// Time Complexity : push--> O(1), pop-> O(1), peek O(1), empty--> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

import java.util.Stack;



class MyQueue {
// Created "in" stack for push operations and "out" stack for pop or peek operations
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {

        this.in = new Stack<>();
        this.out = new Stack<>();
        }
   // push method just pushes the value into "in" stack 
    public void push(int x) {
      this.in.push(x);
    }

    // check if the out stack is empty, if empty pop all the elements in the "in" stack and push them into "Out" stack and return pop from "out" stack
    public int pop() {
       if(out.isEmpty()){
        while(!in.isEmpty()){
             out.push(in.pop());
        }
       }

            return out.pop();
        }
    // check if the out stack is empty, if empty pop all the elements in the "in" stack and push them into "Out" stack and return peek from "out" stack
    public int peek() {

        if(out.isEmpty()){

            while(!in.isEmpty()){
             out.push(in.pop());

            }

            }

            return out.peek();
        
    }

    //the queue is empty if both "in" stack and "out"stack is empty.
    
    public boolean empty() {

    return in.isEmpty() && out.isEmpty() ;
        
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

/*
Given
1. use only 2 stacks
2. push, pop, peek, empty
3. empty, true if the queue is empty, false if not empty
4. use standard operations of stack 
5. x is between 1 and 9
6. all calls to pop and peek are valid
*/ 

// Time Complexity : Average case O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this :
We're not checking if both inStack and outStack are empty
Exception in thread "main" java.util.EmptyStackException
        at java.base/java.util.Stack.peek(Stack.java:103)
        at MyQueue.peek(MyQueue.java:51)
        at MyQueue.main(MyQueue.java:73)

*/
// Your code here along with comments explaining your approach


import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
            }
        } 
        return outStack.peek();
    }

    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
    public static void main(String[] args){
        MyQueue obj = new MyQueue();
        obj.push(9);
        int param_2 = obj.pop();
       // obj.push(9);
        int param_3 = obj.peek();
      //  System.out.println("Param_3 " + param_3);
        boolean param_4 = obj.empty();
    }
}
// Time Complexity : (n)^2
// Space Complexity : n
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : solution looks working theoretically have to learn to code and debug without debugger


// Your code here along with comments explaining your approach
Problem1

class MyQueue {

    /** Initialize your data structure here. */
    public Stack<Integer> stack1,stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(empty()){
            stack1.push(x);
        }else if(stack1.size() == 0 && stack2.size() != 0) {
            loan();
            stack1.push(x);
        }else {
            stack1.push(x);
        }
    }

    public void loan(){
        if(stack1.size() == 0 && stack2.size() !=0) {
            for(int i = 0 ; i < stack2.size() ; i++ ){
                stack1.push(stack2.pop());
            }
        }else if(stack1.size() !=0 && stack2.size() == 0) {
            for(int i = 0 ; i < stack1.size() ; i++ ){
                stack2.push(stack1.pop());
            }
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()){
            return -1;
        }else if(stack2.size() == 0 && stack1.size() != 0) {
            loan();
            return stack2.pop();
        }else {
            return stack2.pop();
        }

    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            return -1;
        }else if(stack2.size() == 0 && stack1.size() != 0) {
            loan();
            return stack2.peek();
        }else {
            return stack2.peek();
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.size() == 0 && stack2.size() == 0) {
            return true;
        }else {
            return false;
        }

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
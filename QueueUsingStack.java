// Time Complexity :
// * Time complexity is O(1) for the push,empty functions
// * Time complexity is O(n) for the popshift, pop and peek functions as we may need to opo the pushStack and transfer it.

// Space Complexity : O(n) for stacks during the initialization
// All other functions have complexity O(1) as no new relevant variable is declared


// Did this code successfully run on Leetcode : Ran succesfully on Leetcode
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        this.pushStack = new Stack<Integer>();
        this.popStack = new Stack<Integer>();

    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(popStack.empty()){
            popShift();
        }

        return popStack.pop();
    }

    public int peek() {

        // Check for empty queue
        if(popStack.empty()){
            popShift();
        }

        return popStack.peek();
        // popStack.peek();
    }

    public boolean empty() {
        if(popStack.empty() && pushStack.empty()){
            return true;
        }

        return false;
    }

    public void popShift(){
        if(popStack.empty()){
            while(!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
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
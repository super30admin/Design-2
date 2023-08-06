// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Used two stacks in and out . Added the elements to in stack for push.
// In case of peek operation - checked if the outStack isEmpty then check if inStack is not empty
//then push it on outStack the elements which are popped from Instack
//Return the Outstack peek element
//in case of Pop operation - we do the same thing as peek and return the outStack.pop
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;


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
            //push elements from inStack to outStack
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }    
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty()&& outStack.isEmpty();
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
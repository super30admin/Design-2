// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {
 private  Stack<Integer> inStack;
        private Stack<Integer> outStack;
    public MyQueue() {
       this.inStack=new Stack<Integer>();
       this.outStack=new Stack<Integer>();
    }
    
    public void push(int x) {
    inStack.push(x); // push the elements into the first Stack 
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop()); //Queue follows first in first out .So we should always pop the first stored element in instack. So we have to push to second task to get the first In element.
            }
        }

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
}


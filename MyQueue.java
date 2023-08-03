// Time Complexity : Average Case = O(1) , Worst Case = O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Maintain two stacks one for pushing value(instack) and other for popping values(outstack). 
Copy values by popping values from inStack and pushing to outStack and pop from outStack
*/
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            copy();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            copy();
        }
        return outStack.peek();
    }

    public void copy(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
    
    public boolean empty() {
        if(outStack.isEmpty()){
            copy();
        }
        return outStack.isEmpty();
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

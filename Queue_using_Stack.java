/*
 * Approach: i am using two stack for specified operations. 
 * Stack1 for Push operations and Stack2 for all the pop operations. 
 * each time i need to push a element i will do it in stack1. 
 * whereas, when i need to pop any element then i will do it from Stack2 
 * and if its empty then transfer all the elements from Stack1 into Stack2 and then perform pop().
 * T.C: Amortized O(1) for all operations.
 * S.C: O(n) n: no. of elements in the stacks. 
*/


import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
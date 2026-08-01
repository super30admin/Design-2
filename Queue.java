//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

class MyQueue {
        Stack<Integer> inStack ;
          Stack<Integer> outStack;


    public MyQueue() {

    inStack = new Stack<Integer>();
      outStack = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
         if (outStack.isEmpty()) {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    if (outStack.isEmpty()) {
        return -1;   // queue is empty
    }

    return outStack.pop();
        
    }
    
    public int peek() {
      if (outStack.isEmpty()) {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    if (outStack.isEmpty()) {
        return -1;   // queue is empty
    }

    return outStack.peek();
        
    }
    
    public boolean empty() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            return true;
        }
        return false;
        
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
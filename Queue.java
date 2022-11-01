import java.util.*;

/**
push - time complexity - O(1), space complexity - O(n)
pop - Average - O(1) , worst case - O(n), space complexity - O(n)
peek - Average - O(1) , worst case - O(n), space complexity - O(n)

**/

class MyQueue {
    
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    

    public MyQueue() {
         inStack = new Stack<Integer>();
         outStack = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        inStack.push(x);
        
    }
    
    public int pop() {
        int result = 0;
        peek();
        result = outStack.pop();
        return result;
        
    }
    
    public int peek() {
       int result = 0;
       if(outStack.size() == 0) {
            while(inStack.size() > 0) {
                outStack.push(inStack.pop());
            }
        }
        result = outStack.peek();
        return result;
               
    }
    
    public boolean empty() {
        if(inStack.size() == 0 && outStack.size() == 0) 
            return true;
        else 
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
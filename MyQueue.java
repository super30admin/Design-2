// Time Complexity :O(n) (O(1) amortized)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


class MyQueue {
    Stack<Integer> InStack; 
    Stack<Integer> OutStack;

    public MyQueue() {
        
        InStack = new Stack<>();
        OutStack = new Stack<>();
        
    }
    
    public void push(int x) {
        InStack.push(x);
        
    }
    
    public int pop() {
        if(empty())
        {
            return -1;
        }        
        if(OutStack.isEmpty()){
            while(!InStack.isEmpty()){
                OutStack.push(InStack.pop());
            }
            
          
            
        }
         return OutStack.pop();
        
        
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        
      if(OutStack.isEmpty()){
            while(!InStack.isEmpty()){
                OutStack.push(InStack.pop());
            }
        
          
        
    }
        return OutStack.peek();
        
      
    }
        
    public boolean empty() {
        
        return (InStack.isEmpty() && OutStack.isEmpty());
        
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
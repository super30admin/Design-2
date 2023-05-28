// Time Complexity :
//                   push,empty O(1)
//                   pop and peek amortized O(1)  
// Space Complexity :
//                   push,empty, pop and peek  O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// used 2 stacks one to store incoming elements. we push the elements to the in stack until we get a peek or pop . In peek and pop, if the out
// stack is empty then we copy all the elements from the instack to the out stack and get the peek or pop from the out stack. 
// to find out if the queue is empty both the stacks should be empty.



import java.util.Stack;

class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek(); 
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();    
    }
    
    public boolean empty() {
         return in.isEmpty() && out.isEmpty();
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
//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : O(N) [ Amortized O(1)]
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
//approach: We maintain two stacks in and out. All the push are made in in stack, whenever a pop or peek the results are retrieved from "out" stack. If the "out" stack is empty all the elements from "in" are moved to "out" this inverts the stack and makes the top element to be peeked or popped from out.


class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
        
    }

    
    
    public void push(int x) {
        in.push(x);
        
    }
    
    public int pop() {
        peek();
        return out.pop();
        
    }
    
    public int peek() {
        if(out.isEmpty() )
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
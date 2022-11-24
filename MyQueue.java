// Time Complexity : O(1) for push() and empty(). Amortized O(1) for pop() and peek()
// Space Complexity : O(n) because we are using 2 stacks for storing all the numbers of the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
        if(out.isEmpty()){
           while(!in.isEmpty()){
                out.push(in.pop());
            } 
        }  
        return out.peek();
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
    }
}

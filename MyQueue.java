// Time Complexity: O(N) (Amortized: O(1))
// Space complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    Stack<Integer> in;      
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    // Time complexity: O(1)
    public void push(int x) {
        in.push(x);
    }
    
    // Time complexity: O(N) (Amortized: O(1))
    public int pop() {
        peek();
        return out.pop();
    }
    
    // Time complexity: O(N) (Amortized: O(1))
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {   
                out.push(in.pop());    
            }
        }
        return out.peek();
    }
    
    // Time complexity: O(1)
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
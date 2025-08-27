// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No problems faced

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out= new Stack<>();
        
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
        return in.isEmpty() && out.isEmpty();
    }
}
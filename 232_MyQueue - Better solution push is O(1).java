// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//we create 2 stacks one for push and other for pop operation
//while pushing we just push
//while popping we check if out is empty if it is we transfer everything to pop(which happens ib reversw way) and then pop it. and same for peek

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out= new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
          if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
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
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
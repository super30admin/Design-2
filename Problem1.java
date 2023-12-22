// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class MyQueue {
    
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
         this.in = new Stack<>();
         this.out = new Stack<>();
    }
    
    public void push(int x) {
        this.in.push(x);
    }
    
    public int pop() {
       peek();
       return out.pop();
    }
    
    public int peek() {
        //check if out stack is empty
        if(out.isEmpty()) 
        {
            while(!in.isEmpty())  //check in stack is empty or not 
            {
               this.out.push(in.pop());  //then push the element in out stack
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
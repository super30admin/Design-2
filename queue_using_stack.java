// Time Complexity :o(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: took 2 stacks 1st as in stack and the second as out stack(queue) the elements are first stored in in stack and them poped to the out stack them becomes the queue.






class MyQueue {
    private Stack<Integer> inst;
    private Stack<Integer> outst;  


    public MyQueue() {
      inst= new Stack<>();
      outst= new Stack<>();
        
    }
    
    public void push(int x) {
        inst.push(x);

        
    }
    
    public int pop() {
        peek();
         return  outst.pop();
        
    }
    
    public int peek() {
        if (outst.isEmpty()) {
            while (!inst.isEmpty()) {
                outst.push(inst.pop());
            }
        }
        return outst.isEmpty() ? -1 : outst.peek();
    }
    public boolean empty() {
        if (outst.isEmpty()) {
            while (!inst.isEmpty()) {
                outst.push(inst.pop());
            }
        }
        return outst.isEmpty();
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
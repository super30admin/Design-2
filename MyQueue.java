// Time Complexity :0(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//Queue using 2 stacks
class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
        
    }
    
    public void push(int x) {
        inSt.push(x);
    }
    
    public int pop() {
        if(empty()) return -1;
        if(outSt.isEmpty()) {
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();  
    }
    
    public int peek() {
        if(outSt.isEmpty()) {
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
        
    }
    
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }
}
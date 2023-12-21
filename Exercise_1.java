// Time Complexity :Push operation: O(1), Pop, Peek, Empty operations: O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// two stack used input and output stack to form FIFO 

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
        if (outSt.isEmpty()) {
            while(!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
    }
    
    public int peek() {
        if (outSt.isEmpty()) {
            while(!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }
    
    public boolean empty() {
        return outSt.isEmpty() && inSt.isEmpty();
    }
}

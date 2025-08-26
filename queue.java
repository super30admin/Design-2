// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this : None

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
        if(empty()) {
            return -1;
        }
        peek();
        return outSt.pop();
    }

    public int peek() {
        if(outSt.isEmpty()){
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
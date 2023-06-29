// Time Complexity : O(1) as only once in a while we 
// shift elements from stk1 to stk2. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class MyQueue {

    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public MyQueue() {
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {

        if(stk2.isEmpty()) {
            while(!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        if(!stk2.isEmpty()) {
            return stk2.pop();
        }

        return -1;
    }
    
    public int peek() {

        if(stk2.isEmpty()) {
            while(!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        if(!stk2.isEmpty()) {
            return stk2.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        if(stk2.isEmpty() && stk1.isEmpty()) {
            return true;
        }
        return false;
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

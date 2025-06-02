// Time Complexity : O(1) for push and empty, O(n) for pop and peek
// Space Complexity : O(n) for pop and peek, O(1) for rest
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> stack1;
    public MyQueue() {
        stack1 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        Stack<Integer> st = new Stack<>();
        while(!stack1.isEmpty()){
            st.push(stack1.pop());
        }
        int result = st.pop();
        while(!st.isEmpty()){
            stack1.push(st.pop());
        }
        return result;
    }
    
    public int peek() {
        Stack<Integer> st = new Stack<>();
        while(!stack1.isEmpty()){
            st.push(stack1.pop());
        }
        int result = st.peek();
        while(!st.isEmpty()){
            stack1.push(st.pop());
        }
        return result;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
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

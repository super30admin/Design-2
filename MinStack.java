
// Time Complexity : O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.Stack;

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        minSt.push(min);

    }

    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minSt.push(min);
    }

    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
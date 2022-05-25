/*
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
*/

class MinStack {
    private Stack<Integer> st;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
        
    }
    
    public void push(int val) {
       if(min >= val){
           st.push(min);
           min = val;
       }
        st.push(val);
    }
    
    public void pop() {
      if(st.pop() == min){
          min = st.pop();
      }
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

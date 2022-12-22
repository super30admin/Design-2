import java.util.Stack;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
Stack<Integer> st1;
Stack<Integer> st2;
private int front;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        front = 0;
    }
    
    public void push(int x) {
        if(st1.isEmpty())
        front =x;
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }
        }
        return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty())
        return front;
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}


import java.util.Stack;

//Time Complexity :O(1)
//Space Complexity :O(n)
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :

class MyQueue {
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st2.push(x);
    }
    
    public int pop() {
        if(st1.isEmpty()){
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
        return st1.pop();
    }
    
    public int peek() {
        if(st1.isEmpty()){
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
       return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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
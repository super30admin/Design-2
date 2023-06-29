// TC - O(1)
// SC - O(n)

import java.util.Stack;

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    int peek;
    public MyQueue() {
        st1 = new Stack<>(); 
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        if(st1.isEmpty())
            peek = x;
        st1.push(x);
        // st2 = new Stack<>();
    }
    
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    public int peek() {
        if(!st2.isEmpty())
            return st2.peek();
        return peek;
    }
    
    public boolean empty() {
        return st2.isEmpty() && st1.isEmpty();
    }
}
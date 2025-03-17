package s30;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> inStk;
    Stack<Integer> outStk;

    public void push(int n) {
        inStk.push(n);
    }

    public int pop() {
        if(outStk.isEmpty()) {
            while(!inStk.isEmpty()) {
                outStk.push(inStk.pop());
            }
        }
        return outStk.pop();
    }

    public boolean empty(){
        return inStk.isEmpty() && outStk.isEmpty();
    }
}

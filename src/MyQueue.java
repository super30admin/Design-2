import java.util.Stack;
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if( out.isEmpty()){
            while ( !in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.peek();
    }

    public boolean empty() {
        if ( in.isEmpty() && out.isEmpty()){
            return true;
        }

        return false;
    }
}

// Time Complexity : 
//                  empty() - O(1)
//                  push - O(1)
//                  pop - O(1) - average case.
//                  peek - O(1) - average case.
// Space Complexity : O(n)
import java.util.Stack;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.add(x);
    }
    
    public int pop() {
        peek();
        return !out.isEmpty() ? out.pop() : -1;
    }

    
    public int peek() {
        if (!out.isEmpty()) {
            return out.peek();
        }
        while (!in.isEmpty()) {
            out.add(in.pop());
        }

        return !out.isEmpty() ? out.peek() : -1;
    }
    
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
//Implement Queue using Stacks
//Time Complexity: O(1) for push, O(n) for pop and peek in worst case, O(1) for pop and peek Amortized
//Space Complexity: O(n)

import java.util.Stack;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(empty()) return -1;
        peek();
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

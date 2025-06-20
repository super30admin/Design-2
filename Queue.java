//Time Complexity - O(1)
//Space Complexity - O(n) each element is stored once in either stack.

// Implemented Queue using the 2 stacks. pushing the elements to in stack
// during pop and peek at first if out stack is empty pushing the elements from in stack to out stack and then pop
// For empty we check if both stacks are empty.

import java.util.Stack;

public class Queue {
    Stack<Integer> in;
    Stack<Integer> out;

    public Queue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        this.in.push(x);
    }

    public int pop() {
        peek();
        return this.out.pop();
    }

    public int peek() {
        if(this.out.isEmpty()) {
            while(!this.in.isEmpty()) {
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }

    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
    }
}

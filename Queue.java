// Time Complexity : Amortized O (1)
// Space Complexity : O(n) as we make use of extra stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Used to stacks in and out
// in stack is used for pushing 
// out stack is used for poppinh
// if out is empty we pop elements from the in and push them to out stack.

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }

    public void push(int x) {
        in.push(x);

    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());

            }

        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());

            }

        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
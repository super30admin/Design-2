// Time Complexity :Push operation: O(1), Pop, Peek, Empty operations: O(1) amortized
// Space Complexity : O(n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// two stacks are used input and output where input stack is used to push elements and output stack is used
// for popping and peeking elements
import java.util.Stack;

class Problem1 {
    Stack< Integer > input = new Stack < > ();
    Stack < Integer > output = new Stack < > ();
    public Problem1() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        int x = output.peek();
        output.pop();
        return x;
    }

    public int peek() {
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }

    public boolean empty() {
        return (output.size() + input.size()) == 0;
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
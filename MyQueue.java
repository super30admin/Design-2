// Time Complexity : Time complexity for push and empty is O(1), amortized time complexity for pop is O(1) and amortized time complexity for pop and peek is O(1)
// Space Complexity : Space complexity would be O(n) as two stacks are used to store the data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// # Design-2

// Explain your approach in **three sentences only** at top of your code
// Using two stacks to implement queue where one stack acts as the tail of the queue while other stack acts as the head of the queue.
// During first pop or peek, all the elements in the first stack are moved in the second stack where the first element would be on the top
// For pop or peek that first element can be used and the remaining elements stay in the second stack acting as head of queue while if
// push is performed then it can be added to the first stack and those elements can be moved to second stack when second stack is empty

import java.util.Stack;

class MyQueue {
    Stack<Integer> pushStk;
    Stack<Integer> popStk;

    public MyQueue() {
        this.pushStk = new Stack<>();
        this.popStk = new Stack<>();
    }

    public void push(int x) {
        this.pushStk.push(x);
    }

    public int pop() {
        this.peek();
        return this.popStk.pop();
    }

    public int peek() {
        if (this.popStk.empty()) {
            while (!this.pushStk.empty())
                this.popStk.push(this.pushStk.pop());
        }

        return this.popStk.peek();
    }

    public boolean empty() {
        return this.popStk.empty() && this.pushStk.empty();
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
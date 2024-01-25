
// Time Complexity :
// push() : O(N)
// pop() : O(1)
// peek() : O(1)
// empty() : O(1)

// Space Complexity :
// push() : 
// pop() : O(1)
// peek() :O(1)
// empty : O(1)

// Constraints:
// 1 <= x <= 9
// At most 100 calls will be made to push, pop, peek, and empty.
// All the calls to pop and peek are valid.

import java.util.Stack;

public class QueueUsingStackPushHeavy {
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            inStack.push(x);
            while (!outStack.isEmpty()) {
                inStack.push(outStack.pop());
            }
        }

        public int pop() {
            return inStack.pop();
        }

        public int peek() {
            return inStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty();
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
}

// Time Complexity : push: O(1), pop: O(n) in worst case, O(1) in amortized, peek: O(n), O(1) in amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Description:
// - Uses two stacks:
//      - stack1 stores newly added elements
//      - stack2 serves elements in FIFO order
//  - Elements are transferred from stack1 to stack2 only when stack2 is empty, which makes pop and peek amortized O(1).

class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        peek();

        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
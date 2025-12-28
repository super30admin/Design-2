
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// The MyQueue class implements a queue using two stacks. The inStack is used for enqueue operations, 
// while the outStack is used for dequeue and peek operations. When the outStack is empty, 
// elements are transferred from inStack to outStack to maintain the queue order.

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Time Complexity: Amortized O(1), Worst case O(n)
     * Space Complexity: O(1)
     */
    public int pop() {
        peek();
        return outStack.pop();
    }

    /**
     * Time Complexity: Amortized O(1), Worst case O(n)
     * Space Complexity: O(1)
     */
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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
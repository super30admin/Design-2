// Time Complexity :
// push(x)  -> O(1)
// pop()    -> Amortized O(1)
// peek()   -> Amortized O(1)
// empty()  -> O(1)
//
// Space Complexity :
// O(N) where N is number of elements stored in the queue
//
// Did this code successfully run on Leetcode :
// Yes
//
// Any problem you faced while coding this :
// No major issues. The only thing to be careful about is moving elements
// from one stack to another only when needed, otherwise operations become slow.


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {

    // This stack is used for push operation
    private Stack<Integer> inst;

    // This stack is used for pop and peek operations
    private Stack<Integer> outst;

    public MyQueue() {
        this.inst = new Stack<>();
        this.outst = new Stack<>();
    }
    
    public void push(int x) {
        // Always push element into input stack
        inst.push(x);
    }
    
    public int pop() {
        // If output stack is empty, move all elements from input stack to output stack
        if (outst.isEmpty()) {
            while (!inst.isEmpty()) {
                outst.push(inst.pop());
            }
        }
        // Now top of outst is the front of the queue
        return outst.pop();
    }
    
    public int peek() {
        // If output stack is empty, move elements first
        if (outst.isEmpty()) {
            while (!inst.isEmpty()) {
                outst.push(inst.pop());
            }
        }
        // Return the front element
        return outst.peek();
    }
    
    public boolean empty() {
        // Queue is empty only if both stacks are empty
        return inst.isEmpty() && outst.isEmpty();
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

import java.util.Stack;

// ## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : Amortized time complexity O(1) since 
// each element is moved at most once from in to out across the entire sequence of operations.
// Worst case time complexity - O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Summarized approach:
// in: holds the newest elements (in push order).
// out: holds elements in queue order (front on top).
// Any problem you faced while coding this : Edge case for when both stacks are empty

// Your code here along with comments explaining your approach
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if (empty()) {
            return -1; // gracefully handle empty case
        }
        peek();
        return out.pop();
    }
    
    public int peek() {
        // Transfer elements from in → out when needed 
        // so that front of the queue ends up on top of the out stack.
        if (empty()) {
            return -1; // gracefully handle empty case
        }
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

    public static void main(String args[]) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println("Popped: " + param_2);
        int param_3 = obj.peek();
        System.out.println("Peeking: " + param_3);
        boolean param_4 = obj.empty();
        System.out.println("Is queue empty: " + param_4);
        int param_5 = obj.pop();
        System.out.println("Popped: " + param_5);
        boolean param_6 = obj.empty();
        System.out.println("Is queue empty: " + param_6);
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

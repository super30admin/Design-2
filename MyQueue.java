import java.util.*;

class MyQueue {

    // Time Complexity : 
    // peek = avg O(1), worst O(n)
    // pop = avg O(1), worst O(n)
    // push = O(1)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    /*
        to implement queue using two stack array we have in stack where we push the value 
        and out stack to pop the value from. Since queue is a FIFO data structure, 
        to pop the first element we added, we need to move all the elements from in stck to out stack to pop them.
        We handle this under peek function, which checks if out stack is empty then push elements
        from in to out stack and then returns the top most element. pop function calls peek func to populate the
        out stack and then pops the topmost element. For push function, we can directly push to the in stack since the in stack already has the order in which we insert the elements
     */

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
        peek();
        return out.pop();
    }
    
    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return out.empty() && in.empty();
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
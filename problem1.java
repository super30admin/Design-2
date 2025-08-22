// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// Using 2 stacks for in and out. Using in to push new elements. Using out to pop the elements after transfering all elements from in to out
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    // Strict O(1)
    public void push(int x) {
        // always pushing the element to in stack
        in.push(x);
    }

    // Amortized O(1) since we have to move all elements from in to out when out is empty
    public int pop() {
        // reusing the logic for moving elements from moving elements from in to out
        peek();

        return out.pop();
    }

    // Amortized O(1) since we have to move all elements from in to out when out is empty
    public int peek() {
        // if out is empty, then move all elements from in to out
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        // this is always valid because of problem description
        return out.peek();
    }

    // Strict O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
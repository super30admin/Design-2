// Time Complexity : O(1) amortized for push, pop, peek, and empty
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues; understanding when to move elements between stacks was the key.

// I used two stacks: 'in' for incoming elements and 'out' for removing elements.
// When popping or peeking, if 'out' is empty, I move all elements from 'in' to 'out' to maintain FIFO order.
// This ensures that each element is moved at most once between the stacks, giving amortized O(1) performance.

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    public void push(int x) {
        in.push(x);

    }
    private void moveInToOut(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());

            }
        }
    }

    public int pop() {
        moveInToOut();
        return out.pop();

    }

    public int peek() {
        moveInToOut();
        return out.peek();

    }

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

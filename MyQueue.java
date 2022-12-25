// Time Complexity : pop() and peek() run in amortized O(1); push(),empty() in O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//We are using 2 stacks in this approach - one in and one out stack. 
//To queue a new element , we can directly push into the in stack.
//To remove an element from the front of the queue we pop from the out stack. If it is empty, push elements one by one from in to out stack and then pop.

class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    private void reorderStacks(){ //call this when out stack is empty
        while(!in.isEmpty())
        {
            out.push(in.pop()); //pop all elements from in and push to out stack
        }
    }

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty())
            reorderStacks();
        return out.pop();
    }
    
    public int peek() {
         if(out.isEmpty())
            reorderStacks();
        return out.peek();
    }
    
    public boolean empty() {
        return (out.isEmpty() && in.isEmpty());
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
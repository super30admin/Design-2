class MyQueue {
    
    // Thought Process:
    /**
        2 Stacks, 1 in, 1 out
        
        Stack is FILO and Queue is FIFO
        So, push is same, but pop is reversed. So 2 stacks.
        
        new element pushed to 'in' stack
        element popped or peeked from 'out' stack
        
        pop or peek called, check if 'out' is empty, then move all 'in' to 'out'


    Time Complexity :
    1. push -> O(1)
    2. peek & pop -> O(1) amortized. Since, it requires O(N) to move from in to out, but only moved when out is empty.
       If we have a large input stream, out stack would hardly be ever empty. SO, average TC will be O(1).
    3. empty -> O(1)

    Space Complexity :
    O(N) -> Since stacks are used to store the data.
    **/
    
    Stack<Integer> in;
    Stack<Integer> out;
    

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
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

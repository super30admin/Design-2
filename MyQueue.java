//Status - ran successfully
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    /* When pop operation is encountered, check if the out stack has values, if so, pop the element, if the out stack is empty, push the elements from in to out. */
    public int pop() {
        peek();
        return out.pop();
    }
    
    /** Get the front element. */
    // return the top element from out stack, if out stack has elements
    // if out stack is empty, push all elements from in to out stack, return the top element
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty(); //checking both stacks for elements
    }
}
/*
    Time Complexity
        push - O(1)
        peek - Amortized O(1)
        pop - Amortized O(1)
        empty - O(1)
    Space compelxity - O(n) where n is the number of input elements to be pushed
*/
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
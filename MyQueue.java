//Time complexity - push O(1), pop O(n), peek O(n) Amortized - O(1) Worst Case - O(n)
//Space complexity - O(n)

// Use two stacks. In stack and out stack to perform queue operations
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    // simply push at in Stack
    public void push(int x) {
        inStack.push(x);
    }
    
    // call the peek operation to transfer elements from In stack to Out stack and then pop from Out stack.
    public int pop() {
        if(empty()){
            return -1;
        }
        peek();
        return outStack.pop();

    }
    
    // First transfer elements from instack to out stack if out stack is empty
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }            
        }
        return outStack.peek();
    }
    
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
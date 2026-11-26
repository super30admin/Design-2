// Time Complexity: O(1) amortized for pop and peek, O(1) average for push and empty
// Space Complexity: O(N) where N is the size of the input and output stack arrays.
// Using two stacks to replicate the functioning of a Queue with FIFO
// Inserting into one stack representing the back of a Queue, and 
// exerting out from the output stack representing the top of a queue.

class MyQueue {
    public Stack<Integer>inputStack;
    public Stack<Integer>outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
        return;
    }
    
    public int pop() {
        
        if (outputStack == null) return -1;

        if (outputStack.isEmpty()) {
            int isize = inputStack.size();
            while (isize > 0) {
                int transfer = inputStack.pop();
                outputStack.push(transfer);
                isize--;
            }
        }
        return outputStack.pop();
    }
    
    public int peek() {
        if (outputStack == null) return -1;
        if (outputStack.isEmpty()) {
            int isize = inputStack.size();
            while (isize > 0) {
                int transfer = inputStack.pop();
                outputStack.push(transfer);
                isize--;
            }
        }
        return outputStack.peek();
    }
    
    public boolean empty() {
        if (inputStack.isEmpty() && outputStack.isEmpty()) return true;
        else return false;
    }
}

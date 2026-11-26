// Time Complexity: O(1) amortized for pop and peek, O(1) average for push and empty
// Space Complexity: O(N) where N is the size of the input and output stack arrays.
// Using two stacks to replicate the functioning of a Queue with FIFO
// Inserting into one stack representing the back of a Queue, and 
// exerting out from the output stack representing the top of a queue.


class MyQueue {
    private final Stack<Integer> inputStack;
    private final Stack<Integer> outputStack;

    public MyQueue() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }

    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

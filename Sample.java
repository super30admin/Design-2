/*
Time Complexity:
 Push: O(1)
 Pop: O(1)
 Peek: Average Time Complexity
    My understanding: Even though we need to transfer n elements for the 1st fill from support to original stack
    as original stack is empty. For the following series of operations we don't copy until original stack is empty
    and the same operation is used over the series.

 Space Complexity: O(n)
 */

class MyQueue {
    // Creating instance members of the class
    private Stack<Integer> supportStack;
    private Stack<Integer> originalStack;
    public MyQueue() {
        // Initialising the instance members
        this.supportStack = new Stack<Integer>();
        this.originalStack = new Stack<Integer>();
    }

    public void push(int x) {
        // To push an element into queue
        this.supportStack.push(x);
    }

    public int pop() {
        // If both the stacks are empty
        if(empty()) return -1;
        peek();
        // Returns first element
        return this.originalStack.pop();
    }

    public int peek() {
        // If original stack is empty
        if(this.originalStack.isEmpty()){
            // Until original stack is not empty
            while(!supportStack.isEmpty()){
                // Copy the elements from supportStack to originalStack from tail to head
                this.originalStack.push(this.supportStack.pop());
            }
        }
        // Return the head of queue
        return originalStack.peek();
    }

    public boolean empty() {
        // If both the stacks are empty that means the queue is empty
        return(this.supportStack.isEmpty() && this.originalStack.isEmpty());
    }
}

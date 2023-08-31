class MyQueue {
   // We will create two stacks inputStack and outputStack 
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    // Constructor for MyQueue class
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    // Method to push element "x" in the inputStack
    // Time complexity: O(1)
    public void push(int x) { // inserts elements in the inputStack
        inputStack.push(x);
    }
    
    // Method to remove last element from the outputStack which would actually be the first element as per Queue logic which is "FIFO" 
    // Time complexity(Average case): O(1) (as it contains peek method) (pop operation in itself is O(1))
    // Time complexity(Worst case): O(n)  (as it contains peek method) (pop operation in itself is O(1))
    public int pop() { // removes and returns first inserted element as per Queue logic.
        peek(); // This method arranges the outputStack such that the first element is removed as per Queue logic
        return outputStack.pop(); // removing and displaying the first element of the Queue as per FIFO logic.
    }
    

    // This method is used to retrieve the top element of the Stack or frst element of the queue (FIFO) logic.
    // Time complexity(Average case): O(1)
    // Time complexity(Worst case): O(n)
    public int peek() { // returns first inserted element as per Queue logic.
        // checking if the outputStack is empty
        if (outputStack.isEmpty())
        {
           // if inputStack is not empty then the elements of inputStack are shifted to outputStack in order to reverse the inputStack so that we can get the first inserted element as per Queue FIFO logic.
           if(!inputStack.isEmpty())
           {
               while(!inputStack.isEmpty())
               {
                  outputStack.push(inputStack.pop());
               }
           }
        }
        return outputStack.peek();
    }
    
    // Time complexity: O(1) 
    public boolean empty() { // returns true or false
        // checks if both the inputStack and outputStack are empty, if they are it returns true.
        return inputStack.isEmpty() && outputStack.isEmpty();
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

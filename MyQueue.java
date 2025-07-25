// This algorithm uses two stacks where one is an input stack to store the values as they come and the other is an output stack that maintains the FIFO order by pulling in elements from input stack whenever it empties out.
class MyQueue {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public MyQueue() {
        
    }

  // Utility method to reload the stack 2
    private void loadStack2() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
      // Reload when stack 2 is empty
        if(stack2.isEmpty()) {
            loadStack2();
        }
        if(stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
    
    public int peek() {
      // Reload when stack 2 is empty
        if(stack2.isEmpty()){
            loadStack2();
        }
        if(stack2.isEmpty()) {
            return -1;
        }
        return stack2.peek();
    }
    
    public boolean empty() {
      // If both the stacks are empty, only then the whole queue is empty
        return stack1.isEmpty() && stack2.isEmpty();
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

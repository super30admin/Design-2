import java.util.*;

class QueueUsingStacks {
    private Stack stack1; 
    private Stack stack2;
    public QueueUsingStacks() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();


    }
    
    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
        stack1.push(x);
    }
    
    public int pop() {
        while (!stack1.isEmpty()) {
        	stack2.push(stack1.peek());
            stack1.pop();
        }
        int returnVal = (int) stack2.peek();
        stack2.pop();
        return returnVal;
    }
    
    public int peek() {
    	while (!stack1.isEmpty()) {
        	stack2.push(stack1.peek());
            stack1.pop();
        }
        int returnVal = (int) stack2.peek();
    	return returnVal;
    }
    
    public boolean empty() {
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
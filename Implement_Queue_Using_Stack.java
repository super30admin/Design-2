import java.util.Stack;

public class Implement_Queue_Using_Stack {
	Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public Implement_Queue_Using_Stack() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = 0;
        if(!stack1.isEmpty())
            val = stack1.pop();
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
    public static void main(String args[])
    {
    	Implement_Queue_Using_Stack obj = new Implement_Queue_Using_Stack();
    	 obj.push(3);
    	 int param_2 = obj.pop();
    	 int param_3 = obj.peek();
    	 boolean param_4 = obj.empty();
    }
}

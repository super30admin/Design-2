import java.util.Stack;

public class QueueUsingStack2 {
	// This solution referred from Leetcode 
	
	// In this method move elements from reference stack to queue stack when needed,
	// i.e., when we need to peek/pop but the output stack is empty.
	
	Stack<Integer> stack1; // reference stack
    Stack<Integer> stack2; // queue stack
    
    /** Initialize your data structure here. */
    public QueueUsingStack2() {
       stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
          stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // first we update the queue stack with all the newly pushed elements
    // and then pop the element from queue stack 
    public int pop() {
    	if(stack1.empty() && stack2.empty()) return -1;
    	else {
    		peek();
    		return stack2.pop();
    	} 	
    }
    
    /** Get the front element. */
    // if both stacks are empty, return -1
    // if queue stack is empty, we push the values from reference stack in the queue stack, till it is empty.
    // at last view the top element of queue stack.
    public int peek() {
       if(stack1.empty() && stack2.empty()) return -1;
    	
       if(stack2.empty()) {
    	   while(!stack1.empty()) {
    		   stack2.push(stack1.pop());
    	   }
       }
      return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
    
    // driver class
    public static void main(String[] args){
        System.out.println("Queue to Stack Implementation");
        QueueUsingStack2 q = new QueueUsingStack2(); 
        System.out.println(q);    
        q.push(1);  
    q.push(2);
    
    System.out.println(q.peek());
    q.push(5);
    q.push(3);
    int c = q.pop();
    System.out.println(c);
    System.out.println(q.pop());
    System.out.println(q.pop());
    System.out.println(q.pop());
    System.out.println(q.pop());    
    

    }
}

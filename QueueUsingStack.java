import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> stack1; // reference stack
    Stack<Integer> stack2; // queue stack
    
    /** Initialize your data structure here. */
    public QueueUsingStack() {
       stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    
    // if queue stack is empty, push value in it.
    // otherwise, transfer the values from queue stack (until its not empty) to reference stack, push new value 
    // in queue stack and transfer values from reference stack to queue stack.
    public void push(int x) {
        if(stack2.isEmpty()){ 		 
            stack2.push(x);
        }else{
            while(!stack2.isEmpty()){			 
                stack1.push(stack2.pop());		
            }
 
            stack2.push(x);						
 
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }    
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // topmost element of queue stack is the front element
    public int pop() {
        if(!stack2.empty())
        return stack2.pop();
        else return -1;
    }
    
    /** Get the front element. */
    public int peek() {
       return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty();
    }
    
    // driver class
    public static void main(String[] args){
        System.out.println("Queue to Stack Implementation");
        QueueUsingStack q = new QueueUsingStack(); 
        System.out.println(q);    
        q.push(1);  
    q.push(2);
    
    System.out.println(q.peek());
    q.push(5);
    int c = q.pop();
    System.out.println(c);
    System.out.println(q.pop());
    System.out.println(q.pop());
    System.out.println(q.pop());
    
    

    }
}

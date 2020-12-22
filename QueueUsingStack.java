import java.util.Stack;

public class QueueUsingStack {
	
    /** Initialize your data structure here. */
    Stack<Integer> stackOne= new Stack();
    Stack<Integer> stackSecond= new Stack();

	
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        
	        stackOne.push(x);
	        
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        
	        peek();
	       return  stackSecond.pop();
	  
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        
	       
	        if(stackSecond.empty()){
	            while(!stackOne.isEmpty()){
	                stackSecond.push(stackOne.pop());
	            }
	        }
	        
	        return stackSecond.peek();
	        
	        
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        
	        return (stackOne.isEmpty() && stackSecond.isEmpty()) ;
	        
	    }
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub
	    	
	    	
	    	QueueUsingStack myQueue = new QueueUsingStack();
	    	myQueue.push(1); // queue is: [1]
	    	myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
	    	System.out.println(myQueue.peek()); // return 1
	    	System.out.println(myQueue.pop()); // return 1, queue is [2]
	    	System.out.println(myQueue.empty()); // return false

		}
		
		
	

}

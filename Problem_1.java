import java.util.Stack;

public class Problem_1 {
	 Stack<Integer> stack;
	 Stack<Integer> auxStack;
	    
	    /** Initialize your data structure here. */
	    public Problem_1() {
	        stack = new Stack<Integer>();
	        auxStack = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        shiftStacks();
	        return auxStack.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        shiftStacks();
	        return auxStack.peek();
	        
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        if(stack.isEmpty() && auxStack.isEmpty()){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    
	    public void shiftStacks(){
	        if(auxStack.isEmpty()){
	            while(!stack.isEmpty()){
	                auxStack.push(stack.pop());
	            }
	        }
	    }
}

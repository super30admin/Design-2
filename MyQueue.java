import java.util.Stack;

/**
 * Implementing using two stacks
 * @author Manogna
 *
 */
public class MyQueue {
	Stack<Integer>  st1;
	Stack<Integer>  st2;
	
	/** Initialize your data structure here. */
    public MyQueue() {
      st1 = new Stack<Integer>();
      st2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    		//If the second stack is empty, take elements from the first
    		if(st2.empty()) {
    			while(!st1.empty()) {
        			int last = st1.pop();
        	        st2.push(last);
        		}
    		}
    		return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	//If the second stack is empty, take elements from the first
		if(st2.empty()) {
			while(!st1.empty()) {
    			int last = st1.pop();
    	        st2.push(last);
    		}
		}
		return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.empty() && st2.empty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue();
		q.push(2);
		q.push(4);
		q.push(6);
		q.push(8);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());

	}

}

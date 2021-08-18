import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue {
	Stack<Integer> queue;
	Stack<Integer> tempStack;
	int top ;
    /** Initialize your data structure here. */
    public MyQueue() {
        
        queue = new Stack<Integer>();
        tempStack = new Stack<Integer>();
        top = 0;
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);
        
        top++;
        
        
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	
    	if (queue.isEmpty())
    		return -1;
    	for(int i=top;i>1;i--) {
    		int ele = queue.pop();
    		
    		tempStack.push(ele);
    		
    	}
    	int val = queue.pop();
    	
    	//reset original queue
    	for (int i=0;i<top-1;i++) {
    		/*if (tempStack.size() == 0 )
    			break;*/
    		int ele = tempStack.pop();
    		
    		queue.push(ele);
    		
    	}
    	
    	top--;
    	return val;
    }
    
    /** Get the front element. */
    public int peek() {
    	if (queue.isEmpty())
    		return -1;
    	return queue.get(0);
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	
    	if (queue.isEmpty())
    		return true;
    	return false;
        
    }
    
    
    public static void main(String [] args) 
    {
    	
    	MyQueue obj= new MyQueue();
    	
    	
    	/**LeetCode Test case**/
    	obj.push(1);
    	
    	obj.push(2);
    	obj.push(3);
    	obj.push(4);
    	System.out.println(obj.pop());
    	obj.push(5);
    	System.out.println(obj.pop());
    	System.out.println(obj.pop());
    	System.out.println(obj.pop());
    	System.out.println(obj.pop());
    	
    	
    	
    	
    	//System.out.println("Element is: "+ obj.peek());
    	//System.out.println("Element is: "+ obj.pop());
    	//System.out.println("Element is: "+ obj.pop());
    	
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
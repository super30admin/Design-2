package test11;

import java.util.Queue;
import java.util.LinkedList;

/*
 * Using queue to implement stack operations.
 * Whenever we push to stack, we add the new value & remove all the previous values
 * and add it back to queue
 * Whenever we pop, we dequeue to get the 1st one in queue
 */

public class MyQueue {

	Queue<Integer> stackAsQueue = new LinkedList<Integer>();
	
	//Driver code
    public static void main(String[] args) 
    { 
    	MyQueue testQueue = new MyQueue();
    	testQueue.push(100);
    	testQueue.push(200);
    	testQueue.push(300);
    	System.out.println("Pop "+testQueue.pop());
    	System.out.println("Pop "+testQueue.pop());
    	   	
    }
    
    public MyQueue() {
    	
    }
    
    public void push(Integer value) {
    	
    	// save the current size
    	int curQueueSize = stackAsQueue.size();
    	
    	// add the new value which gets added to end
    	stackAsQueue.add(value);
    	
    	// now iterate until prev size
    	for (int index=0; index < curQueueSize; index++) {
    		// remove it from head
    		Integer tmpVal = stackAsQueue.remove();
    		// add it back to queue
    		stackAsQueue.add(tmpVal);
    	}
    	
    }
    
    public Integer pop() {
    	  	return stackAsQueue.remove();
    }
    
    public Integer peek() {
    	return stackAsQueue.peek();
    }
    
    public boolean isEmpty() {
    	if (stackAsQueue.isEmpty()) return true;
    	return false;
    }
}

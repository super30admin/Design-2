// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    
    public Stack<Integer> normalStack, reverseStack;

	/** Initialize your data structure here. */
	public MyQueue() {
		normalStack = new Stack();
		reverseStack = new Stack();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		
		while(!normalStack.isEmpty())
			reverseStack.push(normalStack.pop());
		
		normalStack.push(x);
		
		while(!reverseStack.isEmpty())
			normalStack.push(reverseStack.pop());
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		
		return normalStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		return normalStack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (normalStack.size()==0)
			return true;
		else
			return false;
	}
}

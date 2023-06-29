// Time Complexity : O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class MyQueue {
	
	Stack<Integer> inStack;
	Stack<Integer> outStack;
	
	public MyQueue()
	{
		this.inStack = new Stack<>();
		this.outStack = new Stack<>();
	}
	
	public void push(int value)  // pushing elements inside the stack
	{
		inStack.push(value);
	}
	
	public int pop()
	{
		if(empty())
			return -1;
		peek();
		return outStack.pop();
	}
	
	public int peek()
	{
		if(empty())
			return -1;
		if(outStack.isEmpty())
		{
			while(!inStack.isEmpty())
			{
				outStack.push(inStack.pop());//push elements from inStack to outStack to pop the first element inserted.
			}
		}
		return outStack.peek();
	}
	
	public boolean empty()
	{
		return outStack.isEmpty() && inStack.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue);
		System.out.println(myQueue.peek());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.empty());
		myQueue.pop();
		myQueue.pop();
		myQueue.pop();
		 // return 1
		//.pop(); // return 1, queue is [2]
		//myQueue.empty(); // return false

	}

}

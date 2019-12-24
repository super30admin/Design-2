// Time Complexity :
//      push() - O(1)
//      pop() - O(n)
//      peek() - O(n)
//      empty() - O(1)
//      
// Space Complexity :
//      overall - O(n)
//      push() - N/A
//      pop() - N/A
//      peek() - O(1)
//      empty() - N/A
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MyQueue {
	//Two Stack Approach
	Stack<Integer> stk1;
	Stack<Integer> stk2;

	MyQueue() {
		//initialize the two stacks
		stk1 = new Stack<Integer>();
		stk2 = new Stack<Integer>();
	}

	public void push(int x) {
		//push the value to the first stack
		stk1.push(x);
	}

	public void pop() 
	{
		//take all the elements from first stak and put in second stack
		while(!stk1.isEmpty())
		{
			stk2.push(stk1.peek());
			stk1.pop();
		}

		//remove the top element
		//this is same as removing front element from queue
		stk2.pop();

		//push all the elements back into the first stack
		while(!stk2.isEmpty())
		{
			stk1.push(stk2.peek());
			stk2.pop();
		}
	}

	public int peek() {
		//take all the elements from first stak and put in second stack
		while(!stk1.isEmpty())
		{
			stk2.push(stk1.peek());
			stk1.pop();
		}

		//get the front element;
		int t = stk2.peek();

		//push all the elements back into the first stack
		while(!stk2.isEmpty())
		{
			stk1.push(stk2.peek());
			stk2.pop();
		}

		//return the front element's value
		return t;
	}

	public boolean empty() {
		//check if the first stack is empty
		return stk1.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue qu = new MyQueue();
		qu.push(1);
		qu.push(2);  
		System.out.println("peek -> " + qu.peek());  // returns 1
		System.out.println("pop");
		qu.pop();   								  // returns 1
		System.out.println("empty -> " + qu.empty()); // returns false
		System.out.println("peek -> " + qu.peek());  // returns 2
		System.out.println("pop");
		qu.pop();									 // returns 2
		System.out.println("empty -> " + qu.empty()); // returns true
	}

}
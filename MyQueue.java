package com.Aug2020;

import java.util.Stack;
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :

//how to make the solution work using one-stack only to avoid extra stack.
public class MyQueue {

	Stack<Integer> st;
	Stack<Integer> st2;
	int count;

	public MyQueue() {
		// TODO Auto-generated constructor stub
		st = new Stack<Integer>();
		st2 = new Stack<Integer>();
		count = 0;
	}

	public void push(int x) {

		st.add(x);

	} // -- Push element x to the back of queue.

	public void pop() {
		// if (st2.empty()) {

		// }

		st2.pop();

	}// -- Removes the element from in front of queue.

	public int peek() {
		while (!st.empty()) {

			st2.push(st.pop());
		}
		return st2.peek(); // -- Get the front element.

	}

	public boolean empty() { // -- Return whether the queue is empty.
		if (st2.empty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.peek(); // returns 1

		queue.pop(); // returns 1
		queue.empty(); // returns false
	}

}

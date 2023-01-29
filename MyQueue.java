// Time Complexity : o(1) for push and empty, Average O(1) for pop and peek
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Queue -> FIFO, STACK -> LIFO
// when ever pop and peek happens, if out is empty transfer data from in to out   
// insert in in, pop and peek from out

import java.util.Stack;

class MyQueue {

	Stack<Integer> in;
	Stack<Integer> out;

	public MyQueue() {
		in = new Stack<>();
		out = new Stack<>();
	}

	public void push(int x) {
		in.push(x);
	}

	public int pop() {
		if (out.isEmpty()) {
			transfer();
		}
		return out.pop();
	}

	private void transfer() {

		while (!in.isEmpty()) {
			out.push(in.pop());
		}
	}

	public int peek() {
		if (out.isEmpty()) {
			transfer();
		}
		return out.peek();
	}

	public boolean empty() {
		return in.isEmpty() && out.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
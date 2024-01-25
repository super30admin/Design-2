import java.util.Stack;
//Time Complexity : Amortized - O(1) to O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
class MyQueue {

    private Stack<Integer> in_stack;
	private Stack<Integer> out_stack;

	public MyQueue() {
		this.in_stack = new Stack<>();
		this.out_stack = new Stack<>();
	}

	// push all elements to in_stack until you get a pop operation
	public void push(int x) {
		in_stack.push(x);
	}

	public int pop() {
		peek();
		return out_stack.pop();
	}

	public int peek() {
		if (out_stack.isEmpty()) {
			while (!in_stack.isEmpty())
				out_stack.push(in_stack.pop());
		}
		return out_stack.peek();
	}

	public boolean empty() {
		return out_stack.isEmpty() && in_stack.isEmpty();
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
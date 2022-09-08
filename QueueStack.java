// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach

class MyQueue {

	Stack<Integer> in;
	Stack<Integer> out; 
	public MyQueue() {
		 this.in = new Stack<>();
		 this.out = new Stack<>();
	}
	
	public void push(int x) {
		 in.push(x);
	}
	
	public int pop() {
		 peek();
		 return out.pop();
	}
	
	public int peek() {
		 if (out.isEmpty()) {
			  while (!in.isEmpty()) {
					out.push(in.pop());
			  }
		 }
		 return out.peek();
	}
	
	public boolean empty() {
		 if (in.isEmpty() && out.isEmpty()) {
			  return true;
		 }
		 return false;
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
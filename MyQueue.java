import java.util.Stack;

public class MyQueue {
	Stack<Integer> pushQ, popQ;

	public MyQueue() {
		pushQ=new Stack<>();
		popQ= new Stack<>();
	}
	
	// time complexity O(1)
	public void push(int x) {
		pushQ.push(x);
	}
	
	// time complexity O(1) amortized
	public int peek() {
	   migrateToPopQueue();
	   return popQ.peek();
	}
	
	// time complexity O(1) amortized
	public int pop() {
		migrateToPopQueue();
		return popQ.pop();		
	}
	
	// time complexity O(1)
	public boolean isEmpty() {
		return pushQ.isEmpty() && popQ.isEmpty();
	}
	
	private void migrateToPopQueue() {
		if (popQ.isEmpty()) {
			   while (!pushQ.isEmpty()) {
				   popQ.push(pushQ.pop());
			   }
		}
	}
}

import java.util.*;

public class QueueUsingStack {
	Stack<Integer> myStack = new Stack<>();
	
	public void push(int x) {
		myStack.push(x);
		
	}
	
	public int pop() {
		if(myStack.empty()) {
			return -1;
		}
		Stack<Integer> temp = new Stack<>();
		while(!myStack.empty()) {
			temp.push(myStack.pop());
		}
		int value = temp.pop();
		while(!temp.empty()) {
			myStack.push(temp.pop());
		}
		return value;
	}
	
	public boolean empty() {
		return myStack.empty();
	}
	
	public int peek() {
		if(myStack.empty()) {
			return -1;
		}
		Stack<Integer> temp = new Stack<>();
		while(!myStack.empty()) {
			temp.push(myStack.pop());
		}
		int value = temp.peek();
		while(!temp.empty()) {
			myStack.push(temp.pop());
		}
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStack obj = new QueueUsingStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.peek());
		obj.pop();
		System.out.println(obj.peek());
;
		
	}

}

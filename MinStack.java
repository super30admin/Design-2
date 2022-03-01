import java.util.Stack;

public class MinStack {		
	private int SIZE=1000;	
	private Stack<Integer> stk = new Stack<>();
	private Stack<Integer> minStk = new Stack<>();
	private int stkCnt=0;
	private int minStkCnt=0;
	
	public MinStack() {

	}

	public void push(int val) {
		if(stkCnt < SIZE) {
			stk.push(val);
			stkCnt++;
			if(minStk.isEmpty() || val <= minStk.peek()) {
				minStk.push(val);
				minStkCnt++;
			}
		}else {
			System.out.println("Stack is full");
		}
	}

	public void pop() {
		if(stkCnt > 0) {
			if(minStk.peek().equals(stk.peek())) {
				minStk.pop();
				minStkCnt--;
			}
			stk.pop();
			stkCnt--;			
		}else{
			System.out.println("Stack is emppty");
		}
	}

	public int top() {
		return stk.peek();
	}
	
	public int getMin() {
		return minStk.peek();
	}
	
	public boolean isEmpty() {
		return (minStkCnt == 0);
	}
	
	public boolean isFull() {
		return (stkCnt == SIZE);
	}
	/**Time O(1) | Space O(n) **/
}

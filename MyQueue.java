

class MyQueue {
	Stack <Integer> st1;
	Stack <Integer> st2;

    public MyQueue() {
    	st1 = new Stack<Integer>();
    	st2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(!st1.isEmpty()) {
        	while(!st1.isEmpty()) {
        		st2.push(st1.pop());
        	}
        }
        int ans = st2.pop();
        if(!st2.isEmpty()) {
        	while(!st2.isEmpty()) {
        		st1.push(st2.pop());
        	}
        }
        return ans;
    }
    
    public int peek() {
        if(!st1.isEmpty()) {
        	while(!st1.isEmpty()) {
        		st2.push(st1.pop());
        	}
        }
        int ans = st2.peek();
        if(!st2.isEmpty()) {
        	while(!st2.isEmpty()) {
        		st1.push(st2.pop());
        	}
        }
        return ans;
    }
    
    public boolean empty() {
         return st1.isEmpty();
    }
}
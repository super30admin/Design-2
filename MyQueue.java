// Add elements to the primary stack while pushing
// For pop and peek functions, pop elements from primary stack one-by-one into the secondary stack. At the end, pop or peek in secondary stack.
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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

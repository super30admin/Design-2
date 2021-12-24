// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//we create 2 stacks one for push and other for pop operation
//while pushing we check if pop stack is empty, if yes we push in push stack
//while popping we check if push is empty if not we transfer everything to pop(which happens ib reversw way) and then pop it.
class MyQueue {
	
	
	Stack<Integer> stackPush;
	Stack<Integer> stackPop;
	
    public MyQueue() {
    	stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }
    
    public void popAllFromStackPush() {
    	while(stackPush.size()!=0) {
    		int x=stackPush.pop();
    		stackPop.push(x);
    	}
    }
    
    public void popAllFromStackPop() {
    	while(stackPop.size()!=0) {
    		int x=stackPop.pop();
    		stackPush.push(x);
    	}
    }
    public void push(int x) {
    	if(stackPop.size()==0) {
    		stackPush.push(x);
    		return;
    	}else {
    		popAllFromStackPop();
    		stackPush.push(x);
    		return;
    	}
    	
        
    }
    
    public int pop() {
     	if(stackPush.size()==0) {
    		int x = stackPop.pop();
    		return x;
    	}else {
    		popAllFromStackPush();
    		int x = stackPop.pop();
    		return x;
    	}
        
    }
    
    public int peek() {
    	
        if(stackPush.isEmpty() && stackPop.isEmpty()) {
        	return -1;
        }else if(stackPush.isEmpty()) {
        	return stackPop.peek();
        }else {
        	popAllFromStackPush();
        	return stackPop.peek();
        }
        
    }
    
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
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
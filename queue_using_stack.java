// Time Complexity : O(1) for push and O(N) for pop and peek
// Space Complexity : O(N)

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> popStack;

    public MyQueue() {
        stack = new Stack<>();
        popStack = new Stack<>();   
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(!popStack.empty()){
            return popStack.pop();
        } else {
            while(!stack.empty()){
                int stackVal = stack.pop();
                popStack.push(stackVal);
            }
            return popStack.pop();
        }
    }
    
    public int peek() {
        if(!popStack.empty()){
            return popStack.peek();
        } else {
            while(!stack.empty()){
                int stackVal = stack.pop();
                popStack.push(stackVal);
            }
            return popStack.peek();
        }
        
    }
    
    public boolean empty() {
        return stack.empty() && popStack.empty();
        
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


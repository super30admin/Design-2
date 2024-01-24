// Time Complexity : for all operations O(1) but push [push is O(n)]
// Space Complexity : for all operations O(1) but push [push is O(n)]
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I've used two stacks, Whenever I'm doing push I check If Stack1 is empty then I push,
 * If Not empty then I push everything from Stack1 in Stack2 and then again I push everything 
 * from Stack2 back to Stack1 to maintian FIFO order  
 */

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
        } else {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
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
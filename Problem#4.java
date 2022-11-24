// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class MyQueue {

    private Stack<Integer> stack1 = new Stack<>(); //'In' stack to push elements
    private Stack<Integer> stack2 = new Stack<>(); //'Out' stack to pop elements

    public MyQueue() {
        
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public void push(int x) {
        stack1.push(x); // Push element onto the in stack
    }
    
    // Average Time Complexity : O(1)
    // Space Complexity : O(1)
    public int pop() {
        if(stack2.isEmpty()){ //Check if the out stack is empty
            while(!stack1.isEmpty()){ //Loop through the in stack and pop elements
                stack2.push(stack1.pop()); //Push every element popped to the out stack
            }
        }
        return stack2.pop(); //When we pop from out stack, FIFO will hold as order will be reversed
    }
    
    // Average Time Complexity : O(1)
    // Space Complexity : O(1)
    public int peek() {
        if(stack2.isEmpty()){ //Check if the out stack is empty
            while(!stack1.isEmpty()){ //Loop through the in stack and pop elements
                stack2.push(stack1.pop()); //Push every element popped to the out stack
            }
        }
        return stack2.peek(); //Return the element on top of the out stack. FIFO will hold as order will be reversed
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty(); //There are no elements in the queue if both in and out stacks are emptys
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
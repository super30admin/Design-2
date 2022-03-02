// Time Complexity : Push & Peek - O(1), Pop - O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int peek;

    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
  //Push into queue and maintain first element for peek
    public void push(int x) {
        if(stack1.empty()){
            peek = x;
        }
        stack1.push(x);
    }
    
  // Move all elements from stack 1 to stack 2 LIFO -> LIFO(LIFO) = FIFO in stack 2, but do it only if stack2 is empty, else pop direclty to get first element
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    // If stack 2 is empty pop operation not perfromed yet, return peek maintained from push(), else peek first element from stack 2
    public int peek() {
        if(stack2.empty()){
            return peek;
            }
        peek = stack2.peek();      
        return peek;
        
    }
    
    // Check both stack1 and stack2 to check if empty
    public boolean empty() {
        return stack1.empty() && stack2.empty();
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

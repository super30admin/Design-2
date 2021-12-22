/* Time Complexity: O(1) */
/* Space Complexity: O(n) */
/* Did this code successfully run on Leetcode : Yes */
/* Any problem you faced while coding this :  No */


class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
        
    }
    
    //push element x to the back of the queue
    public void push(int x) {
        stack1.push(x);
        
    }
    
    //pop element from front of the queue and return that element
    public int pop() {
        if(stack2.isEmpty()){
            shiftStacks();
           
        }
         return stack2.pop();
    }
    
    //get the front element 
    public int peek() {
        if(stack2.isEmpty()){
            shiftStacks();
           
        }
         return stack2.peek();
    }
    
    //return whether queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    //push the element in 2nd stack
    public void shiftStacks(){
        while(!stack1.isEmpty()){
        int temp = stack1.pop();
        stack2.push(temp);
        }
            
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
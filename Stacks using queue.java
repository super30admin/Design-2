// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : The transferring of elements from stack1 to stack2 was difficult


// Your code here along with comments explaining your approach
class MyQueue {

    /* Intuition:
    We will use two stacks. Stack 1 would act as the back of the queue , Stack 2 would act as the front of the queue. We keep on pushing the values to the stack 1, until pop happens on the queue
    When the pop happens on the queue , if the stack2 has elements then pop those , otherwise transfer all elements from stack1 to Stack 2

    */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    // keep pushing to stack 1
    public void push(int x) {
        stack1.push(x);
    }
    // we will pop from stack2 which is the back of the queue
    public int pop() {
        if(stack2.isEmpty()){ // if nothing in stack2 , then transfer elements from the stack 1
            transferElements();
        }
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty()){ // if nothing in stack2 , then transfer elements from the stack 1
            transferElements();
        }
        return stack2.peek();
        
    }
    
    public boolean empty() {
        // if both stacks are empty , then only it would be empty
        return stack1.isEmpty() && stack2.isEmpty();

    }
    // Transfer elements from stack 1 to stack 2
    private void transferElements(){

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
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
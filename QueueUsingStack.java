// Time Complexity : O(1) for push, O(n) for pop and peek in worst case when outStack is empty, O(1) for pop and peek when outStack is not empty.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We can use two stacks to implement a queue.
 * We will push elements to stack, and when we need to pop or peek, we will check if the outStack is empty. If it is empty, we will pop all elements from inStack and push them to outStack. 
 * This way, the order of elements will be reversed and we can pop or peek from outStack to get the front element of the queue.
 * To check empty, we will check if both stacks are empty.
 */


class MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        inStack.push(x);
        
    }

    public void reverse(){
        if((outStack.isEmpty())){
            while(!(inStack.isEmpty())){
                outStack.push(inStack.pop());

            }
        }

    }
    
    public int pop() {
        reverse();
        return outStack.pop();
        
        
    }
    
    public int peek() {
        reverse();
        return outStack.peek();

        
    }
    
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
        
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

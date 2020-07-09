// Approach
// 1. maintian 2 stacks
// 2. always push in stack1
// 3. to pop check if stack2 is empty or not based on that either pop from stack2 or copy from stack1 to stack2 and 
// pop form stack2



// Time Complexity : push  - O(1) , pop - O(1) amortized cost
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes	
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!this.s2.isEmpty()){
            return this.s2.pop();
        }else{
            while(!this.s1.isEmpty()){
                this.s2.push(this.s1.pop());
            }
            return this.s2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(!this.s2.isEmpty()){
            return this.s2.peek();
        }else{
            while(!this.s1.isEmpty()){
                this.s2.push(this.s1.pop());
            }
            return this.s2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
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

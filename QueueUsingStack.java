/**
Time Complexity : push = O(N), pop = O(1), peek = O(1), empty = O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : NO

Queue using stack

56
58
43
45
35
Stack

Implementation with two stacks

push operation: add to the end of the queue
    
    if it is the first element to be added to the queue then 
        simply push to tyhe firstStack
    else
        empty the firstStack into secondStack
        push value in the firstStack
        push the secondStack into firstStack
        

    
pop operation:
    simply pop the firstStack since the top of the stack is hold the first element which was added to it
    
peek:
    firstStack.peek()
    
isEmpty:
    firstStack.isEmpty()

**/



class MyQueue {

    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    /** Initialize your data structure here. */
    public MyQueue() {
    
        this.firstStack = new Stack<>();
        this.secondStack = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    
        if(this.firstStack.isEmpty()) {
            this.firstStack.push(x);
            return;
        }
    
        while(!this.firstStack.isEmpty()) {
            this.secondStack.push(this.firstStack.pop());
        }
    
        this.firstStack.push(x);
    
        while(!this.secondStack.isEmpty()) {
            this.firstStack.push(this.secondStack.pop());
        }   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.firstStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return this.firstStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.firstStack.isEmpty();
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



       



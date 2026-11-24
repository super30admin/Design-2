// Time Complexity: O(1) for push and empty, O(1) amortized for pop and peek (O(n) worst case).
// Space Complexity: O(n), where n is the number of elements in the queue.

// Approach: Use two stacks, one for adding elements and another for removing or accessing elements in FIFO order.
// Whenever pop or peek is called and the second stack is empty, transfer all the elements from the first stack to the second stack to reverse their order.
// The queue is empty when both stacks are empty.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {
   Stack <Integer> s1;
   Stack  <Integer> s2;
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        s1.push(x);
        
    }
    
    public int pop() {
        if(!s2.isEmpty()){
            return s2.pop();
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
        
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
        
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

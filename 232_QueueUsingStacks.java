// Time Complexity :O(1)
// Space Complexity :O(n) - where n is the number of entries in HashMap 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No









import java.util.Stack;


// Take 2 Stack called "in" and "out".
// initially we will add element to "in" stack when push happens.
// whenever pop or peek happen we will use "out" stack.
// at the time of these two operation we will transfer all element of "in" to the "out" stack if and if "out" stack is empty.
// The reason of this transfer is, in Queue is follow the FIFO.
// In FIFO, we have make sure that, first inserted elememt has choosen for "peek" or "pop" operation.
// And Stack use LIFO, so to get the last element of the stack which is basically first in Queue, we are using "out" stack.
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
        
    }
    
    // when new push happen, use "in" stack to push the new element
    public void push(int x) {
        
        in.push(x);
    }
    
    // we will first make sure if "in" stack is not empty and "out" stack is empty
    // if this condition is true, we will do tranfer of element.
    // and then pop out first element of "out" stack. 
    public int pop() {
        if(!in.isEmpty() && out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
        
    }
    

    // For peek, we will check first if "out" is not Empty. if condition is true, we simply get the element.
    // otherwise, we will do same transfer as "pop()" operation and then peek the element from "out" stack.
    public int peek() {
        if(!out.isEmpty()){
                return out.peek();       
        }else{
            if(!in.isEmpty() && out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
        }
        
    }
    
    // if both stacks are empty, we will return True otherwise false.
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
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

// Time Complexity :
//  push(): O(1)
//  pop(), peek(): Best- O(1), Worst - O(n), Amortized - O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Stack;

class MyQueue {
    
    // member variables
    private Stack<Integer> input;
    // holds min-value and count 
    private Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x); 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        checkOutputStack();
        return output.pop();
    }

    /** Checks if output stack is empty and tries to fill it from input. */
    private void checkOutputStack(){
         // output stack empty
         if(output.isEmpty())
         // pop out all the elements of input and push it into output
            while(!input.isEmpty())
                output.push(input.pop());
    }
    
    /** Get the front element. */
    public int peek() {
        checkOutputStack();
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        int x = 5, y = 10, z = 2;
        obj.push(x);
        obj.push(y);
        obj.push(z);
        int param_2 = obj.pop();
        System.out.println("Popped: "+ param_2);
        int param_3 = obj.peek();
        System.out.println("Peek: "+ param_3);
        boolean param_4 = obj.empty();
        System.out.println("Queue Empty: "+ param_4);
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

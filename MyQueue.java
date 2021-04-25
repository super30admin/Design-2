package Queue;

import java.util.Stack;

/*S30 Big N Problem #3  https://www.youtube.com/watch?v=F2qyQidQ1mI
Design the following operations 

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  

queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack 
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
Source Link: https://leetcode.com/problems/implement-queue-using-stacks/
*/public class MyQueue {
    

   private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
       
    }

    public int peek() {
        
        if (!out.isEmpty()) {
            return out.peek();
        } else {
            while (!in.isEmpty())
                out.push(in.pop());
        }
        return out.peek();
    }

    public boolean empty() {

        return in.empty() && out.empty();

    }


}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MyQueue {

     /**Time Complexity : O(1)
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No
     Your code here along with comments explaining your approach **/
     //Initializing two stacks. Enqueue stack is where you push elements and dequeue stack is used for reversing those elements.
    Stack <Integer> enqueueSt;
    Stack <Integer> dequeueSt;
    public MyQueue() {
        this.enqueueSt = new Stack<>();
        this.dequeueSt = new Stack<>();
    }
    //Pushing the integers into Enqueue stack.
    public void push(int x) {
        enqueueSt.push(x);
    }
    //In a queue, pop() removes the element in the head. To implement this, reverse the integers present in the Enqueue stack by popping one by one and pushing it to the Dequeue stack. Then use the pop() so that the first element is popped out, which will be the elment present in the head of queue.
    public int pop() {
        if (dequeueSt.isEmpty()){
            while (!enqueueSt.isEmpty()){
                dequeueSt.push(enqueueSt.pop());
            }
        }
        return dequeueSt.pop();
    }
    //In quque, peek() shows the element present in the head. Implementing the same process as the above function and replace pop() with peek()(method of stack), to view the top element of dequeue which will the head element of queue.
    public int peek() {
        if (dequeueSt.isEmpty()){
            while (!enqueueSt.isEmpty()){
                dequeueSt.push(enqueueSt.pop());
            }
        }
        return dequeueSt.peek();
    }
    //The empty() must return true, if and only if both the enqueue and dequeue stacks are empty. This means that the queue is empty. Otherwise, it will return false.
    public boolean empty() {
        if (enqueueSt.isEmpty() && dequeueSt.empty())
            return true;
        else
            return false;
    }
}



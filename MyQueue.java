/* 
Time complexity : O(1)
Space complexity: O(n)
*/

/* 
 Did this code successfully run on Leetcode : Yes 
*/

/* 
Approach :   
 1. Take two stacks one for enqueuing to the queue (enq) and other fo dequeuing from the queue (deq)
 2. For the enqueue operation the element will be added to the enq stack
 3. For the dequeue operation, first the stacks are checked for empty condition if empty return -1, 
    if not then the elements from the enq stack are transferred to the deq stack,the element is  then 
    popped from the deq stack
 4. For the peek operation, first the stacks are checked if they are empty, if empty return  -1, if not then
    the elements from the enq stack are transferred to the deq stack and the peek() operation is called on 
    the deq stack
 5. For empty operation, if both stacks are empty then the queue is empty.      
*/
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> enq,deq;
    public MyQueue() {
       enq = new Stack<>();
       deq = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enq.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(enq.isEmpty() && deq.isEmpty()) return  -1;
       if(deq.isEmpty()) {
           while(!enq.isEmpty()) {
               deq.push(enq.pop());
           }
       }
      return deq.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(enq.isEmpty() && deq.isEmpty()) return -1;
        if(deq.isEmpty()) {
            while(!enq.isEmpty()) {
                deq.push(enq.pop());
            }
        }
        return deq.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(enq.isEmpty() && deq.isEmpty()) return true;
        else return false;
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
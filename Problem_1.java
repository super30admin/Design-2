/*
   
Design queue using stack
*/

//Time comlpexity - O(1) 
//space complexity - O(n)
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/

// Your code here along with comments explaining your approach
class MyQueue {

  Stack<Integer> stack1;
  Stack<Integer> stack2;
  
  
  /** Initialize your data structure here. */
  public MyQueue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
  }
  
  /** Push element x to the back of queue. */
  public void push(int x) {
      stack1.push(x);
  }
  
  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      if(stack2.isEmpty()){
          while(!stack1.isEmpty()){
              int elem = stack1.pop();
              stack2.push(elem);
          }
      }
      return stack2.pop();
  }
  
  /** Get the front element. */
  public int peek() {
      if(stack2.isEmpty()){
          while(!stack1.isEmpty()){
              int elem = stack1.pop();
              stack2.push(elem);
          }
      }
      return stack2.peek();
  }
  
  /** Returns whether the queue is empty. */
  public boolean empty() {
      return stack1.isEmpty()&&stack2.isEmpty();
  }
}
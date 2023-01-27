// Time Complexity : O(1) for push() and empty(), Average O(1) for pop() and peek()
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use 2 stacks ("in" and "out") to replicate the FIFO technique of queue. While pushing we just push to "in" stack. While popping/peeking
   we just pop() all elements from "in" stack and push to "out" stack and then pop from "out" stack. In this way the element pushed first into "in" stack
   will be on top of "out" stack (FIFO) and popped. Since elements are moved from "in" stack to "out" stack only when "out" stack is empty, average time complexity 
   for pop() will be O(1).
*/

 class MyQueue {
  Stack<Integer> in;
  Stack<Integer> out;

  public MyQueue() {
      in = new Stack<>();
      out = new Stack<>();
  }
  
  public void push(int x) {
      in.push(x);
  }
  
  public int pop() {
      peek();
      return out.pop();
  }
  
  public int peek() {
      if(out.isEmpty()) {
          while(!in.isEmpty())
              out.push(in.pop());
      }
      return out.peek();
  }
  
  public boolean empty() {
      return in.isEmpty() && out.isEmpty();
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
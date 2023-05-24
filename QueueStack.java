// Time Complexity : O(1)  -- Push - O(1), Pop - O(1)[amotized time]
// Space Complexity : O(n) - using 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach is when you have push operation just push into the inStack and when you have pop operation check if the outStack has elements , if it
has then pop from the top of outStack and if outStack is empty then push all the elements of inStack to outstack and then pop from outstack */


class MyQueue {
    Stack<Integer> inStack ;
      Stack<Integer> outStack;
      public MyQueue() {
          inStack = new Stack<>();
          outStack = new Stack<>();
         
      }
      
      public void push(int x) {
          inStack.push(x);
      }
  
      public int pop() {
         peek();
        return outStack.pop();
      }
      
      public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
        
      }
      
      public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
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
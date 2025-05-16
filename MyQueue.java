// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MyQueue {

  Stack<Integer> s1 = new Stack<>();  // primary stack 
  Stack<Integer> s2 = new Stack<>();  // secondary stack

  public MyQueue() {

  }

  // TC - O(n)
  // SC - O(n)
  public void push(int x) {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    s2.push(x);
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  // TC - O(1)
  // SC - O(1)
  public int pop() {
    return s1.pop();
  }

  // TC - O(1)
  // SC - O(1)
  public int peek() {
    return s1.peek();
  }

  // TC - O(1)
  // SC - O(1)
  public boolean empty() {
    return s1.isEmpty();
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
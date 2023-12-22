// Time Complexity :O(1) Amortized
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class QueueWithStack {
  Stack<Integer> s1;
  Stack<Integer> s2;

  public QueueWithStack() {
    s1 = new Stack<Integer>();
    s2 = new Stack<Integer>();
  }

  public void push(int x) {
    s1.push(x);
  }

  public int pop() {
    if (!s2.isEmpty()) {
      return s2.pop();
    } else {
      while (!s1.isEmpty()) {
        int temp = s1.peek();
        s1.pop();
        s2.push(temp);
      }
      return s2.pop();
    }
  }

  public int peek() {
    if (s2.size() != 0) {
      return s2.peek();
    } else {
      while (!s1.isEmpty()) {
        int temp = s1.pop();
        s2.push(temp);
      }
      return s2.peek();
    }
  }

  public boolean empty() {
    if (!s1.isEmpty() || !s2.isEmpty()) return false;
    return true;
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

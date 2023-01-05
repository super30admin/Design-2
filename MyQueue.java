import java.util.Stack;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MyQueue {
  Stack<Integer> in = new Stack<>();
  Stack<Integer> out = new Stack<>();

  public MyQueue() {

  }

  public void push(int x) {
    in.push(x);
  }

  public int pop() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.pop();
  }

  public int peek() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.peek();

  }

  public boolean empty() {
    return (in.isEmpty() && out.isEmpty());
  }
}

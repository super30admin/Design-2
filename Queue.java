// Time complexity is : 0(1)
//Space Complexity is :0(n) since using 2 stack
public class Queue {

  private Stack<Integer> in, out;

  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  private void transferIfRequired() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
  }

  public void push(int x) {
    in.push(x);
  }

  public int pop() {
    transferIfRequired();
    return out.pop();
  }

  public int peek() {
    transferIfRequired();
    return out.peek();
  }

  public boolean empty() {
    return out.isEmpty() && in.isEmpty();
  }
}

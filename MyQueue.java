
//o(n) time for add and o(1) tiem for other functions
//o(n) space

//to add element recursive;ly go to the  bottom of stack and ad the element
import java.util.Stack;
class MyQueue {

  Stack<Integer> s;

    public MyQueue() {
        s = new Stack<>();
    }

    public void push(int x) {
      if(s.size() == 0){
        s.push(x);
        return;
      }
      int val = s.pop();
      push(x);
      s.push(val);
    }

    public int pop() {
        return empty() ? -1 : s.pop();
    }

    public int peek() {
        return empty() ? -1 : s.peek();
    }

    public boolean empty() {
        return s.size() == 0;
    }
}

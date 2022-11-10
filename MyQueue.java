import java.util.Stack;
/* Time Compexity - O(1)
* Space Complexity - O(n)
* 2 stacks are used when a push occurs, push the element into first stack
* when pop encountered pop or peek we pop elements from first stack and push into second stack. Then pop the elements
* from second stack. For peek, return the first element of stack 2. For empty both stacks should be empty.
* */
public class MyQueue {
//https://leetcode.com/problems/implement-queue-using-stacks/
Stack<Integer>in;
    Stack<Integer>out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int val) {

        in.push(val);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if(empty()) return -1;
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }

        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

public static void main(String[] args) {
    MyQueue obj = new MyQueue();
  obj.push(6);
  int param_2 = obj.pop();
  obj.push(5);
  int param_3 = obj.peek();
  boolean param_4 = obj.empty();
}

}

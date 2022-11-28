import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> in;
    private Stack<Integer> out;
    private int front;

    QueueUsingStacks() {
        in = new Stack();
        out = new Stack();
    }

    public void push(int val) {
        if (in.isEmpty())
            front = val;

        in.push(val);
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
        if (!out.isEmpty()) {
            return out.peek();
        }
        return front;
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
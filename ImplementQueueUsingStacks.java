import java.util.Stack;

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int first;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            first = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return first;
    }

    public boolean empty() {
        if (s1.isEmpty() && s2.isEmpty())
            return true;

        return false;
    }
}
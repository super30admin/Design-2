import java.util.Stack;

class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first =new Stack();
        second = new Stack();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int rem=second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return rem;
    }

    public int peek() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int rem=second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return rem;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
import java.util.Stack;

public class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }

        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }

        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

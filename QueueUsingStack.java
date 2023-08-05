import java.util.Stack;

public class QueueUsingStack {
    //Time complexity: for the push operation O(N), all other O(1)
    //Space complexity: O(N) number of values inside the stack
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void push(int x) {
        if(stack1.isEmpty()){
            stack1.push(x);
            return;
        }
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(x);
        while(!stack2.isEmpty())stack1.push(stack2.pop());
    }

    public int pop() {
        if(stack1.isEmpty()) return -1;

        return stack1.pop();

    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}

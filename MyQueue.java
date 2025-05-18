import java.util.Stack;

public class MyQueue {
    /* Using 2 stacks one for pushing and another for popping.All push will
    go to push stack and Pop stack will be filled by popping from Push stack
    essentially reversing the push stack. Hence, making the pop operation amortized O(1)
    */
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) { //O(1)
        pushStack.push(x);
    }

    public int pop() { //amortized O(1)
        peek(); //reuse before removing/popping element from popStack
        return popStack.pop();
    }

    public int peek() { //amortized O(1)
        // Fill the popStack with pushStack in reverse order
        if (popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() { //O(1)
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

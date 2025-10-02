import java.util.Stack;

/**
 * Implementing Queue using 2 stack, IN stack and OUT stack.
 * We push values in IN Stack and Pop from OUT stack.
 * When Pop is called, check if OUT stack is empty
 *      a) If emtpy, push all value from IN to OUT stack, and call pop() on OUT stack
 *      b) If Not empty, call pop() on OUT Stack
 * Push Time Complexity : O(n)
 * Pop Time Complexity : Amortized O(1)
 */
class MyQueue2 {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public MyQueue2() {
    }

    // Time Complexity : O(n)
    public void push(int x) {
        in.push(x);
    }

    // Time Complexity : Amortized O(1)
    public int pop() {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    // Time Complexity : O(1)
    public int peek() {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.empty();
    }
}
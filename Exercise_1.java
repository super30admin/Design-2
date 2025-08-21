import java.util.Stack;
//we take 2 stacks, in stack to push the elements, out stack to pop/peek the elements
//TC : push : perfect O(1), pop, peek: Amortized O(1), empty: O(1)
//SC: O(1)
public class MyQueue {

    private final Stack<Integer> in;
    private final Stack<Integer> out;

    /**
     * Constructor to initialize {@link MyQueue} and the in and out stacks
     */
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    /**
     * Push the elements in the in stack
     * @param x the value to be pushed
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     *
     * @return pop the top element in the out stack aka the Queue
     */
    public int pop() {
        peek();
        return out.pop();
    }

    /**
     *
     * @return peek the top element in the out stack aka the Queue
     */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.peek();
    }

    /**
     *
     * @return true if both in stack and out stack are empty
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        final MyQueue myQueue = new MyQueue();

        myQueue.empty();    //return true
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        myQueue.empty();    //return false
        myQueue.pop();      //return 1
        myQueue.peek();     //return 2
        myQueue.pop();      //return 2
        myQueue.pop();      //return 3
        myQueue.pop();      //return 4
        myQueue.push(6);
        myQueue.push(7);

        myQueue.pop();  //return 6
        myQueue.pop();  //return 7

        myQueue.empty(); //return true
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
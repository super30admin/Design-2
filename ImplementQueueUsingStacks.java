
import java.util.Stack;

//keeping elements in st1 but in FIFO manner.

// When a new element is pushed, all existing elements in st1 are first moved to st2.

// st2 will now contain the elements in reverse order (i.e., LIFO: like a stack).

// Then push the new element to st1.

// Finally,  move everything back from st2 to st1, restoring the FIFO order in st1.
class ImplementQueueUsingStacks {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public ImplementQueueUsingStacks() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        st1.push(x);

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }


    public int pop() {
        return st1.pop();
    }


    public int peek() {
        return st1.peek();
    }


    public boolean empty() {
        return st1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        // Testing push
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        // Testing peek
        System.out.println("Peek: " + queue.peek()); // Should print 1

        // Testing pop
        System.out.println("Pop: " + queue.pop());   // Should print 1
        System.out.println("Pop: " + queue.pop());   // Should print 2

        // Testing empty
        System.out.println("Is empty? " + queue.empty()); // Should print false

        // Further pop
        System.out.println("Pop: " + queue.pop());   // Should print 3
        System.out.println("Pop: " + queue.pop());   // Should print 4

        // Final empty check
        System.out.println("Is empty? " + queue.empty()); // Should print true
    }
}

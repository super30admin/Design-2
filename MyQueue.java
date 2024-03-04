import java.util.Stack;

class MyQueue {
    private Stack<Integer> in; // First stack for enqueue operation
    private Stack<Integer> out; // Second stack for dequeue operation

    public MyQueue() { // Constructor for initialization
        this.in = new Stack<>(); // Initialize the 'in' stack
        this.out = new Stack<>(); // Initialize the 'out' stack
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public void push(int x) { // Enqueue operation
        in.push(x); // Push the element to the 'in' stack
    }

    // Time complexity: Amortized O(1), worst-case O(n) where n is the number of elements
    // Space complexity: O(1)
    public int pop() { // Dequeue operation
        peek(); // Ensure 'out' stack is populated with elements
        return out.pop(); // Pop from the 'out' stack
    }

    // Time complexity: Amortized O(1), worst-case O(n) where n is the number of elements
    // Space complexity: O(1)
    public int peek() { // Peek operation
        if (out.isEmpty()) { // If 'out' stack is empty
            while (!in.isEmpty()) { // Transfer elements from 'in' to 'out' stack
                out.push(in.pop());
            }
        }
        return out.peek(); // Return the top element of 'out' stack
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public boolean empty() { // Check if the queue is empty
        return in.isEmpty() && out.isEmpty(); // Queue is empty if both stacks are empty
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Adding elements to the queue
        queue.push(1);
        queue.push(2);
        queue.push(3);

        // Removing elements from the queue
        System.out.println("Popped element: " + queue.pop());
        System.out.println("Popped element: " + queue.pop());

        // Adding more elements to the queue
        queue.push(4);

        // Checking if the queue is empty
        System.out.println("Queue is empty: " + queue.empty());

        // Removing the remaining elements from the queue
        System.out.println("Popped element: " + queue.pop());
        System.out.println("Popped element: " + queue.pop());

        // Checking if the queue is empty after removing all elements
        System.out.println("Queue is empty: " + queue.empty());
    }
}

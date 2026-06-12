// Approach:
// Use two stacks to simulate the operations of a queue.
// Push new elements into the input stack and transfer elements to the output stack when needed.
// Perform pop and peek operations from the output stack to maintain FIFO order.

// Time Complexity: push: O(1), pop: Amortized O(1), peek: Amortized O(1), empty: O(1)
// Space Complexity: O(N)

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
//problem 2
// Approach:
// Use an integer array to store the value corresponding to each key.
// Initialize all entries with -1 to indicate that no value is mapped to the key.
// Update, retrieve, and remove values by directly accessing the array index.

// Time Complexity: put: O(1), get: O(1), remove: O(1)
// Space Complexity: O(1000001)

class MyHashMap {
    int[] map;

    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

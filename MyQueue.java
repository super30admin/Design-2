/**
 * The idea is to maintain 2 stacks.
 * Stack A and Stack B
 * 
 * Push: all push would be performed on Stack A
 * Because Queue follows FIFO policy, for top() & pop() we need to get to element that is at 
 * bottom of the stack.
 * Transfer function does this: pops from first stack and pushes to second stack.
 * 
 * Space Complexity: O(n)
 * Time Complexity:
 * Push: O(1)
 * Pop: O(n)
 * Top: O(n)
 */
class MyQueue {

    Deque stackA, stackB;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new LinkedList();
        stackB = new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // we need to access the element at bottom of stackA
        transfer(stackA, stackB);
        int element = (int) stackB.removeLast();
        // transfer back to preserve consistency
        transfer(stackB, stackA);
        return element;
    }

    /** Get the front element. */
    public int peek() {
        // we need to access the element at bottom of stackA
        transfer(stackA, stackB);
        int element = (int) stackB.getLast();
        // transfer back to preserve consistency
        transfer(stackB, stackA);
        return element;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.size() == 0;
    }

    /**
     * transfer element one by one 
     * popping from a and pushing to b
     * until a is empty
     */
    private void transfer(Deque a, Deque b) {
        while (a.size() > 0) {
            b.add(a.removeLast());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
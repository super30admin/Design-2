class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //if stack is empty push the first element else push the element to the top of the stack
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // if the helper stack s2 is empty then pop the top element from the stack and push it to s2
        // else pop pop the top element which satisfies the rule of FIFO as
        // the top will have the first element of the main stack
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return  s2.pop();

    }

    /** Get the front element. */
    public int peek() {
        //If s2 is empty then return front which the front element in main stack else return front element in s2
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        //if any of the stack is empty then return false.
        return s1.isEmpty() && s2.isEmpty();

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
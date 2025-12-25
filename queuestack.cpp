class MyQueue {

    // stack used for pushing new elements
    stack<int> inSt;

    // stack used for popping and peeking elements
    stack<int> outSt;

public:

    // constructor initializes empty stacks
    MyQueue() {}

    // pushes element x to the back of the queue
    void push(int x) {
        inSt.push(x);
    }

    // removes and returns the element from the front of the queue
    int pop() {
        // ensure out stack has the front element
        peek();

        int val = outSt.top();
        outSt.pop();
        return val;
    }

    // returns the element at the front of the queue
    int peek() {
        // if out stack is empty, transfer all elements from in stack
        if (outSt.empty()) {
            while (!inSt.empty()) {
                outSt.push(inSt.top());
                inSt.pop();
            }
        }
        return outSt.top();
    }

    // returns true if the queue is empty
    bool empty() {
        return inSt.empty() && outSt.empty();
    }
};

#include <stack>

using namespace std;

class MyQueue {
    private:
        stack<int> st1;
        stack<int> st2;

        // Rebalance the stacks to support FIFO
        void rebalance() {
            while (!st1.empty()) {
                st2.push(st1.top());
                st1.pop();
            }
        }
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        st1.push(x);
    }
    
    int pop() {
        // st2 empty? rebalance due to FIFO policy.
        if (st2.empty()) {
            rebalance();
        }
        int val = st2.top();
        st2.pop();
        return val;
    }
    
    int peek() {
        // st2 empty? rebalance due to FIFO policy.
        if (st2.empty()) {
            rebalance();
        }

        return st2.top();
    }
    
    bool empty() {
        return st1.empty() && st2.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
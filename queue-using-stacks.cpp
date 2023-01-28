// Implement Queue using Stacks
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyQueue {
private:
    stack<int> in;
    stack<int> out;
public:
    MyQueue() {

    }

    void push(int x) {
        in.push(x);
    }

    int pop() {
        peek();
        int popped = out.top();
        out.pop();
        return popped;
    }

    int peek() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
        }
        return out.top();
    }

    bool empty() {
        return in.empty() && out.empty();
    }
};
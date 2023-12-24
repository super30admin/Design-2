/*
 * Time Complexity :
 *      Push - O(1)
 *      Peek - O(n)
 *      Pop - O(n)

 * Space Complexity : O(n)

 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No

 ? Your code here along with comments explaining your approach
   I created 2 stack called in & out stack which I'm using for
   storing. When ever there is a push onto my queue I'm pushing
   those values onto the in stack. When I get a peek for the
   first in queue I check if my out stack is empty and if it is
   is empty then I pop from my in stack and push it onto my out
   stack and return the top element of the out stack and if the
   out stack is not empty I directly return the top of the out
   stack. Now for pop operation I do the same expect I remove
   the top element of the out stack.
*/

#include <stack>

class MyQueue {
    std::stack<int> out_st, in_st;
public:
    MyQueue() {}

    void push(int x) {
        in_st.push(x);
    }

    int pop() {
        peek();
        int p = out_st.top();
        out_st.pop();
        return p;
    }

    int peek() {
        if (out_st.empty()) {
            while (!in_st.empty()) {
                out_st.push(in_st.top());
                in_st.pop();
            }
        }
        return out_st.top();
    }

    bool empty() {
        return in_st.empty() && out_st.empty();
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
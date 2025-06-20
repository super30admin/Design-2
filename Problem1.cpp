// Time Complexity : O(1) for all operations amortized
// Space Complexity : O(n) where n is the number of elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include<stack>
using namespace std;

class MyQueue {
private:
    stack<int> s1, s2;

public:
    MyQueue() {}
    
    void push(int x) {
        s1.push(x);
    }
    
    int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.top());
                s1.pop();
            }
        }
        int val = s2.top();
        s2.pop();
        return val;        
    }
    
    int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.top());
                s1.pop();
            }
        }
        return s2.top();        
    }
    
    bool empty() {
       return s1.empty() && s2.empty(); 
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
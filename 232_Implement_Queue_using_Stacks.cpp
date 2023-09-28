// Time Complexity : Push O(1), Pop amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Why was amortized O(1)


// Your code here along with comments explaining your approach
// Technique: Maintain the front elem at bottom of main stack
// Push directly to main (in) stack.
// When we need to peek or pop, move all elements to out stack in LIFO manner. Then top elem is required element. Again move all from out to in stack

#include<bits/stdc++.h>
using namespace std;

class MyQueue {
public:
    stack<int> in;
    stack<int> out;
    int size;
    MyQueue() {
        size = 0;
    }
    
    void push(int x) {
        in.push(x);
        size++;
    }
    
    int pop() {
        if(empty()) {
            return -1;
        }
        while(!in.empty()) {
            out.push(in.top());
            in.pop();
        }
        int frontElem = out.top();
        out.pop();
        size--;
        while(!out.empty()) {
            in.push(out.top());
            out.pop();
        }

        return frontElem;
    }
    
    int peek() {
        if(empty()) {
            return -1;
        }
        while(!in.empty()) {
            out.push(in.top());
            in.pop();
        }
        int frontElem = out.top();
        while(!out.empty()) {
            in.push(out.top());
            out.pop();
        }

        return frontElem;
    }
    
    bool empty() {
        return size == 0;
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
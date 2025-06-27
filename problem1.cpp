// Time Complexity : O(n) for push, O(1) for others
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
// Your code here along with comments explaining your approach
#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
public:
    stack<int> s1;
    stack<int> s2;

    MyQueue() {
        // Constructor
    }

    void push(int x) {
        // Move all elements from s1 to s2
        while (!s1.empty()) {
            s2.push(s1.top());
            s1.pop();
        }

        // Push new element to s1
        s1.push(x);

        // Move everything back to s1 from s2
        while (!s2.empty()) {
            s1.push(s2.top());
            s2.pop();
        }
    }

    int pop() {
            int ans = s1.top();
            s1.pop();
            return ans;
        }
       

    int peek() {
            return s1.top();
        }
   

    bool empty() {
        return s1.empty();
    }
};

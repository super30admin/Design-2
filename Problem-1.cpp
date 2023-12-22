// Time Complexity : O(1)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Appoarch: Made use of 2 stacks for queue implementation, 
// while pushing items in stack1 for inserting and moving them 
// to stack2 for pop and peek operations as queue follows FIFO.

#include <bits/stdc++.h>
using namespace std;

class MyQueue {
public:
    stack<int> st1;
    stack<int> st2;

    MyQueue() {
    }
    
    void push(int x) {
        st1.push(x);
    }
    
    int pop() {
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.top());

                st1.pop();
            }
        }
        int val = st2.top();
        st2.pop();
        return val;
    }
    
    int peek() {
       if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.top());

                st1.pop();
            }
        }
        int val = st2.top();
        return val;
    }
    
    bool empty() {
        return st1.empty() && st2.empty();     
    }
};
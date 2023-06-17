// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : using .pop in c++ doesnt auctomatically return that value. Just had a little problem working around using c++.

#include <iostream>
#include <stack>
  
using namespace std;


class MyQueue {
    stack<int> inStack;
    stack<int> outStack;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        inStack.push(x);
    }
    
    int pop() {
        if(outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        int front = outStack.top();
        outStack.pop();
        return (front);
    }
    
    int peek() {
        if(outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        return (outStack.top());
    }
    
    bool empty() {
        if(inStack.empty() && outStack.empty()){
            return(true);
        }
        return(false);
    }
};
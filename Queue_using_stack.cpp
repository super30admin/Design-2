//Time complexity : push(x) : O(1) , pop() : Amortized O(1)

#include<bits/stdc++.h>
using namespace std;
class MyQueue {
public:
    stack<int>in,out;
    MyQueue() {}
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        peek();
        int x=out.top();
        out.pop();
        return x;  
    }
    
    int peek() {
        if(out.empty()){
            while(in.size()){
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


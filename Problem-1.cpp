// Time Complexity : O(1) for push, pop and peek. but if second stack is empty then pop and peek take O(n) time, amortized O(1) time complexity
// Space Complexity : O(1) no extra space used for any operation (excluding the stacks)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

#include<stack>
#include<iostream>
using namespace std;
class MyQueue {
private:
        stack<int> s1;
        stack<int> s2;
public:

    
    /** Push element x to the back of queue. */
    void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int val;
        int temp;
        if(s2.empty()){
            while(!s1.empty()){
                temp = s1.top();
                s2.push(temp);
                s1.pop();
            }
            val = s2.top();
            s2.pop();
        }
        else{
            val = s2.top();
            s2.pop();
        }
    return val;
    }
    
    /** Get the front element. */
    int peek() {                    // because pop() doesn't return anything I have to write peek separately for cpp
        int temp;                   // alternatively I can use front and rear as private variables on stack 1 and stack 2 and return rear to avoid re-writing peek()
        if(s2.empty()){
            while(!s1.empty()){
                temp = s1.top();
                s2.push(temp);
                s1.pop();
            }
            return s2.top();
        }
        else{
            return s2.top();
        }
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(s1.empty() && s2.empty())
            return true;
        else
            return false;
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
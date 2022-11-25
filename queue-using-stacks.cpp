/*

TC: Amortized O(1)
SC: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Logic:
Instead of moving around the stack at every single push/pop, we can notice that we need to shift elements only when the pop operation
 has already popped all the elements in the pop array. We don't need to shift the whole stack otherwise. This is way, only
 few of the operations cost O(n) -> this is amortized O(1)
*/

class MyQueue {
    stack<int> s1, s2;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        s1.push(x);
    }
    
    int pop() {
        if(s2.empty())
            while(!s1.empty())  s2.push(s1.top()), s1.pop();
        int top = s2.top(); s2.pop();
        return top;
    }
    
    int peek() {
        if(s2.empty())
            while(!s1.empty())  s2.push(s1.top()), s1.pop();
        return s2.top();
    }
    
    bool empty() {
        return s1.empty() && s2.empty();
    }
};
// Time Complexity : O(N) for push, O(1) for pop/peek/empty
// Space Complexity : O(1), we are allowed to use 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
public:
    stack<int> s1;
    stack<int> s2;
    
    MyQueue() {}
    
    void push(int x) {
        if(!s2.empty()){
            while(!s2.empty()){
                int val = s2.top();
                s2.pop();
                s1.push(val);
            }
            s2.push(x);
            while(!s1.empty()){
                int val2 = s1.top();
                s2.push(val2);
                s1.pop();
            }
        }
        else{
            s2.push(x);
            cout<<"Invoked";
        }
    }
    
    int pop() {
        int val = peek();
        s2.pop();
        return val;
    }
    
    int peek() {
        return s2.top();
    }
    
    bool empty() {
        return s2.empty();
    }
};

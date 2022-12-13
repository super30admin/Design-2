// Implement Queue using Stacks
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
// Create 2 stacks; in stack & out stack. All push happens in in stack.
// When a pop happens, transfer all elements from in stack to out stack and then pop the element.
// In some cases, when the out stack is empty and we need to do pop, then again push all the elements from in to out stack if in stack is not empty.

class MyQueue {
private: 
    stack<int> in;
    stack<int> out;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        peek();
        int popped = out.top();
        out.pop();
        return popped;
    }
    
    int peek() {
        if(out.empty()) {
            while(!in.empty()) {
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

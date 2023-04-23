// Time Complexity : O(1) Amortized complexity, O(n) for worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class MyQueue {
public:
    stack<int>In;
    stack<int>Out;
    
    MyQueue() {
        
    }
    
    void push(int x) {
        In.push(x);
    }
    
    int pop() {
        peek();
        int popped = Out.top();
        Out.pop();
        return popped;
        
    }
    
    int peek() {
        if(Out.empty()){
            while(!In.empty()){
                Out.push(In.top());
                In.pop();
            }
        }
        return Out.top();
        
    }
    
    bool empty() {
        if(In.empty() && Out.empty())
        {
            return true;
        }
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
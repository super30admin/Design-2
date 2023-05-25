// Time Complexity : O(n) -- Worst Case Scenario
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyQueue {
private: 
    stack<int> in; 
    stack<int> out;
public:
    MyQueue() {}
    
    void push(int x) {
        in.push(x);    
    }
    
    int pop() {
        int topElement = peek(); 
        out.pop(); 
        return topElement; 
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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
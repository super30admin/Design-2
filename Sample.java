// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue {
    stack<int>in;
    stack<int>out;
public:
    MyQueue() {
        
    }
    
    //o(1)
    void push(int x) {
        in.push(x);
    }
    
    //o(n)
    int pop() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
            
        } 
        int top = out.top();
        out.pop();
       return top;
    }
    
    //o(n)
    int peek() {
         if(out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
        } 
       return out.top();   
    }
    
    //o(1)
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


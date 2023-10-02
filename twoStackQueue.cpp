// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 


class MyQueue {
    stack<int> in, out;
public:
    MyQueue() {
    }
    
    void push(int x) {
        this->in.push(x);
    }
    
    int pop() {
        if(this->out.empty()){
            while(!this->in.empty()){
                this->out.push(this->in.top());
                this->in.pop();
            }
        }
        int popValue=this->out.top();
        this->out.pop();
        return popValue;
    }
    
    int peek() {
        if(this->out.empty()){
            while(!this->in.empty()){
                this->out.push(this->in.top());
                this->in.pop();
            }
        }
        return this->out.top();
    }
    
    bool empty() {
        return (this->out.empty() && this->in.empty());
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
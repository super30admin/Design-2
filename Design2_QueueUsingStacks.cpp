// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyQueue {
    stack<int> in;
    stack<int> out;
public:
    /** Initialize your data structure here. */
    MyQueue() {
        //stack<int> in;
        //stack<int> out;
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        in.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int result=peek();
        out.pop();
        return result;
        
    }
    
    /** Get the front element. */
    int peek() {
        if(out.empty()){
            while(!in.empty()){
               // int a=in.pop();
                out.push(in.top());
                in.pop();
                
            }
        }
        return out.top();
        
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return (in.empty() && out.empty());
        
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
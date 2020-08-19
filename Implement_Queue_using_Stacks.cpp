// Time Complexity : O(n)
// Space Complexity : O(n) as we are using an extra stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


// Your code here along with comments explaining your approach


class MyQueue {
public:
    /** Initialize your data structure here. */
    stack <int> stpush;
    stack <int> stpoppeak;
    int val;
    int first;
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        stpush.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if (stpoppeak.empty()){
            while (!stpush.empty()){
                val = stpush.top();
                stpush.pop();
                stpoppeak.push(val);
            }
        }
        val = stpoppeak.top();
        stpoppeak.pop();
        return val;
    }
    
    /** Get the front element. */
    int peek() {
         if (stpoppeak.empty()){
            while (!stpush.empty()){
                 val = stpush.top();
                stpush.pop();
                stpoppeak.push(val);
            }
        }
       return stpoppeak.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return ( stpush.empty() && stpoppeak.empty())  ;      
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
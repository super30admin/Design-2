// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> s1;
    stack<int> s2;
    int top1;
    int top2;
    MyQueue() {
        top1 = -1;
        top2 = -1;
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int x = 0;
        if (s2.empty())
        {
            while (!s1.empty())
            {
                x= s1.top();
                s1.pop();
                s2.push(x);
            }
        }
        
        int b = s2.top();
        s2.pop();
        return b;
        
    }
    
    /** Get the front element. */
    int peek() {
        int x = 0;
        if (s2.empty())
        {
            while (!s1.empty())
            {
                x= s1.top();
                s1.pop();
                s2.push(x);
            }
        }
        
        return s2.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return s1.empty() && s2.empty();  
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